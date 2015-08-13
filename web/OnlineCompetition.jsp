<!DOCTYPE html>
<%--
  Created by IntelliJ IDEA.
  User: scotg_000
  Date: 2015/7/15
  Time: 11:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<link href="css/submit_sheet.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/bootstrap-theme.css">

<script type="text/javascript">
    function changeCode() {
        document.getElementById("rc").src = "randcode?seed=" + Math.random();
    }
</script>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <title>暑期线上新生实用多媒体基础技能大赛</title>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div id="pic_logo" class="col-sm-2"><img src="img/logo_sm.png" class="img-responsive"></div>
        <div class="col-sm-10">
            <h1>暑期新生实用多媒体基础技能大赛</h1>
        </div>
    </div>
</div>
<div class="center-block" id="form_area">
    <form:form id="compete" name="competePage" method="post"
               action="${pageContext.request.contextPath}/OnlineCompetition.jsp/comp.action" class="form-horizontal">
        <div class="form-group">
            <label for="inputOne" class="col-sm-2 control-label">姓名</label>

            <div class="col-sm-10">
                <input type="text" class="form-control" id="inputOne" name="applicant">
            </div>
        </div>
        <div class="form-group">
            <label for="className" class="col-sm-2 control-label">专业与班级</label>

            <div class="col-sm-10">
                <input type="text" class="form-control" id="className" name="classroom">
            </div>
        </div>
        <div class="form-group">
            <label for="qq_num" class="col-sm-2 control-label">QQ</label>

            <div class="col-sm-10">
                <input type="text" class="form-control" id="qq_num" name="qq">
            </div>
        </div>
        <div class="form-group">
            <label for="phone" class="col-sm-2 control-label">手机</label>

            <div class="col-sm-10">
                <input type="tel" class="form-control" id="phone" name="phone_num">
            </div>
        </div>
        <div class="form-group">
            <label for="thirdDep" class="col-sm-2 control-label">报名组别</label>

            <div class="col-sm-10" id="thirdDep">
                <select name="group" class="form-control">
                    <option value="photography">摄影</option>
                    <option value="writing">写作</option>
                    <option value="art">美术</option>
                    <option value="video">视频</option>
                    <option value="coding">编程</option>
                </select>
            </div>
        </div>
        <div class="form-group">
            <label for="validation" class="col-sm-2 control-label">RandomCode</label>

            <div class="col-sm-2 center-block" id="validation">
                <img class="img-responsive" src="randcode" id="rc" onclick="changeCode()" title="Show another"/>
            </div>
            <div class="col-sm-8">
                <input type="text" class="form-control" id="validation_input" name="validation_code">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-primary">Submit</button>
            </div>
        </div>
    </form:form>
</div>
<script src="js/jquery-2.1.4.js"></script>
<script src="js/bootstrap.js"></script>
</body>
</html>
