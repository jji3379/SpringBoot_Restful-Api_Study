package com.example.restfulwebservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    // GET
    // hello-world (endpoint)
    // @RequestMapping(method=RequestMethod.GET, path="/hello-world")
    // 웹 브라우저에 http://localhost:8888/hello-world 치면 "Hello World" 나옴
    @GetMapping(path="/hello-world")
    public String helloWorld(){
        return "Hello World";
    }

    // alt + enter, Generator, Refactor => 나는 command +1
    @GetMapping(path="/hello-world-bean")
    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("Hello World");
        // 결과 : {"message":"Hello World"}
    }

    @GetMapping(path="/hello-world-bean/path-variable/{name}")
    public HelloWorldBean helloWorldBean(@PathVariable String name){ //다른 값일 경우 @PathVariable(value="name")
        return new HelloWorldBean(String.format("Hello World, %s",name));
        // 결과 : {"message":"Hello World"}
    }
}
