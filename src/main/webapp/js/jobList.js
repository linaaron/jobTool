$(function () {
    $('#jobDetail').on('show.bs.modal', function (event) {
        $(".job-submit")[0].reset();
        var button = $(event.relatedTarget);
        var jobId = button.data('jobId');

        if (jobId !== "") {
            $.ajax({
                url: "/jobTool/job/detail/" + jobId,
                type: 'GET',
                dataType: "json",
                contentType: 'application/json',
                success: function (data) {
                    $("#jobId").val(data.jobId);
                    $("#jobName").val(data.jobName);
                    $("#jobGroup").val(data.jobGroup);
                    $("#targetObject").val(data.targetObject);
                    $("#targetMethod").val(data.targetMethod);
                    $("#cronExpression").val(data.cronExpression);
                    $("#jobStatus").val(data.jobStatus);
                },
                error: function () {
                    console.log("get job detail error" + jobId);
                }
            });
        }
    });
});

function delJob(delJobId) {
    $('#delJobId').val(delJobId);
    $('#delJob').modal();
}

function delSubmit() {
    var delJobId = $.trim($("#delJobId").val());

    $.ajax({
        url: '/jobTool/job/del/' + delJobId,
        type: 'POST',
        dataType: "json",
        contentType: 'application/json',
        success: function (data) {
            window.location.href = "/jobTool/job/list";
        },
        error: function () {
            console.log("del job error" + delJobId);
        }
    });
}