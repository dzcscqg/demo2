package com.example.demo.entity;

import java.util.Date;

public class Branch {
    private Integer bId;

    private Integer eId;

    private String bName;

    private Date bBegin;

    private Date bEnd;

    private Integer bState;

    private String bRemark;

    private Double bPrice;

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

    public String getbName() {
        return bName;
    }

    public void setbName(String bName) {
        this.bName = bName == null ? null : bName.trim();
    }

    public Date getbBegin() {
        return bBegin;
    }

    public void setbBegin(Date bBegin) {
        this.bBegin = bBegin;
    }

    public Date getbEnd() {
        return bEnd;
    }

    public void setbEnd(Date bEnd) {
        this.bEnd = bEnd;
    }

    public Integer getbState() {
        return bState;
    }

    public void setbState(Integer bState) {
        this.bState = bState;
    }

    public String getbRemark() {
        return bRemark;
    }

    public void setbRemark(String bRemark) {
        this.bRemark = bRemark == null ? null : bRemark.trim();
    }

    public Double getbPrice() {
        return bPrice;
    }

    public void setbPrice(Double bPrice) {
        this.bPrice = bPrice;
    }
}