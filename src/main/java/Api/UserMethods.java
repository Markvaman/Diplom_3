package Api;

import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class UserMethods extends RestClient {
public ValidatableResponse create(User user) {
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
