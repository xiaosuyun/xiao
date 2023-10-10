package com.bilibili.xm.pojo;

import java.util.Date;

public class ProjectList {

    private Integer id;
    private String title;
    private Double price;
    private String caregory;
    private String create_tiem;
    private String sellPoint;
    private String descs;

    public ProjectList(Integer id, String title, Double price, String caregory, String create_tiem, String sellPoint, String descs) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.caregory = caregory;
        this.create_tiem = create_tiem;
        this.sellPoint = sellPoint;
        this.descs = descs;
    }

    public ProjectList() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCaregory() {
        return caregory;
    }

    public void setCaregory(String caregory) {
        this.caregory = caregory;
    }

    public String getCreate_tiem() {
        return create_tiem;
    }

    public void setCreate_tiem(String create_tiem) {
        this.create_tiem = create_tiem;
    }

    public String getSellPoint() {
        return sellPoint;
    }

    public void setSellPoint(String sellPoint) {
        this.sellPoint = sellPoint;
    }

    public String getDescs() {
        return descs;
    }

    public void setDescs(String descs) {
        this.descs = descs;
    }

    @Override
    public String toString() {
        return "ProjectList{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", caregory='" + caregory + '\'' +
                ", create_tiem='" + create_tiem + '\'' +
                ", sellPoint='" + sellPoint + '\'' +
                ", descs='" + descs + '\'' +
                '}';
    }
}
