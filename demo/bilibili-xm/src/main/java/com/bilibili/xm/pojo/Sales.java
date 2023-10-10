package com.bilibili.xm.pojo;

public class Sales {
    private Integer id;
    private String clothing;
    private Integer quantity;
    private Integer clothingsale;

    public Sales(Integer id, String clothing, Integer quantity, Integer clothingsale) {
        this.id = id;
        this.clothing = clothing;
        this.quantity = quantity;
        this.clothingsale = clothingsale;
    }

    public Sales() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClothing() {
        return clothing;
    }

    public void setClothing(String clothing) {
        this.clothing = clothing;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getClothingsale() {
        return clothingsale;
    }

    public void setClothingsale(Integer clothingsale) {
        this.clothingsale = clothingsale;
    }

    @Override
    public String toString() {
        return "Sales{" +
                "id=" + id +
                ", clothing='" + clothing + '\'' +
                ", quantity=" + quantity +
                ", clothingsale=" + clothingsale +
                '}';
    }
}
