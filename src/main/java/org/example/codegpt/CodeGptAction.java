package org.example.codegpt;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.huya.xiao.action.common.exception.ActionException;
import com.huya.xiao.action.common.exception.ErrorCode;
import com.huya.xiao.action.plugin.api.ActionParam;
import com.huya.xiao.action.plugin.api.ActionResult;
import com.huya.xiao.action.plugin.api.IAction;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.BeanUtils;
import org.example.codegpt.service.CodeGptParams;
import org.example.codegpt.service.CodeGptService;
import org.example.codegpt.service.metadata.ChatStreamRequest;
import org.pf4j.Extension;

import java.util.HashMap;


@Slf4j
@Extension
public class CodeGptAction implements IAction {
    private static Gson gson = new Gson();
    private final String streamURL = "http://localhost:8083/v3/chat/stream";
    private final String createURL = "https://localhost:8083/conversation/create";

    private CodeGptService service = new CodeGptService();


    @SneakyThrows
    @Override
    public ActionResult execute(ActionParam actionParam) {
        HashMap<String, String> systemVariableMap = new HashMap<>();
//        //本地测试环境变量
//        systemVariableMap.put("PIPELINE_NAME", "bbb_test");
//        systemVariableMap.put("PIPELINE_ID", "11");
//        systemVariableMap.put("PIPELINE_ENV", "22333");
//        systemVariableMap.put("PIPELINE_TASK_ID", "123");
//        systemVariableMap.put("PIPELINE_JOB_ID", "1234");
//        systemVariableMap.put("PIPELINE_EXECUTOR_ACCESS_TOKEN", "1234");
//        systemVariableMap.put("CUSTOM_ENVIRONMENTS_BASE64", "test");
//        systemVariableMap.put("PIPELINE_JOB_CREATED_BY", "test123");
//        systemVariableMap.put("PIPELINE_JOB_NUMBER", "test123");

//        SystemVariable.initRuntimeEnvMap(systemVariableMap);
        //1.提取参数
        // 创建一个 CodeGptParams 对象，用于存储构建代码所需的参数
        CodeGptParams params = new CodeGptParams();
        // 使用 Apache Commons BeanUtils 工具类将 actionParam 中的参数填充到 params 对象中
        BeanUtils.populate(params, actionParam.getParamsMap());

        //2.校验参数
        // 验证 params 对象中的参数是否合法，如果不合法则抛出 ActionException 异常
        if (!params.verify()) {
            throw new ActionException(ErrorCode.INVALID_PARAM);
        }
        log.info("输入的参数为:{}", JSON.toJSON(params));

        String modelType = params.getModelType();
        Long templateId = params.getTemplateId();
        String instruction = params.getInstruction();
        Long pluginId = params.getPluginId();
        Long conversationId = params.getConversationId();


        ChatStreamRequest chatStreamRequest = ChatStreamRequest.builder()
                .modelType(modelType)
                .pluginId(pluginId)
                .conversationId(conversationId)
                .templateId(templateId)
                .instruction(instruction)
                .build();

        HashMap<String, String> resMap = service.chatWithGpt(chatStreamRequest);


        // 返回一个成功的 ActionResult 对象，其中包含构建结果
        return ActionResult.success(resMap);
    }
}
