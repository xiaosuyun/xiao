package com.bilibili.xm.pojo;

public class MyTest {
    private Integer id;
    private Integer viewTotal;
    private Integer views;
    private Integer saleTotal;
    private Integer sale;
    private Integer payTotal;
    private Integer pay;
    private Integer collectTotal;
    private Integer collect;

    public MyTest(Integer id, Integer viewTotal, Integer views, Integer saleTotal, Integer sale, Integer payTotal, Integer pay, Integer collectTotal, Integer collect) {
        this.id = id;
        this.viewTotal = viewTotal;
        this.views = views;
        this.saleTotal = saleTotal;
        this.sale = sale;
        this.payTotal = payTotal;
        this.pay = pay;
        this.collectTotal = collectTotal;
        this.collect = collect;
    }

    public MyTest() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getViewTotal() {
        return viewTotal;
    }

    public void setViewTotal(Integer viewTotal) {
        this.viewTotal = viewTotal;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public Integer getSaleTotal() {
        return saleTotal;
    }

    public void setSaleTotal(Integer saleTotal) {
        this.saleTotal = saleTotal;
    }

    public Integer getSale() {
        return sale;
    }

    public void setSale(Integer sale) {
        this.sale = sale;
    }

    public Integer getPayTotal() {
        return payTotal;
    }

    public void setPayTotal(Integer payTotal) {
        this.payTotal = payTotal;
    }

    public Integer getPay() {
        return pay;
    }

    public void setPay(Integer pay) {
        this.pay = pay;
    }

    public Integer getCollectTotal() {
        return collectTotal;
    }

    public void setCollectTotal(Integer collectTotal) {
        this.collectTotal = collectTotal;
    }

    public Integer getCollect() {
        return collect;
    }

    public void setCollect(Integer collect) {
        this.collect = collect;
    }

    @Override
    public String toString() {
        return "MyTest{" +
                "id=" + id +
                ", viewTotal=" + viewTotal +
                ", views=" + views +
                ", saleTotal=" + saleTotal +
                ", sale=" + sale +
                ", payTotal=" + payTotal +
                ", pay=" + pay +
                ", collectTotal=" + collectTotal +
                ", collect=" + collect +
                '}';
    }
}
