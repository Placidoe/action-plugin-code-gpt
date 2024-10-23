import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.example.codegpt.service.metadata.StreamDto;

public class TestStreamDto {
    public static void main(String[] args) {
        // 创建一个Gson对象
        Gson gson = new Gson();

// 假设你有一个JSON字符串
        String jsonString = "{\"stream\":{\"ret_code\":0,\"err_msg\":\"12312312312312\",\"res_delta\":\"4444444444444\",\"index\":1}}";

// 使用Gson将JSON字符串转换为JsonObject对象
        JsonObject jsonObject = gson.fromJson(jsonString, JsonObject.class);

// 从JsonObject中提取stream对象
        JsonObject streamObject = jsonObject.getAsJsonObject("stream");

// 使用Gson将stream对象转换为StreamDto对象
        StreamDto streamDto = gson.fromJson(streamObject, StreamDto.class);

// 现在你可以使用streamDto对象了
        System.out.println(streamDto.getRet_code());
        System.out.println(streamDto.getErr_msg());
        System.out.println(streamDto.getRes_delta());
        System.out.println(streamDto.getIndex());

    }
}
