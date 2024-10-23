import com.google.gson.Gson;
import com.huya.xiao.action.common.util.HttpUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.example.codegpt.service.MapObjectUtil;
import org.example.codegpt.service.metadata.Create.CreateResponse;
import org.example.codegpt.service.metadata.Create.CreateResquest;
import org.example.codegpt.service.metadata.MessageVO;

import javax.net.ssl.SSLContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestCreateURL {
    public static void main(String[] args) {

        final String createURL = "http://localhost:8083/conversation/create";

        Gson gson = new Gson();
        Map<String, String> headerMap = new HashMap<>();
        headerMap.put("oa-token", "eyJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJoeS1vYSIsImlhdCI6MTcyOTU5MTI0OCwic3ViIjoiU1NPIiwiZXhwIjoxNzI5ODUwNDQ4LCJjb2RlIjoiSjA3MzQiLCJ1c2VyX25hbWUiOiJsaXhpYW5nMSIsInl5X251bWJlciI6bnVsbCwieXlfYWNvdW50IjoiZHdfbGl4aWFuZzEiLCJvcmdhbml6YXRpb25JZCI6MTg4OSwiYXBwX2tleSI6IjE2MzQwODQ3NTQ1MzcwMzc4MjYiLCJ5eU51bWJlciI6bnVsbCwidXNlcl9pZCI6ImxpeGlhbmcxIiwibmlja19uYW1lIjpudWxsLCJvcmdhbml6YXRpb25faWQiOjE4ODksIm5hbWUiOiLmnY7lk40iLCJpZCI6ImxpeGlhbmcxIiwieXlfYWNjb3VudCI6ImR3X2xpeGlhbmcxIiwieXlBY291bnQiOiJkd19saXhpYW5nMSIsImVtYWlsIjoibGl4aWFuZzFAaHV5YS5jb20ifQ.SGD12rULm67HQeGeVfapbzAdgywV23GBkcL7hTpEW3Rsgj_XX9s7Mxs-p3zniIRlSFvs59rqVrb8frRhoarspe6DKE9V5YhYdCAm9XXq2g_4w7WzjPBaLxUFgGjfXXRs-80vSEpTfB3SD_6Hq-woVHl0scBJd5BSB8AJdoAQlM4lNqJ51fic2TqwRvqXT7KDbKWC6K2CMeH18R2mdnTS0S3JNHp5DNR3_lC8ANU6jU0p9_jUPvOBWwkKm9ivKN35pNWnSfTiydnjT9M_SuggajMWYIsS4I5IgP3xzpP55miAdm6NGGiSM0OS7h95ePqO7aJCZt0gjQZDt4qtfxzJgA");
        headerMap.put("content-type", "application/json");
        CreateResquest createResquest = new CreateResquest();
        List<MessageVO> messages = new ArrayList<>();

        MessageVO messageVO = new MessageVO();
        messageVO.setRole("user");
        messageVO.setContent("你好女士");
        messageVO.setTraceId("bee1318e-9fcc-4304-b64f-6b65489ca30c");
        messageVO.setModelType("gpt-3.5");

        messages.add(messageVO);

        createResquest.setMessages(messages);
        createResquest.setName("lixiang1");
        createResquest.setTemplateId(419L);
        createResquest.setType(1);

        String requestJson=gson.toJson(createResquest);
        String responseJson = HttpUtils.doPut(createURL, requestJson,headerMap);
        System.out.println(responseJson);
        CreateResponse response = gson.fromJson(responseJson, CreateResponse.class);
        System.out.println(response.getData().getId());
    }
}
