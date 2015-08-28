<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link href="css/bootstrap.css" rel="stylesheet">
<link href="css/bootstrap-theme.css" rel="stylesheet">
<link href="css/submit_sheet.css" rel="stylesheet" type="text/css">

<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <title>团学联报名</title>
    <script type="text/javascript">
        function validate_required(field, alerttxt) {
            with (field) {
                if (value == null || value == "") {
                    alert(alerttxt);
                    return false
                }
                else {
                    return true
                }
            }
        }

        function validate_form(thisform) {
            with (thisform) {
                if (validate_required(Name, "填个姓名吧") == false) {
                    Name.focus();
                    return false
                }
                if (validate_required(date_of_birth, "填个出生年月吧") == false) {
                    date_of_birth.focus();
                    return false;
                }
                if (validate_required(major, "把专业填上吧") == false) {
                    major.focus();
                    return false;
                }
                if (validate_required(phoneNum, "没有电话号码我们没有办法找到你呢") == false) {
                    phoneNum.focus();
                    return false;
                }
                if (validate_required(self_introduction, "自我介绍~") == false) {
                    self_introduction.focus();
                    return false;
                }
                if (validate_required(work_exp, "工作经历~") == false) {
                    work_exp.focus();
                    return false;
                }
                if (validate_required(future_vision, "未来展望~") == false) {
                    future_vision.focus();
                    return false;
                }
            }
        }
    </script>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div id="pic_logo" class="col-sm-2"><img src="img/logo_sm.png" class="img-responsive"></div>
        <div class="col-sm-10">
            <h1>光学与电子信息学院团学联招新报名</h1>
        </div>
    </div>
</div>
<div class="center-block" id="form_area">
    <form id="apply" name="applyPage" method="post" onsubmit="return validate_form(this)"
          action="${pageContext.request.contextPath}/ApplyForm.jsp/apply.action" class="form-horizontal">
        <div class="form-group">
            <label for="inputOne" class="col-sm-2 control-label">姓名</label>

            <div class="col-sm-10">
                <input type="text" class="form-control" id="inputOne" name="Name">
            </div>
        </div>
        <div class="form-group">
            <label for="inputTwo" class="col-sm-2 control-label">性别</label>

            <div class="col-sm-10 " id="inputTwo">
                <select name="sex" class="form-control">
                    <option value="男">男</option>
                    <option value="女">女</option>
                </select>
            </div>
        </div>
        <div class="form-group">
            <label for="date_area" class="col-sm-2 control-label">出生年月日</label>

            <div class="col-sm-10" id="date_area">
                <input type="date" name="date_of_birth" class="form-control">
            </div>
        </div>
        <div class="form-group">
            <label for="politic" class="col-sm-2 control-label">政治面貌</label>

            <div class="col-sm-10" id="politic">
                <select name="politic" class="form-control">
                    <option value="党员">党员</option>
                    <option value="团员">团员</option>
                    <option value="无">无</option>
                </select>
            </div>
        </div>
        <div class="form-group">
            <label for="major" class="col-sm-2 control-label">专业</label>

            <div class="col-sm-10" id="major">
                <input type="text" name="major" class="form-control">
            </div>
        </div>
        <div class="form-group">
            <label for="phone" class="col-sm-2 control-label">联系方式（手机号）</label>

            <div class="col-sm-10" id="phone">
                <input type="tel" name="phoneNum" class="form-control">
            </div>
        </div>
        <div class="form-group">
            <label for="firstDep" class="col-sm-2 control-label">第一志愿</label>

            <div class="col-sm-10" id="firstDep">
                <select name="firstWish" class="form-control">
                    <option value="宣传部">宣传部</option>
                    <option value="学术部">学术部</option>
                    <option value="社会实践部">社会实践部</option>
                    <option value="女生部">女生部</option>
                    <option value="体育部">体育部</option>
                    <option value="文艺部">文艺部</option>
                    <option value="网络部">网络部</option>
                    <option value="权益部">权益部</option>
                    <option value="心理服务部">心理服务部</option>
                    <option value="新闻部">新闻部</option>
                    <option value="新媒体小组">新媒体小组</option>
                    <option value="办公室">办公室</option>
                    <option value="科创部">科创部</option>
                    <option value="外联部">外联部</option>
                    <option value="主持人队">主持人队</option>
                    <option value="组织部">组织部</option>
                    <option value="人力资源部">人力资源部</option>
                    <option value="礼仪队">礼仪队</option>
                </select>
            </div>
        </div>
        <div class="form-group">
            <label for="secondDep" class="col-sm-2 control-label">第二志愿</label>

            <div class="col-sm-10" id="secondDep">
                <select name="secondWish" class="form-control">
                    <option value="宣传部">宣传部</option>
                    <option value="学术部">学术部</option>
                    <option value="社会实践部">社会实践部</option>
                    <option value="女生部">女生部</option>
                    <option value="体育部">体育部</option>
                    <option value="文艺部">文艺部</option>
                    <option value="网络部">网络部</option>
                    <option value="权益部">权益部</option>
                    <option value="心理服务部">心理服务部</option>
                    <option value="新闻部">新闻部</option>
                    <option value="新媒体小组">新媒体小组</option>
                    <option value="办公室">办公室</option>
                    <option value="科创部">科创部</option>
                    <option value="外联部">外联部</option>
                    <option value="主持人队">主持人队</option>
                    <option value="组织部">组织部</option>
                    <option value="人力资源部">人力资源部</option>
                    <option value="礼仪队">礼仪队</option>
                </select>
            </div>
        </div>
        <div class="form-group">
            <label for="thirdDep" class="col-sm-2 control-label">第三志愿</label>

            <div class="col-sm-10" id="thirdDep">
                <select name="thirdWish" class="form-control">
                    <option value="宣传部">宣传部</option>
                    <option value="学术部">学术部</option>
                    <option value="社会实践部">社会实践部</option>
                    <option value="女生部">女生部</option>
                    <option value="体育部">体育部</option>
                    <option value="文艺部">文艺部</option>
                    <option value="网络部">网络部</option>
                    <option value="权益部">权益部</option>
                    <option value="心理服务部">心理服务部</option>
                    <option value="新闻部">新闻部</option>
                    <option value="新媒体小组">新媒体小组</option>
                    <option value="办公室">办公室</option>
                    <option value="科创部">科创部</option>
                    <option value="外联部">外联部</option>
                    <option value="主持人队">主持人队</option>
                    <option value="组织部">组织部</option>
                    <option value="人力资源部">人力资源部</option>
                    <option value="礼仪队">礼仪队</option>
                </select>
            </div>
        </div>
        <div class="form-group">
            <label for="introduce" class="col-sm-2 control-label">自我介绍</label>

            <div class="col-sm-10" id="introduce">
                <textarea name="self_introduction" class="form-control"></textarea>
            </div>
        </div>
        <div class="form-group">
            <label for="workexp" class="col-sm-2 control-label">工作经历</label>

            <div class="col-sm-10" id="workexp">
                <textarea name="work_exp" class="form-control"></textarea>
            </div>
        </div>
        <div class="form-group">
            <label for="vision" class="col-sm-2 control-label">未来展望</label>

            <div class="col-sm-10" id="vision">
                <textarea name="future_vision" class="form-control"></textarea>
            </div>
        </div>
        <div class="form-group">
            <label for="validation" class="col-sm-2 control-label">验证码</label>

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
