package org.acme

import io.restassured.RestAssured.given
import org.junit.jupiter.api.Test
import io.quarkus.test.junit.QuarkusTest

@QuarkusTest
class UsersEndpointTest {
    @Test
    fun `List all users`() {
        given()
            .`when`().get("/users")
            .then()
            .statusCode(200)
    }
}