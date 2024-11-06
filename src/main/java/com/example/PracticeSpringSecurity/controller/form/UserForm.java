package com.example.PracticeSpringSecurity.controller.form;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Objects;


@Data
@Component
public class UserForm {

    private int id;
    private String account;
    private String password;
    private String passCheck;
    private String name;
    private Integer branchId;
    private Integer departmentId;
    private Integer isStopped;
    private Date createdDate;
    private Date updatedDate;

    private String loginTime;
    private int messageCount;
    private int commentCount;
}
