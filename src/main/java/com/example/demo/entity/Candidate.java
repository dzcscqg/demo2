package com.example.demo.entity;

import lombok.ToString;

@ToString
public class Candidate {
    private Integer cId;

    private String cNickname;

    private String cMail;

    private String cTelephone;

    private String cPwd;

    private String cName;

    private String cIdcard;

    private String cImage;

    private String cSex;

    private String cType;

    private Integer cState;

    private String cSchool;

    private String cCollege;

    private String cMajor;

    private String cGrade;

    private String cStuentNum;

    private String cClass;

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public String getcNickname() {
        return cNickname;
    }

    public void setcNickname(String cNickname) {
        this.cNickname = cNickname == null ? null : cNickname.trim();
    }

    public String getcMail() {
        return cMail;
    }

    public void setcMail(String cMail) {
        this.cMail = cMail == null ? null : cMail.trim();
    }

    public String getcTelephone() {
        return cTelephone;
    }

    public void setcTelephone(String cTelephone) {
        this.cTelephone = cTelephone == null ? null : cTelephone.trim();
    }

    public String getcPwd() {
        return cPwd;
    }

    public void setcPwd(String cPwd) {
        this.cPwd = cPwd == null ? null : cPwd.trim();
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName == null ? null : cName.trim();
    }

    public String getcIdcard() {
        return cIdcard;
    }

    public void setcIdcard(String cIdcard) {
        this.cIdcard = cIdcard == null ? null : cIdcard.trim();
    }

    public String getcImage() {
        return cImage;
    }

    public void setcImage(String cImage) {
        this.cImage = cImage == null ? null : cImage.trim();
    }

    public String getcSex() {
        return cSex;
    }

    public void setcSex(String cSex) {
        this.cSex = cSex == null ? null : cSex.trim();
    }

    public String getcType() {
        return cType;
    }

    public void setcType(String cType) {
        this.cType = cType == null ? null : cType.trim();
    }

    public Integer getcState() {
        return cState;
    }

    public void setcState(Integer cState) {
        this.cState = cState;
    }

    public String getcSchool() {
        return cSchool;
    }

    public void setcSchool(String cSchool) {
        this.cSchool = cSchool == null ? null : cSchool.trim();
    }

    public String getcCollege() {
        return cCollege;
    }

    public void setcCollege(String cCollege) {
        this.cCollege = cCollege == null ? null : cCollege.trim();
    }

    public String getcMajor() {
        return cMajor;
    }

    public void setcMajor(String cMajor) {
        this.cMajor = cMajor == null ? null : cMajor.trim();
    }

    public String getcGrade() {
        return cGrade;
    }

    public void setcGrade(String cGrade) {
        this.cGrade = cGrade == null ? null : cGrade.trim();
    }

    public String getcStuentNum() {
        return cStuentNum;
    }

    public void setcStuentNum(String cStuentNum) {
        this.cStuentNum = cStuentNum == null ? null : cStuentNum.trim();
    }

    public String getcClass() {
        return cClass;
    }

    public void setcClass(String cClass) {
        this.cClass = cClass == null ? null : cClass.trim();
    }
}