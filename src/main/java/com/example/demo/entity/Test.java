package com.example.demo.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Data
@Getter
@Setter
public class Test {
    private Integer tId;

    private Integer mId;

    private Integer tNum;

    private String tHall;

    private Integer tLimited;
   // private String mName;
//
//    public String getmName() {
//        return mName;
//    }
//
//    public void setmName(String mName) {
//        this.mName = mName;
//    }

    public Integer gettId() {
        return tId;
    }

    public void settId(Integer tId) {
        this.tId = tId;
    }

    public Integer getmId() {
        return mId;
    }

    public void setmId(Integer mId) {
        this.mId = mId;
    }

    public Integer gettNum() {
        return tNum;
    }

    public void settNum(Integer tNum) {
        this.tNum = tNum;
    }

    public String gettHall() {
        return tHall;
    }

    public void settHall(String tHall) {
        this.tHall = tHall == null ? null : tHall.trim();
    }

    public Integer gettLimited() {
        return tLimited;
    }

    public void settLimited(Integer tLimited) {
        this.tLimited = tLimited;
    }
}