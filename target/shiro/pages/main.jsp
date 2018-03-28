<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
    String path = request.getContextPath();
    String basepath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <base href="<%=basepath %>" />
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
    <title>管理主页</title>
    <script type="text/javascript" src="/js/jquery-1.8.3.js"></script>
    <script type="text/javascript" src="/js/lhgdialog/lhgdialog.js?s=default,chrome"></script>
    <script>
        function changerole(){
            var dglg = new window.$.dialog({
                id:"changerole",//窗口唯一标示,自定义
                title: '变更角色',
                page:'/pages/frame/xitong/changerole.jsp',//子窗口中显示的内容
                skin:'chrome',//窗口风格，需要在样式中有这个，并且在页面上引用js时问号传参传递
                drag:true,//是否允许拖拽
                resize:false,//是否允许改变窗口大小
                cover: true,//打开子窗口时是否遮盖父窗口
                maxBtn:false,//是否显示最大化子窗口按钮
                minBtn:false,//是否显示最小化子窗口按钮
                xButton:true,//是否显示子窗口关闭按钮
                width:240,
                height:170
                //cancelBtn:false
            });
            dglg.ShowDialog();
        }
    </script>
</head>
<body>
<!--
	当iframe引入的页面的内容的高度是可变时：
	在子页面上，js里面，获取子页面的实际高度;
	在子页面上，通过parent(就可以直接获取到父页面的window对象),获取父页面上的iframe标签；
	把获取的iframe标签的height属性值设定为子页面的实际高度
 -->
<iframe src="/pages/main_frame.jsp" width="100%" height="700" ></iframe>
</body>
</html>
