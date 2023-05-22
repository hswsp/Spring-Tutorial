package com.springboot.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Account {
    private String account;
    private String name;
    private String password;
    private String accountType;
    private String tel;
}
