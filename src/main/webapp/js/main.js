$(function() {

	$("#accordion").accordion();

	var availableTags = [ "ActionScript", "AppleScript", "Asp", "BASIC", "C",
			"C++", "Clojure", "COBOL", "ColdFusion", "Erlang", "Fortran",
			"Groovy", "Haskell", "Java", "JavaScript", "Lisp", "Perl", "PHP",
			"Python", "Ruby", "Scala", "Scheme" ];
	$("#autocomplete").autocomplete({
		source : availableTags
	});

	$("#button").button();
	$("#radioset").buttonset();

	$("#tabs").tabs();
	$("#tabs-trigger").tabs();

	$("#dialog").dialog({
		autoOpen : false,
		width : 400,
		buttons : [ {
			text : "Ok",
			click : function() {
				$(this).dialog("close");
			}
		}, {
			text : "Cancel",
			click : function() {
				$(this).dialog("close");
			}
		} ]
	});

	// Link to open the dialog
	$("#dialog-link").click(function(event) {
		$("#dialog").dialog("open");
		event.preventDefault();
	});

	$("#datepicker").datepicker({
		inline : true
	});

	$("#slider").slider({
		range : true,
		values : [ 17, 67 ]
	});

	$("#progressbar").progressbar({
		value : 20
	});

	// Hover states on the static widgets
	$("#dialog-link, #icons li").hover(function() {
		$(this).addClass("ui-state-hover");
	}, function() {
		$(this).removeClass("ui-state-hover");
	});

});

function addTrigger(key) {
	$("#dialog").dialog({
		height : 250,
		title : description,
		width : 600,
		modal : true,
		buttons : {
			'添 加' : function() {
				submitAddTrigger();

			}
		}
	});
}

function submitAddTrigger() {
	var selected = $("#tabs-trigger").tabs().tabs('option', 'selected');
	$('input[name="type"]').val(selected + 1);

	var param = {
		taskName : $('input[name="taskName"]').val(),
		type : $('input[name="type"]').val(),
		dateTimeType : $('select[name="dateTimeType"]').val(),
		datetime : $('input[name="datetime"]').val(),
		appointType : $('select[name="appointType"]').val(),
		appointStr : $('input[name="appointStr"]').val(),
		cron : $('input[name="cron"]').val(),
	};

	$.ajax({
		cache : false,
		type : 'POST',
		data : param,
		url : "/job/addScheduler",
		error : function() {
			alert('请求失败');
		},
		success : function(data) {
			if (data.message.succeeded == 1) {
				alert('任务添加成功!');
				$( "#dialog" ).dialog("close");
			} else {
				alert(data.message.message);
			}
		}
	});
}

function pauseTrigger(name,group) {
	$.ajax({
		cache : false,
		type : 'POST',
		data : {
			"jobName" : name,
			"jobGroup" : group
		},
		url : "/pause",
		error : function() {
			alert('请求失败');
		},
		success : function(data) {
			if (data.message.succeeded == 1) {
				alert('已暂停任务!');
			} else {
				alert(data.message.message);
			}
		}
	});
}

function resumeTrigger(name,group) {
	$.ajax({
		cache : false,
		type : 'POST',
		data : {
			"jobName" : name,
			"jobGroup" : group
		},
		url : "/resume",
		error : function() {
			alert('请求失败');
		},
		success : function(data) {
			if (data.message.succeeded == 1) {
				alert('已删除任务!');
			} else {
				alert(data.message.message);
			}
		}
	});
}

function removeTrigger(name,group) {
	$.ajax({
		cache : false,
		type : 'POST',
		data : {
			"jobName" : name,
			"jobGroup" : group
		},
		url : "/remove",
		error : function() {
			alert('请求失败');
		},
		success : function(data) {
			if (data.message.succeeded == 1) {
			} else {
				alert(data.message.message);
			}
		}
	});
}
