<link rel="stylesheet" type="text/css" media="all"
	href="css/layout.css" />

<aside id="sidebar" class="column">
	<h2>
		<font color="green">${ShelterFormBean.loginShelter.shelterName}</font>
	</h2>
	<hr />
	<h3>Orphans</h3>
	<ul class="toggle">
		<li class="icn_add_user"><a href="orphanInsertPath.do?frmControl=1">Insert
				and View Orphan-lists</a></li>

	</ul>
	<h3>Donors</h3>
	<ul class="toggle">

		<li class="icn_view_users"><a href="shelterDonorPath.do?donorListControl=1">View Donor
				Lists</a></li>
	</ul>

	<h3>Adopters</h3>
	<ul class="toggle">

		<li class="icn_view_users"><a
			href="shelterAdopterPath.do?frmControl=1">View Adopter Lists</a></li>

	</ul>




	<h3>Events</h3>
	<ul class="toggle">
		<li class="icn_categories"><a href="uploadEventPath1.do?frmControl=1">Upload
				Event</a></li>
		<li class="icn_categories"><a href="viewEventPath.do">View
				Event</a></li>

	</ul>
	<h3>Reports</h3>
	<ul class="toggle">

		<li class="icn_folder"><a href="viewReportPath.do">View
				Reports</a></li>

	</ul>
	<h3>Your Profile</h3>
	<ul class="toggle">
		<li class="icn_settings"><a href="updatePathFirst.do" onclick="register()">Update
				Profile</a></li>

		<li class="icn_jump_back"><a href="logoutPath.do">Logout</a></li>
	</ul>
	</aside>
