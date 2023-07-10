package com.example.demo.member;

import lombok.*;

@RequiredArgsConstructor
@Getter
public class MemberRequest {
    private final String name;
    private final Integer age;

    public Member toEntity(){
        return new Member(name,age);
    }

}
