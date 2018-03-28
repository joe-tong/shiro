<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basepath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basepath %>" />
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>NO Privilege</title>
<style type="text/css">

</style>
<link href="css/css.css" rel="stylesheet" type="text/css" />
  <script type="text/javascript">
    function goback() {
        history.back();
    }
  </script>
</head>

<body>
<h3>对不起,当前用户没有权限,请联系管理员</h3>
<p>你可以选择:<a href="javascript:goback();">后退</a>回到上一个页面 </p>
</body>
</html>