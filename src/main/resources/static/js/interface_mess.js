/**
 * Created by andy on 2016/12/22.
 */

$(document).ready(function(){
    $.get("http://localhost:8080/test/interface",function(data){
        var inter_mess = data["interface message"];
        var table = document.getElementById("interface_table");
        //创建表头
        var $row0 = table.insertRow(0);
        var $cell0 = $row0.insertCell(0);
        $cell0.innerHTML = "url";
        var $cell1 = $row0.insertCell(1);
        $cell1.innerHTML = "description";
        var $cell2 = $row0.insertCell(2);
        $cell2.innerHTML = "params";
        inter_mess.forEach(function(data,index,arr){
            var $row = table.insertRow(index+1);
            var url = data["url"];
            var $cell0 = $row.insertCell(0);
            $cell0.innerHTML = url;
            var description = data["description"];
            var $cell1 = $row.insertCell(1);
            $cell1.innerHTML = description;
            var param = data["paramterInfo"];
            var $cell2 = $row.insertCell(2);
            var param_description = "";
            var param_index = 1;
            var length  = Object.keys(param).length ;
            for(var key in param){
                param_description+=param_index+".";
                param_description+="参数名："+key+" , 参数描述："+param[key];
                console.log(length)
                if(param_index!==length){
                    param_description+="<br>";//换行
                }
                param_index++;
            }
            $cell2.innerHTML = param_description;
        });

    });
});