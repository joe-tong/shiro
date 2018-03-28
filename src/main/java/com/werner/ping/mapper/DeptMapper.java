package com.werner.ping.mapper;

import com.werner.ping.bean.Dept;

import java.util.List;

public interface DeptMapper {
    Dept selectById(Integer deptNo);
    List<Dept> selectAllDept();
}