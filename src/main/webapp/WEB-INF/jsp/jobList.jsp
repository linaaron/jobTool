<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>job list</title>
    <script src="<c:url value='/js/jquery-2.1.4.min.js'/>"></script>
    <link href="<c:url value='/css/bootstrap.min.css'/>" rel="stylesheet">
    <script src="<c:url value='/js/bootstrap.min.js'/>"></script>
    <script src="<c:url value='/js/jobList.js'/>"></script>
</head>
<body>
<br/>
<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#jobDetail" data-job-id="">Add Job
</button>
<br/>
<br/>

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
            <th>${jobInfo['jobName']}</th>
            <th>${jobInfo['jobGroup']}</th>
            <th>${jobInfo['targetObject']}</th>
            <th>${jobInfo['targetMethod']}</th>
            <th>${jobInfo['cronExpression']}</th>
            <th>${jobInfo['jobStatus'] eq 1 ? 'on':'off'}</th>
            <th>
                <button type="button" data-toggle="modal" data-target="#jobDetail" data-job-id="${jobInfo.jobId}"
                        class="btn btn-success btn-xs">edit job
                </button>
                <button type="button" onclick="delJob('${jobInfo.jobId}')" class="btn btn-danger btn-xs">del job
                </button>
            </th>
        </tr>
    </c:forEach>
    </tbody>
</table>

<div class="modal fade" id="jobDetail" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">Job Detail</h4>
            </div>
            <form action="/jobTool/job/save" class="job-submit" id="job-submit" method="post">
                <div class="modal-body">
                    <input type="hidden" id="jobId" name="jobId"/>

                    <div class="form-group">
                        <label for="jobName" class="control-label">jobName</label>
                        <input type="text" class="form-control" id="jobName" name="jobName" placeholder="jobName">
                    </div>
                    <div class="form-group">
                        <label for="jobGroup" class="control-label">jobGroup</label>
                        <input type="text" class="form-control" id="jobGroup" name="jobGroup" placeholder="jobGroup">
                    </div>
                    <div class="form-group">
                        <label for="targetObject" class="control-label">targetObject</label>
                        <input type="text" class="form-control" id="targetObject" name="targetObject"
                               placeholder="targetObject">
                    </div>
                    <div class="form-group">
                        <label for="targetMethod" class="control-label">targetMethod</label>
                        <input type="text" class="form-control" id="targetMethod" name="targetMethod"
                               placeholder="targetMethod">
                    </div>
                    <div class="form-group">
                        <label for="cronExpression" class="control-label">cronExpression</label>
                        <input type="text" class="form-control" id="cronExpression" name="cronExpression"
                               placeholder="0/5 * * * * ?">
                    </div>
                    <div class="form-group">
                        <label for="jobStatus" class="control-label">jobStatus</label>
                        <select class="form-control" id="jobStatus" name="jobStatus">
                            <option value="0">off</option>
                            <option value="1">on</option>
                        </select>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary">Save Job</button>
                </div>
            </form>
        </div>
    </div>
</div>

<div class="modal fade" id="delJob">
    <div class="modal-dialog">
        <div class="modal-content message_align">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">×</span></button>
                <h4 class="modal-title">message</h4>
            </div>
            <div class="modal-body">
                <h2>Are you sure to delete?</h2>
            </div>
            <div class="modal-footer">
                <input type="hidden" id="delJobId"/>
                <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                <a onclick="delSubmit()" class="btn btn-success" data-dismiss="modal">OK</a>
            </div>
        </div>
    </div>
</div>
</body>
</html>
