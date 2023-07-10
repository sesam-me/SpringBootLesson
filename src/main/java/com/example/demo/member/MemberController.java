package com.example.demo.member;

import com.example.demo.store.Store;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/members") // 서버를 만들때는 api를 적어라?
public class MemberController {
    private final MemberService memberService;

//    @RequiredArgsConstructor 애노테이션은 클래스의 final 필드나 @NonNull으로 표시된 필드에 대한 생성자를 자동으로 생성
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }



    @GetMapping
    public List<Member> findALl(){
        return memberService.findAll();
    }

    @GetMapping("{name}")
    public Member findByName(@PathVariable("name") String name){
        return memberService.findByName(name);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody MemberRequest member){
        Store.members.add(member.toEntity());
    }

    @DeleteMapping({"{name}"})
    public void delete(@PathVariable("name") String name){
        memberService.delete(name);
    }

    @PutMapping("{name}")
    public void update(@PathVariable("name") String name, @RequestBody MemberRequest memberRequest){
        memberService.update(name,memberRequest);
    }

}
