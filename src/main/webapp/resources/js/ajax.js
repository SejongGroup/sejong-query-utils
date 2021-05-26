function postAjax(param, param_url){ 
    var data = param.serializeObject();

    $.ajax({
        type: "POST",
        url: param_url,	// form을 전송할 실제 파일경로
        data: JSON.stringify(data),
        processData: false,
        contentType: 'application/json',
        cache: false,
        timeout: 600000,
        beforeSend : function() {
            // 전송 전 실행 코드
        },
        success: function (data) {
            // 전송 후 성공 시 실행 코드
            $('#Contents').children().remove();
            // Contents 영역 교체
            $('#Contents').html(data);
            // console.log(data);
        },
        error: function (e) {
            // 전송 후 에러 발생 시 실행 코드
            console.log("ERROR : ", e);
        }
    });
}

function getAjax(param_url){ 

    $.ajax({
        type: "GET",
        url: param_url,	// form을 전송할 실제 파일경로
        data: {responseType: "html"},
        cache: false,
        timeout: 600000,
        beforeSend : function() {
            // 전송 전 실행 코드
        },
        success: function (data) {
            $('#Contents').children().remove();
            // Contents 영역 교체
            $('#Contents').html(data);
            // console.log(data);
        },
        error: function (e) {
            // 전송 후 에러 발생 시 실행 코드
            console.log("ERROR : ", e);
        }
    });
}

function getAjaxNodate(param_url){ 
    $.ajax({
        type: "GET",
        url: param_url,	// form을 전송할 실제 파일경로
        processData: false,
        contentType: 'application/json',
        cache: false,
        timeout: 600000,
        beforeSend : function() {
            // 전송 전 실행 코드
        },
        success: function (data) {
            $('#Contents').children().remove();
            // Contents 영역 교체
            $('#Contents').html(data);
            // console.log(data);
        },
        error: function (e) {
            // 전송 후 에러 발생 시 실행 코드
            console.log("ERROR : ", e);
        }
    });
}

function postAjax_test(param, param_url){ 
    var data = param.serializeObject();

    $.ajax({
        type: "POST",
        url: param_url,	// form을 전송할 실제 파일경로
        data: JSON.stringify(data),
        processData: false,
        contentType: 'application/json',
        cache: false,
        timeout: 600000,
        beforeSend : function() {
            // 전송 전 실행 코드
        },
        success: function (data) {
            $(param).find("#result").text(dbTostr(decodeUnicode(data)));
             // console.log(data);
        },
        error: function (e) {
            // 전송 후 에러 발생 시 실행 코드
            console.log("ERROR : ", e);
        }
    });
}

function decodeUnicode(unicodeString) { 
    var r = /\\u([\d\w]{4})/gi; 
    unicodeString = unicodeString.replace(r, function (match, grp) { 
        return String.fromCharCode(parseInt(grp, 16));
     }
      );
       return unescape(unicodeString);
    }
