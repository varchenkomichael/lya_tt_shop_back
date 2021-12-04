package com.varchenko.ttshop.model;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class User {

    private int id;
    private String phone;
    private String email;
    private String username;
    private String password;

}
