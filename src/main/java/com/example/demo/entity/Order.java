package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@ToString
@Getter
@Setter
public class Order {
    private int pId;

    private String pName;

    private String pImg;

    private String pCard;

    private String pNum;

    private int pSeat;

    private String eSchool;

    private String eCollege;

    private String pCampus;

    private int bId;

    private int eId;

    private int tId;

    private int pState;

    private int pGoal;

    private int cId;

    private Branch branch;


}
