package com.little.service;

import com.little.entity.Refrigerator;

import java.util.List;

public interface UseRerigeratorService {
//    添加冰箱
    boolean addRefrigerator(Refrigerator refrigerator);
//    查看冰箱
    List<Refrigerator> refrigerators();
//    修改冰箱信息
    boolean updateRefrigerator(Refrigerator refrigerator);
//    删除冰箱
    boolean deleteRefrigerator(String name);
}
