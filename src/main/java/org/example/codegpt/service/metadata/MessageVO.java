package org.example.codegpt.service.metadata;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@NoArgsConstructor
@SuperBuilder
public class MessageVO {

    //角色
    private String role;

    //内容
    private String content;

    //模型类型：gpt-3.5, gpt-4
    private String modelType;

    //每个对话的traceId
    private String traceId;

    //赞（只有role为assistant才有值）
    private Boolean like;

    //踩（只有role为assistant才有值）
    private Boolean unlike;

    //链式调用插件的信息：只有role为assistant才有值
    private ChainPluginMsg chainPluginMsg;


}
