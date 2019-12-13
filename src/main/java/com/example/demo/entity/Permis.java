package com.example.demo.entity;

import lombok.ToString;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;


@ToString
public class Permis implements Serializable {
    private Integer pId;

    private String pName;

    private String pImg;

    private String pCard;

    private String pNum;

    private Integer pSeat;

    private String eSchool;

    private String eCollege;

    private String pCampus;

    private Integer bId;

    private Integer eId;

    private Integer tId;

    private Integer pState;

    private Integer pGoal;

    private Integer cId;


    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName == null ? null : pName.trim();
    }

    public String getpImg() {
        return pImg;
    }

    public void setpImg(String pImg) {
        this.pImg = pImg == null ? null : pImg.trim();
    }

    public String getpCard() {
        return pCard;
    }

    public void setpCard(String pCard) {
        this.pCard = pCard == null ? null : pCard.trim();
    }

    public String getpNum() {
        return pNum;
    }

    public void setpNum(String pNum) {
        this.pNum = pNum == null ? null : pNum.trim();
    }

    public Integer getpSeat() {
        return pSeat;
    }

    public void setpSeat(Integer pSeat) {
        this.pSeat = pSeat;
    }

    public String geteSchool() {
        return eSchool;
    }

    public void seteSchool(String eSchool) {
        this.eSchool = eSchool == null ? null : eSchool.trim();
    }

    public String geteCollege() {
        return eCollege;
    }

    public void seteCollege(String eCollege) {
        this.eCollege = eCollege == null ? null : eCollege.trim();
    }

    public String getpCampus() {
        return pCampus;
    }

    public void setpCampus(String pCampus) {
        this.pCampus = pCampus == null ? null : pCampus.trim();
    }

    public Integer getbId() {
        return bId;
    }

    public void setbId(Integer bId) {
        this.bId = bId;
    }

    public Integer geteId() {
        return eId;
    }

    public void seteId(Integer eId) {
        this.eId = eId;
    }

    public Integer gettId() {
        return tId;
    }

    public void settId(Integer tId) {
        this.tId = tId;
    }

    public Integer getpState() {
        return pState;
    }

    public void setpState(Integer pState) {
        this.pState = pState;
    }

    public Integer getpGoal() {
        return pGoal;
    }

    public void setpGoal(Integer pGoal) {
        this.pGoal = pGoal;
    }

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }
}