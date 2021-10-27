package com.little.service.Impl;

import com.little.entity.Elephant;
import com.little.entity.Refrigerator;
import com.little.interfaces.ElephantOperating;
import com.little.interfaces.RefrigeratorOperating;
import com.little.service.PutElephant;
import com.little.service.UseElephantService;
import com.little.service.UseRerigeratorService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
@Service
public class PutElephantImpl implements PutElephant {
    @Autowired
    private UseElephantService useElephantService;
    @Autowired
    private ElephantOperating elephantOperating;
    @Autowired
    private RefrigeratorOperating refrigeratorOperating;
    @Autowired
    private UseRerigeratorService useRerigeratorService;

    @Override
    public List<Elephant> getelephantlist() {
        return null;
    }

    @Override
    public List<Refrigerator> refrigeratorlist() {
        return null;
    }

    @Override
    public boolean takeinelephant(String elephantname, String refrigeratorname) {
        Elephant elephant=elephantOperating.singleelephant(elephantname);
        Refrigerator refrigerator=refrigeratorOperating.singlerefrigerator(refrigeratorname);
//        System.out.println("start");
        if(refrigerator.getStatus().equals("null")){
//            System.out.println("1");
            com.little.function.PutElephant takein=new com.little.function.PutElephant();
            takein.setElephant(elephant);
            takein.setRefrigerator(refrigerator);
            if(takein.putElephant()){
                elephant.setStatus(refrigerator.getRefrigeratorName());
                refrigerator.setStatus(elephant.getName());
                useElephantService.updateElephant(elephant);
                useRerigeratorService.updateRefrigerator(refrigerator);
                return takein.putElephant();
            }else{
                return false;
            }

        }else {
            return false;
        }

    }

    @Override
    public boolean takeoutelephant(String elephantname) {
        try{
            Elephant elephant=elephantOperating.singleelephant(elephantname);
            Refrigerator refrigerator=refrigeratorOperating.statusrefrigerator(elephantname);
            com.little.function.PutElephant takein=new com.little.function.PutElephant();
            takein.setElephant(elephant);
            takein.setRefrigerator(refrigerator);
            elephant.setStatus("null");
            refrigerator.setStatus("null");
            useElephantService.updateElephant(elephant);
            useRerigeratorService.updateRefrigerator(refrigerator);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean deleterefrigerator(String name) {
        return false;
    }
}
