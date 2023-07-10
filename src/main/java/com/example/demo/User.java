package com.example.demo;

import lombok.*;
import org.springframework.context.annotation.Primary;

import java.security.PrivateKey;



//@Getter @Setter @AllArgsConstructor @NoArgsConstructor @ToString
@Data // 모든 걸 포함한게 @Data
@AllArgsConstructor
public class User {
    private String name;
    private Integer age;

}
