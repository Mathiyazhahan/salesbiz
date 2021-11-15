<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<div class="wrapper">
	<header class="main-header">
		<!-- main navbar -->
		<nav
			class="navbar navbar-default navbar navbar-fixed-top main-navbar hidden-sm hidden-xs">
			<div class="container">
				<div class="collapse navbar-collapse">
					<ul class="nav navbar-nav  nav-bar-width">
						<li class="header-tab"
					style="width: 130px; color: #fff; font-size: 20px; font-weight: 600; margin-top: 10px;"><span style="font-size:18px; font-weight: 600; margin-top: 10px;">
						<i class="fa fa-bar-chart" aria-hidden="true"
						style="font-size: 15px; margin-left:15px;margin-right:5px;"></i><span style="font-size:16px;margin-top: 10px;">Sales</span><i>Biz</i>
				</span></li>
					</ul>
					<sec:authorize access="isAuthenticated()">
					<ul class="nav navbar-nav" style="float: right;">						
						<sec:authorize access="hasRole('ROLE_ADMIN')">				

							<li class="dropdown" id="fdJobId"><a href="#"
								class="pd-tp-27" style="font-size: 13px; font-weight: 700;"><span
									class="dropbtn">Access Management<i
										class="fa fa-caret-down" aria-hidden="true"
										style="font-size: 15px; margin-left: 5px;"></i></span></a>
								<div class="dropdown-content dropdown-menu" role="menu"
									style="list-style-type: none;">
									<a href="create-role" style="height: 15px;"><i
										class="fa fa-play" aria-hidden="true" style="font-size: 8px;"></i>
										&nbsp;&nbsp; Create Role</a> <a href="view-role"
										style="height: 15px;"><i class="fa fa-play"
										aria-hidden="true" style="font-size: 8px;"></i>
										&nbsp;&nbsp;List Roles</a>  <a href="create-privileges"
										style="height: 15px;"><i class="fa fa-play"
										aria-hidden="true" style="font-size: 8px;"></i>
										&nbsp;&nbsp;Create Privileges</a> <a href="view-privileges"
										style="height: 15px;"><i class="fa fa-play"
										aria-hidden="true" style="font-size: 8px;"></i>
										&nbsp;&nbsp;List Privileges</a> 
										<a href="role-privileges"
										style="height: 15px;"><i class="fa fa-play"
										aria-hidden="true" style="font-size: 8px;"></i>
										&nbsp;&nbsp;Role Privileges</a>
										
										<a href="create-access"
										style="height: 15px;"><i class="fa fa-play"
										aria-hidden="true" style="font-size: 8px;"></i>
										&nbsp;&nbsp;Create Access</a> <a href="view-access"
										style="height: 15px;"><i class="fa fa-play"
										aria-hidden="true" style="font-size: 8px;"></i>
										&nbsp;&nbsp;List Access</a> <a href="create-privilege-access"
										style="height: 15px;"><i class="fa fa-play"
										aria-hidden="true" style="font-size: 8px;"></i>
										&nbsp;&nbsp;Privileges Access</a> <a href="view-privilege-access"
										style="height: 15px;"><i class="fa fa-play"
										aria-hidden="true" style="font-size: 8px;"></i>
										&nbsp;&nbsp;List Privileges-Access</a>


								</div></li>

							<li class="dropdown" id="fdJobId"><a href="#"
								class="pd-tp-27" style="font-size: 13px; font-weight: 700;"><span
									class="dropbtn">Employees<i class="fa fa-caret-down"
										aria-hidden="true" style="font-size: 15px; margin-left: 5px;"></i></span></a>
								<div class="dropdown-content dropdown-menu" role="menu"
									style="list-style-type: none;">
									<a href="create-employees" style="height: 15px;"><i
										class="fa fa-play" aria-hidden="true" style="font-size: 8px;"></i>
										&nbsp;&nbsp;Create Employees</a> <a href="view-employees"
										style="height: 15px;"><i class="fa fa-play"
										aria-hidden="true" style="font-size: 8px;"></i>
										&nbsp;&nbsp;View Employees</a><a href="create-user-roles"
										style="height: 15px;"><i class="fa fa-play"
										aria-hidden="true" style="font-size: 8px;"></i> &nbsp;&nbsp;
										Manage User & Role</a>
								</div></li>
						</sec:authorize>
						
						<sec:authorize access="isAuthenticated()">
							<li class="link-btn hdr-icon-pd"><a href="logout"
								class="pd-tp-20"><span
									class="btn btn-theme  btn-pill btn-xs btn-line">Logout</span></a></li>
						</sec:authorize>
					</ul>
					</sec:authorize>
				</div>
			</div>
		</nav>
	</header>

	<!--start mobile header -->
	<div class="container mobi" style="background-color: #2a3f54;">
		<nav class="mobile-nav hidden-md hidden-lg navbar navbar-fixed-top">
			<ul class="nav navbar-nav nav-block-left">
				<li class="header-tab"
					style="width: 130px; color: #fff; font-size: 20px; font-weight: 600; margin-top: 10px;"><span style="width: 130px; color: #fff; font-size: 20px; font-weight: 600; margin-top: 10px;">
						<i class="fa fa-bar-chart" aria-hidden="true"
						style="font-size: 15px; margin-left: 5px;"></i>MySales
				</span></li>
			</ul>
			<a href="#" class="btn-nav-toogle first"> <span class="bars"></span>
				Menu
			</a>

			<div class="mobile-nav-block">

				<a href="#" class="btn-nav-toogle"> <span class="barsclose"></span>
					Close
				</a>
				<ul class="nav navbar-nav" style="float: right;">						
						<sec:authorize access="hasRole('ROLE_ADMIN')">

							

							<li class="dropdown" id="fdJobId"><a href="#"
								class="pd-tp-27" style="font-size: 13px; font-weight: 700;"><span
									class="dropbtn">Access Management<i
										class="fa fa-caret-down" aria-hidden="true"
										style="font-size: 15px; margin-left: 5px;"></i></span></a>
								<div class="dropdown-content dropdown-menu" role="menu"
									style="list-style-type: none;">
									<a href="create-role" style="height: 15px;"><i
										class="fa fa-play" aria-hidden="true" style="font-size: 8px;"></i>
										&nbsp;&nbsp; Create Role</a> <a href="view-role"
										style="height: 15px;"><i class="fa fa-play"
										aria-hidden="true" style="font-size: 8px;"></i>
										&nbsp;&nbsp;List Roles</a> <a href="role-privileges"
										style="height: 15px;"><i class="fa fa-play"
										aria-hidden="true" style="font-size: 8px;"></i>
										&nbsp;&nbsp;Role Privileges</a> <a href="create-privileges"
										style="height: 15px;"><i class="fa fa-play"
										aria-hidden="true" style="font-size: 8px;"></i>
										&nbsp;&nbsp;Create Privileges</a> <a href="view-privileges"
										style="height: 15px;"><i class="fa fa-play"
										aria-hidden="true" style="font-size: 8px;"></i>
										&nbsp;&nbsp;List Privileges</a> <a href="create-access"
										style="height: 15px;"><i class="fa fa-play"
										aria-hidden="true" style="font-size: 8px;"></i>
										&nbsp;&nbsp;Create Access</a> <a href="view-access"
										style="height: 15px;"><i class="fa fa-play"
										aria-hidden="true" style="font-size: 8px;"></i>
										&nbsp;&nbsp;List Access</a> <a href="create-privilege-access"
										style="height: 15px;"><i class="fa fa-play"
										aria-hidden="true" style="font-size: 8px;"></i>
										&nbsp;&nbsp;Privileges Access</a> <a href="view-privilege-access"
										style="height: 15px;"><i class="fa fa-play"
										aria-hidden="true" style="font-size: 8px;"></i>
										&nbsp;&nbsp;List Privileges-Access</a>


								</div></li>

							<li class="dropdown" id="fdJobId"><a href="#"
								class="pd-tp-27" style="font-size: 13px; font-weight: 700;"><span
									class="dropbtn">Employees<i class="fa fa-caret-down"
										aria-hidden="true" style="font-size: 15px; margin-left: 5px;"></i></span></a>
								<div class="dropdown-content dropdown-menu" role="menu"
									style="list-style-type: none;">
									<a href="create-employees" style="height: 15px;"><i
										class="fa fa-play" aria-hidden="true" style="font-size: 8px;"></i>
										&nbsp;&nbsp;Create Employees</a> <a href="view-employees"
										style="height: 15px;"><i class="fa fa-play"
										aria-hidden="true" style="font-size: 8px;"></i>
										&nbsp;&nbsp;View Employees</a><a href="create-user-roles"
										style="height: 15px;"><i class="fa fa-play"
										aria-hidden="true" style="font-size: 8px;"></i> &nbsp;&nbsp;
										Manage User & Role</a>
								</div></li>
						</sec:authorize>
						
						<sec:authorize access="isAuthenticated()">
							<li class="link-btn hdr-icon-pd"><a href="logout"
								class="pd-tp-20"><span
									class="btn btn-theme  btn-pill btn-xs btn-line">Logout</span></a></li>
						</sec:authorize>
					</ul>
			</div>
		</nav>
	</div>
</div>


