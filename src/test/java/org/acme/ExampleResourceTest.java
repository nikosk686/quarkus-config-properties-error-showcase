package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import io.smallrye.mutiny.Uni;
import org.junit.jupiter.api.Test;


import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;

@QuarkusTest
class ExampleResourceTest {

    @InjectMock
    ExampleClient exampleClient;

    @Test
    void testHelloEndpoint() {
        when(exampleClient.hello()).thenReturn(Uni.createFrom().item("Hello RESTEasy Reactive"));

        given()
          .when().get("/hello")
          .then()
             .statusCode(200)
             .body(is("Hello RESTEasy Reactive"));
    }

}