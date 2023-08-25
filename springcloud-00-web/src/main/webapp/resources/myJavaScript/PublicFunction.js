
var publicFunction = {
    baseUrl: "http://localhost:8080/sfa008/"
}

function AJAX_RequestMethod(url, params, DataType, method, successFun, errorFun) {
    $.ajax({
        url: url,
        type: method,
        data: params,
        dataType: DataType,
        async: true,
        beforeSend: function (request){
            request.withCredentials = true;
            request.setRequestHeader("Authorization", "Basic " + btoa('admin' + ":" + 'password'));
        },
        success: function (data) {
            if (successFun) {
                successFun(data);
            }
        },
        error: errorFun
    });
}

/**
 * 用于创建html 节点信息
 * @param tagName
 * @param className
 * @param container
 * @param id
 * @constructor
 */
function createEle(tagName, className, container, id) {
    var el = window.document.createElement(tagName);
    if (className) {
        el.className = className;
    }
    if (id) {
        el.id = id;
    }
    if (container) {
        $(container).append(el);
    }
    return el;
}





