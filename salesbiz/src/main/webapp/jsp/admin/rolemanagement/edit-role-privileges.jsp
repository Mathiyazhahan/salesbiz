<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<link href="resources/css/jquery-ui-1.10.4.custom.css" rel="stylesheet">
<script type="text/javascript" src="resources/js/jquery-ui.min.js"></script>
<script type="text/javascript"
	src="http://js.nicedit.com/nicEdit-latest.js"></script>
<html>
<div class="box-list">
	<div class="item" style="border: 0px solid #ffff;">
		<br /> <br /> <br /> <br />
		<br />

		<sec:authorize access="hasRole('ROLE_ADMIN')">
			<div class="row">

				<div class="form-group">
					<form:form method="post" modelAttribute="rolesbo">

						<div>
							<form:hidden path="roleId" />
						</div>
						<h3>Edit RolePrivileges</h3>

						<td></br> </br> <label>Role <span class="font10 text-danger">*</span></label>

							<form:select path="roleName" class="form-control required">
								<form:option value="Select Role"></form:option>
								<c:forEach items="${rolebolists}" var="rolename">
									<form:option value="${rolename.roleName}"></form:option>
								</c:forEach>
							</form:select></td>

						<br />
					<%-- 	<label>Privilege <span class="font10 text-danger">*</span></label>
						<c:forEach items="${listprivilege}" var="privname">
							<input type="checkbox" name="privilegename"
								value="${privname.privilegename }" />
							<c:out value="${privname.privilegename }"></c:out>
						</c:forEach>
						 --%>
						<label>Privilege <span class="font10 text-danger">*</span></label>
						<form:checkboxes path="privilegeIds"
							items="${listprivilege}" itemLabel="privilegename"
							itemValue="privilegeId" />
							
						<div style="text-align: right; margin-right: 31px">
							<button type="submit" id="btnsubmit"
								class="btn btn-t-primary btn-theme lebal_align mt-20">Submit</button>
							<a href=view-campaign?page=1"><span
								class="btn btn-t-primary btn-theme lebal_align mt-20">Cancel</span></a>
						</div>


					</form:form>

				</div>
			</div>
		</sec:authorize>