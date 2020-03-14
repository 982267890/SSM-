<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/param/index">该User的详细信息</a>
<a href="param/testParm/allQuestion">所有的User</a>
<a href="question">题目</a>
<form action="param/index/token" method="post">
    token<input type="text" name="id">
    <input type="submit" value="获取">
</form>
<form action="param/index" method="post">
    姓名：<input type="text" name="useranme"/><br/>
    密码：<input type="text" name="userpwd"/><br/>
    <input type="submit" value="登录">
</form>
</body>
</html>
