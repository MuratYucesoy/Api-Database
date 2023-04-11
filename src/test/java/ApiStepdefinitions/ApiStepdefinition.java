package ApiStepdefinitions;

import com.github.javafaker.Faker;
import hooks.HooksAPI;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;
import pojos.*;
import utilities.APIUtils;

import java.awt.print.Book;
import java.util.*;

import static io.restassured.RestAssured.given;

public class ApiStepdefinition {
    APIUtils apiUtils;
    Response response;
    Trendlife_Id_Request idRequest;
    public static String fullPath;
    State_id stateId;

    Trendlife_Expected_Body trendlife_expected_body;
    Trendlife_AddressesBody trendlife_addressesBody;

    Trendlife_AddressesBody addressesBody;
    Trendlife_InnerGet_City innerGet_city;
    Trendlife_InnerGet_State innerGet_state;
    Trendlife_InnerGet_Country innerGet_country;
    Country_id countryId;
    Trendlife_Expected_Body expectedBody;
    JSONObject reqBody01;
    Trendlife_Expected_Body expected_body;

    @Given("Istenilen {string} endpoint adrsine gidilir")
    public void istenilen_endpoint_adrsine_gidilir(String rawPaths) {
        //  spec.pathParams("pp1","api","pp2","login");
        //  Response response = given().when().get("{pp1}/{pp2}");

        String[] paths = rawPaths.split(",");
        StringBuilder tempPath = new StringBuilder("{");

        for (int i = 0; i < paths.length; i++) {
            String key = "pp" + i;
            String value = paths[i].trim();
            HooksAPI.spec.pathParam(key, value);

            tempPath.append(key + "}/{");
        }
        tempPath.deleteCharAt(tempPath.lastIndexOf("{"));
        tempPath.deleteCharAt(tempPath.lastIndexOf("/"));

        fullPath = tempPath.toString();
        System.out.println(fullPath);
    }

    @And("US_onalti_TC_sifirbir icin request body olusturulur")
    public void us_onalti_tc_sifirbirIcinRequestBodyOlusturulur() {
        idRequest = new Trendlife_Id_Request(223);

    }

    @Then("Response kaydedilir")
    public void response_kaydedilir() {
        response = given()
                .headers("Authorization", "Bearer " + HooksAPI.token)
                .contentType(ContentType.JSON)
                .spec(HooksAPI.spec)
                .when().body(idRequest)
                .get(fullPath);
        response.prettyPrint();
    }


    @Then("US_onalti_TC_sifiriki icin request body olusturulur")
    public void us_onalti_tc_sifiriki_icin_request_body_olusturulur() {
        idRequest = new Trendlife_Id_Request(20);
    }

    @Then("US_onalti_TC_sifiriki icin expected body olustur")
    public void us_onalti_tc_sifirikiIcinExpectedBodyOlustur() {

        innerGet_country = new Trendlife_InnerGet_Country(231, "US", "United States", "1", "/flags/flag-of-United-States-of-America.jpg", 1, null, null);
        innerGet_state = new Trendlife_InnerGet_State(3953, "New Jersey", 231, 1, null, null);
        innerGet_city = new Trendlife_InnerGet_City(47790, "Asbury Park", 3953, 1, null, null);
        addressesBody = new Trendlife_AddressesBody( 20, 40, "asdfasdf", "234141234", "sadfas@asda.com", "22", "47790", "3953", "231", "23423", 0, 0, "2022-12-20T17:15:49.000000Z", "2022-12-21T04:59:45.000000Z", innerGet_country, innerGet_state,innerGet_city);
        Trendlife_AddressesBody [] adres={addressesBody};
        expectedBody=new Trendlife_Expected_Body(adres,"success");

    }

    @Then("US_onalti_TC_sifiriki icin response kaydedilir")
    public void us_onalti_tc_sifiriki_icin_response_kaydedilir() {
        response = given().
                headers("Authorization", "Bearer " + HooksAPI.token).
                spec(HooksAPI.spec).
                contentType(ContentType.JSON).
                when().
                body(idRequest).
                get(fullPath);
    }

    @Then("US_onalti_TC_sifiriki icin assertion islemi yapilir")
    public void us_onalti_tc_sifiriki_icin_assertion_islemi_yapilir() {
        Trendlife_Expected_Body resBody=response.as(Trendlife_Expected_Body.class);
        Assert.assertEquals(expectedBody.getMessage(),resBody.getMessage());
        Assert.assertEquals(expectedBody.getAddresses(),resBody.getAddresses());


    }

    @Then("US_onalti_TC_sifirdort icin response kaydeder")
    public void us_onalti_tc_sifirdort_icin_response_kaydeder() {
        response = given()
                .headers("Authorization", "Bearer " + HooksAPI.token)
                .contentType(ContentType.JSON)
                .spec(HooksAPI.spec)
                .when()
                .get(fullPath);
    }


    @Then("US_onalti_TC_sifiruc icin request body olusturur")
    public void us_onalti_tc_sifirucIcinRequestBodyOlusturur() {
        idRequest = new Trendlife_Id_Request(3336);

    }

    @Then("US_onalti_TC_sifiruc icin response kaydeder")
    public void us_onalti_tc_sifirucIcinResponseKaydeder() {
        response = given()
                .headers("Authorization", "Bearer " + HooksAPI.token)
                .contentType(ContentType.JSON)
                .spec(HooksAPI.spec)
                .when().body(idRequest)
                .get(fullPath);


    }

    @Then("Status Code {int} ve message {string} bilgileri assert edilir")
    public void statusCodeVeMessageBilgileriAssertEdilir(int arg0, String arg1) {
        response.then().assertThat().statusCode(arg0).body("message", Matchers.equalTo(arg1));
    }


    @Then("US_onalti_TC_sifirbes icin response kaydeder")
    public void us_onalti_tc_sifirbesIcinResponseKaydeder() {

        response =given()
                .headers("Authorization", "Bearer " + HooksAPI.token)
                .contentType(ContentType.JSON)
                .spec(HooksAPI.spec)
                .when()
                .get(fullPath);
        response.prettyPrint();
        ;
    }


    @Then("US_onalti_TC_sifiralti icin request body olusturulur")
    public void us_onalti_tc_sifiraltiIcinRequestBodyOlusturulur() {
        countryId = new Country_id(22);

    }

    @And("US_onalti_TC_sifiralti icin response kaydeder")
    public void us_onalti_tc_sifiraltiIcinResponseKaydeder() {
        response = given()
                .headers("Authorization", "Bearer " + HooksAPI.token)
                .contentType(ContentType.JSON)
                .spec(HooksAPI.spec)
                .when().body(countryId)
                .get(fullPath);
    }

    @Then("US_onalti_TC_sifirsekiz icin request body olusturulur")
    public void us_onalti_tc_sifirsekizIcinRequestBodyOlusturulur() {
        stateId = new State_id(1);
    }

    @And("US_onalti_TC_sifirsekiz icin response kaydeder")
    public void us_onalti_tc_sifirsekizIcinResponseKaydeder() {

        response = given()
                .headers("Authorization", "Bearer " + HooksAPI.token)
                .contentType(ContentType.JSON)
                .spec(HooksAPI.spec)
                .when().body(stateId)
                .get(fullPath);
    }


    @Then("US_onalti_TC_sifiryedi icin response kaydeder")
    public void us_onalti_tc_sifiryediIcinResponseKaydeder() {
        countryId = new Country_id(223);
        response = given()
                .headers("Authorization", "Bearer " + HooksAPI.token)
                .contentType(ContentType.JSON)
                .spec(HooksAPI.spec)
                .when().body(countryId)
                .get(fullPath);

    }


    @And("Asserttion yapar")
    public void asserttionYapar() {

        RestAssured.baseURI = "https://restapi.demoqa.com/utilities/books/getallbooks";
        RequestSpecification request = RestAssured.given();

        Response response = request.get();
        System.out.println("Response Body -> " + response.body().asString());
        //https://trendlifebuy.comapi/profile/countryStates
    }


    @And("US_onlati TC_sifirbes {string} {string} {string} Assertion yapar")
    public void us_onlatiTC_sifirbesAssertionYapar(String arg0, String code, String name) {

        JsonPath jsonPath=response.jsonPath();
        Assert.assertEquals(jsonPath.get("addresses[222].code"),code);
        Assert.assertEquals(jsonPath.get("addresses[222].name"),name);
    }

    @And("US_onlati TC_sifirbes id {string} {string} Assertion yapar")
    public void us_onlatiTC_sifirbesIdAssertionYapar(String code, String name) {

        JsonPath jsonPath=response.jsonPath();
        Assert.assertEquals(jsonPath.get("addresses[222].code"),code);
        Assert.assertEquals(jsonPath.get("addresses[222].name"),name);
    }

    @And("US_onlati TC_sifirbes id, code {string} ve icin name {string} Assertion yapar")
    public void us_onlatiTC_sifirbesIdCodeVeIcinNameAssertionYapar(String code, String name) {
        JsonPath jsonPath=response.jsonPath();
        Assert.assertEquals(jsonPath.get("addresses[222].code"),code);
        Assert.assertEquals(jsonPath.get("addresses[222].name"),name);
    }

    @Then("US_sifir sifir_bir icin request body olusturulur")
    public void us_sifirSifir_birIcinRequestBodyOlusturulur() {
        /*
        {
  "first_name": "abc",
  "last_name": "bcd",
  "username":"efg",
  "email": "jjksjd@gmail.com",
  "password": "As.23123123",
  "password_confirmation": "As.23123123",
  "user_type": "customer",
  "phone":"12112312233",
  "referral_code": "4454653445464546"
}
         */
        Faker faker=new Faker();
        String password=faker.internet().password();
        reqBody01=new JSONObject();

        reqBody01.put("first_name",faker.name().firstName());
        reqBody01.put("last_name",faker.name().lastName());
        reqBody01.put("username",faker.name().username());
        reqBody01.put("email",faker.internet().emailAddress());
        reqBody01.put("password",password);
        reqBody01.put("password_confirmation",password);
        reqBody01.put("user_type",faker.team().name());
        reqBody01.put("phone",faker.phoneNumber().cellPhone());
        reqBody01.put("referral_code",faker.code().asin());



    }

    @And("US_sifir_bir sifir_bir icin response kaydeder")
    public void us_sifir_birSifir_birIcinResponseKaydeder() {
        response = given()
                .headers("Authorization", "Bearer " + HooksAPI.token)
                .contentType(ContentType.JSON)
                //.accept(ContentType.JSON)
                .spec(HooksAPI.spec)
                .when().body(reqBody01.toString())
                .post(fullPath);
        response.prettyPrint();
    }
}







