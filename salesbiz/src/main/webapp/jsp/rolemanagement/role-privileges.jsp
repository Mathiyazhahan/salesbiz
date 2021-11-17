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

<div class="contact-form-wrapper">
<div class="box-list">
	<div class="item">
				<div class="row">
				<div class="text-center underline">
					<h3>Assign RolePrivileges</h3>
				</div>
				<br>

				<div class="form-group">
					<form:form method="post" modelAttribute="roletype"
						action="role-privileges">

						<div>
							<form:hidden path="roleId" />
						</div>
						

						 <td><label>Role <span class="font10 text-danger">*</span></label>

							<form:select path="roleName" class="form-control required">
								<form:option value="Select Role"></form:option>
								<c:forEach items="${rolebolists}" var="rolename">
									<form:option value="${rolename.roleName}"></form:option>
								</c:forEach>
							</form:select></td>

						<br />
						<label>Privilege <span class="font10 text-danger">*</span></label>
						<c:forEach items="${listprivilege}" var="privname">
							<input type="checkbox" name="privilegename"
								value="${privname.privilegename }" />
							<c:out value="${privname.privilegename }"></c:out>
						</c:forEach>

						<div style="text-align: right; margin-right: 31px">
							<button type="submit" id="btnsubmit"
								class="btn btn-t-primary btn-theme lebal_align mt-20">Submit</button>
							<a href=view-campaign?page=1"><span
								class="btn btn-t-primary btn-theme lebal_align mt-20">Cancel</span></a>
						</div>
 

					</form:form>
				
					<h3>View Role Privileges</h3>
					<div class="row">
						<div class="pi-responsive-table-sm">
							<div class="pi-section-w pi-section-white piTooltips">
								<display:table id="data" name="${rolebo}" pagesize="10"
									requestURI="/role-privileges" export="false"
									class="pi-table pi-table-complex pi-table-hovered pi-round pi-table-shadow pi-table-all-borders">

									<display:column property="sNo" title="SNo" />

									<display:column property="roleName" title="Role Name" />


									<display:column url="edit-role-privileges" media="html"
										paramId="id" paramProperty="roleId" title="Edit">
										<a
											href="edit-role-privileges?roleId=${data.roleId}<%-- privilegeid=${data.privilegesbolist.privilegeId} --%>"><i
											style="text-align: center;" class="fa fa-pencil"></i></a>
									</display:column>
									<display:column url="delete-role--privileges" media="html"
										paramId="id" paramProperty="privilegeId" title="Delete">
										<a
											href="delete-role-privileges?roleId=${data.roleId}<%-- &&privilegeid=${data.privilegesbolist.privilegeId} --%>"
											onclick="return confirm('Are you sure you want to Delete?')"><i
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
</div>


