<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="box-list">
		<div class="item">
			<div class="row ">
				<h3 class="text-center no-margin titleunderline underline"
				style="margin-top:-10px;">View Privilege Access</h3>
			</div>

			<div class="row">
				<div class="pi-responsive-table-sm">
					<div class="pi-section-w pi-section-white piTooltips">
						<display:table id="data" name="${privilegeBOlist}" pagesize="10"
							requestURI="/view-privilege-access" export="false"
							class="pi-table pi-table-complex pi-table-hovered pi-round pi-table-shadow pi-table-all-borders">

							<display:column property="sNo" title="SNo" />

							<display:column property="privilegename" title="Privilege Name" />


							<display:column url="edit-privilege-access" media="html"
								paramId="privilegeId" paramProperty="privilegeId" title="Edit">
								<a href="edit-privilege-access?privilegeId=${data.privilegeId}"><i
									style="text-align: center;" class="fa fa-pencil"></i></a>

							</display:column>

							<display:column url="delete-privilege-access" media="html"
								paramId="privilegeId" paramProperty="privilegeId" title="Delete">
								<a
									href="delete-privilege-access?privilegeId=${data.privilegeId}"><i
									style="text-align: center;" class="fa fa-trash"></i></a>

							</display:column>
						</display:table>
					</div>
				</div>
			</div>
			</div>
		</div>
</body>
</html>