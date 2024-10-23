//import com.huya.ee.build.sdk.standard.response.AplusResponse;
//
//import lombok.extern.slf4j.Slf4j;
//import org.example.codegpt.service.CodeGptService;
//import org.example.codegpt.service.metadata.ChatStreamRequest;
//import org.example.codegpt.service.metadata.ChatStreamResponse;
//
//
//@Slf4j
//public class TestHttp {
//
//    private final static CodeGptService localService = new CodeGptService(
//            "http://aplus-local.huya.info/", "pipeline", "2a00b14tdb13ffce");
//    private final static CodeGptService prodService = new CodeGptService(
//            "https://aplus.huya.com/", "pipeline", "2a00b14tdb13ffce");
//    private final static CodeGptService testService = new CodeGptService(
//            "http://aplus-codebuild-dev.huya.info/", "pipeline", "2a00b14tdb13ffce");
//    private static CodeGptService service = localService;
//
//    private boolean isRepeatBuild = false;
//    public static void main(String[] args) {
//
//        ChatStreamRequest chatStreamRequest = ChatStreamRequest.builder()
//                .modelType("gpt-3.5")
////                .pluginId(1L)
//                .conversationId(256313L)
//                .templateId(19L)
//                .instruction("你好")
//                .build();
//
////        AplusResponse<ChatStreamResponse> aplusResponse = service.chatWithGpt(chatStreamRequest);
////        log.info(aplusResponse.getMessage());
//    }
//
//}
