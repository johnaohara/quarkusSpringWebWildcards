package io.quarkus.test;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class SpringResourceTest extends AbstractResourceTest {

    @Override
    protected String getEndpoint() {
        return "/spring-web";
    }
    
    @Test
    public void testSpringHelloEndpoint() {
        validateEndpoint("/hello", 200, "hello");
    }

    @Test
    public void testSpringGreetingEndpoint() {
        validateEndpoint("/wildcard/1/quarkus", 200);
   }

    @Test
    public void testInvalidSpringGreetingEndpoint() {
        validateEndpoint("/wildcard/*/quarkus", 200);
   }

    @Test
    public void testSpringCardAboutEndpoint() {
        validateEndpoint("/wildcard/card/about", 200);
   }

    @Test
    public void testSpringCardEndpoint() {
        validateEndpoint("/wildcard/card", 200);
   }

    @Test
    public void testSpringCardVosaEndpoint() {
        validateEndpoint("/wildcard/card/vosa/registration", 200);
   }

    @Test
    public void testSpringJaxRsPatternGreetingEndpoint() {
        validateEndpoint("/pattern/1/quarkus", 200);
    }

    @Test
    public void testCarsShopEndpoint() {
        validateEndpoint("/cars/shop/info", 200, "from test1()");
    }

    @Test
    public void testCartShowEndpoint() {
        validateEndpoint("/cart/show/info", 200, "from test1()");
    }

    @Test
    public void testBarsSpeedEndpoint() {
        validateEndpoint("/bars/speed/info", 200, "from test2()");
    }

    @Test
    public void testBabbieSignalizedEndpoint() {
        validateEndpoint("/babbie/signalized/info", 200, "from test2()");
    }

}