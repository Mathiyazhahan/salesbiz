<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<script>
	$(function() {
		$("#datepicker").datepicker();
	});
</script>
<script>
	$(document).ready(function() {
		$('#submit').click(function(e) {
			var isValid = true;

			$('input[type="text"]').each(function() {
				if ($.trim($(this).val()) == '') {
					isValid = false;
					$(this).css({
						"border" : "1px solid red",
					});
				} else {
					$(this).css({
						"border" : "",
						"background" : ""
					});
				}
			});

			if (isValid == false)
				e.preventDefault();

		});
	});
</script>

<div class="contact-form-wrapper">
	<div class="box-list">
		<div class="item">
			<div class="row ">
				<div class="text-center underline">
					<h3>Edit Roles</h3>
				</div>
				<br>


				<form:form method="POST" id="addForm" action="edit-role-type"
					modelAttribute="editroleobj" commandName="editroleobj">


					<div class="row">
						<div class="col-sm-4">
							<div class="form-group">
								<label> Role Name <span class="font10 text-danger">*</span></label>
								<form:input id="inputFirstName" type="text" path="roleName"
									class="form-control required" placeholder="RoleName"
									maxlength="150" />
								<form:errors path="roleName" class="input_error" />
							</div>
						</div>
					</div>

					<form:hidden path="roleId" />

					<div class="row">
						<div class="col-sm-1" style="float: right;">
							<a href=edit-role-type?page=1"><span
								class="btn btn-t-primary btn-theme lebal_align">Cancel</span></a>
						</div>
						<div class="col-sm-1" style="float: right;">
							<button type="submit" id="btnsubmit"
								class="btn btn-t-primary btn-theme lebal_align">Update</button>
						</div>
					</div>
				</form:form>
			</div>
		</div>
	</div>
</div>
