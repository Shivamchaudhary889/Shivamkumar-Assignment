<!DOCTYPE html>
<html>
<head>
	<title>
		reg2
	</title>
</head>
<body>



<!-- Statring of Form -->

<form id="regForm" action="reg2.php" method="post" onSubmit="return myfun(this);">

  <h1>Registration</h1>
  
  <div class="labels">
  <h3>	Father Name:
    <p><input placeholder="First name..." id="fname" name="fname" required></p>
    <p><input placeholder="Last name..." name="lname" required></p>
<h3>	Mother Name:
    <p><input placeholder="First name..." id="mfname" name="mfname" required></p>
    <p><input placeholder="Last name..." name="mlname" required></p>

	Contact Info:	
    <p><input type="email" placeholder="E-mail..."  name="email"required></p>
    <p><input placeholder="Phone..."  name="phone" required></p>
   

Country:
<p><input placeholder="Country..." name="country" required></p>
City: 
	<p> <input placeholder="City...."  name="city" required></p>
 Age :
 	<p><input placeholder="Father's Age....." name="fage" required></p>
    <p><input placeholder="Mother's Age...."  name="mage" required></p>
    Password:
    <p><input type="password" placeholder="Password" id="password" name="password"></p>
 

 </h3>
	<center>
    <div style="float:center;">
	<button type="submit" id="submit" value="submit" onclick="submit">Submit</button>
	</a>
	</center>
	<p>
	<center>
	<div style="float:absolute">
	
	<a href="home.html"><button type="button" id="cancel" onclick="return">Cancel</button></a>
	</center>
	</p>
  </body>
</html>


