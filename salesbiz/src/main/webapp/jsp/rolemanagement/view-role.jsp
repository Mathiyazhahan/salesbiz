<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>

<link href="resources/theme/css/custom.css" rel="stylesheet">
<link href="resources/css/jquery-ui-1.10.4.custom.css" rel="stylesheet">
<script type="text/javascript" src="resources/js/jquery-ui.min.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<script>
	$(function() {
		$("#startDateInput").datepicker({
			changeMonth : true,
			changeYear : true,
			numberOfMonths : 1,
			onSelect : function(selected) {
				var dt = new Date(selected);
				dt.setDate(dt.getDate());
			}
		});
	});
</script>

<div class="box-list">
	<div class="item">
		<div class="row ">
			<h3 class="text-center no-margin titleunderline underline"
				style="margin-top: -10px;">View Role</h3>

			<c:if test="${not empty sucessmessage}">
				<div class="alert alert-success">
					<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
					<strong>Success:</strong>
					<c:out value="${sucessmessage}"></c:out>
				</div>
			</c:if>


			<div class="row">
				<div class="pi-responsive-table-sm">
					<div class="pi-section-w pi-section-white piTooltips">


						<div>
							<c:if test="${not empty updateinfomessage }">

								<c:out value="${updateinfomessage }"></c:out>


							</c:if>
						</div>

						.
						<div>
							<c:if test="${not empty deleteinfomessage }">

								<c:out value="${deleteinfomessage }"></c:out>


							</c:if>
						</div>

						<form:form id="myForm" method="post" class="login-form clearfix"
							action="search-role" commandName="searchObj">
							<div class="row"
								style="border: 4px solid #e6e6e6; margin: 15px 15px 15px 15px; background-color: #e1e1e1">
								<div class=" col-md-3">
									<div class="form-group home-left">
										<label class="hidden-xs">&nbsp;</label>
										<form:input type="text" class="form-control"
											path="roleName" escapeXml="false" placeholder="RoleName"
											style="height: 35px;font-weight: 700;"></form:input>
									</div>
								</div>

								<div class=" col-md-1" style="padding-bottom: 0px;">
									<div class="form-group home-right">
										<label class="hidden-xs">&nbsp;</label>
										<button class="btn btn-theme btn-success btn-block"
											style="padding: 6px 5px; background-color: #7cb228; border-color: #7cb228;">
											<small><i class="fa fa-search" aria-hidden="true"
												style="font-size: 20px;"></i></small>
										</button>
									</div>
								</div>

							</div>
						</form:form>



						<display:table id="data" name="${listroleobj}"
							requestURI="/view-role" pagesize="10" export="false"
							class="pi-table pi-table-complex pi-table-hovered pi-round pi-table-shadow pi-table-all-borders">

							<display:column property="sNo" title="S:No" />

							<display:column property="roleName" title="RoleName" />
							<display:column url="edit-role-type" media="html"
								paramId="roleId" paramProperty="roleId" title="Edit">
								<a href="edit-role-type?roleId=${data.roleId}"><i
									style="text-align: center;" class="fa fa-pencil"></i></a>
								<%-- <a href="delete-role-type?roleId=${data.roleId}"
										onclick="return confirm('Are you sure you want to Delete?')"><i
										style="text-align: center;" class="fa fa-trash"></i></a>	 --%>
							</display:column>
							<display:column url="delete-role-type" media="html"
								paramId="roleId" paramProperty="roleId" title="Delete">
								<a href="delete-role-type?roleId=${data.roleId}"
									onclick="return confirm('Are you sure you want to Delete?')"><i
									style="text-align: center;" class="fa fa-trash"></i></a>
							</display:column>
						</display:table>

					</div>
				</div>
			</div>
		</div>
	</div>
	<br />
</div>
</html>