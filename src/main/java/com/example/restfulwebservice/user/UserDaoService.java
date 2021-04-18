package com.example.restfulwebservice.user;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
public class UserDaoService {
    private static List<User> users=new ArrayList<>();

    private static int usersCount=3;

    //User 파일에서 lombok 으로 생성자가 만들어졌기에 가능
    static{
        users.add(new User(1,"Kenneth",new Date()));
        users.add(new User(2,"Alice",new Date()));
        users.add(new User(3,"Elena",new Date()));
    }
    //모든 유저 정보 추출
    public List<User> findAll(){
        return users;
    }
    //새로운 유저 추가
    public User save(User user){
        if(user.getId()==null){
            user.setId(++usersCount);
        }
        users.add(user);
        return user;
    }

    //현재는 DB와 연동된 것이 아니기에 이런식으로 작성한 것임
    //한명의 데이터 추출
    public User findOne(int id){
        for(User user:users){
            if(user.getId()==id){
                return user;
            }
        }
        return null;
    }

    public User deleteById(int id){
        // Iterator : 열거형 데이터를(배열, 리스트 등) 순차적으로 접근 하기 위한 열거형 데이터 타입
        Iterator<User> iterator=users.iterator();

        while (iterator.hasNext()){
            User user=iterator.next();

            if(user.getId() ==id){
                iterator.remove();
                return user;
            }
        }

        return null;
    }
}
