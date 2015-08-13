<!DOCTYPE html>
<%--
  Created by IntelliJ IDEA.
  User: scotg_000
  Date: 2015/7/15
  Time: 20:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link href="css/bootstrap.css" rel="stylesheet">
<link href="css/bootstrap-theme.css" rel="stylesheet">
<link href="css/submit_sheet.css" rel="stylesheet" type="text/css">

<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <title>ApplyForm</title>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div id="pic_logo" class="col-sm-2"><img src="img/logo_sm.png" class="img-responsive"></div>
        <div class="col-sm-10">
            <h1>Apply For A Position</h1>
        </div>
    </div>
</div>
<div class="center-block" id="form_area">
    <form id="apply" name="applyPage" method="post"
          action="${pageContext.request.contextPath}/ApplyForm.jsp/apply.action" class="form-horizontal">
        <div class="form-group">
            <label for="inputOne" class="col-sm-2 control-label">Name</label>

            <div class="col-sm-10">
                <input type="text" class="form-control" id="inputOne" name="name">
            </div>
        </div>
        <div class="form-group">
            <label for="inputTwo" class="col-sm-2 control-label">Sex</label>

            <div class="col-sm-10 " id="inputTwo">
                <select name="sex" class="form-control">
                    <option value="male">Male</option>
                    <option value="female">Female</option>
                </select>
            </div>
        </div>
        <div class="form-group">
            <label for="date_area" class="col-sm-2 control-label">DateOfBirth</label>
            <div class="col-sm-10" id="date_area">
                <input type="text" name="date_of_birth" class="form-control">
            </div>
        </div>
        <div class="form-group">
            <label for="politic" class="col-sm-2 control-label">Political Status</label>
            <div class="col-sm-10" id="politic">
                <select name="politic" class="form-control">
                    <option value="partyMember">PartyMember</option>
                    <option value="group">GroupMember</option>
                    <option value="nothing">None</option>
                </select>
            </div>
        </div>
        <div class="form-group">
            <label for="major" class="col-sm-2 control-label">Major</label>
            <div class="col-sm-10" id="major">
                <input type="text" name="major" class="form-control">
            </div>
        </div>
        <div class="form-group">
            <label for="phone" class="col-sm-2 control-label">Contact</label>
            <div class="col-sm-10" id="phone">
                <input type="tel" name="phoneNum" class="form-control">
            </div>
        </div>
        <div class="form-group">
            <label for="firstDep" class="col-sm-2 control-label">firstDep</label>
            <div class="col-sm-10" id="firstDep">
                <select name="firstWish" class="form-control">
                    <option value="DepOne">DepOne</option>
                    <option value="DepTwo">DepTwo</option>
                    <option value="DepThree">DepThree</option>
                    <option value="DepFour">DepFour</option>
                </select>
            </div>
        </div>
        <div class="form-group">
            <label for="secondDep" class="col-sm-2 control-label">secondDep</label>
            <div class="col-sm-10" id="secondDep">
                <select name="secondWish" class="form-control">
                    <option value="DepOne">DepOne</option>
                    <option value="DepTwo">DepTwo</option>
                    <option value="DepThree">DepThree</option>
                    <option value="DepFour">DepFour</option>
                </select>
            </div>
        </div>
        <div class="form-group">
            <label for="thirdDep" class="col-sm-2 control-label">thirdDep</label>
            <div class="col-sm-10" id="thirdDep">
                <select name="thirdWish" class="form-control">
                    <option value="DepOne">DepOne</option>
                    <option value="DepTwo">DepTwo</option>
                    <option value="DepThree">DepThree</option>
                    <option value="DepFour">DepFour</option>
                </select>
            </div>
        </div>
        <div class="form-group">
            <label for="introduce" class="col-sm-2 control-label">SelfIntroduction</label>
            <div class="col-sm-10" id="introduce">
                <textarea name="self_introduction" class="form-control"></textarea>
            </div>
        </div>
        <div class="form-group">
            <label for="workexp" class="col-sm-2 control-label">WorkExperience</label>
            <div class="col-sm-10" id="workexp">
                <textarea name="work_exp" class="form-control"></textarea>
            </div>
        </div>
        <div class="form-group">
            <label for="vision" class="col-sm-2 control-label">FutureVision</label>
            <div class="col-sm-10" id="vision">
                <textarea name="future_vision" class="form-control"></textarea>
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
                <input type="submit" value="Submit" class="btn btn-primary">
            </div>
        </div>
    </form>
</div>
<script src="js/jquery-2.1.4.js"></script>
<script src="js/bootstrap.js"></script>
</body>
</html>
