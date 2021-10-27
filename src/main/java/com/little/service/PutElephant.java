package com.little.service;

import com.little.entity.Elephant;
import com.little.entity.Refrigerator;

import java.util.List;

public interface PutElephant {
//    步骤：第一个功能是获得大象的列表与大象处在哪一个冰箱中；
//    第二个功能是查看冰箱的状态，是否空闲；
//    第三个功能是根据提供的大象名与冰箱名，判断是否能够将大象放进冰箱中
//    如果能够放进冰箱则久就修改冰箱与大象的相关数据；如果不能够放进去，则就提示不能够放进冰箱；
//    第四是删除冰箱的时候将冰箱中存储的大象数据一并删除
    List<Elephant> getelephantlist();
    List<Refrigerator> refrigeratorlist();
    boolean takeinelephant(String elephantname,String refrigeratorname);
    boolean takeoutelephant(String elephantname);
    boolean deleterefrigerator(String name);
}
