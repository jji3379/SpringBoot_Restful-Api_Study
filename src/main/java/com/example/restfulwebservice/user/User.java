package com.example.restfulwebservice.user;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@AllArgsConstructor
public class User {
    private Integer id;

    //pom.xml 에 dependency 추가
    @Size(min=2, message = "Name은 2글자 이상 입력해 주세요.")
    private String name;
    //회원이 가입하는 날짜는 미래 데이터는 올 수 없고
    //과거 데이터만 올 수 있다
    @Past
    private Date joinDate;
}
