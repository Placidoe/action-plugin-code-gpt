package org.example.codegpt.service.metadata.Create;

import lombok.Data;

import java.util.Date;

@Data
public class CreateResponse {
    private Data data;
    private int code;
    private String requestId;
    private String message;
    private boolean success;

    // Getters and Setters
    @lombok.Data
    public static class Data {
        private int id;
        private String idMd5;
        private String name;
        private String aigcSessId;
        private int templateId;
        private int type;
        private String preMsgNum;
        private Integer detectButExecuteCount;
        private Integer favorite;
        private Integer pinToTop;
        private Integer orderNum;
        private String createTime;
        private Boolean isDel;
        private String updateTime;
        private Boolean isCreator;

        // Getters and Setters
    }
}
