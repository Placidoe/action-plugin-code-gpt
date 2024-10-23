package org.example.codegpt.service.metadata.TransFrom;

import lombok.Data;

import java.util.List;
import java.util.Date;

@Data
public class TransFromResponse {
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
        private long templateId;
        private int type;
        private String preMsgNum;
        private int detectButExecuteCount;
        private boolean favorite;
        private boolean pinToTop;
        private int orderNum;
        private Date createTime;
        private boolean isDel;
        private Date updateTime;
        private boolean isCreator;
        private List<Message> messages;

        // Getters and Setters


        @lombok.Data
        public static class Message {
            private String role;
            private String content;
            private String modelType;
            private String traceId;
            private Object like;  // Change to appropriate type if needed
            private Object unlike; // Change to appropriate type if needed
            private Object huyaChatPluginMsg; // Change to appropriate type if needed
            private Object chainPluginMsg; // Change to appropriate type if needed
            private List<String> imageUrls;

            // Getters and Setters
        }
    }
}