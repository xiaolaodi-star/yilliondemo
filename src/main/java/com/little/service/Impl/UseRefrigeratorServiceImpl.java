package com.little.service.Impl;

import ch.qos.logback.core.encoder.EchoEncoder;
import com.little.entity.Refrigerator;
import com.little.interfaces.RefrigeratorOperating;
import com.little.service.UseElephantService;
import com.little.service.UseRerigeratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UseRefrigeratorServiceImpl implements UseRerigeratorService {
    @Autowired
    private RefrigeratorOperating refrigeratorOperating;
    @Autowired
    private UseElephantService useElephantService;
//添加冰箱相关的数据
    @Override
    public boolean addRefrigerator(Refrigerator refrigerator) {
        try{
            Refrigerator refrigerator1=refrigerator;
            System.out.println(refrigerator1);
            refrigeratorOperating.addRefrigerator(refrigerator1);
            System.out.println("添加冰箱成功");
            return true;
        }catch (Exception e){
            System.out.println("添加冰箱失败");
            return false;
        }

    }
//查看冰箱
    @Override
    public List<Refrigerator> refrigerators() {
        List<Refrigerator> refrigerators=refrigeratorOperating.checkRefrigerator();
        return refrigerators;
    }
    //修改冰箱相关信息
    @Override
    public boolean updateRefrigerator(Refrigerator refrigerator) {
        try{
            refrigeratorOperating.updateRefrigerator(refrigerator);
            System.out.println("修改冰箱相关信息成功");
            return true;
        }catch (Exception e){
            System.out.println("修改冰箱信息失败");
            return false;
        }
    }

    /**
     *
     * * @param name
     * @return
     */
    @Override
    public boolean deleteRefrigerator(String name) {
        try{
            Refrigerator refrigerator=refrigeratorOperating.singlerefrigerator(name);
            if(!refrigerator.getStatus().equals("null")){
                useElephantService.deleteElephant(refrigerator.getStatus());
            }
            refrigeratorOperating.deleteRefrigerator(name);
            System.out.println("删除冰箱的相关信息成功");
            return true;
        }catch(Exception e){
            System.out.println("删除冰箱的相关信息失败");
            return false;
        }
    }
}
