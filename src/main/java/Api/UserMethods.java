package Api;

import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.useRelaxedHTTPSValidation;

public class UserMethods extends RestClient {
    private User user;
public ValidatableResponse create(String name, String email, String password) {
    user = new User(email, name, password);
    return
            given()
                    .spec(getBaseSpec())
                    .body(user)
                    .when()
                    .post("/api/auth/register/")
                    .then();
}

public ValidatableResponse login(User user) {
    return
            given()
                    .spec(getBaseSpec())
                    .body(user)
                    .when()
                    .post("/api/auth/login")
                    .then();
}

public ValidatableResponse delete(String accessToken) {
    return
            given()
                    .spec(getBaseSpec())
                    .header("Authorization", accessToken)
                    .when()
                    .delete("/api/auth/user/")
                    .then();
}

}
