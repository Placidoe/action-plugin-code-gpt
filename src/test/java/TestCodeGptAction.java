import com.alibaba.fastjson.JSON;
import com.huya.xiao.action.common.util.SystemVariable;
import com.huya.xiao.action.plugin.api.ActionParam;
import com.huya.xiao.action.plugin.api.ActionResult;
import com.huya.xiao.action.plugin.api.IAction;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.example.codegpt.CodeGptAction;
import org.pf4j.DefaultPluginManager;
import org.pf4j.PluginManager;

import java.io.File;
import java.lang.*;
import java.util.*;


@Slf4j
public class TestCodeGptAction {

    @SneakyThrows
    public static void main(String[] args) {

        SystemVariable.getAccessToken();//PIPELINE_EXECUTOR_ACCESS_TOKEN
        SystemVariable.getPipelineTaskId();//PIPELINE_TASK_ID
        String actionJarName = "action-plugin-demo-1.0.15.jar";
        File file = new File(Thread.currentThread().getContextClassLoader().getResource("").toURI().getPath());
        String filePath = file.getParentFile().getAbsolutePath() + "\\" + actionJarName;


        CodeGptAction codeGptAction = new CodeGptAction();
        ActionParam param = new ActionParam();
        param.setName("codegpt");
        param.setVersion("1.0");
        Map<String, String> paramsMap = new HashMap<>();
        paramsMap.put("buildProjectName", "athena-local_codegpt");
        paramsMap.put("env", "dev");
        paramsMap.put("releaseTag", "true");
        paramsMap.put("buildSpecYml", "test");


        paramsMap.put("conversationId", "5991");
        paramsMap.put("instruction", "你好");
        paramsMap.put("modelType", "gpt-3.5");
        paramsMap.put("templateId", "67");
        paramsMap.put("traceId", "e6603d36-2f4a-4897-943f-1c48293966d9");


        param.setParamsMap(paramsMap);


        HashMap<String, String> systemVariableMap = new HashMap<>();
        systemVariableMap.put("PIPELINE_NAME", "bbb_test");
        systemVariableMap.put("PIPELINE_ID", "11");
        SystemVariable.initRuntimeEnvMap(systemVariableMap);


        log.info("开始执行,param={}", JSON.toJSON(param));
        ActionResult actionResult = invoke(filePath, param);
        log.info("actionResult={}", JSON.toJSON(param));
    }

    private static ActionResult invoke(String filePath, ActionParam actionParam) {
        // create the plugin manager
        PluginManager pluginManager = new DefaultPluginManager();
        // start and load all plugins of application
        String actionId = pluginManager.loadPlugin(new File(filePath).toPath());
        pluginManager.startPlugins();
        List<IAction> actionList = pluginManager.getExtensions(IAction.class, actionId);
        if (actionList == null || actionList.size() == 0) {
            throw new RuntimeException("can not load any plugin!");
        } else if (actionList.size() > 1) {
            throw new RuntimeException("multi plugin error!");
        }
        IAction action = actionList.get(0);
        ActionResult actionResult = action.execute(actionParam);
        pluginManager.stopPlugins();

        return actionResult;
    }

}
