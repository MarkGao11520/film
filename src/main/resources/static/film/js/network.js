/**
 * Created by gaowenfeng on 2017/9/28.
 */
function rpc(url,method,data,success) {
    $.ajax({
        method:method,
        url:baseUrl+url,
        data:data,
        success:success,
        error:error
    })
}

// String.prototype.endWith=function(endStr){
//     var d=this.length-endStr.length;
//     return (d>=0&&this.lastIndexOf(endStr)==d)
// }

/**
 * get请求
 * @param url
 * @param data
 * @param success
 * @param withAuth
 */
function getData(url,data,success) {
    rpc(url,'get',data,success)
}


/**
 * 根据浏览器参数  获取值
 * @param     parameterName
 * @returns   value
 * @constructor
 */
function getQueryString(name)
{
    var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if(r!=null)return  unescape(r[2]); return null;
}

function error(error) {
    console.log("操作失败:",JSON.stringify(error));
    alert(JSON.parse(error.responseText).message)
}