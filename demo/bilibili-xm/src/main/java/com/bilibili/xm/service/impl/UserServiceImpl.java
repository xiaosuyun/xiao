package com.bilibili.xm.service.impl;

import com.bilibili.xm.mapper.UserMapper;
import com.bilibili.xm.pojo.*;
import com.bilibili.xm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<MyTest> findAllUser() {
        List<MyTest> allUser = userMapper.findAllUser();
        return allUser;
    }

    public List<Sales> findAllSales() {
        List<Sales> allSales = userMapper.findAllSales();
        return allSales;
    }

    public List<Order> findAllOrder(){
        List<Order> allOrder = userMapper.findAllOrder();
        return  allOrder;
    }

    public List<Format> findAllFormat(){
        List<Format> allFormat = userMapper.findAllFormat();
        return allFormat;
    }

    public List<ProjectList> findProjectList(Integer id){
        List<ProjectList> objProjectList = userMapper.findProjectList(id);
        return objProjectList;
    }

    public List<ProjectList> findSearchProjectTitle(String search){
        List<ProjectList> strSearchProjectTitle = userMapper.findSearchProjectTitle(search);
        return strSearchProjectTitle;
    }

    public List<ProjectList> deleteProjectById(Integer id){
        List<ProjectList> objDeleteProjectById = userMapper.deleteProjectById(id);
        return objDeleteProjectById;
    }
}
