// function myFunction() {
//     document.getElementById("myDropdown").classList.toggle("show");
// }
//
// // 点击下拉菜单意外区域隐藏
// window.onclick = function(event) {
//     if (!event.target.matches('.dropbtn')) {
//         var dropdowns = document.getElementsByClassName("dropdown-content");
//         var i;
//         for (i = 0; i < dropdowns.length; i++) {
//             var openDropdown = dropdowns[i];
//             if (openDropdown.classList.contains('show')) {
//                 openDropdown.classList.remove('show');
//             }
//         }
//     }
// }
function elephantop(){
    document.getElementById("elephant").classList.toggle("elephantshow");
}
window.onclick=function (event){
    if(!event.target.matches('.elephantop')){
        var elephantdrop=document.getElementsByClassName("elephantcontent");
        var i;
        for(i=0;i<elephantdrop.length;i++){
            var opendrop=elephantdrop[i];
            if(opendrop.classList.contains('elephantshow')){
                opendrop.classList.remove('elephantshow')
            }
        }
    }
}
function refrigeratorop(){
    document.getElementById("refrigerator").classList.toggle("refrigeratorshow");
}
window.onclick=function (event){
    if(!event.target.matches('.refrigeratorop')){
        var elephantdrop=document.getElementsByClassName("refrigeratorcontent");
        var i;
        for(i=0;i<elephantdrop.length;i++){
            var opendrop=elephantdrop[i];
            if(opendrop.classList.contains('refrigeratorshow')){
                opendrop.classList.remove('refrigeratorshow')
            }
        }
    }
}
function useroperating(){
    document.getElementById("useroperating").classList.toggle("useroperatingshow");
}
window.onclick=function (event){
    if(!event.target.matches('.useroperating')){
        var elephantdrop=document.getElementsByClassName("useroperatingcontent");
        var i;
        for(i=0;i<elephantdrop.length;i++){
            var opendrop=elephantdrop[i];
            if(opendrop.classList.contains('useroperatingshow')){
                opendrop.classList.remove('useroperatingshow')
            }
        }
    }
}