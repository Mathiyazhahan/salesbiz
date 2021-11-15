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

 <script>
	$(document).ready(function() {

		$('#name').focus();

		$('#btnsubmit').click(function(e) {
			var isValid = true;
			var userName = $('#name').val();
			if (userName == '') {
				isValid = false;
				$("#nameErr").show();
				$("#nameErr").html("Please enter privilege name");
				$("#name").css({
					"border" : "1px solid red",

				});

			} else if (!/^[a-zA-Z\s]*$/g.test(userName)) {
				isValid = false;
				$("#nameErr").show();
				$("#nameErr").html("Please enter characters only");
			} else {
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

	<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
	<div class="contact-form-wrapper" style="margin-top: 50px;">
		<div class="box-list">
			<div class="item">

				<div class="text-center underline">
					<h3>Create Privileges</h3>
				</div>
				<br />
				<div>
					<form:form method="POST" id="addForm" action="create-privileges"
						modelAttribute="privileges">
						<div class="row">
							<div class="col-sm-4">
								<div class="form-group">
									<label>Privilege Name <span class="font10 text-danger">
											*</span></label>
									<form:input path="privilegename" id="name"
										 class="form-control" />
											<form:errors path="privilegename" class="error" />
											<div id="nameErr" style="colors:red;"></div>
 
								</div>
							</div>

						</div>

						<div class="row">
							
							<div class="col-sm-1">
								<button type="submit" id="btnsubmit"
									class="btn btn-t-primary btn-theme lebal_align">Submit</button>
							</div>
							<div class="col-sm-1">
								<a href=view-privileges?page=1"><span
									class="btn btn-t-primary btn-theme lebal_align">Cancel</span></a>
							</div>
						</div>

					</form:form>
				</div>
			</div>
		</div>
	</div>



</body>
</html>