function getlist(){
    showtable();
    showtable1();
}
function dealresult(){
    var ename=document.getElementById("elephantname").value;
    var rname=document.getElementById("refrigeratorname").value;
    var data=JSON.stringify({"elephantname":ename,"refrigeratorname":rname});
    console.log(data);
    $.ajax({
        type:"post",
        url:"takeinpage",
        data:data,
        async:false,
        contentType:"application/json",
        success:function (data){
            if(data==false){
                alert("将大象放进冰箱失败。");
            }else {
                alert("可以将大象放进冰箱");
            };
            getlist();
        },
        error:function (data){
            alert("将大象放进冰箱失败。");
        },

    });
}
function takeout(){
    var ename=document.getElementById("elephantname").value;
    // var rname=document.getElementById("refrigeratorname").value;
    var data=JSON.stringify({"elephantname":ename});
    console.log(data);
    $.ajax({
        type:"post",
        url:"takeout",
        data:data,
        async:false,
        contentType:"application/json",
        success:function (data){
            alert("大象已经拿出");
            getlist();
        },
        error:function (data){
            alert("大象拿出失败。");
        },

    });
}
function showtable(){
    $.ajax({
        type:"post",
        url:"checkelephant",
        dataType:"json",
        data:{},
        async:false,
        contentType:"application/json",
        success:function (data)
        {
            var str = "";
            for (var i=0;i<data.length;i++){
                var temp=data[i];
                temp=JSON.stringify(temp);
                temp=String(temp);
                temp = eval('(' + temp + ')');
                str=str+"<tr>" +
                    "<td>"+(i+1)+"</td>" +
                    "<td>"+temp.name+"</td>" +
                    "<td>"+temp.length+"</td>"+
                    "<td>"+temp.height+"</td>"+
                    "<td>"+temp.width+"</td>" +
                    "<td>"+temp.status+"</td>" +
                    "</tr>"
            }
            if(!str){
                str=str+"<tr>" +
                    "<td>"+(i+1)+"</td>" +
                    "<td>"+null+"</td>" +
                    "<td>"+null+"</td>"+
                    "<td>"+null+"</td>"+
                    "<td>"+null+"</td>" +
                    "<td>"+null+"</td>" +
                    "</tr>"
            }
            document.getElementById("showplace1").innerHTML= str;
        }
    });
}
function showtable1(){
    $.ajax({
        type:"post",
        url:"checkrefrigerator",
        dataType:"json",
        data:{},
        async:false,
        contentType:"application/json",
        success:function (data)
        {
            var str = "";
            for (var i=0;i<data.length;i++){
                var temp=data[i];
                temp=JSON.stringify(temp);
                temp=String(temp);
                temp = eval('(' + temp + ')');
                console.log(temp);
                str=str+"<tr>" +
                    "<td>"+(i+1)+"</td>" +
                    "<td>"+temp.refrigeratorName+"</td>" +
                    "<td>"+temp.length+"</td>"+
                    "<td>"+temp.height+"</td>"+
                    "<td>"+temp.width+"</td>" +
                    "<td>"+temp.status+"</td>" +
                    "</tr>"
            }
            if(!str){
                str=str+"<tr>" +
                    "<td>"+(i+1)+"</td>" +
                    "<td>"+null+"</td>" +
                    "<td>"+null+"</td>"+
                    "<td>"+null+"</td>"+
                    "<td>"+null+"</td>" +
                    "<td>"+null+"</td>" +
                    "</tr>"
            }
            document.getElementById("showplace2").innerHTML= str;
        }
    });
}
