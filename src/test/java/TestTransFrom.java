import com.google.gson.Gson;
import com.huya.xiao.action.common.util.HttpUtils;
import org.example.codegpt.service.metadata.Create.CreateResponse;
import org.example.codegpt.service.metadata.TransFrom.TransFromResponse;

import java.util.HashMap;
import java.util.Map;

public class TestTransFrom {
    private final String streamURL = "http://localhost:8083/v3/chat/stream";
    private final String createConservationURL = "http://localhost:8083/conversation/create";

    private final String transformMD5URL = "http://localhost:8083/conversation/";
    private final String host = "URL_ADDRESS";
    private static Gson gson = new Gson();

    public static void main(String[] args) {
        Map<String, String> createHeader = new HashMap<>();
        createHeader.put("oa-token", "eyJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJoeS1vYSIsImlhdCI6MTcyOTU5MTI0OCwic3ViIjoiU1NPIiwiZXhwIjoxNzI5ODUwNDQ4LCJjb2RlIjoiSjA3MzQiLCJ1c2VyX25hbWUiOiJsaXhpYW5nMSIsInl5X251bWJlciI6bnVsbCwieXlfYWNvdW50IjoiZHdfbGl4aWFuZzEiLCJvcmdhbml6YXRpb25JZCI6MTg4OSwiYXBwX2tleSI6IjE2MzQwODQ3NTQ1MzcwMzc4MjYiLCJ5eU51bWJlciI6bnVsbCwidXNlcl9pZCI6ImxpeGlhbmcxIiwibmlja19uYW1lIjpudWxsLCJvcmdhbml6YXRpb25faWQiOjE4ODksIm5hbWUiOiLmnY7lk40iLCJpZCI6ImxpeGlhbmcxIiwieXlfYWNjb3VudCI6ImR3X2xpeGlhbmcxIiwieXlBY291bnQiOiJkd19saXhpYW5nMSIsImVtYWlsIjoibGl4aWFuZzFAaHV5YS5jb20ifQ.SGD12rULm67HQeGeVfapbzAdgywV23GBkcL7hTpEW3Rsgj_XX9s7Mxs-p3zniIRlSFvs59rqVrb8frRhoarspe6DKE9V5YhYdCAm9XXq2g_4w7WzjPBaLxUFgGjfXXRs-80vSEpTfB3SD_6Hq-woVHl0scBJd5BSB8AJdoAQlM4lNqJ51fic2TqwRvqXT7KDbKWC6K2CMeH18R2mdnTS0S3JNHp5DNR3_lC8ANU6jU0p9_jUPvOBWwkKm9ivKN35pNWnSfTiydnjT9M_SuggajMWYIsS4I5IgP3xzpP55miAdm6NGGiSM0OS7h95ePqO7aJCZt0gjQZDt4qtfxzJgA");
        createHeader.put("content-type", "application/json");
        String URL = "http://localhost:8083/conversation/"+6019;
        String transformResponseJson = HttpUtils.doGet(URL,createHeader);
        System.out.println(transformResponseJson);
        TransFromResponse transFromResponse = gson.fromJson(transformResponseJson, TransFromResponse.class);
        String IDMD5str = transFromResponse.getData().getIdMd5();
        System.out.println(IDMD5str);
    }
}
