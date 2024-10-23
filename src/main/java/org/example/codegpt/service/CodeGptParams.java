package org.example.codegpt.service;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.example.codegpt.service.metadata.AdvancePropertyVO;

import java.util.List;


@Data
public class CodeGptParams {
    public static final String REPEAT_BUILD_STRATEGY_TASK_FAILED = "TASK_FAILED";
    public static final String REPEAT_BUILD_STRATEGY_USE_EXISTING_TASK = "USE_EXISTING_TASK";

    //    @ApiModelProperty(value = "会话id")
    private Long conversationId;

    @Deprecated
//    @ApiModelProperty(value = "aigc会话id")
    private Long aigcSessId;

    //    @ApiModelProperty(value = "当前提问的信息")
    private String instruction;

    //    @ApiModelProperty(value = "人设模板id：如果用户选中了人设，则传入人设对应的模板id，如果用户没有选中人设，则不传入")
    private Long templateId;

    //    @ApiModelProperty(value = "模型类型：1.gpt-4o-mini; 2.gpt-3.5-16k; 3.gpt-4-8k")
    private String modelType;

    //    @ApiModelProperty(value = "语言：#zh-cn #en-us")
    private String language;

    //    @ApiModelProperty(value = "提问traceId，用于跟踪问题")
    private String traceId;

    //    @ApiModelProperty(value = "插件id")
    private Long pluginId;

    //    @ApiModelProperty(value = "高级配置参数列表")
    private List<AdvancePropertyVO> advancePropertyVOList;

    //    @ApiModelProperty(value = "图片url列表")
    private List<String> imageUrls;


    //项目名称
    private String buildProjectName;
    //流水线分支
    private String branch;
    //
    private String pipelineSource;
    //
    private String commit;
    //环境变量
    private String env;
    //
    private String releaseTag;
    //
    private String buildSpecYml;
    //
    private String desc;


    //模型
    private String mode;
    //人设
    private String template;
    //问题
    private String content;
    //插件
    private String plugin;
    //会话id
    private String chatId;


    public boolean verify() {
        if (StringUtils.isEmpty(buildProjectName)) {
            return false;
        }
        return true;
    }

}
