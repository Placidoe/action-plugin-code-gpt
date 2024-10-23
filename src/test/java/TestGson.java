//import com.google.gson.Gson;
//import com.google.gson.reflect.TypeToken;
//import com.huya.ee.build.sdk.standard.response.AplusResponse;
//import com.huya.ee.build.sdk.standard.util.JsonUtils;
//import lombok.extern.slf4j.Slf4j;
//import org.example.codegpt.service.metadata.ChatStreamResponse;
//
//import java.util.regex.Pattern;
//
//@Slf4j
//public class TestGson {
//    public static void main(String[] args) {
//        String str = "data:{\"stream\":{\"ret_code\":0,\"err_msg\":\"\",\"res_delta\":\"\",\"index\":1}}\n" +
//                "\n" +
//                "data:{\"stream\":{\"ret_code\":0,\"err_msg\":\"\",\"res_delta\":\"你\",\"index\":2}}\n" +
//                "\n" +
//                "data:{\"stream\":{\"ret_code\":0,\"err_msg\":\"\",\"res_delta\":\"好\",\"index\":3}}\n" +
//                "\n" +
//                "data:{\"stream\":{\"ret_code\":0,\"err_msg\":\"\",\"res_delta\":\"！\",\"index\":4}}\n" +
//                "\n" +
//                "data:{\"stream\":{\"ret_code\":0,\"err_msg\":\"\",\"res_delta\":\"有\",\"index\":5}}\n" +
//                "\n" +
//                "data:{\"stream\":{\"ret_code\":0,\"err_msg\":\"\",\"res_delta\":\"什\",\"index\":6}}\n" +
//                "\n" +
//                "data:{\"stream\":{\"ret_code\":0,\"err_msg\":\"\",\"res_delta\":\"么\",\"index\":7}}\n" +
//                "\n" +
//                "data:{\"stream\":{\"ret_code\":0,\"err_msg\":\"\",\"res_delta\":\"可以\",\"index\":8}}\n" +
//                "\n" +
//                "data:{\"stream\":{\"ret_code\":0,\"err_msg\":\"\",\"res_delta\":\"帮\",\"index\":9}}\n" +
//                "\n" +
//                "data:{\"stream\":{\"ret_code\":0,\"err_msg\":\"\",\"res_delta\":\"助\",\"index\":10}}\n" +
//                "\n" +
//                "data:{\"stream\":{\"ret_code\":0,\"err_msg\":\"\",\"res_delta\":\"你\",\"index\":11}}\n" +
//                "\n" +
//                "data:{\"stream\":{\"ret_code\":0,\"err_msg\":\"\",\"res_delta\":\"的\",\"index\":12}}\n" +
//                "\n" +
//                "data:{\"stream\":{\"ret_code\":0,\"err_msg\":\"\",\"res_delta\":\"吗\",\"index\":13}}\n" +
//                "\n" +
//                "data:{\"stream\":{\"ret_code\":0,\"err_msg\":\"\",\"res_delta\":\"？\",\"index\":14}}\n" +
//                "\n" +
//                "data:{\"stream\":{\"ret_code\":0,\"err_msg\":\"\",\"res_delta\":\"\",\"index\":15}}\n" +
//                "\n" +
//                "data:{\"stream\":{\"ret_code\":0,\"err_msg\":\"\",\"res_delta\":\"\",\"index\":16}}\n";
//
//        // 创建一个Gson对象
//        Gson gson = new Gson();
//
//        // 使用正则表达式分割字符串
//        String[] jsonObjects = str.split(Pattern.quote("data:"));
//
////        Object data = (AplusResponse) JsonUtils.fromJson(str, (new TypeToken<AplusResponse<ChatStreamResponse>>() {
////        }).getType());
//
//
//        AplusResponse data = (AplusResponse) JsonUtils.fromJson(jsonObjects[1], (new TypeToken<AplusResponse<ChatStreamResponse>>() {
//        }).getType());
//        System.out.println(data);
////        // 遍历每个JSON对象并将其转换为JsonObject
////        for (String jsonObjectString : jsonObjects) {
////            if (!jsonObjectString.isEmpty()) {
//////                // 去除"data:"前缀
//////                jsonObjectString = jsonObjectString.substring(5);
////
////                // 将字符串转换为JsonObject
////                JsonObject jsonObject = gson.fromJson(jsonObjectString, JsonObject.class);
////
////                // 打印转换后的JSON对象
////                System.out.println(jsonObject);
////            }
////        }
//    }
//}
