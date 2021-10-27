package com.little.service.Impl;

import com.little.entity.Elephant;
import com.little.interfaces.ElephantOperating;
import com.little.service.UseElephantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UseElephantServiceImpl implements UseElephantService {

    @Autowired
    private ElephantOperating elephantOperatingperating;

//    添加大象
    @Override
    public boolean addElephant(Elephant elephant) {
        try{
            elephantOperatingperating.addElephantOperating(elephant);
            System.out.println("添加大象成功！");
            return true;
        }catch (Exception e){
            System.out.println("添加大象失败！");
            return false;
        }

    }

//    查询所有的大象
    @Override
    public List<Elephant> checkElephant() {
        List<Elephant> elephants=elephantOperatingperating.checkElephant();
        return elephants;
    }

//    更新大象的相关信息
    @Override
    public boolean updateElephant(Elephant elephant) {
        try{
            elephantOperatingperating.updateElephant(elephant);
            System.out.println("更改大象相关信息成功！");
            return true;
        }catch (Exception e){
            System.out.println("更改大象信息失败！");
            return false;
        }
    }

//    删除大象
    @Override
    public boolean deleteElephant(String name) {
        try{
            System.out.println(name);
            elephantOperatingperating.deleteElephant(name);
            System.out.println("删除大象成功！");
            return true;
        }catch (Exception e){
            System.out.println("删除大象失败！");
            return false;
        }
    }
}
