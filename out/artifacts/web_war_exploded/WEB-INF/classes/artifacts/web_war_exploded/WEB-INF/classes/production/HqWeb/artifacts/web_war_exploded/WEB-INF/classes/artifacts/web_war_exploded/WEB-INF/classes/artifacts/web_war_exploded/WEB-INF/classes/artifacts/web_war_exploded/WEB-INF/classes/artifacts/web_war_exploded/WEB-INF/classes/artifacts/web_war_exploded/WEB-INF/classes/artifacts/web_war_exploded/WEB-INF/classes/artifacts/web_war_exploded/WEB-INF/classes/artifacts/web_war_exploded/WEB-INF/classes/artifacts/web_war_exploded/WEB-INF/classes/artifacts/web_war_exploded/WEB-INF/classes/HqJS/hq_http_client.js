

function startGetRequest(url,param,callback) {

    startRequest(url,"get",param,callback);
}
function startPostRequest(url,param,callback) {

    startRequest(url,"post",param,callback);
}

function createXMLHttpRequest() {

    var xmlhttp;
    if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
        xmlhttp=new XMLHttpRequest();
    }else {// code for IE6, IE5
        xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    }
    return xmlhttp;
}
function startRequest(url,method,param,callback) {

    var  xmlhttp = createXMLHttpRequest();
    xmlhttp.onreadystatechange=function () {
        if (xmlhttp.readyState==4 && xmlhttp.status==200) {
            //请求成功
            callback(xmlhttp,xmlhttp.responseText)
        }
    };
    xmlhttp.open(method,url,true);
    xmlhttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded;");
    xmlhttp.onerror = function() {
        //请求失败
        callback(xmlhttp,null);
    };
    if (param == null){
        xmlhttp.send();
    }else {
        xmlhttp.send(param);
    }

}
