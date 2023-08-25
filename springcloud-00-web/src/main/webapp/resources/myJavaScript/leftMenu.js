
var mainMenu = {

    param: "1,2,3",
    menuDataUrl: publicFunction.baseUrl + "/web/menu/getMenu",
    initEvent: function () {
        var thisObj = this;
        var param = {};
        param.roleIds = "1,2,3";
        AJAX_RequestMethod(thisObj.menuDataUrl, param, "json", "get", thisObj.initMenu);
    },

    /**
     * 创建菜单
     * @param data 从后台数据库获取的菜单信息
     */
    initMenu: function (data) {

        if (data != null) {
            var keys = Object.keys(data);
            for (var i = 0; i < keys.length; i++) {
                var keyname = keys[i];
                if (data[keys[i]] != null && data[keys[i]] != '') {
                    creteMainMenu("side-menu", keyname, data[keys[i]]);
                }
            }
            //显示默认的第一个页面
            // setIndexPage(data[keys[0]]);
        }

        /**
         * 创建一级菜单
         * @param eleId
         * @param keys
         * @param data
         */
        function creteMainMenu(eleId, keys, data) {
            var ulid = window.document.getElementById(eleId);
            for (var i = 0; i < data.length; i++) {
                var menu = data[i];
                var type = menu.pageType;
                var litable = createEle("li", "slide", ulid, null);

                var a = createEle("a", "side-menu__item", litable, null);
                $(a).attr("href", '#');
                $(a).attr("data-bs-toggle", "slide");

                if (type == "mainPage") {//主页菜单项的图标
                    createEle("em", "iconfont icon-home", a, null);
                } else {//非主页菜单项的图标
                    createEle("em", "iconfont icon-list", a, null);
                }

                a.innerHTML += "&nbsp;&nbsp;&nbsp;";
                var span = createEle("span", "side-menu__label", a, null);
                $(span).text(menu.name);
                // 非首页，一级菜单右侧添加箭头，“首页"菜单项右侧添加箭头
                if (type == "mainPage") {
                    $(a).attr("href", publicFunction.baseUrl + menu.url);
                } else {
                    $(a).attr("href", '#');
                    var iEle = createEle("i", "angle fa fa-angle-right", a, null);
                }

                var subMenu = menu.subMenu;
                if (subMenu) {
                    createMenu(litable, "slide-menu", subMenu);
                }

            }

        }

        /**
         * 创建二级菜单以及内部嵌套的其他层级菜单
         * @param parentLi
         * @param subClass
         * @param data
         */
        function createMenu(parentLi, subClass, data) {

            //创建UL标签
            var ulMenu = createEle("ul", subClass, parentLi, null);
            for (var i = 0 ; i < data.length; i++) {
                var menu = data[i];
                //创建li
                var liLable = createEle("li",null, ulMenu,null);
                //向li标签中增加a标签
                var alabel = createEle("a","slide-item", liLable, null);
                alabel.href = publicFunction.baseUrl + menu.url;
                alabel.innerHTML = menu.name;
                $(alabel).attr("target", "content");

                //增加子菜单
                var subMenus = menu.subMenu;
                if (subMenus != null && subMenus != undefined && subMenus.length != 0) {
                    var emlable = createEle("em", "iconfont icon-arrDown", alabel, null);
                    createMenu(liLable, "slide-menu", subMenus);
                }

                //第一个元素
                // if (i == 0) {
                //     liLable.className ="onbox";
                //     alabel.className = alabel.className+" on";
                //     if ($(alabel).attr('name') =='javascript:void(0)') {
                //         $(alabel).addClass('unon');
                //     }
                // }
            }

        }

    }



}


$(function() {

    // 初始化页面元素
    mainMenu.initEvent();

    // 一级菜单绑定的单击响应事件（展开或折叠当前菜单）
    $(document).on("click", ".side-menu li", function () {
        var thisLi = this;
        $('.side-menu li').each(function () {
            $(this).removeClass("is-expanded");
        });
        $(thisLi).addClass("is-expanded");
    });



});















