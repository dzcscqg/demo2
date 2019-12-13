package com.example.demo.entity;

import lombok.ToString;

import java.util.Date;

@ToString
public class News {
    private Integer nId;

    private String nTitle;

    private Date nDate;

    private String nText;

    private Date nDateModified;

    private int nStatus;

    public Date getnDateModified() {
        return nDateModified;
    }

    public void setnDateModified(Date nDateModified) {
        this.nDateModified = nDateModified;
    }

    public int getnStatus() {
        return nStatus;
    }

    public void setnStatus(int nStatus) {
        this.nStatus = nStatus;
    }

    public Integer getnId() {
        return nId;
    }

    public void setnId(Integer nId) {
        this.nId = nId;
    }

    public String getnTitle() {
        return nTitle;
    }

    public void setnTitle(String nTitle) {
        this.nTitle = nTitle == null ? null : nTitle.trim();
    }

    public Date getnDate() {
        return nDate;
    }

    public void setnDate(Date nDate) {
        this.nDate = nDate;
    }

    public String getnText() {
        return nText;
    }

    public void setnText(String nText) {
        this.nText = nText == null ? null : nText.trim();
    }
}