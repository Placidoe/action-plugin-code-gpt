package org.example.codegpt.service.metadata;

import lombok.Data;

@Data
public class StreamDto {
    String ret_code;
    String err_msg;
    String res_delta;
    String index;
}
