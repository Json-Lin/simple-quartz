<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<table class="tablelist">
	<thead>
		<tr>
			<th>任务名<i class="sort"></th>
			<th>所在组</th>
			<th>描述</th>
			<th>cron表达式</th>
			<th>操作</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${jobDtos }" var="jobDto">
			<tr>
				<td>${jobDto.name}</td>
				<td>${jobDto.group}</td>
				<td>${jobDto.description}</td>
				<td></td>
				<%-- <td><a href="javascript:;" onclick="addTrigger('${jobDto.name}','${jobDto.description}')">添 加</a> </td> --%>
				<td><a href="#" id="dialog-link"
					class="ui-state-default ui-corner-all"
					onclick="pauseTrigger('${jobDto.name}')">暂停</a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>