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
        	data = JSON.parse(data)
        	let result = $(param).find("#result");
        	let append_data = "";
        	append_data += "<table class=type10>";
        	append_data += "<thead>";
        	append_data += "<tr>";
        	
        	/* 데이터 속성 */
//        	for (var i in data["queryresult"]) {
//        		if(data["queryresult"][i] != null) {
//            		for(var key in data["queryresult"][i]) {
//            			append_data += "<th scope=cols>" + key + "</th>";
//            		}
//        		}
//        	}
        	
        	if (data["queryresult"][0] != null) {
        		for(var key in data["queryresult"][0]) {
        			append_data += "<th scope=cols>" + key + "</th>";
        		}
        	} else {
        		return;
        	}
        	
//        	for (var i in data["queryresult"]) {
//        		
//        		append_data += "<th scope=cols>" +  + "</th>";
//        	}
        	
        	append_data += "</thead>";
        	append_data += "<tbody>";
        	
        	
        	/* 데이터 값 */
        	/* 데이터 속성 */
        	for (var i in data["queryresult"]) {
        		res = data["queryresult"][i] 
        		if(res != null) {
        			append_data += "<tr>";
            		for(var key in res) {
            			append_data += "<td scope=cols>" + res[key] + "</td>";
            		}
            		append_data += "</tr>";
        		}
        	}
        	
        	
        	append_data += "</tbody>";
        	append_data += "</table>";
        	
        	$(result).empty();
        	$(result).append(append_data);
        	
            //$(param).find("#result").text(dbTostr(decodeUnicode(data)));

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
