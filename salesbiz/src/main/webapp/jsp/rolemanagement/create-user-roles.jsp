<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<link href="resources/css/jquery-ui-1.10.4.custom.css" rel="stylesheet">
<script type="text/javascript" src="resources/js/jquery-ui.min.js"></script>
<script type="text/javascript"
	src="http://js.nicedit.com/nicEdit-latest.js"></script>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<div class="contact-form-wrapper" style="margin-top: 50px;">
		<div class="box-list">
			<div class="item">
				<div class="text-center underline">
					<h3>Create UserRoles</h3>
				</div>
				<br />
				
				<div class="item">
					<form:form method="POST" id="addForm" action="create-user-roles"
						modelAttribute="userRoles">
						<div class="row">
							<div class="col-md-12">
								<div class="form-group">

									<label>User Name <span class="font10 text-danger">
											*</span></label>
									<form:select path="name" class="form-control required">
										<form:option value="Select"></form:option>

										<form:options items="${listuser }" itemLabel="name"
											itemValue="id"></form:options>

									</form:select>

									<label style="margin-left: 5px;">RoleName <span class="font10 text-danger">*</span></label>
									<form:checkboxes items="${listbo}" itemLabel="roleName"
										itemValue="roleId" path="roleName" />

								</div>

							</div>


						</div>

						<br />
						<div class="row">
							<div class="col-sm-1" style="float: right;">
								<a href=view-gst?page=1"><span
									class="btn btn-t-primary btn-theme lebal_align">Cancel</span></a>
							</div>
							<div class="col-sm-1" style="float: right;">
								<button type="submit" id="btnsubmit"
									class="btn btn-t-primary btn-theme lebal_align">Submit</button>
							</div>
						</div>
					</form:form>
					
										<h3>View User Roles</h3>
					<div class="row">
						<div class="pi-responsive-table-sm">
							<div class="pi-section-w pi-section-white piTooltips">
								<display:table id="data" name="${listUserBo}" pagesize="10"
									requestURI="/role-privileges" export="false"
									class="pi-table pi-table-complex pi-table-hovered pi-round pi-table-shadow pi-table-all-borders">

									<display:column property="sNo" title="SNo" />

									<display:column property="name" title="User Name" />
								
								  <display:column url="edit-user-role" media="html" 
									paramId="id" paramProperty ="id" title="Edit">
								 <a
											href="edit-user-role?userId=${data.id}"><i
											style="text-align: center;" class="fa fa-pencil"></i></a>
							 
									</display:column>
									
								 	<display:column url="delete-user-role" media="html" 
									paramId="id" paramProperty ="id" title="Delete">
									<a
											href="delete-user-role?userid=${data.id}"><i
											style="text-align: center;" class="fa fa-trash"></i></a>
							
									</display:column>
							 		  	</display:table>
							 </div>
						</div>
					</div>
					 
				</div>
			</div>
		</div>
	</div>

</body>
</html>