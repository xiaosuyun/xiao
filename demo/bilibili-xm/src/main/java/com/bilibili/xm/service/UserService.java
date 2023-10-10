package com.bilibili.xm.service;

import com.bilibili.xm.pojo.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserService {
    List<MyTest> findAllUser();
    List<Sales> findAllSales();
    List<Order> findAllOrder();
    List<Format> findAllFormat();
    List<ProjectList> findProjectList(Integer id);
    List<ProjectList> findSearchProjectTitle(String search);
    List<ProjectList> deleteProjectById(Integer id);
}
