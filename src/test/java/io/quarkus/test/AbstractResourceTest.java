package io.quarkus.test;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.jboss.resteasy.spi.NotImplementedYetException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

public abstract class AbstractResourceTest {

    protected void validateEndpoint(String path, int expectedResponseCode) {
        this.validateEndpoint(path, expectedResponseCode, null);
    }

    protected void validateEndpoint(String path, int expectedResponseCode, String expectedBody) {

        given()
                .when().get(getEndpoint() + path)
                .then()
                .statusCode(expectedResponseCode)
                .body((expectedBody == null) ? mockMatcher : is(expectedBody));

    }

    protected abstract String getEndpoint();

    /*
        mocked matcher that always matches no matter input
    */
    private static Matcher<String> mockMatcher = new Matcher<String>() {

        @Override
        public boolean matches(Object actual) {
            return true;
        }

        @Override
        public void describeMismatch(Object actual, Description mismatchDescription) {
            throw new NotImplementedYetException();
        }

        @Override
        public void _dont_implement_Matcher___instead_extend_BaseMatcher_() {
            throw new NotImplementedYetException();
        }

        @Override
        public void describeTo(Description description) {
            description.appendText("dummy matcher always matches ");
        }
    };
}