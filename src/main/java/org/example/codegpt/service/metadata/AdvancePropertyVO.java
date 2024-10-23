package org.example.codegpt.service.metadata;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@SuperBuilder
public class AdvancePropertyVO {

    //    @ApiModelProperty(value = "高级配置的自定义属性code")
    private String code;

    //    @ApiModelProperty(value = "高级配置的自定义属性value")
    private String value;

}