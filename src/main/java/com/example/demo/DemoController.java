package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("users")
public class DemoController {
    List<User> userList = new ArrayList<>();
   
    public DemoController(){
        userList.add(new User("김수동", 29));    
        userList.add(new User("이세인", 25));    
        userList.add(new User("이태웅", 26));    
        userList.add(new User("정민균", 28));
    }
    
    @GetMapping
//    @ResponseBody // 뷰가 아닌(jsp없을 때),데이터(return "test")만 보내고 싶을 때 -> @RestController달면 이거 매번 안써도 됨
    public List<User> findAll() throws InterruptedException {
        return userList;
    }

    @GetMapping("{name}") // {중괄호} : 변수
    public User findByName(@PathVariable("name") String name){
        return userList.stream().filter(u -> u.getName().equals(name)).findFirst().orElse(null);
    }


//  ## INSERT ##
    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity insert(@RequestBody User user){ //@RequestBody : @ModelAttribute와 비슷
//      ResponseEntity : 상태코드 보내줌?

//      만약 user가 있을 때는 201
        User user1 = userList.stream().filter(u -> u.getName().equals(user.getName())).findFirst().orElse(null);
        if(user1==null){
            userList.add(user);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } else{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); }
    }

    @DeleteMapping("{name}")
    public void delete(@PathVariable("name") String name){
        userList = userList.stream().filter(u->!u.getName().equals(name)).toList();
    }

    @PutMapping("{name}")
    public void update(@PathVariable("name") String name, @RequestBody User user){
        userList = userList.stream().map(u->u.getName().equals(name) ? user : u).toList();
    }
}

