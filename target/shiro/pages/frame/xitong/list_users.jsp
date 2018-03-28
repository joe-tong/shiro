<%@ page language="java" contentType="text/html; charset=utf-8"
         isELIgnored="false"
         pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%
    String path = request.getContextPath();
    String basepath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";

%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <base href="<%=basepath %>"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>用户列表页面</title>
    <style type="text/css">

    </style>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.css" rel="stylesheet">
    <%--<link rel="stylesheet" type="text/css" href="/js/easyui/themes/default/easyui.css"/>--%>
    <%--<link rel="stylesheet" type="text/css" href="/js/easyui/themes/icon.css"/>--%>
    <%--<script type="text/javascript" src="/js/easyui/jquery.easyui.min.js"></script>--%>
    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.js"></script>
    <script src="https://cdn.bootcss.com/twbs-pagination/1.4.1/jquery.twbsPagination.js"></script>
    <%--<link href="/css/style.css" rel="stylesheet" type="text/css"/>--%>
    <script type="text/JavaScript">
        function subFun() {
            var input = $(".pageNum").val();
            var total = $(".total").val();
            var reg = /^\d+$/;
            if (reg.test(input) && parseInt(input) > 0 && input <= parseInt(total)) {
                return true;
            } else {
                $(".pageNum").val("");
                alert("页面输入不和法");
                $(".pageNum").focus();
                return false;
            }
        }

        function link() {
            $("#fom").submit();
        }

        function changerole() {
            alert("23")
//             $("#dlg").dialog({
//                width:"400",
//                height:"200",
//                title : "修改角色窗口",
//                buttons:[{
//                    text:'保存',
//                    handler:function(){alert("save");}
//                },{
//                    text:'关闭',
//                    handler:function(){alert("close");}
//                }]
//            });
            parent.parent.changerole();
        }
    </script>
    <script type="text/javascript">
        var pageSize = 2; //每页显示多少条记录
        var totalPages = 1;
        var currentPage = 1;
        var url = "user/page_info2";
        $(function () {
            var $pagination = $("#pagination");
            loadPageData();

            function loadPageData() {
                var setting = {
                    type: "post",
                    data: {pageNum: currentPage, pageSize: pageSize},
                    dataType: "json",
                    success: function (data) {
                        totalPages = data.pages;
                        initPage();
                    },
                    error: function () {

                    }
                };
                $.ajax(url, setting);
            }

            /**
             * 初始化分页元素
             */
            function initPage() {
                var defaultOption = {
                    totalPages: totalPages,
                    visiblePages: pageSize,
                    first: '首页',
                    prev: '前一页',
                    next: '下一页',
                    last: '尾页',
                    onPageClick: function (event, page) {
                        currentPage = page;
                        loadPageData();
                    }
                };
                $pagination.twbsPagination(defaultOption);
            }
        });
    </script>
    <link href="/css/style.css" rel="stylesheet" type="text/css"/>
</head>

<body>

<table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
        <td height="30">
            <table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                    <td height="62" background="../images/nav04.gif">
                        <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
                            <tr>
                                <td width="21"><img src="../images/ico07.gif" width="20" height="18"/></td>
                                <td width="538">查看内容：按时间：
                                    <input name="textfield" type="text" size="12" readonly="readonly"/>
                                    <span class="newfont06">至</span>
                                    <input name="textfield" type="text" size="12" readonly="readonly"/>
                                    <input name="Submit4" type="button" class="right-button02" value="查 询"/></td>
                                <td width="144" align="left">
                                    <a href="#" onclick="sousuo()"><input name="Submit3" type="button"
                                                                          class="right-button07" value="高级搜索"/></a>
                                </td>
                            </tr>
                        </table>
                    </td>
                </tr>
            </table>
        </td>
    </tr>
    <tr>
        <td>
            <table id="subtree1" width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                    <td>
                        <table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
                            <tr>
                                <td height="20"><span class="newfont07">选择:
                                        <a href="#" class="right-font08" onclick="selectAll();">全选</a>
                                    <a href="#" class="right-font08" onclick="unselectAll();">反选</a></span>
                                    <form name="fom" id="fom" method="post" action="user/add_user">
                                        <input type="button" class="right-button08" value="删除所选用户"/>
                                        <shiro:hasPermission name="user/add_user">
                                            <input type="submit" value="添加用户"/>
                                        </shiro:hasPermission>
                                    </form>
                                </td>
                            </tr>
                            <tr>
                                <td height="40" class="font42">
                                    <table width="100%" border="0" cellpadding="4" cellspacing="1" bgcolor="#464646"
                                           class="newfont03">
                                        <tr class="CTitle">
                                            <td height="22" colspan="7" align="center" style="font-size:16px">
                                                用户详细列表
                                            </td>
                                        </tr>
                                        <tr bgcolor="#EEEEEE">
                                            <td width="4%" align="center" height="30">选择</td>
                                            <td width="10%">账户</td>
                                            <td width="10%">真实姓名</td>
                                            <td width="10%">部门</td>
                                            <td width="10%">简介</td>
                                            <td width="5%">状态</td>
                                            <td width="12%">操作</td>
                                        </tr>
                                        <c:forEach items="${pageInfo.list}" var="user">
                                            <tr bgcolor="#FFFFFF">
                                                <td height="20"><input type="checkbox" name="delid"/></td>
                                                <td><a href="listmokuaimingxi.htm" onclick=""></a>${user.loginname}
                                                </td>
                                                <td>${user.realname}</td>
                                                <td>${user.dept.dname}</td>
                                                <td>
                                                        ${fn:substring(user.userDesc,0 ,12)}
                                                        ${fn:length(user.userDesc)> 12?"...":""}

                                                </td>
                                                <td>${user.userStatus == "0" ?"在职":(user.userStatus == "1"?"休假":"离职")}</td>
                                                <td>
                                                    <a href="editrenwu.htm">编辑|</a>
                                                    <a href="listrenwumingxi.htm">查看|</a>
                                                    <a href="javascript:changerole();">变更岗位|</a>
                                                    <a href="#">删除</a>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </table>
                                </td>
                            </tr>
                        </table>
                        <table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
                            <tr>
                                <td height="6"><img src="/images/spacer.gif" width="1" height="1"/></td>
                            </tr>
                            <tr>
                                <td height="33">
                                    <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0"
                                           class="right-font08">
                                        <tr>
                                            <td width="50%">共 <span class="right-text09">${pageInfo.pages}</span> 页
                                                | 第 <span
                                                        class="right-text09">${pageInfo.pageNum}</span> 页
                                            </td>
                                            <td width="49%" align="right">[<a
                                                    href="/user/page_info?pageNum=${pageInfo.firstPage}"
                                                    class="right-font08">首页</a> |
                                                <a href="/user/page_info?pageNum=${pageInfo.prePage==0?1:pageInfo.prePage}"
                                                   class="right-font08">上一页</a> |
                                                <a href="/user/page_info?pageNum=${pageInfo.nextPage==0?pageInfo.lastPage:pageInfo.nextPage}"
                                                   class="right-font08">下一页</a>
                                                | <a href="/user/page_info?pageNum=${pageInfo.lastPage}"
                                                     class="right-font08">末页</a>] 转至：
                                            </td>
                                            <%--<div class="row">--%>
                                            <%--<nav aria-label="Page navigation" class="text-center">--%>
                                            <%--<ul class="pagination" id="pagination">--%>

                                            <%--</ul>--%>
                                            <%--</nav>--%>
                                            <%--</div>--%>
                                            <td width="1%">
                                                <form action="/user/page_info" id="search_num" method="post"
                                                      onsubmit="return subFun()">
                                                    <input type="hidden" class="total" value="${pageInfo.pageSize}">
                                                    <table width="20" border="0" cellspacing="0" cellpadding="0">
                                                        <tr>
                                                            <td width="1%">
                                                                <input name="pageNum" type="text" class="pageNum"
                                                                       size="1"/>
                                                            </td>
                                                            <td width="87%">
                                                                <input type="submit" id="search" value="GO"/>
                                                            </td>
                                                        </tr>
                                                    </table>
                                                </form>

                                            </td>
                                        </tr>
                                    </table>
                                </td>
                            </tr>
                        </table>
                    </td>
                </tr>
            </table>
</table>

</body>
</html>
