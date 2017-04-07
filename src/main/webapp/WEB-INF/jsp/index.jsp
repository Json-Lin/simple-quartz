<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Quatrz Home</title>
<link href="/css/main.css" rel="stylesheet">
<link href="/css/ui-lightness/jquery-ui-1.9.2.custom.min.css"
	rel="stylesheet">
<link href="/css/style.css" rel="stylesheet" type="text/css" />
<script src="/js/jquery-1.8.3.js"></script>
<script src="/js/jquery-ui-1.9.2.custom.min.js"></script>
<script src="/js/main.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
		$(".click").click(function() {
			$(".tip").fadeIn(200);
		});

		$(".tiptop a").click(function() {
			$(".tip").fadeOut(200);
		});

		$(".sure").click(function() {
			$(".tip").fadeOut(100);
		});

		$(".cancel").click(function() {
			$(".tip").fadeOut(100);
		});

	});
</script>
</head>
<body>
	<div id="tabs">
		<ul>
			<li><a href="#tabs-1">正在运行</a></li>
			<li><a href="#tabs-2">所有任务</a></li>
			<li><a href="#tabs-3">常用corn表达式</a></li>
		</ul>

		<div id="tabs-1">
			<table class="tablelist">
				<thead>
					<tr>
						<th>任务名<i class="sort"></th>
						<th>所在组</th>
						<th>类型</th>
						<th>执行状态</th>
						<th>上次执行时间</th>
						<th>下次执行时间</th>
						<th>描述</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${triggers}" var="trigger">
						<tr>
							<td>${trigger.jobName}</td>
							<td>${trigger.jobGroup}</td>
							<td>${trigger.triggerType}</td>
							<td>${trigger.triggerState}</td>
							<td><fmt:formatDate value="${trigger.lastRunTime}" pattern="yyyy-MM-dd  HH:mm:ss" /></td>
							<td><fmt:formatDate value="${trigger.nextRunTime}" pattern="yyyy-MM-dd  HH:mm:ss" /></td>
							<td>${trigger.description}</td>
							<%-- <td><a href="javascript:;" onclick="addTrigger('${jobDto.name}','${jobDto.description}')">添 加</a> </td> --%>
							<td>
							<a href="#" id="dialog-link" class="ui-state-default ui-corner-all" onclick="pauseTrigger('${trigger.jobName}','${trigger.jobGroup}')">暂停</a>
							<a href="#" id="dialog-link" class="ui-state-default ui-corner-all" onclick="resumeTrigger('${trigger.jobName}','${trigger.jobGroup}')">恢复</a>
							<a href="#" id="dialog-link" class="ui-state-default ui-corner-all" onclick="removeTrigger('${trigger.jobName}','${trigger.jobGroup}')">删除</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>

		<div id="tabs-2">
			<table class="tablelist">
				<thead>
					<tr>
						<th>任务名<i class="sort"></th>
						<th>所在组</th>
						<th>描述</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${jobs}" var="job">
						<tr>
							<td>${job.name}</td>
							<td>${job.group}</td>
							<td>${job.description}</td>
							<%-- <td><a href="javascript:;" onclick="addTrigger('${jobDto.name}','${jobDto.description}')">添 加</a> </td> --%>
							<td><a href="#" id="dialog-link" class="ui-state-default ui-corner-all" onclick="addTrigger('${job.key}')">添 加</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<!-- ui-dialog -->
		<div id="dialog" title="添加任务运行时间">
			<div id="tabs-trigger">
				<ul>
					<li><a href="#tabs-trigger-1">指定时间</a></li>
					<li><a href="#tabs-trigger-2">时间间隔</a></li>
					<li><a href="#tabs-trigger-3">Cron表达式</a></li>
				</ul>
				<form action="/job/addScheduler">
					<div id="tabs-trigger-1">
						<select name="dateTimeType">
							<option value="1">按天重复</option>
							<option value="2">运行一次</option>
						</select> <input name="datetime" size="20" readonly="readonly"
							class="datepicker" id="datepicker"/> <br />
					</div>
					<div id="tabs-trigger-2">
						<select name="appointType">
							<option value="1">指定的小时</option>
							<option value="2">指定的分钟</option>
						</select> <input name="appointStr" size="30" value="1,5,9,13,16,17,21" /> <br />
					</div>
					<div id="tabs-trigger-3">
						<input name="cron" size="30" value="0/15 * * * * ?" /> <br /> <input
							type="hidden" name="taskName" value="" /> <input type="hidden"
							name="type" value="" />
					</div>
				</form>
			</div>
		</div>
		<div id="tabs-3">
			<p>0/15 * * * * ? - 执行间隔15秒</p>
			<p>5 0/5 * * * ? - 每5分钟的第5秒执行</p>
			<p>0 15 10 15 * ? - 每月15号的10：15触发</p>
			<p>"0 0 12 * * ?" 每天中午十二点触发</p>
			<p>"0 15 10 ? * *" 每天早上10：15触发</p>
			<p>"0 15 10 * * ?" 每天早上10：15触发</p>
			<p>"0 15 10 * * ? *" 每天早上10：15触发</p>
			<p>"0 15 10 * * ? 2005" 2005年的每天早上10：15触发</p>
			<p>"0 * 14 * * ?" 每天从下午2点开始到2点59分每分钟一次触发</p>
			<p>"0 0/5 14 * * ?" 每天从下午2点开始到2：55分结束每5分钟一次触发</p>
			<p>"0 0/5 14,18 * * ?" 每天的下午2点至2：55和6点至6点55分两个时间段内每5分钟一次触发</p>
			<p>"0 0-5 14 * * ?" 每天14:00至14:05每分钟一次触发</p>
			<p>"0 10,44 14 ? 3 WED" 三月的每周三的14：10和14：44触发</p>
			<p>"0 15 10 ? * MON-FRI" 每个周一、周二、周三、周四、周五的10：15触发</p>
			<p>"0 15 10 15 * ?" 每月15号的10：15触发</p>
			<p>"0 15 10 L * ?" 每月的最后一天的10：15触发</p>
			<p>"0 15 10 ? * 6L" 每月最后一个周五的10：15触发</p>
			<p>"0 15 10 ? * 6L" 每月最后一个周五的10：15触发</p>
			<p>"0 15 10 ? * 6L 2002-2005" 2002年至2005年的每月最后一个周五的10：15触发</p>
			<p>"0 15 10 ? * 6#3" 每月的第三个周五的10：15触发</p>
		</div>

	</div>
</body>

</html>