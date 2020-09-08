package com.example.Carolyn.practice;

import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class CarolynPracticeApplicationTests {
    @LocalServerPort
    int port;

    @Before
    public void setUp() {
        RestAssured.port = port;
    }

    @Test
    public void givenEnterTwoNumbersEqualsOddTest() {
        given().
            queryParam("first-number", "1").
            queryParam("second-number", "6").
        when().
            get("/odd").
        then().
            assertThat().
            statusCode(Integer.parseInt("200"));
//				body(equalTo("200"));
    }

    @Test
    public void givenTwoNumbersEnteredDoesNotEqualOddTest() {
        given().
            queryParam("first-number", "2").
            queryParam("second-number", "6").
        when().
            get("/odd").
        then().
            assertThat().
            statusCode(Integer.parseInt("200"));
//				body(equalTo("200"));
    }

    @Test
    public void givenEnterTwoNumbersEqualsEvenTest() {
        given().
            queryParam("first-number", 4).
            queryParam("second-number", 2).
        when().
            get("/even").
        then().
            assertThat().
            body(equalTo("200"));
    }

    @Test
    public void givenEnterTwoNumbersDoesNotEqualEvenTest() {
        given().
            queryParam("first-number", 5).
            queryParam("second-number", 2).
        when().
            get("/even").
        then().
            assertThat().
            body(equalTo("207"));
    }

    @Test
    public void givenLeapYearIsEnteredTest() {
        given().
            queryParam("year", "2020").
        when().
            get("/leap").
        then().
            assertThat().
            body(equalTo("200"));
    }

    @Test
    public void givenLeapYearIsNotEnteredTest() {
        given().
            queryParam("year", "1999").
        when().
            get("/leap").
        then().
            assertThat().
            body(equalTo("207"));
    }

    @Test
    public void when_PalindromeIsEntered_expect_APalindrome() {
        given().
            queryParam("word", "racecar").
        when().
            get("/palindrome").
        then().
            assertThat().
            body(equalTo("It is a palindrome!"));
    }

    @Test
    public void when_NoPalindromeIsEntered_expect_NoAPalindrome() {
        given().
            queryParam("word", "racecars").
        when().
            get("/palindrome").
        then().
            assertThat().
            body(equalTo("Not a palindrome"));
    }

//	@Test
//	public void givenAnArrayisEnteredTests() {
//		given().(ArrayList<Integer>(), 1,4,5,6,3,7,2);
//		when().
//	}

}
