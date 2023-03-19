package com.eastindia.springcloud.model;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {

    private Integer id;
    private String name;
    private String phone;
}
