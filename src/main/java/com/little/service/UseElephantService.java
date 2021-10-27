package com.little.service;

import com.little.entity.Elephant;

import java.util.List;

public interface UseElephantService {
//    添加大象
    boolean addElephant(Elephant elephant);
//    查看大象相关信息
    List<Elephant> checkElephant();
//    修改大象相关数据
    boolean updateElephant(Elephant elephant);
//    删除大象
    boolean deleteElephant(String name);
}
