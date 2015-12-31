<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>job list</title>
    <link href="http://libs.baidu.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet">
    <script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
    <script src="http://libs.baidu.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
    <script src="/jobTool/js/jquery-1.9.1.min.js"></script>
    <script src="/jobTool/js/jobList.js"></script>
</head>
<body>
<br/>
<div class="row">
    <div class="col-xs-6">
        <form class="form-horizontal">
            <input type="hidden" id="jobId" name="jobId"/>
            <div class="form-group">
                <label for="jobName" class="col-sm-2 control-label">jobName</label>
                <div class="col-sm-10">
                    <input type="text" style="width: 300px;" class="form-control" id="jobName" placeholder="jobName">
                </div>
            </div>
            <div class="form-group">
                <label for="jobGroup" class="col-sm-2 control-label">jobGroup</label>
                <div class="col-sm-10">
                    <input type="text" style="width: 300px;" class="form-control" id="jobGroup" placeholder="jobGroup">
                </div>
            </div>
            <div class="form-group">
                <label for="targetObject" class="col-sm-2 control-label">targetObject</label>
                <div class="col-sm-10">
                    <input type="text" style="width: 300px;" class="form-control" id="targetObject"
                           placeholder="jobGroup">
                </div>
            </div>
            <div class="form-group">
                <label for="targetMethod" class="col-sm-2 control-label">targetMethod</label>
                <div class="col-sm-10">
                    <input type="text" style="width: 300px;" class="form-control" id="targetMethod"
                           placeholder="jobGroup">
                </div>
            </div>
            <div class="form-group">
                <label for="cronExpression" class="col-sm-2 control-label">cronExpression</label>
                <div class="col-sm-10">
                    <input type="text" style="width: 300px;" class="form-control" id="cronExpression"
                           placeholder="jobGroup">
                </div>
            </div>
            <div class="form-group">
                <label for="jobStatus" class="col-sm-2 control-label">jobStatus</label>
                <div class="col-sm-10" id="jobStatus">
                    <select class="form-control" style="width: 100px;">
                        <option value="0">off</option>
                        <option value="1">on</option>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="button" class="btn btn-primary btn-lg">Save Job</button>
                    <button type="button" class="btn btn-success btn-lg">Edit Job</button>
                    <button type="reset" class="btn btn-warning btn-lg">Reset</button>
                </div>
            </div>
        </form>
    </div>
    <div class="col-xs-6">
        <p class="lead">cronExpression:</p>
    </div>
</div>

<table class="table table-hover table-bordered">
    <thead>
    <tr class="success">
        <th>#</th>
        <th>JobName</th>
        <th>JobGroup</th>
        <th>targetObject</th>
        <th>targetMethod</th>
        <th>cronExpression</th>
        <th>jobStatus</th>
        <th>operation</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${jobInfoList}" var="jobInfo" varStatus="status">
        <tr class="warning">
            <th>${status.index+1}</th>
            <th><a class="edit-job" data-job-id="${jobInfo.jobId}"
                   href="javascript:void(0);">${jobInfo['jobName']}</a></th>
            <th>${jobInfo['jobGroup']}</th>
            <th>${jobInfo['targetObject']}</th>
            <th>${jobInfo['targetMethod']}</th>
            <th>${jobInfo['cronExpression']}</th>
            <th>${jobInfo['jobStatus'] eq 1 ? 'on':'off'}</th>
            <th><button type="button" class="btn btn-danger btn-xs">del job</button></th>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
