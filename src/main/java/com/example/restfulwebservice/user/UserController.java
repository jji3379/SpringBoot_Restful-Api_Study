package com.example.restfulwebservice.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    private UserDaoService service;

    //생성자를 이용하여 의존성을 주입하는 방법
    //생성자의 매개변수를 통해서 전달하고자 하는 객체의 인스턴스를 선언
    public UserController(UserDaoService service){
        this.service=service;
    }

    @GetMapping("/users")
    public List<User> retrieveAllUsers(){
        //control(나는 오른쪽 control) + 마우스커서 : 메소드로 바로 갈 수 있음
        return service.findAll();
    }

    // GET /users/1 or users/10
    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable int id){
        return service.findOne(id);
    }
}
