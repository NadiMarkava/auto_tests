package api;

import io.restassured.response.Response;

public class UsersAPIUtil {

    public static String postUserAndGetId() {
        PostUserMethod postUserMethod = new PostUserMethod();
        postUserMethod.setProperties("api/users/user.properties");
        Response response = postUserMethod.callAPIExpectSuccess();
        return response.path("id").toString();
    }
}
