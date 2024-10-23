package org.example.codegpt.service.metadata.Create;

import lombok.Data;
import org.example.codegpt.service.metadata.MessageVO;

import java.util.List;

@Data
public class CreateResquest {
    //会话名称
    private String name = "new chat";

    //会话内容
    private List<MessageVO> messages;

    //会话类型: 1-用户会话类型；2-ai人设模板示例类型；3-ai人设模板调试类型
    private Integer type;

    //人设模板id：如果用户选中了人设，则传入人设对应的模板id，如果用户没有选中人设，则不传入
    private Long templateId;
}
