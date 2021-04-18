package com.example.restfulwebservice.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
    public User retrieveUser(@PathVariable int id) {
        User user = service.findOne(id);

        if(user==null){
            throw new UserNotFoundException(String.format("ID[%s] not found", id));
        }
        return user;
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user){
        User savedUser=service.save(user);

        //GET 방식과 POST 방식의 응답 코드를 다르게 제어하기 위해 사용되는 ServletUriComponentsBuilder
        //서버에서 반환시켜 주려고 하는 데이터 값을 ResponseEntity 에 담아서 전달
        //fromCurrentRequest : 현재 요청된 request 값을 사용한다
       URI location=ServletUriComponentsBuilder.fromCurrentRequest()
               //가변 변수
               .path("/{id}")
               //요청된 사용자의 추가
                .buildAndExpand(savedUser.getId())
               //어떤 uri를 가지고 추가된 리소스를 확인할 수 있는지 정보를 반환 (상세정보 보기가 가능한 uri)
               .toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id){
        User user=service.deleteById(id);

        if(user==null){
            throw new UserNotFoundException(String.format("ID[%s] not found",id));
        }
    }
}
