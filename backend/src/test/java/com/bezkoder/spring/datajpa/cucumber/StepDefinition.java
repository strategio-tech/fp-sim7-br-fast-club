package com.bezkoder.spring.datajpa.cucumber;

import java.io.InputStream;
import java.util.Scanner;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import com.github.tomakehurst.wiremock.WireMockServer;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;



// @CucumberContextConfiguration
// @SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StepDefinition {

    private static final String TEST_USER_ID = "testuserCuke";
    private static final String RESTAURANT_GET_PATH = "/api/restaurants";
    private static final String RESTAURANT_POST_PATH = "/api/collections/testuserCuke/restaurants";
    private static final String COLLECTION_GET_PATH = "/api/collections/testuserCuke/restaurants";
    private static final String COLLECTION_POST_PATH = "/api/collections";
    private static final String COLLECTION_CHECK_PATH = "/api/collection/testuserCuke";
    private static final String APPLICATION_JSON = "application/json";

    private final static String BASE_URI = "http://localhost";

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

    }
    @Then("There will be a collection for that user")
    public void collectionCheckResponse() throws Throwable{

    }


    @Given("User send a GET request for the collection")
    public void userGetCollection() throws Throwable{

    }
    @Then("There is a collection information returned")
    public void collectionInformationResponse() throws Throwable{

    }


    @Given("User send a POST request with the information of the restaurant")
    public void userPostRestaurant() throws Throwable{

    }
    @Then("The restaurant is created and its information returned")
    public void restaurantCreatedReturned() throws Throwable{

    }


    @Given("User send a GET request to see the information of all restaurants")
    public void userGetRestaurants() throws Throwable{

    }
    @Then("The list of restaurant is returned")
    public void restaurantsResponseReturn() throws Throwable{

    }


    @Given("User send a GET request to see the restaurants in their collection")
    public void userGetCollectionRestaurants() throws Throwable{

    }
    @Then("The list of restaurents in their collection is returned")
    public void collectionRestaurantsResponseReturn() throws Throwable{

    }

    // private static final InputStream jsonInputStream = this.getClass().getClassLoader().getResourceAsStream("test.json");
    // private final String jsonString = new Scanner(jsonInputStream, "UTF-8").useDelimiter("\\Z").next();
}
