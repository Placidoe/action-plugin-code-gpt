package org.example.codegpt.service;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.huya.xiao.action.common.util.HttpUtils;
import lombok.extern.slf4j.Slf4j;
import org.example.codegpt.service.metadata.ChatStreamRequest;
import org.example.codegpt.service.metadata.Create.CreateResponse;
import org.example.codegpt.service.metadata.Create.CreateResquest;
import org.example.codegpt.service.metadata.MessageVO;
import org.example.codegpt.service.metadata.StreamDto;
import org.example.codegpt.service.metadata.TransFrom.TransFromResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

@Slf4j
public class CodeGptService {

    private final String streamURL = "http://localhost:8083/v3/chat/stream";
    private final String createConservationURL = "http://localhost:8083/conversation/create";

    private final String transformMD5URL = "http://localhost:8083/conversation/";
    private final String host = "http://localhost:8080/#/?id=";
    private static Gson gson = new Gson();


    //业务逻辑
    public HashMap<String, String> chatWithGpt(ChatStreamRequest params) {
        //1.获取参数-
        Map<String, String> streamParams = MapObjectUtil.toMap(params);
        Map<String, String> Header = new HashMap<>();
        Header.put("oa-token", "eyJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJoeS1vYSIsImlhdCI6MTcyOTU5MTI0OCwic3ViIjoiU1NPIiwiZXhwIjoxNzI5ODUwNDQ4LCJjb2RlIjoiSjA3MzQiLCJ1c2VyX25hbWUiOiJsaXhpYW5nMSIsInl5X251bWJlciI6bnVsbCwieXlfYWNvdW50IjoiZHdfbGl4aWFuZzEiLCJvcmdhbml6YXRpb25JZCI6MTg4OSwiYXBwX2tleSI6IjE2MzQwODQ3NTQ1MzcwMzc4MjYiLCJ5eU51bWJlciI6bnVsbCwidXNlcl9pZCI6ImxpeGlhbmcxIiwibmlja19uYW1lIjpudWxsLCJvcmdhbml6YXRpb25faWQiOjE4ODksIm5hbWUiOiLmnY7lk40iLCJpZCI6ImxpeGlhbmcxIiwieXlfYWNjb3VudCI6ImR3X2xpeGlhbmcxIiwieXlBY291bnQiOiJkd19saXhpYW5nMSIsImVtYWlsIjoibGl4aWFuZzFAaHV5YS5jb20ifQ.SGD12rULm67HQeGeVfapbzAdgywV23GBkcL7hTpEW3Rsgj_XX9s7Mxs-p3zniIRlSFvs59rqVrb8frRhoarspe6DKE9V5YhYdCAm9XXq2g_4w7WzjPBaLxUFgGjfXXRs-80vSEpTfB3SD_6Hq-woVHl0scBJd5BSB8AJdoAQlM4lNqJ51fic2TqwRvqXT7KDbKWC6K2CMeH18R2mdnTS0S3JNHp5DNR3_lC8ANU6jU0p9_jUPvOBWwkKm9ivKN35pNWnSfTiydnjT9M_SuggajMWYIsS4I5IgP3xzpP55miAdm6NGGiSM0OS7h95ePqO7aJCZt0gjQZDt4qtfxzJgA");
        Header.put("content-type", "application/json");
        //2.调用chatgpt接口
        //2.1.调用新建会话接口
        CreateResquest createResquest = new CreateResquest();
        List<MessageVO> messages = new ArrayList<>();


//        String modelType = params.getModelType();
//        Long templateId = params.getTemplateId();
//        String instruction = params.getInstruction();
//        Long pluginId = params.getPluginId();
//        Long conversationId = params.getConversationId();


        MessageVO messageVO = new MessageVO();
        messageVO.setRole("user");
        messageVO.setContent(params.getInstruction());
        messageVO.setTraceId(params.getTraceId());
        messageVO.setModelType(params.getModelType());

        messages.add(messageVO);

        createResquest.setMessages(messages);
        createResquest.setName("new chat");
        createResquest.setTemplateId(params.getTemplateId());
        createResquest.setType(1);

        String createRequestJson = gson.toJson(createResquest);
        String createResponseJson = HttpUtils.doPut(createConservationURL, createRequestJson, Header);
        log.info("createResponseJson：" + createResponseJson);
        CreateResponse createResponse = gson.fromJson(createResponseJson, CreateResponse.class);

        //2.2.调用MD5转化接口
        String URL = transformMD5URL + createResponse.getData().getId();
        String transformResponseJson = HttpUtils.doGet(URL, Header);
        log.info("transformResponseJson：" + transformResponseJson);
        TransFromResponse transFromResponse = gson.fromJson(transformResponseJson, TransFromResponse.class);
        String IDMD5str = transFromResponse.getData().getIdMd5();
        String shortURL = host + IDMD5str;

        //2.3.调用stream对话接口
        if (streamParams.get("conversationId") == null)
            streamParams.put("conversationId", String.valueOf(createResponse.getData().getId()));


        String resultJson = HttpClientUtils.sendPost(streamURL, streamParams);
        log.info("resultJson：" + resultJson);

        // 使用正则表达式分割字符串
        String[] jsonObjects = resultJson.split(Pattern.quote("data:"));
        StringBuilder stringBuilder = new StringBuilder();

        // 遍历每个JSON对象并将其转换为JsonObject
        for (String jsonObjectString : jsonObjects) {
            if (!jsonObjectString.isEmpty()) {
                // 将字符串转换为JsonObject
                JsonObject jsonObject = gson.fromJson(jsonObjectString, JsonObject.class);
                JsonElement streamJson = jsonObject.get("stream");
                StreamDto streamDto = gson.fromJson(streamJson, StreamDto.class);
                // 打印转换后的JSON对象
                stringBuilder.append(streamDto.getRes_delta());
                log.info(streamDto.getRes_delta());
            }
        }

        HashMap<String, String> resMap = new HashMap<>();
        resMap.put("Data", stringBuilder.toString());
        log.info(resMap.get("Data"));
        resMap.put("conversationId", String.valueOf(createResponse.getData().getId()));
        log.info(resMap.get("conversationId"));
        resMap.put("shortURL", shortURL);
        log.info(resMap.get("shortURL"));

        return resMap;
    }

}
