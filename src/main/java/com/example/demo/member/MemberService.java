package com.example.demo.member;

import com.example.demo.store.Store;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    public List<Member> findAll(){
        return Store.members;
    }

    public Member findByName(String name){
        return Store.members.stream().filter(u->u.getName().equals(name)).findFirst().orElse(null);
    }

    public void delete(String name){
//      내가 쓴거 빼고(!) list를 보여줘
        Store.members.remove(findByName(name));
    }

    public void update(String name, MemberRequest memberRequest){
        Member byname = findByName(name);
        byname.setAge(memberRequest.getAge());
        byname.setName(memberRequest.getName());

        Store.members = Store.members.stream().map(u -> u.getName().equals(name) ? byname : u).toList();

    }

}
