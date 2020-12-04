package TestCases;

import io.restassured.RestAssured;
import io.restassured.response.Response;
//import org.graalvm.compiler.debug.Assertions;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;



import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static FileReadAndWrite.ReadWriteFileData.ReadFile;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.number.OrderingComparison.lessThanOrEqualTo;
import static org.testng.AssertJUnit.assertEquals;

public class RestAssuredAPI {

    @Test
    public static void TestAPI() throws IOException {
       TestLogin ();
        //Do change the email for the request body in the sheet, or else the status code will be 400!!!!
        TestSignUp ();

    }
    public static void TestGETRequest() throws  IOException
    {

      RestAssured.given()
                .baseUri("https://emumba-test.herokuapp.com/trend")
                // When
                .when()
                .get()
                // Then
                .then()
                .statusCode(201);


    }

    public static void TestLogin() throws IOException {
        //Saving Response in a variable for later usage , duhh..
        Response loginResponse=
                RestAssured
                        .given ()
                        .baseUri(ReadFile( 4,0,1))
                        .contentType("application/json")
                        .body(ReadFile( 4,2,1))
                        .when ()
                        .post ();

                loginResponse.then().assertThat ().statusCode(Integer.parseInt(ReadFile (4,4,1)));
        //following assertion will validate the schema for the login request
                assertThat(loginResponse.body ().asString (), matchesJsonSchemaInClasspath("postLogin.json"));

        //following piece of code will test the response time and response size in kbs.
        //the content read from the file are in data type String, we need to convert them to Long to
       // use them in time() funtion.
                 Long expectedTime= Long.parseLong (ReadFile (4,5,1));
                 int expectedContentLength= Integer.parseInt (ReadFile (4,5,1))*1000;
                 loginResponse.then().assertThat ().time(Matchers.lessThanOrEqualTo (expectedTime), TimeUnit.SECONDS);
                 loginResponse.then ().header ("Content-Length", Integer::parseInt, lessThanOrEqualTo(expectedContentLength));

    }

    public static void TestSignUp() throws IOException {
        //Saving Response in a variable for later usage , duhh.
        Response loginResponse=
                RestAssured
                        .given ()
                        .baseUri(ReadFile( 3,0,1))
                        .contentType("application/json")
                        .body(ReadFile( 3,2,1))
                        .when ()
                        .post ();
        //following piece of code will verify the status code for login post request.
        loginResponse.then().assertThat ().statusCode(Integer.parseInt(ReadFile (4,4,1)));
        //following assertion will validate the schema for the login request
        assertThat(loginResponse.body ().asString (), matchesJsonSchemaInClasspath("postSignUp.json"));
        //following piece of code will test the response time and response size in kbs.
        //the content read from the file are in data type String, we need to convert them to Long to
        // use them in time() funtion.
        Long expectedTime= Long.parseLong (ReadFile (3,5,1));
        int expectedContentLength= Integer.parseInt (ReadFile (3,5,1))*1000;
        loginResponse.then().assertThat ().time(Matchers.lessThanOrEqualTo (expectedTime), TimeUnit.SECONDS);
        loginResponse.then ().header ("Content-Length", Integer::parseInt, lessThanOrEqualTo(expectedContentLength));

    }
}

