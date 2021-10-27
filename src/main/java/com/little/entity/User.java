package com.little.entity;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private String UserName;
    private String Passwd;
    private String Sex;
    private Date LastDate;
}
