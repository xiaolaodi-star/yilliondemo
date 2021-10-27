function addrefrigerator(){
    var name=document.getElementById("refriname").value;
    var length=document.getElementById("refrilength").value;
    var width=document.getElementById("refriwidth").value;
    var height=document.getElementById("refriheight").value;
    var data=JSON.stringify({"refrigeratorname":name,"refrigeratorlength":length,"refrigeratorwidth":width,"refrigeratorheight":height});
    console.log(data);
    $.ajax({
        type:"post",
        url:"addrefrigerator",
        data:data,
        async:false,
        contentType:"application/json",
        success:function (data){
            alert("添加冰箱成功。");
            showtable();
        },
        error:function (data){
            alert("添加冰箱失败");
        }
    });
}
function updatefrigerator(){
    // var names=document.getElementsByName("")
    // 由于页面没有设置好，获取数据或是别的id比较麻烦，所以就不设置了，这个函数与前面的函数一致，只不过其中的路由地址不同
    var name=document.getElementById("refriname").value;
    var length=document.getElementById("refrilength").value;
    var width=document.getElementById("refriwidth").value;
    var height=document.getElementById("refriheight").value;
    var data=JSON.stringify({"refrigeratorname":name,"refrigeratorlength":length,"refrigeratorwidth":width,"refrigeratorheight":height});
    $.ajax({
        type:"post",
        url:"updaterefrigerator",
        data:data,
        async:false,
        contentType:"application/json",
        success:function (data){
            alert("修改冰箱成功。");
            showtable();
        },
        error:function (data){
            alert("修改冰箱失败");
        }
    });
}