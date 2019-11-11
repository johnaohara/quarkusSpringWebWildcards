package io.quarkus.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/spring-web")
public class SpringResource {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/wildcard/*/{name}")
    public String testWildCard(@PathVariable String name){
        return "hello " + name;
    }

    @GetMapping("/pattern/{id: .*}/{name}")
    public String testPattern(@PathVariable("name") String name){
        return "hello " + name;
    }

    @RequestMapping("/wildcard/card/**")
    public String test3() {
        return "from test3()";
    }
    @RequestMapping("/car?/s?o?/info")
    public String test1() {
        return "from test1()";
    }

    @RequestMapping("/b*/s*d/info")
    public String test2() {
        return "from test2()";
    }
}