package com.bilibili.xm.controller;

import com.bilibili.xm.pojo.*;
import com.bilibili.xm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    @Autowired
    private UserService userService;

    @GetMapping("/home/test")
    public List<MyTest> getAllUser(){
        List<MyTest> allUser = userService.findAllUser();
        return allUser;
    }

    @GetMapping("/home/sales")
    public List<Sales> getAllSales(){
        List<Sales> allSales = userService.findAllSales();
        return allSales;
    }

    @GetMapping("/home/order")
    public List<Order> getAllOrder(){
        List<Order> allOrder = userService.findAllOrder();
        return allOrder;
    }

    @GetMapping("/home/format")
    public List<Format> getAllFormat(){
        List<Format> allFormat = userService.findAllFormat();
        return allFormat;
    }

    @GetMapping("/goods/productList")
    public List<ProjectList> getProjectList(Integer id){
        int pageId;
        if(id == null){
            pageId = 0;
        }else{
            pageId = (id-1)*4;
        };
        List<ProjectList> objProjectList = userService.findProjectList(pageId);
        return objProjectList;
    }

    @GetMapping("/goods/search")
    public List<ProjectList> getSearchProjectTitle(String search){
        List<ProjectList> strSearchProjectTitle = userService.findSearchProjectTitle(search);
        return strSearchProjectTitle;
    }

    @GetMapping("/goods/deleteItemById")
    public List<ProjectList> getProjectById(Integer id){
        List<ProjectList> delProjectById = userService.deleteProjectById(id);
        return delProjectById;
    }
}
