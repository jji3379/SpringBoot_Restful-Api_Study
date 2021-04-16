package com.example.restfulwebservice.helloworld;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// lombok => getter, setter 자동 생성 @Data 추가
@Data
@AllArgsConstructor // 생성자 만들어짐
@NoArgsConstructor // 디폴트 생성자 생성
public class HelloWorldBean {
    private String message; // 결과 : {"message":"Hello World"}

}
