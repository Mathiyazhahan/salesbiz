<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<%-- <div class="warning">

		<c:if test="${not empty successMessage}">
			<div class="alert alert-info" role="alert"
				style="font-size: 12px; padding: 8px 9px 5px 10px; margin-top: 15px;">
				<button type="button" class="close" data-dismiss="alert"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<strong>success!</strong>
				<c:out value="${successMessage}"></c:out>
			</div>
</c:if>
</div>

 --%>
<body>

	<br />
	<div class="box-list">
		<div class="item">
			<div class="row ">
				<h3 class="text-center no-margin titleunderline underline"
					style="margin-top: -10px;">View Privileges</h3>
				
				<c:if test="${not empty successMessage}">
				<div class="alert alert-info" role="alert"
					style="font-size: 12px; padding: 8px 9px 5px 10px; margin-top: 15px;">
					<button type="button" class="close" data-dismiss="alert"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<strong>success!</strong>
					<c:out value="${successMessage}"></c:out>
				</div>
			</c:if>
			
			<c:if test="${not empty errorMessage}">
				<div class="alert alert-success">
					<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
					<strong>Success:</strong>
					<c:out value="${errorMessage}"></c:out>
				</div>
			</c:if>
			<c:if test="${not empty infoMessagemessage}">
				<div class="alert alert-info" role="alert"
					style="font-size: 12px; padding: 8px 9px 5px 10px; margin-top: 15px;">
					<button type="button" class="close" data-dismiss="alert"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<strong>Info!</strong>
					<c:out value="${infoMessagemessage}"></c:out>
				</div>
			</c:if>
			
			
				<form:form id="myForm" method="post" class="login-form clearfix"
				action="search-privileges" commandName="searchprivileges">
				<div class="row"
					style="border: 4px solid #e6e6e6; margin:15px 15px 15px 15px; background-color: #e1e1e1">
					<div class=" col-md-3">
						<div class="form-group home-left">
							<label class="hidden-xs">&nbsp;</label>
							<form:input type="text" class="form-control" path="privilegename"
								escapeXml="false"
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
			
				<c:if test="${!empty privilegeslist}">
					<div class="row">
						<div class="pi-responsive-table-sm">
							<div class="pi-section-w pi-section-white piTooltips">
								<display:table id="data" name="${privilegeslist}"
									requestURI="/view-privileges" pagesize="10" export="false"
									class="pi-table pi-table-complex pi-table-hovered pi-round pi-table-shadow pi-table-all-borders">

									<display:column property="sNo" title="SNo" />

									<display:column property="privilegename"
										title="Privileges Name" />

									<display:column url="edit-privileges" media="html" paramId="id"
										paramProperty="privilegeId" title="Edit">
										<a href="edit-privileges?id=${data.privilegeId}"><i
											style="text-align: center;" class="fa fa-pencil"></i></a>
									</display:column>
									<display:column url="delete-privileges" media="html"
										paramId="id" paramProperty="privilegeId" title="Delete">
										<a href="delete-privileges?id=${data.privilegeId}"
											onclick="return confirm('Are you sure you want to Delete?')"><i
											style="text-align: center;" class="fa fa-trash"></i></a>
									</display:column>
								</display:table>
							</div>
						</div>
					</div>
				</c:if>

			</div>
		</div>
	</div>
</body>
</html>

