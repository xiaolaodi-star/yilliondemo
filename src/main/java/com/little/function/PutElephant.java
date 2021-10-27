package com.little.function;

import com.little.entity.Elephant;
import com.little.entity.Refrigerator;
import com.little.service.UseElephantService;
import com.little.service.UseRerigeratorService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;

public class PutElephant {
    public Elephant elephant;
    public Refrigerator refrigerator;
    @Autowired
    private UseElephantService useElephantService;
    @Autowired
    private UseRerigeratorService useRerigeratorService;
    public void setElephant(Elephant elephant) {
        this.elephant = elephant;
    }

    public void setRefrigerator(Refrigerator refrigerator) {
        this.refrigerator = refrigerator;
    }

    public boolean putElephant(){
        if(deal(elephant.getHeight(), elephant.getLength(), elephant.getWidth(),
                refrigerator.getHeight(), refrigerator.getLength(), refrigerator.getWidth())){
            elephant.setStatus(refrigerator.getRefrigeratorName());
            refrigerator.setStatus("full");
            return true;
        }else{
            return false;
        }
    }

    public boolean deal(double x1,double y1,double z1,double x2,double y2,double z2){
        double[] arrays1=new double[] {x1,y1,z1};
        double[] arrays2=new double[]{x2,y2,z2};
        Arrays.sort(arrays1);
        Arrays.sort(arrays2);
        if(arrays1[0]<=arrays2[0]||arrays1[1]<=arrays2[1]||arrays1[2]<=arrays2[2]){
            return true;
        }else {
            return false;
        }
    }
}
