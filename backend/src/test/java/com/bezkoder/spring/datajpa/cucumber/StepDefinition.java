package com.bezkoder.spring.datajpa.cucumber;

import java.io.InputStream;
import java.util.Scanner;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import com.github.tomakehurst.wiremock.WireMockServer;
import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.configureFor;
import static com.github.tomakehurst.wiremock.client.WireMock.containing;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.getRequestedFor;
import static com.github.tomakehurst.wiremock.client.WireMock.post;
import static com.github.tomakehurst.wiremock.client.WireMock.postRequestedFor;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static com.github.tomakehurst.wiremock.client.WireMock.verify;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
// import static org.junit.Assert.assertThat;

import static org.hamcrest.MatcherAssert.assertThat;

// import com.github.tomakehurst.wiremock.WireMockServer;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;


// @CucumberContextConfiguration
// @SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StepDefinition {

    private static final String TEST_USER_ID = "testuserCuke";
    private static final String RESTAURANT_GET_PATH = "/api/restaurants";
    private static final String RESTAURANT_POST_PATH = "/api/collections/testuserCuke/restaurants";
    private static final String COLLECTION_GET_PATH = "/api/collections/testuserCuke/restaurants";
    private static final String COLLECTION_POST_PATH = "/api/collections";
    // private static final String COLLECTION_CHECK_PATH = "/api/collection/testuserCuke";
    private static final String APPLICATION_JSON = "application/json";

    private final static String BASE_URI = "http://localhost";

    private final InputStream jsonInputStream = this.getClass().getClassLoader().getResourceAsStream("cucumber.json");
    private final String jsonString = new Scanner(jsonInputStream, "UTF-8").useDelimiter("\\Z").next();

    private final WireMockServer wireMockServer = new WireMockServer(options().dynamicPort());
    private final CloseableHttpClient httpClient = HttpClients.createDefault();

    // @LocalServerPort
    // private int port;

    // private ValidatableResponse validatableResponse;

    // private void configureRestAssured(){
    //     RestAssured.baseURI = BASE_URI;
    //     RestAssured.port = port;
    // }

    // protected RequestSpecification requestSpecification(){
    //     configureRestAssured();
    //     return given();
    // }

    @Given("user logged in to the system and their collection is created now or before")
    public void userLoggedInCollectionThere() throws Throwable{
        wireMockServer.start();

        configureFor("localhost", wireMockServer.port());

        stubFor(post(urlEqualTo(COLLECTION_POST_PATH))
                .withHeader("content-type", equalTo(APPLICATION_JSON))
                .withRequestBody(containing("testing-framework"))
                .willReturn(aResponse().withStatus(200)));

        HttpPost request = new HttpPost("http://localhost:" + wireMockServer.port() + COLLECTION_POST_PATH);
        StringEntity entity = new StringEntity(jsonString);
        request.addHeader("content-type", APPLICATION_JSON);
        request.setEntity(entity);
        HttpResponse response = httpClient.execute(request);

        assertEquals(200, response.getStatusLine().getStatusCode());
        verify(postRequestedFor(urlEqualTo(COLLECTION_POST_PATH))
                .withHeader("content-type", equalTo(APPLICATION_JSON)));

        wireMockServer.stop();

    }
    @Then("There will be a collection for that user")
    public void collectionCheckResponse() throws Throwable{

    }





    @Given("User send a POST request with the information of the restaurant")
    public void userPostRestaurant() throws Throwable{
        //TODO: after Restaurant DELETE is implemented
    }
    @Then("The restaurant is created and its information returned")
    public void restaurantCreatedReturned() throws Throwable{

    }


    @Given("User send a GET request to see the information of all restaurants")
    public void userGetRestaurants() throws Throwable{
        wireMockServer.start();

        configureFor("localhost", wireMockServer.port());
        stubFor(get(urlEqualTo(RESTAURANT_GET_PATH)).withHeader("accept", equalTo(APPLICATION_JSON))
                .willReturn(aResponse().withBody(jsonString)));

        HttpGet request = new HttpGet("http://localhost:" + wireMockServer.port() + RESTAURANT_GET_PATH);
        request.addHeader("accept", APPLICATION_JSON);
        HttpResponse httpResponse = httpClient.execute(request);
        String responseString = convertResponseToString(httpResponse);

        assertThat(responseString, containsString("address"));
        verify(getRequestedFor(urlEqualTo(RESTAURANT_GET_PATH)).withHeader("accept", equalTo(APPLICATION_JSON)));

    }
    @Then("The list of restaurant is returned")
    public void restaurantsResponseReturn() throws Throwable{

    }


    @Given("User send a GET request to see the restaurants in their collection")
    public void userGetCollectionRestaurants() throws Throwable{
        //TODO: after Restaurant DELETE is implemented
    }
    @Then("The list of restaurents in their collection is returned")
    public void collectionRestaurantsResponseReturn() throws Throwable{

    }

    private String convertResponseToString(HttpResponse response) throws Throwable {
        InputStream responseStream = response.getEntity().getContent();
        Scanner scanner = new Scanner(responseStream, "UTF-8");
        String responseString = scanner.useDelimiter("\\Z").next();
        scanner.close();
        return responseString;
    }

    // private static final InputStream jsonInputStream = this.getClass().getClassLoader().getResourceAsStream("test.json");
    // private final String jsonString = new Scanner(jsonInputStream, "UTF-8").useDelimiter("\\Z").next();
}
