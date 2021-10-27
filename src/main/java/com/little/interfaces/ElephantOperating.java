package com.little.interfaces;

import com.little.entity.Elephant;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
@Service
public interface ElephantOperating {
//    添加大象
    void addElephantOperating(Elephant elephant);
//    查看大象
    List<Elephant> checkElephant();
//    修改大象相关信息
    void updateElephant(Elephant elephant);
//    删除大象
    void deleteElephant(String name);

    Elephant singleelephant(String name);
}
