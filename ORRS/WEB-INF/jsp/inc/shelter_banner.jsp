
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
		<font color="white">Welcome ${ShelterFormBean.loginShelter.shelterName}</font>
	</h4>
    <ul>
      <li>
      
      <p id="ko" class="label-for-check" for="koko"><span class="glyphicon glyphicon-home" aria-hidden="true"> HOME</span></p>
        <label  id="home1"class="label-for-check" for="home"><table><tr height="80%"></tr><tr><td width="90%"></td><td width="10%"><div class="showhide">Show</div></td></tr></table></label>
        
       <input type="checkbox" class="check-with-label" id="home" onclick='changePrice()'/>
  <!-- <label class="label-for-check" for="idinput">My Label</label> -->
  
        <div>
          <ul>
           
            <li><a href="shelterHomepagePath.do">Main Page</a></li>
            
           
          </ul>
        </div>
      </li>
      <li>
        <p id="ko" class="label-for-check" for="koko"><span class="glyphicon glyphicon-gift" aria-hidden="true"> Orphan</span></p>
       <label  id="orphan1"class="label-for-check" for="orphan"><table><tr><td width="90%"></td><td width="10%"><div class="showhide">Show</div></td></tr></table></label>
        
       <input type="checkbox" class="check-with-label" id="orphan" onclick='changePrice()'/>
        <div>
          <ul>
            <li><a href="orphanInsertPath.do?frmControl=1" >Insert
				and View Orphan List</a></li>
            
          </ul>
        </div>
      </li>
      
       <li>
        <p id="ko" class="label-for-check" for="koko"><span class="glyphicon glyphicon-gift" aria-hidden="true"> Donor</span></p>
       <label  id="donor1"class="label-for-check" for="donor"><table><tr><td width="90%"></td><td width="10%"><div class="showhide">Show</div></td></tr></table></label>
        
       <input type="checkbox" class="check-with-label" id="donor" onclick='changePrice()'/>
        <div>
          <ul>
            <li><a href="shelterDonorPath.do?donorListControl=1" >View Donor
				Lists</a></li>
            
          </ul>
        </div>
      </li>
      
      <li>
        <p id="ko" class="label-for-check" for="koko"><span class="glyphicon glyphicon-heart" aria-hidden="true"> Adopter</span></p>
       <label  id="adopter1"class="label-for-check" for="adopter"><table><tr><td width="90%"></td><td width="10%"><div class="showhide">Show</div></td></tr></table></label>
        
       <input type="checkbox" class="check-with-label" id="adopter" onclick='changePrice()'/>
        <div>
          <ul>
            <li><a href="shelterAdopterPath.do?frmControl=1">View Adopter Lists</a></li>
            
          </ul>
        </div>
      </li>
      <li>
        <p id="ko" class="label-for-check" for="koko"><span class="glyphicon glyphicon-road" aria-hidden="true"> Activity</span></p>
       <label  id="event1"class="label-for-check" for="event"><table><tr><td width="90%"></td><td width="10%"><div class="showhide">Show</div></td></tr></table></label>
        
       <input type="checkbox" class="check-with-label" id="event" onclick='changePrice()'/>
        <div>
          <ul>
            <li><a href="uploadEventPath1.do?frmControl=1">Upload Story or
				Activity</a></li>
			<li><a href="viewEventPath.do">View
				Story and Activity</a></li>
            
          </ul>
        </div>
      </li>
       <li>
        <p id="ko" class="label-for-check" for="koko"><span class="glyphicon glyphicon-picture" aria-hidden="true"> Report</span></p>
       <label  id="report1"class="label-for-check" for="report"><table><tr><td width="90%"></td><td width="10%"><div class="showhide">Show</div></td></tr></table></label>
        
       <input type="checkbox" class="check-with-label" id="report" onclick='changePrice()'/>
        <div>
          <ul>
            <li><a href="viewCategoryReportPath.do">Category Reports</a></li>
             <li><a href="viewDailyReportPath.do">Daily Reports</a></li>
              <li><a href="viewMonthlyReportPath.do">Monthly Reports</a></li>
               <li><a href="viewYearlyReportPath.do">Yearly Reports</a></li>
            
            
          </ul>
        </div>
      </li>
     
      <li>
        <p id="ko" class="label-for-check" for="koko"><span class="glyphicon glyphicon-th-list" aria-hidden="true"> Profile</span></p>
       <label  id="profile1"class="label-for-check" for="profile"><table><tr><td width="90%"></td><td width="10%"><div class="showhide">Show</div></td></tr></table></label>
        
       <input type="checkbox" class="check-with-label" id="profile" onclick='changePrice()'/>
        <div>
          <ul>
            <li><a href="updatePathFirst.do">Update
				Profile</a></li>
			 <li><a href="logoutPath.do">Logout</a></li>
            
          </ul>
        </div>
      </li>
      
    
      
     
    </ul>
  </nav>
</div>
<script type="text/javascript">
function changePrice(){
	
	var chkadopte = document.getElementById('home');
	if( chkadopte.checked==true)
		{
		document.getElementById('home1').innerHTML = '<table><tr height="80%"></tr><tr><td width="90%"></td><td width="10%"><div class="showhide">Hide</div></td></tr></table>';
		}
	else{
		document.getElementById('home1').innerHTML = '<table><tr height="80%"></tr><tr><td width="90%"></td><td width="10%"><div class="showhide">Show</div></td></tr></table>';
	}
	
	var chkHome = document.getElementById('orphan');
	if( chkHome.checked==true)
		{
		document.getElementById('orphan1').innerHTML = '<table><tr height="80%"></tr><tr><td width="90%"></td><td width="10%"><div class="showhide">Hide</div></td></tr></table>';
		}
	else{
		document.getElementById('orphan1').innerHTML = '<table><tr height="80%"></tr><tr><td width="90%"></td><td width="10%"><div class="showhide">Show</div></td></tr></table>';
	}
    
	
	var chkShelter = document.getElementById('donor');
	if( chkShelter.checked==true)
		{
		document.getElementById('donor1').innerHTML = '<table ><tr height="80%"></tr><tr><td width="90%"></td><td width="10%"><div class="showhide">Hide</div></td></tr></table>';
		}
	else{
		document.getElementById('donor1').innerHTML = '<table><tr height="80%"></tr><tr><td width="90%"></td><td width="10%"><div class="showhide">Show</div></td></tr></table>';
	}
	
	var chkevent = document.getElementById('adopter');
	if( chkevent.checked==true)
		{
		document.getElementById('adopter1').innerHTML = '<table><tr height="80%"></tr><tr><td width="90%"></td><td width="10%"><div class="showhide">Hide</div></td></tr></table>';
		}
	else{
		document.getElementById('adopter1').innerHTML = '<table><tr height="80%"></tr><tr><td width="90%"></td><td width="10%"><div class="showhide">Show</div></td></tr></table>';
	}
	
	var chkDonor = document.getElementById('event');
	if( chkDonor.checked==true)
		{
		document.getElementById('event1').innerHTML = '<table><tr height="80%"></tr><tr><td width="90%"></td><td width="10%"><div class="showhide">Hide</div></td></tr></table>';
		}
	else{
		document.getElementById('event1').innerHTML = '<table><tr height="80%"></tr><tr><td width="90%"></td><td width="10%"><div class="showhide">Show</div></td></tr></table>';
	}
	var chkOrphan = document.getElementById('report');
	if( chkOrphan.checked==true)
		{
		document.getElementById('report1').innerHTML = '<table><tr height="80%"></tr><tr><td width="90%"></td><td width="10%"><div class="showhide">Hide</div></td></tr></table>';
		}
	else{
		document.getElementById('report1').innerHTML = '<table><tr height="80%"></tr><tr><td width="90%"></td><td width="10%"><div class="showhide">Show</div></td></tr></table>';
	}
	
	var chkCategory = document.getElementById('profile');
	if( chkCategory.checked==true)
		{
		document.getElementById('profile1').innerHTML = '<table><tr height="80%"></tr><tr><td width="90%"></td><td width="10%"><div class="showhide">Hide</div></td></tr></table>';
		}
	else{
		document.getElementById('profile1').innerHTML = '<table><tr height="80%"></tr><tr><td width="90%"></td><td width="10%"><div class="showhide">Show</div></td></tr></table>';
	}
	
</script>

</body>
</html:html>


