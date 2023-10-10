package com.bilibili.xm.pojo;

public class Order {
    private Integer id;
    private Integer curOrderCount;
    private Integer curCollect;
    private Integer curMoney;
    private Integer orderCount;
    private Integer collect;
    private Integer money;

    public Order(Integer id, Integer curOrderCount, Integer curCollect, Integer curMoney, Integer orderCount, Integer collect, Integer money) {
        this.id = id;
        this.curOrderCount = curOrderCount;
        this.curCollect = curCollect;
        this.curMoney = curMoney;
        this.orderCount = orderCount;
        this.collect = collect;
        this.money = money;
    }

    public Order() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCurOrderCount() {
        return curOrderCount;
    }

    public void setCurOrderCount(Integer curOrderCount) {
        this.curOrderCount = curOrderCount;
    }

    public Integer getCurCollect() {
        return curCollect;
    }

    public void setCurCollect(Integer curCollect) {
        this.curCollect = curCollect;
    }

    public Integer getCurMoney() {
        return curMoney;
    }

    public void setCurMoney(Integer curMoney) {
        this.curMoney = curMoney;
    }

    public Integer getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(Integer orderCount) {
        this.orderCount = orderCount;
    }

    public Integer getCollect() {
        return collect;
    }

    public void setCollect(Integer collect) {
        this.collect = collect;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", curOrderCount=" + curOrderCount +
                ", curCollect=" + curCollect +
                ", curMoney=" + curMoney +
                ", orderCount=" + orderCount +
                ", collect=" + collect +
                ", money=" + money +
                '}';
    }
}
