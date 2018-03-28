<%@ page language="java" contentType="text/html; charset=utf-8"
         isELIgnored="false"
         pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basepath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <base href="<%=basepath %>"/>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312"/>
    <title>添加用户</title>
    <link rel="stylesheet" rev="stylesheet" href="/css/style.css" type="text/css" media="all"/>
    <script type="text/javascript" src="/js/jquery-1.8.3.js"></script>
    <script type="text/javascript">
        $(function () {
            $.post("http://localhost:8080/user/show_dept_and_role", {}, function (data) {
                $.each(data.deptList, function (i, n) {03
                   var $option = $("<option/>").attr("value",n.deptno).text(n.dname);
                    $("#deptno").append($option);
                });
                $.each(data.roleList, function (i, n) {
                    var $option = $("<option/>").attr("value",n.roleid).text(n.roleCn);
                    $("#role_cn").append($option);
                })
            })
//图片上传预览
//            new uploadPreview({ UpBtn: "pic", DivShow: "imgdiv", ImgShow: "mgShow" });
        })
//哈哈哈,touch啦啦啦

    </script>
    <style type="text/css">

    </style>
</head>

<body class="ContentBody">
<form action="" method="post" enctype="multipart/form-data" name="fom" id="fom" target="sypost">
    <div class="MainDiv">
        <table width="99%" border="0" cellpadding="0" cellspacing="0" class="CContent">
            <tr>
                <th class="tablestyle_title">用户添加</th>
            </tr>
            <tr>
                <td class="CPanel">
                    <table border="0" cellpadding="0" cellspacing="0" style="width:100%">
                        <tr>
                            <td align="left">
                                <input type="button" name="Submit" value="保存" class="button" onclick="alert('保存成功！');"/>　
                                <input type="button" name="Submit2" value="返回" class="button"
                                       onclick="window.history.go(-1);"/>
                            </td>
                        </tr>
                        <TR>
                            <TD width="100%">
                                <fieldset style="height:100%;">
                                    <legend>添加用户</legend>
                                    <table border="0" cellpadding="2" cellspacing="1" style="width:100%">
                                        <tr>
                                            <td nowrap align="right" width="13%">账户名称:</td>
                                            <td width="41%"><input name="text" class="text" style="width:250px"
                                                                   type="text" size="40"/>
                                                <span class="red"> *</span></td>
                                            <td align="right" width="19%">真实姓名:</td>
                                            <td width="27%"><input name="Input22" id="Input22" class="text"
                                                                   style="width:154px"/></td>
                                        </tr>
                                        <tr>
                                            <td nowrap align="right">密码:</td>
                                            <td><input name="" id="pwd" class="text" style="width:154px"/></td>
                                            <td align="right">邮箱:</td>
                                            <td><input name="Input" id="Input" class="text" style="width:154px"/></td>
                                        </tr>
                                        <tr>
                                            <td nowrap align="right">确认密码:</td>
                                            <td><input name="" id="resure" class="text" style="width:154px"/></td>
                                        </tr>
                                        <tr>
                                            <td nowrap align="right">用户状态:</td>
                                            <td><select name="select2">
                                                <%--<option  selected="selected">==请选择==</option>--%>
                                                <option selected="selected">在职</option>
                                                <option>休假</option>
                                                <option>离职</option>
                                            </select></td>
                                            <td align="right">部门:</td>
                                            <td>
                                                <select id="deptno" name="select">
                                                    <option selected="selected">==请选择==</option>
                                                </select>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td align="right">用户岗位:</td>
                                            <td><select id="role_cn" name="role.roleid">
                                                <option selected="selected">==请选择==</option>
                                            </select>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td nowrap align="right">用户照片:</td>
                                            <td>
                                                <input name="pic" type="file" id="pic" class="text"
                                                       style="width:154px"/>
                                            </td>
                                            <td colspan="2">
                                                <div id="imgdiv"><img id="imgShow" width="60" height="60"/></div>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td nowrap align="right" height="120px">简介:</td>
                                            <td colspan="3"><textarea id="textarea" name="textarea" rows="5"
                                                                      cols="80"></textarea></td>
                                        </tr>
                                    </table>
                                    <br/>
                                </fieldset>
                            </TD>
                        </TR>
                    </TABLE>
                </td>
            </tr>
            <TR>
                <TD colspan="2" align="center" height="50px">
                    <input type="button" name="Submit" value="保存" class="button" onclick="link();"/>　

                    <input type="button" name="Submit2" value="返回" class="button" onclick="window.history.go(-1);"/>
                </TD>
            </TR>
        </TABLE>
        </td>
        </tr>
        </table>
    </div>
</form>
</body>
</html>
