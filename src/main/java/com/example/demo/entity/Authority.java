package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@ToString
@Getter
@Setter
public class Authority extends Menu implements Serializable {
    private Integer jId;

    private Integer pid;

    private String jName;

    private String jUrl;

    private String jIcon;

    private Integer jShow;


}