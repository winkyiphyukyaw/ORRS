
<%@ include file="common.jsp" %>
<html:html>
<head>
<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
<link href="css/style2.css" rel='stylesheet' type='text/css' />
<link href="css/style3.css" rel='stylesheet' type='text/css' />
</head>
<body>
<div class="wrapper">
  <nav class="vertical">
  <h4>
		<font color="white">Welcome ${AdminFormBean.loginAdmin.adminName}</font>
	</h4>
    <ul>
      <li>
      
      <p id="ko" class="label-for-check" for="koko"><span class="glyphicon glyphicon-home" aria-hidden="true"> HOME</span></p>
        <label  id="home1"class="label-for-check" for="home"><table><tr height="80%"></tr><tr><td width="90%"></td><td width="10%"><div class="showhide">Show</div></td></tr></table></label>
        
       <input type="checkbox" class="check-with-label" id="home" onclick='changePrice()'/>
  <!-- <label class="label-for-check" for="idinput">My Label</label> -->
  
        <div>
          <ul>
           
            <li><a href="homepagePath.do">Main Page</a></li>
            
           <!--  <li><a href="#">Contact</a></li> -->
          </ul>
        </div>
      </li>
      <li>
        <p id="ko" class="label-for-check" for="koko"><span class="glyphicon glyphicon-gift" aria-hidden="true"> Donor</span></p>
       <label  id="donor1"class="label-for-check" for="donor"><table><tr><td width="90%"></td><td width="10%"><div class="showhide">Show</div></td></tr></table></label>
        
       <input type="checkbox" class="check-with-label" id="donor" onclick='changePrice()'/>
        <div>
          <ul>
            <li><a href="adminDonorPath.do?donorListControl=1?" >View Donor Lists</a></li>
            
          </ul>
        </div>
      </li>
      
       <li>
        <p id="ko" class="label-for-check" for="koko"><span class="glyphicon glyphicon-gift" aria-hidden="true"> Adopter</span></p>
       <label  id="adopter1"class="label-for-check" for="adopter"><table><tr><td width="90%"></td><td width="10%"><div class="showhide">Show</div></td></tr></table></label>
        
       <input type="checkbox" class="check-with-label" id="adopter" onclick='changePrice()'/>
        <div>
          <ul>
            <li><a href="adopterViewPath.do?frmControl=1" >View Adopter Lists</a></li>
            
          </ul>
        </div>
      </li>
      
      <li>
        <p id="ko" class="label-for-check" for="koko"><span class="glyphicon glyphicon-heart" aria-hidden="true"> Orphan</span></p>
       <label  id="orphan1"class="label-for-check" for="orphan"><table><tr><td width="90%"></td><td width="10%"><div class="showhide">Show</div></td></tr></table></label>
        
       <input type="checkbox" class="check-with-label" id="orphan" onclick='changePrice()'/>
        <div>
          <ul>
            <li><a href="AdminViewOrphanPath.do?adminViewOrphanControl=1">View Orphan</a></li>
            
          </ul>
        </div>
      </li>
      <li>
        <p id="ko" class="label-for-check" for="koko"><span class="glyphicon glyphicon-road" aria-hidden="true"> SHELTER</span></p>
       <label  id="shelter1"class="label-for-check" for="shelter"><table><tr><td width="90%"></td><td width="10%"><div class="showhide">Show</div></td></tr></table></label>
        
       <input type="checkbox" class="check-with-label" id="shelter" onclick='changePrice()'/>
        <div>
          <ul>
            <li><a href="adminViewShelterPath.do?frmControl=1">View Shelter List</a></li>
            
          </ul>
        </div>
      </li>
       <li>
        <p id="ko" class="label-for-check" for="koko"><span class="glyphicon glyphicon-picture" aria-hidden="true"> Activity</span></p>
       <label  id="event1"class="label-for-check" for="event"><table><tr><td width="90%"></td><td width="10%"><div class="showhide">Show</div></td></tr></table></label>
        
       <input type="checkbox" class="check-with-label" id="event" onclick='changePrice()'/>
        <div>
          <ul>
            <li><a href="adminEventPath1.do?frmControl=1">Upload Activity and Story</a></li>
            <li><a href="adminViewEventPath.do?frmControl=6">View And Edit Activity</a></li>
            
          </ul>
        </div>
      </li>
     
      <li>
        <p id="ko" class="label-for-check" for="koko"><span class="glyphicon glyphicon-th-list" aria-hidden="true"> Category</span></p>
       <label  id="category1"class="label-for-check" for="category"><table><tr><td width="90%"></td><td width="10%"><div class="showhide">Show</div></td></tr></table></label>
        
       <input type="checkbox" class="check-with-label" id="category" onclick='changePrice()'/>
        <div>
          <ul>
            <li><a href="categoryPathFirst.do?updateCategoryControl=1">Add New Category</a></li>
            
          </ul>
        </div>
      </li>
      <li>
        <p id="ko" class="label-for-check" for="koko"><span class="glyphicon glyphicon-list" aria-hidden="true"> City</span></p>
       <label  id="city1"class="label-for-check" for="city"><table><tr><td width="90%"></td><td width="10%"><div class="showhide">Show</div></td></tr></table></label>
        
       <input type="checkbox" class="check-with-label" id="city" onclick='changePrice()'/>
        <div>
          <ul>
            <li><a href="location.do?frmControl=1">Add New City</a></li>
            
          </ul>
        </div>
      </li>
      <li>
        <p id="ko" class="label-for-check" for="koko"><span class="glyphicon glyphicon-book" aria-hidden="true"> Financial</span></p>
       <label  id="final1"class="label-for-check" for="final"><table><tr><td width="90%"></td><td width="10%"><div class="showhide">Show</div></td></tr></table></label>
        
       <input type="checkbox" class="check-with-label" id="final" onclick='changePrice()'/>
        <div>
          <ul>
            <li><a href="financialPath.do?frmFormControl=1">View Amount</a></li>
            
          </ul>
        </div>
      </li>
       <li>
        <p id="ko" class="label-for-check" for="koko"><span class="glyphicon glyphicon-envelope" aria-hidden="true"> Income Report</span></p>
       <label  id="report1"class="label-for-check" for="report"><table><tr><td width="90%"></td><td width="10%"><div class="showhide">Show</div></td></tr></table></label>
        
       <input type="checkbox" class="check-with-label" id="report" onclick='changePrice()'/>
        <div>
          <ul>
            <!-- <li><a href="#">Reports</a></li> -->
            
            <li class="icn_categories"><a href="adminViewCategoryReportPath.do">Reports by Category</a></li>
            <li class="icn_categories"><a href="adminViewDailyReportPath.do">Daily Reports </a></li>
          	<li class="icn_categories"><a href="adminViewMonthlyReportPath.do">Monthly Reports </a></li>
          	<li class="icn_categories"><a href="adminViewYearlyReportPath.do">Yearly Reports </a></li>
          
          </ul>
        </div>
      </li>
      <li>
        <p id="ko" class="label-for-check" for="koko"><span class="glyphicon glyphicon-envelope" aria-hidden="true"> Outcome Report</span></p>
       <label  id="report3"class="label-for-check" for="report2"><table><tr><td width="90%"></td><td width="10%"><div class="showhide">Show</div></td></tr></table></label>
        
       <input type="checkbox" class="check-with-label" id="report2" onclick='changePrice()'/>
        <div>
          <ul>
            <!-- <li><a href="#">Reports</a></li> -->
            
            <li class="icn_categories"><a href="adminViewOutcomeReportPath.do">Annual Report</a></li>
            
          
          </ul>
        </div>
      </li>
      <li>
       <p id="ko" class="label-for-check" for="koko"><span class="glyphicon glyphicon-user" aria-hidden="true"> Profile</span></p>
       <label  id="profile1"class="label-for-check" for="profile"><table><tr><td width="90%"></td><td width="10%"><div class="showhide">Show</div></td></tr></table></label>
        
       <input type="checkbox" class="check-with-label" id="profile" onclick='changePrice()'/>
        <div>
          <ul>
            <li><a href="adminViewPath.do">View Profile</a></li>
            <li><a href="adminLogoutPath.do">Logout</a></li>
            
          </ul>
        </div>
      </li>
    </ul>
  </nav>
</div>
<script type="text/javascript">
function changePrice(){
	
	var chkadopte = document.getElementById('adopter');
	if( chkadopte.checked==true)
		{
		document.getElementById('adopter1').innerHTML = '<table><tr height="80%"></tr><tr><td width="90%"></td><td width="10%"><div class="showhide">Hide</div></td></tr></table>';
		}
	else{
		document.getElementById('adopter1').innerHTML = '<table><tr height="80%"></tr><tr><td width="90%"></td><td width="10%"><div class="showhide">Show</div></td></tr></table>';
	}
	
	var chkHome = document.getElementById('home');
	if( chkHome.checked==true)
		{
		document.getElementById('home1').innerHTML = '<table><tr height="80%"></tr><tr><td width="90%"></td><td width="10%"><div class="showhide">Hide</div></td></tr></table>';
		}
	else{
		document.getElementById('home1').innerHTML = '<table><tr height="80%"></tr><tr><td width="90%"></td><td width="10%"><div class="showhide">Show</div></td></tr></table>';
	}
    
	
	var chkShelter = document.getElementById('shelter');
	if( chkShelter.checked==true)
		{
		document.getElementById('shelter1').innerHTML = '<table ><tr height="80%"></tr><tr><td width="90%"></td><td width="10%"><div class="showhide">Hide</div></td></tr></table>';
		}
	else{
		document.getElementById('shelter1').innerHTML = '<table><tr height="80%"></tr><tr><td width="90%"></td><td width="10%"><div class="showhide">Show</div></td></tr></table>';
	}
	
	var chkevent = document.getElementById('event');
	if( chkevent.checked==true)
		{
		document.getElementById('event1').innerHTML = '<table><tr height="80%"></tr><tr><td width="90%"></td><td width="10%"><div class="showhide">Hide</div></td></tr></table>';
		}
	else{
		document.getElementById('event1').innerHTML = '<table><tr height="80%"></tr><tr><td width="90%"></td><td width="10%"><div class="showhide">Show</div></td></tr></table>';
	}
	
	var chkDonor = document.getElementById('donor');
	if( chkDonor.checked==true)
		{
		document.getElementById('donor1').innerHTML = '<table><tr height="80%"></tr><tr><td width="90%"></td><td width="10%"><div class="showhide">Hide</div></td></tr></table>';
		}
	else{
		document.getElementById('donor1').innerHTML = '<table><tr height="80%"></tr><tr><td width="90%"></td><td width="10%"><div class="showhide">Show</div></td></tr></table>';
	}
	var chkOrphan = document.getElementById('orphan');
	if( chkOrphan.checked==true)
		{
		document.getElementById('orphan1').innerHTML = '<table><tr height="80%"></tr><tr><td width="90%"></td><td width="10%"><div class="showhide">Hide</div></td></tr></table>';
		}
	else{
		document.getElementById('orphan1').innerHTML = '<table><tr height="80%"></tr><tr><td width="90%"></td><td width="10%"><div class="showhide">Show</div></td></tr></table>';
	}
	/* var chkStory = document.getElementById('story');
	if( chkStory.checked==true)
		{
		document.getElementById('story1').innerHTML = '<table><tr height="80%"></tr><tr><td width="90%"></td><td width="10%"><div class="showhide">Hide</div></td></tr></table>';
		}
	else{
		document.getElementById('story1').innerHTML = '<table><tr height="80%"></tr><tr><td width="90%"></td><td width="10%"><div class="showhide">Show</div></td></tr></table>';
	} */
	var chkCategory = document.getElementById('category');
	if( chkCategory.checked==true)
		{
		document.getElementById('category1').innerHTML = '<table><tr height="80%"></tr><tr><td width="90%"></td><td width="10%"><div class="showhide">Hide</div></td></tr></table>';
		}
	else{
		document.getElementById('category1').innerHTML = '<table><tr height="80%"></tr><tr><td width="90%"></td><td width="10%"><div class="showhide">Show</div></td></tr></table>';
	}
	var chkCity = document.getElementById('city');
	if( chkCity.checked==true)
		{
		document.getElementById('city1').innerHTML = '<table><tr height="80%"></tr><tr><td width="90%"></td><td width="10%"><div class="showhide">Hide</div></td></tr></table>';
		}
	else{
		document.getElementById('city1').innerHTML = '<table><tr height="80%"></tr><tr><td width="90%"></td><td width="10%"><div class="showhide">Show</div></td></tr></table>';
	}
	var chkfinal = document.getElementById('final');
	if( chkfinal.checked==true)
		{
		document.getElementById('final1').innerHTML = '<table><tr height="80%"></tr><tr><td width="90%"></td><td width="10%"><div class="showhide">Hide</div></td></tr></table>';
		}
	else{
		document.getElementById('final1').innerHTML = '<table><tr height="80%"></tr><tr><td width="90%"></td><td width="10%"><div class="showhide">Show</div></td></tr></table>';
	}
	var chkReport = document.getElementById('report');
	if( chkReport.checked==true)
		{
		document.getElementById('report1').innerHTML = '<table><tr height="80%"></tr><tr><td width="90%"></td><td width="10%"><div class="showhide">Hide</div></td></tr></table>';
		}
	else{
		document.getElementById('report1').innerHTML = '<table><tr height="80%"></tr><tr><td width="90%"></td><td width="10%"><div class="showhide">Show</div></td></tr></table>';
	}
	var chkProfile = document.getElementById('profile');
	if( chkProfile.checked==true)
		{
		document.getElementById('profile1').innerHTML = '<table><tr height="80%"></tr><tr><td width="90%"></td><td width="10%"><div class="showhide">Hide</div></td></tr></table>';
		}
	else{
		document.getElementById('profile1').innerHTML = '<table><tr height="80%"></tr><tr><td width="90%"></td><td width="10%"><div class="showhide">Show</div></td></tr></table>';
	}
}
</script>

</body>
</html:html>


