/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 *
 * TODO apendizar al evento de mouse move y key pressed o up o down el reseteo del counter
 * 
 */
//var leftTime = 30000;
//var remaingTime;
//
//jQuery(document).ready(function($) {
//    remaingTime = leftTime;
//
//    $('.cc-info-login').live('click keypress', function(event) {
//        remaingTime = leftTime;
//    });
//
//    $('.eventHandler').live('click', function(event) {
//        remaingTime = leftTime;
//    });
//
//    setTimeout("refreshTime()",1000);
//});
//
//function refreshTime(){
//    if(remaingTime == 0){
//        window.location.replace("/sca/sessionExpired.jsp");
//    }
//    var seg = remaingTime%60;
//    var min = (remaingTime-seg) / 60;
//    var textMin = '00' + min;
//    var textSeg = '00' + seg;
//    jQuery(".leftTimeDiv").html('<div style="float: left;">Tiempo Restante</div><div style="text-align:center;">' + textMin.substr(textMin.length-2, 2) + ':' + textSeg.substr(textSeg.length-2,2) + '</div>');
//    remaingTime--;
//    setTimeout("refreshTime()",1000);
//}
