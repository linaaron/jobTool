$(function(){
    $(".edit-job").bind('click',function(){
        var jobId = $(this).data('jobId');

        $.ajax({
            url:"",
            type: 'GET',
            dataType: "json",
            contentType: 'application/json',
            success : function(collection, response, options) {

            },
            error : function(){

            }

        });
    });
});