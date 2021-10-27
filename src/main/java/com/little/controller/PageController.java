package com.little.controller;

import com.little.entity.Elephant;
import com.little.entity.Refrigerator;
import com.little.entity.User;
import com.little.service.PutElephant;
import com.little.service.UseElephantService;
import com.little.service.UseRerigeratorService;
import com.little.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("")
public class PageController {
//    数据区
    @Autowired
    private UserService userService;

    @Autowired
    private UseElephantService useElephantService;

    @Autowired
    private UseRerigeratorService useRerigeratorService;

    @Autowired
    private PutElephant putElephant;

    private String ProjectStatus="null";

//函数区
//    进入页面
    @RequestMapping("/")
    public String toIndex(){
        return "UserIndex";
    }
//    报错页面
//    @RequestMapping("/error")
//    public String toError(){
//        return "Error";
//    }
//    用户登录成功
    @RequestMapping("login")
    public String userLogin(){
        return "success";
    }
//    用户登录验证
//    由于只有一个用户，就不对用户进行查看或是别的操作
    @RequestMapping(value = "userlogin",method = RequestMethod.POST)
    public String getUser(@RequestParam("username") String name,@RequestParam("passwd") String passwd){
        System.out.println(name+"      "+passwd);
        List<User> users=userService.getUser();
        User user=users.get(0);
        System.out.println(user.toString());
        if(user.getUserName().equals(name)&&user.getPasswd().equals(passwd)){
            ProjectStatus="true";
            return "success";
        }else{
            ProjectStatus="false";
            return "Error";
        }
    }
    /*在登录成功后
    换路由进入demopage项目
    为了避免恶意或是直接登录后台
    做一个status状态，用来隔离恶意的行为
    * */
    @RequestMapping(value = "demopage")
    public String toDemoPage(){
        if(ProjectStatus.equals("true")){
            return "demopage";
        }else {
            return "Error";
        }
    }
//    添加大象
    @RequestMapping(value = "addelephant" ,method=RequestMethod.POST)
    public String addElephantInfo(@RequestParam("elephantname") String name,
                                  @RequestParam("elephantlength") Double length,
                                  @RequestParam("elephantheight") Double height,
                                  @RequestParam("elephantwidth") Double width
                                  ){
        Elephant elephant=new Elephant();
        elephant.setName(name);
        elephant.setHeight(height);
        elephant.setWidth(width);
        elephant.setLength(length);
        elephant.setLocation("null");
        elephant.setStatus("null");
        boolean operatestatus=useElephantService.addElephant(elephant);
        if(operatestatus){
            System.out.println("控制层添加大象完毕");
            return "addelephantpage";
        }else{
            System.out.println("添加失败");
            return "demopage";
        }

    }
//    查看所有的大象的相关数据
    @RequestMapping(value = "checkelephant",method = RequestMethod.POST)
    @ResponseBody
    public List<Elephant> checkElephantInfo(){
        List<Elephant> elephants= useElephantService.checkElephant();
        return elephants;
    }
    //    修改大象相关数据
@RequestMapping(value = "updateelephant",method = RequestMethod.POST)
public void updateElephantInfo(@RequestParam("elephantname") String name,
                               @RequestParam("elephantlength") Double length,
                               @RequestParam("elephantheight") Double height,
                               @RequestParam("elephantwidth") Double width,
                               @RequestParam("elephantlocation")String location,
                               @RequestParam("elephantstatus") String status){
        Elephant elephant=new Elephant();
        elephant.setName(name);
        elephant.setHeight(height);
        elephant.setWidth(width);
        elephant.setLength(length);
        elephant.setLocation(location);
        elephant.setStatus(status);
    System.out.println(elephant);
        if(useElephantService.updateElephant(elephant)){
            System.out.println("控制层修改大象相关数据成功");
        }else {
            System.out.println("控制层修改大象数据失败");
        }


    }
//    删除大象
    @RequestMapping(value = "deleteelephant",method = RequestMethod.POST)
    public void deleteElephantInfo(@RequestParam("elephantname") String name){
        if(useElephantService.deleteElephant(name)){
            System.out.println("控制层删除大象数据成功");
        }else{
            System.out.println("控制层删除大象数据失败");
        }

    }
//    添加冰箱
    @RequestMapping(value = "addrefrigerator",method = RequestMethod.POST)
    @ResponseBody
    public void addRefrigeratorInfo(@RequestBody HashMap<String,String> map){
        Refrigerator refrigerator=new Refrigerator();
        System.out.println(map);
        try {
            refrigerator.setRefrigeratorName(map.get("refrigeratorname"));
            refrigerator.setHeight(Double.parseDouble(map.get("refrigeratorheight")));
            refrigerator.setLength(Double.parseDouble(map.get("refrigeratorlength")));
            refrigerator.setWidth(Double.parseDouble(map.get("refrigeratorwidth")));
            refrigerator.setStatus("null");
        }catch (Exception e){
            System.out.println(map);
        }
        if(useRerigeratorService.addRefrigerator(refrigerator)){
            System.out.println("在控制层添加冰箱成功");
        }else {
            System.out.println("在控制层添加冰箱失败");
        }
    }
//    查看冰箱
    @RequestMapping(value = "checkrefrigerator",method = RequestMethod.POST)
    @ResponseBody
    public List<Refrigerator> checkRefrigeratorInfo(){
        List<Refrigerator> refrigerators=useRerigeratorService.refrigerators();
        return refrigerators;
    }
//    修改冰箱相关信息
    @RequestMapping(value = "updaterefrigerator",method = RequestMethod.POST)
    @ResponseBody
    public void updateRefrigeratorInfo(@RequestBody HashMap<String,String> map)
    {
        Refrigerator refrigerator=new Refrigerator();
        System.out.println(map);
        refrigerator.setRefrigeratorName(map.get("refrigeratorname"));
        refrigerator.setHeight(Double.parseDouble(map.get("refrigeratorheight")));
        refrigerator.setLength(Double.parseDouble(map.get("refrigeratorlength")));
        refrigerator.setWidth(Double.parseDouble(map.get("refrigeratorwidth")));
        refrigerator.setStatus("null");
        if(useRerigeratorService.updateRefrigerator(refrigerator)){
            System.out.println("在控制层修改冰箱信息成功");
        }else {
            System.out.println("在控制层修改冰箱信息失败");
        }
    }
//    删除冰箱
    @RequestMapping(value = "deleterefrigerator",method = RequestMethod.POST)
    @ResponseBody
    public void deleteRefrigerator(@RequestBody HashMap<String,String> map){
        System.out.println(map.get("name"));
        if(useRerigeratorService.deleteRefrigerator(map.get("name"))){
            System.out.println("在控制层删除冰箱信息成功");
        }else{
            System.out.println("在控制层删除冰箱信息失败");
        }
    }
//    将大象放进冰箱
    @RequestMapping(value = "takein",method = RequestMethod.POST)
    @ResponseBody
    public void takeinelephant(@RequestParam HashMap<String,String> map){
        String elephantnaname=map.get("name");
    }
    /*
    * 要做的操作如下所示：
    * 第一步判断大象是否能够放进冰箱
    * 第二步对冰箱和大象的相关数据进行改写
    * */
    @RequestMapping(value = "addelephantpage")
    public String addElephantPage(){
        return "addelephantpage";
    }
    @RequestMapping(value = "checkelephantpage")
    public String checkElephantPage(){
        return "checkelephant";
    }
    @RequestMapping("deleteelephantpage")
    public String deleteElephantPage(){
        return "deleteelephant";
    }
    @RequestMapping("updateelephantpage")
    public String updateElephantPage(){
        return "updateelephant";
    }
    @RequestMapping("addrefrigeratorpage")
    public String addRefrigeratorPage(){
        return "addrefrigerator";
    }
    @RequestMapping(value = "putelephant")
    public String putelephant(){
        return "takein";
    }
    @RequestMapping(value = "takeinpage",method = RequestMethod.POST)
    @ResponseBody
    public boolean takeIn(@RequestBody HashMap<String,String> map){
        if(putElephant.takeinelephant(map.get("elephantname"),map.get("refrigeratorname"))){
            System.out.println("sueecss");
            return true;
        }else{
            System.out.println("放大象失败");
            return false;
        }
//        return true;
    }
    @RequestMapping(value = "takeout",method = RequestMethod.POST)
    @ResponseBody
    public boolean takeOut(@RequestBody HashMap<String,String> map){
        System.out.println(map);
        if(putElephant.takeoutelephant(map.get("elephantname"))){
            System.out.println("sueecss");
            return true;
        }else{
            return false;
        }
//        return true;
    }
}

