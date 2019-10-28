package edu.csu2017fa314.T30.Controller;

import com.google.gson.Gson;
import edu.csu2017fa314.T30.Model.Users.User.User;
import edu.csu2017fa314.T30.TripCo;
import org.json.JSONObject;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import spark.Spark;
import spark.utils.IOUtils;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.*;


public class UserControllerTest {

    @BeforeClass
    public static void beforeClass() throws SQLException {
        TripCo.main(null);
    }

    @AfterClass
    public static void afterClass() {
        Spark.stop();
    }

    @Test
    public void user() {

        JSONObject myData   = new JSONObject();
        myData.put("id","3000");
        myData.put("email","emails");
        myData.put("firstName","Mike");
        myData.put("lastName","Lynn");
        String json = myData.toString();

        UserControllerTest.TestResponse res = request("/user", json);
        JSONObject myResponse = new JSONObject(res.body.toString() );
        System.out.println("res fghfghbody" + myResponse + "testset");
        User user = new Gson().fromJson(res.body, User.class);
        assertEquals(200, res.status);
        assertEquals(user.id, "3000");
    }

    private UserControllerTest.TestResponse request(String path, String json) {


        try {

            URL url = new URL("http://localhost:4567" + path);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            // Ensure the Connection Will Be Used to Send Content
            connection.setDoOutput(true);

            OutputStream os = connection.getOutputStream();
            os.write(json.getBytes("UTF-8"));
            os.close();

            connection.connect();
            String body = IOUtils.toString(connection.getInputStream());
            return new UserControllerTest.TestResponse(connection.getResponseCode(), body);
        } catch (IOException e) {
            e.printStackTrace();
            fail("Sending request failed: " + e.getMessage());
            return null;
        }
    }

    private static class TestResponse {

        public final String body;
        public final int status;

        public TestResponse(int status, String body) {

            this.status = status;
            this.body = body;
        }

        public Map<String,String> json() {
            return new Gson().fromJson(body, HashMap.class);
        }
    }


}
