package com.werner.ping.bean;

public class Privilege {
    private Integer priid;

    private String priName;

    private String priUrl;

    private String priImage;

    private Integer parentid;

    private String priStatus;

    private String priDesc;

    public Integer getPriid() {
        return priid;
    }

    public void setPriid(Integer priid) {
        this.priid = priid;
    }

    public String getPriName() {
        return priName;
    }

    public void setPriName(String priName) {
        this.priName = priName == null ? null : priName.trim();
    }

    public String getPriUrl() {
        return priUrl;
    }

    public void setPriUrl(String priUrl) {
        this.priUrl = priUrl == null ? null : priUrl.trim();
    }

    public String getPriImage() {
        return priImage;
    }

    public void setPriImage(String priImage) {
        this.priImage = priImage == null ? null : priImage.trim();
    }

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    public String getPriStatus() {
        return priStatus;
    }

    public void setPriStatus(String priStatus) {
        this.priStatus = priStatus == null ? null : priStatus.trim();
    }

    public String getPriDesc() {
        return priDesc;
    }

    public void setPriDesc(String priDesc) {
        this.priDesc = priDesc == null ? null : priDesc.trim();
    }
}