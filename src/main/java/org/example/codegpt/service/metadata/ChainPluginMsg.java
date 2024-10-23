package org.example.codegpt.service.metadata;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@SuperBuilder
public class ChainPluginMsg {

    private String pluginResult;

    private String rawContent;
}