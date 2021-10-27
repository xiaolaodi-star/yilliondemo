package com.little.interfaces;

import com.little.entity.Refrigerator;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
@Service
public interface RefrigeratorOperating {
//    添加冰箱
    void addRefrigerator(Refrigerator refrigerator);
//    查看冰箱的相关信息
    List<Refrigerator> checkRefrigerator();
//    修改冰箱相关信息
    void updateRefrigerator(Refrigerator refrigerator);
//    删除冰箱
    void deleteRefrigerator(String name);

    Refrigerator singlerefrigerator(String name);

    Refrigerator statusrefrigerator(String status);
}
