


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>

<script>
	$(document).ready(function() {
		$('#btnsubmit').click(function(e) {
			var isValid = true;

			var name = $('#name').val();
			if (name == '') {
				isValid = false;
				$("#nameErr").show();
				$("#nameErr").html("Please enter role name ");
				$("#name").css({
					"border" : "1px solid red",

				});

			}else if (!/^[a-zA-Z\s]*$/g.test(userName)) {
					isValid = false;
					$("#nameErr").show();
					$("#nameErr").html("Please enter characters only");
					$("#name").css({
						"border" : "1px solid red",

					});

				}
			else {
				$('#nameErr').hide();
				$('#name').css({

					"border" : "",
					"background" : ""
				});
			}
			

			if (isValid == false)
				e.preventDefault();

		});
	});
</script>

<div class="contact-form-wrapper">
	<div class="box-list">
		<div class="item">
<div class="row"
					style="margin:15px 15px 15px 15px;">
										<div class="text-center underline">
					
						<h3>Create Roles</h3>
						</div>
				<br>

				<form:form method="POST" id="addForm" action="create-role"
					modelAttribute="roleobj" commandName="roleobj">

					<div>
						<c:if test="${not empty createinfomessage}">

							<c:out value="${createinfomessage}"></c:out>

						</c:if>
					</div>

					<div>

						<c:if test="${not empty createerrormessage}">
							<c:out value="${createerrormessage}"></c:out>

						</c:if>
					</div>

					<div class="row">
						<div class="col-sm-4">
							<div class="form-group">
								<label>RoleName<span class="font10 text-danger">*</span></label>
								<form:input type="text" path="roleName" id="name"
									class="form-control required" placeholder="RoleName"
									maxlength="150" />
								<form:errors path="roleName" cssClass="error" />
								<div id="nameErr" style="color: red;"></div>
							</div>
						</div>
					</div>


					<div class="row">
						
						<div class="col-sm-1">
							<button type="submit" id="btnsubmit"
								class="btn btn-t-primary btn-theme lebal_align">Submit</button>
						</div>
						
						<div class="col-sm-1">
							<a href=view-gst?page=1"><span
								class="btn btn-t-primary btn-theme lebal_align">Cancel</span></a>
						</div>
					</div>
					

				</form:form>

			</div>
		</div>
	</div>
</div>
