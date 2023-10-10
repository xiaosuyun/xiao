package com.bilibili.xm.mapper;

import com.bilibili.xm.pojo.*;

import java.util.List;

public interface UserMapper {
    List<Sales> findAllSales();
    List<MyTest> findAllUser();
    List<Order> findAllOrder();
    List<Format> findAllFormat();
    List<ProjectList> findProjectList(Integer id);
    List<ProjectList> findSearchProjectTitle(String search);
    List<ProjectList> deleteProjectById(Integer id);
}
