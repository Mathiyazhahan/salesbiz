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
	bkLib.onDomLoaded(function() {
		new nicEditor({
			buttonList : [ 'fontSize', 'bold', 'italic', 'underline', 'ol',
					'ul', 'strikeThrough', 'html' ]
		}).panelInstance('inputAddress');
	});
</script>

<!-- <div class="row scrollspy-sidenav pb-20 body-mt-15">
 -->
<!-- <script>
		$(document).ready(function() {
			$('#btnsubmit').click(function(e) {
				var isValid = true;
				$('input[type="text"].required').each(function() {
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

					if (isValid == false)
						e.preventDefault();

				});
			});
		});

		$(document).ready(function() {
			$('#btnsubmit').click(function(e) {
				var isValid1 = true;
				$('input[id="password"].required').each(function() {
					if ($.trim($(this).val()) == '') {
						isValid1 = false;
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
				if (isValid1 == false)
					e.preventDefault();

			});
		});
	</script>
 -->
<div class="row scrollspy-sidenav pb-20 body-mt-15">

	<script>
	$(document).ready(function() {

		$('#name').focus();

		$('#btnsubmit').click(function(e) {
			var isValid = true;
			var name = $('#name').val();
			if (name == '') {
				isValid = false;
				$("#nameErr").show();
				$("#nameErr").html("Please enter employee name");
				$("#name").css({
					"border" : "1px solid red",

				});

			} else {
				$('#nameErr').hide();
				$('#name').css({

					"border" : "",
					"background" : ""
				});
			}
			
			

			var isValid = true;
			var emailAddress = $('#emailAddressId').val();
			if (emailAddress == '') {
				isValid = false;
				$("#emailAddressIdErr").show();
				$("#emailAddressIdErr").html("Please enter emailaddress");
				$("#emailAddressId").css({
					"border" : "1px solid red",

				});

			} else {
				$('#emailAddressIdErr').hide();
				$('#emailAddressId').css({

					"border" : "",
					"background" : ""
				});
			}
 
			var isValid = true;
			var password = $('#passwordId').val();
			if (password == '') {
				isValid = false;
				$("#passwordIdErr").show();
				$("#passwordIdErr").html("Please enter password");
				$("#passwordId").css({
					"border" : "1px solid red",

				});

			} else {
				$('#passwordIdErr').hide();
				$('#passwordId').css({

					"border" : "",
					"background" : ""
				});
			}
		
			
			var isValid = true;
			var confirmPassword = $('#confirmPasswordId').val();
			if (confirmPassword == '') {
				isValid = false;
				$("#confirmPasswordErr").show();
				$("#confirmPasswordErr").html("Please enter emailaddress");
				$("#confirmPasswordId").css({
					"border" : "1px solid red",

				});

			} else {
				$('#confirmPasswordErr').hide();
				$('#confirmPasswordId').css({

					"border" : "",
					"background" : ""
				});
			}

			 
			var isValid = true;
			var mobileNo = $('#mobileNoId').val();
			if (mobileNo == '') {
				isValid = false;
				$("#mobileNoErr").show();
				$("#mobileNoErr").html("Please enter mobile number");
				$("#mobileNoId").css({
					"border" : "1px solid red",

				});

			} else {
				$('#mobileNoErr').hide();
				$('#mobileNoId').css({

					"border" : "",
					"background" : ""
				});
			}
 
			
			if (isValid == false)
				e.preventDefault();

			
			
			
		});
	});
</script>
<script>
	$(function() {
		$("#datepicker1").datepicker();
	});
</script>
<script>
	$(function() {
		$("#datepickers").datepicker();
	});
</script>


	<div class="warning">

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
			<div class="alert alert-info" role="alert"
				style="font-size: 12px; padding: 8px 9px 5px 10px; margin-top: 15px;">
				<button type="button" class="close" data-dismiss="alert"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<strong>Info!</strong>
				<c:out value="${errorMessage}"></c:out>
			</div>
		</c:if>
		<c:if test="${not empty errorMobileMessage}">
			<div class="alert alert-info" role="alert"
				style="font-size: 12px; padding: 8px 9px 5px 10px; margin-top: 15px;">
				<button type="button" class="close" data-dismiss="alert"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<strong>Info!</strong>
				<c:out value="${errorMobileMessage}"></c:out>
			</div>
		</c:if>
	</div>

	<div class="contact-form-wrapper">

		<div class="box-list">
			<div class="item">
				<div class="row ">

					
						<div class="text-center underline">
							<h3>Create Campaign</h3>
						</div>
						<br>
						<form:form method="POST" id="addForm" action="create-campaign"
							modelAttribute="campaign" commandName="campaign">
							<div class="col-sm-b   12">
								<div class="col-sm-4">
									<div class="form-group">
										<label path="campaignOwner"> Campaign Owner <span
											class="font10 text-danger">*</span></label>
										<form:input type="text" id="campaignOwner" path="campaignOwner"
											class="form-control required" placeholder="Campaign Owner"
											maxlength="150" />
										<form:errors path="campaignOwner" class="error" />
										<div id="nameErr" style="color: red;"></div>
									</div>
								</div>
								<div class="col-sm-4">
									<div class="form-group">
										<label path="campaignName"> Campaign Name <span
											class="font10 text-danger">*</span></label>
										<form:input type="text" id="campaignName" path="campaignName"
											class="form-control required" placeholder="Campaign Name"
											maxlength="150" />
										<form:errors path="campaignName" class="error" />
										<div id="nameErr" style="color: red;"></div>
									</div>
								</div>
							
							<div class="col-md-4">
								<div class="form-group">

									<label>Type <span class="font10 text-danger">
											*</span></label>
									<form:select path="type" class="form-control required">
										<form:option value="Select"></form:option>
                                        <form:option value="SMS">SMS</form:option>
                                        <form:option value="WHATSAPP">WHATSAPP</form:option>
                                        <form:option value="EMAIL">EMAIL</form:option>
									</form:select>
								</div>
							</div>
							</div>
							
							<div class="col-sm-b   12">
							<div class="col-md-4">
								<div class="form-group">

									<label>Status <span class="font10 text-danger">
											*</span></label>
									<form:select path="type" class="form-control required">
										<form:option value="Select"></form:option>
                                        <form:option value="IsActive">IsActive</form:option>
                                        <form:option value="NotActive">NotActive</form:option>
									</form:select>
								</div>
							</div>
								<div class="col-sm-4">
									<div class="form-group">
										<label path="startDate"> Start Date <span
											class="font10 text-danger">*</span></label>
										<form:input type="text" id="datepicker1" path="startDate"
								placeholder="Start Date" class="form-control element-block" />
							<label class="element-block fw-normal font-lato"
								style="font-size: 10px">EX:MM/DD/YYYY</label>
										<form:errors path="startDate" class="error" />
									</div>
								</div>
								<div class="col-sm-4">
									<div class="form-group">
										<label path="endDate"> End Date <span
											class="font10 text-danger">*</span></label>
										<form:input type="text" id="datepickers" path="endDate"
								placeholder="End Date" class="form-control element-block" />
							<label class="element-block fw-normal font-lato"
								style="font-size: 10px">EX:MM/DD/YYYY</label>
										<form:errors path="endDate" class="error" />
									</div>
								</div>
							</div>
							<div class="col-sm-b   12">
								<div class="col-sm-4">
									<div class="form-group">
										<label path="expectedRevenue"> Expected Revenue <span
											class="font10 text-danger">*</span></label>
										<form:input type="text" id="expectedRevenue" path="expectedRevenue"
											class="form-control required" placeholder="Expected Revenue"
											maxlength="150" />
										<form:errors path="expectedRevenue" class="error" />
										<div id="nameErr" style="color: red;"></div>
									</div>
								</div>
								<div class="col-sm-4">
									<div class="form-group">
										<label path="actualCost"> Actual Cost <span
											class="font10 text-danger">*</span></label>
										<form:input type="text" id="actualCost" path="actualCost"
											class="form-control required" placeholder="Actual Cost"
											maxlength="150" />
										<form:errors path="actualCost" class="error" />
										<div id="nameErr" style="color: red;"></div>
									</div>
								</div>
							
							<div class="col-sm-4">
									<div class="form-group">
										<label path="budgetedCost"> Budgeted Cost <span
											class="font10 text-danger">*</span></label>
										<form:input type="text" id="budgetedCost" path="budgetedCost"
											class="form-control required" placeholder="Budgeted Cost"
											maxlength="150" />
										<form:errors path="budgetedCost" class="error" />
										<div id="nameErr" style="color: red;"></div>
									</div>
								</div>
							</div>
							
							<div class="col-sm-b   12">
								<div class="col-sm-4">
									<div class="form-group">
										<label path="expectedResponse"> Expected Response <span
											class="font10 text-danger">*</span></label>
										<form:input type="text" id="expectedResponse" path="expectedResponse"
											class="form-control required" placeholder="Expected Response"
											maxlength="150" />
										<form:errors path="expectedResponse" class="error" />
										<div id="nameErr" style="color: red;"></div>
									</div>
								</div>
								<div class="col-sm-4">
									<div class="form-group">
										<label path="numberSent"> Number Sent <span
											class="font10 text-danger">*</span></label>
										<form:input type="text" id="numberSent" path="numberSent"
											class="form-control required" placeholder="Number Sent"
											maxlength="150" />
										<form:errors path="numberSent" class="error" />
										<div id="nameErr" style="color: red;"></div>
									</div>
								</div>
							
							<div class="col-sm-4">
									<div class="form-group">
										<label path="description"> Description <span
											class="font10 text-danger">*</span></label>
										<form:input type="textarea" id="description" path="description"
											class="form-control required" placeholder="Description"
											maxlength="150" />
										<form:errors path="description" class="error" />
										<div id="nameErr" style="color: red;"></div>
									</div>
								</div>
							</div>
							
							<br>
				<div>
							<div style="text-align: right; margin-right: 31px">
								<button type="submit" id="btnsubmit"
									class="btn btn-t-primary btn-theme lebal_align mt-20"
									style="text-align: right;">Submit</button>
								<a href="view-employees?page=1"><span
									class="btn btn-t-primary btn-theme lebal_align mt-20">Cancel</span></a>
							</div>
						</div>
						</form:form>
					
                     </div>
				</div>
			</div>
		</div>
	</div>

<br>



