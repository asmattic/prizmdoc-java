package groupIdOne;

import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


/**
 * Hello world!
 *
 */

public class App {
    OkHttpClient client = new OkHttpClient();

    // post request code here

    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");


    String createViewingSessionJson() {
        return "{\r\n    \"source\": {\r\n        \"type\": \"upload\",\r\n        \"displayName\": \"test\"\r\n    }\r\n}";
    }
/*
    private void printResponse() {

    }
*/
    String doPostRequest(String url, String json) throws IOException {
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Response response = client.newCall(request).execute();
        // print response
        System.out.println("========= Response \n" + " response code: " + response.code());
        return response.body().string();
    }

    public static void main(String[] args) throws IOException {
        // Initialize
        App example = new App();

        // issue the post request
        String json = example.createViewingSessionJson();
        String postResponse = example.doPostRequest("http://localhost:3000/ViewingSession", json);
        System.out.println("postresponse" + postResponse);
    }
}