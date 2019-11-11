package io.quarkus.test;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class RestEasyResourceTest extends AbstractResourceTest {

    @Override
    protected String getEndpoint() {
        return "/resteasy";
    }

    @Test
    public void testRestHelloEndpoint() {
        validateEndpoint("/hello", 200, "hello");
    }

    @Test
    public void testPatternGreetingEndpoint() {
        validateEndpoint("/pattern/1/quarkus", 200, "hello quarkus");
    }

    @Test
    public void testPatternStarGreetingEndpoint() {
        validateEndpoint("/pattern/*/quarkus", 200);
    }


    @Test
    public void testRestWildcardEndpoint() {
        validateEndpoint("/wildcard/1/quarkus", 404);
    }

    @Test
    public void testRestWildcardStarEndpoint() {
        validateEndpoint("/wildcard/*/quarkus", 200, "hello quarkus");
    }

    @Test
    public void testRestVarWildcardEndpoint() {
        validateEndpoint("/pathA/a/b/c/d/pathZ", 200);
    }

}