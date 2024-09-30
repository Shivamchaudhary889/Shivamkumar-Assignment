

<html>
<body>
<?php
$fname=$_POST['fname'];
$lname=$_POST['lname'];
$mfname=$_POST['mfname'];
$mlname=$_POST['mlname'];
$email=$_POST['email'];
$phone=$_POST['phone'];
$country=$_POST['country'];
$city=$_POST['city'];
$fage=$_POST['fage'];
$mage=$_POST['mage'];
$password=$_POST['password'];

if($phone.length< 10)
{
	alert(" no msg ");
	exit();
}



$conn = mysql_connect("localhost", "root", "") or die ("Error connecting to mysql");
mysql_select_db('orphan') or die ('Unable to select  database!');


$query="insert into reg values('$fname','$lname','$mfname','$mlname','$email','$phone','$country','$city','$fage','$mage','$password')";

$query1="insert into adoption values('$email','$password')";


if (!mysql_query($query))
  {
  die('Error: ' . mysql_error());
  } 
  
 if (!mysql_query($query1 ))
  {
  die('Error: ' . mysql_error());
  } 
  
  
  
  ?>
 <script>
 alert("you registered successfull please enter the login details"); 
document.location="adoption.html";
</script>
<?php 
 mysql_close($conn)
?>
</body>
</html>


<html>
<head>
<title>
	Parental Registration.
</title>	

  <link href="css/menu.css" rel="stylesheet" type="text/css">
  <link href="css/form.css" rel="stylesheet" type="text/css">

<script type="text/javascript">
function validate ()
	{
    

if (phone.length < 10)
{
alert("phone number should be atleast 10 numbers, Please Try Again");
}

  }


</script>


<!-- Statring of Form -->

<form id="regForm" method="post">

  <h1>Registration</h1>
  
  <div class="labels">
  <h3>	Father Name:
    <p><input placeholder="First name..." id="fname" name="fname" ></p>
    <p><input placeholder="Last name..." name="lname" ></p>
<h3>	Mother Name:
    <p><input placeholder="First name..." id="mfname" name="mfname" ></p>
    <p><input placeholder="Last name..." name="mlname" ></p>

	Contact Info:	
    <p><input type="email" placeholder="E-mail..."  name="email"></p>
    <p><input placeholder="Phone..."  name="phone" ></p>
   

Country:
<p><input placeholder="Country..." name="country" ></p>
City: 
	<p> <input placeholder="City...."  name="city" ></p>
 Age :
 	<p><input placeholder="Father's Age....." name="fage" ></p>
    <p><input placeholder="Mother's Age...."  name="mage" ></p>
    Password:
    <p><input type="password" placeholder="Password" id="password" name="password"></p>
 

 </h3>
	<center>
    <div style="float:center;">
	<button type="submit" id="submit" value="submit" onClick="validate()">Submit</button>
	</a>
	</center>
	<p>
	<center>
	<div style="float:absolute">
	
	<a href="home.html"><button type="button" id="cancel" onclick="return">Cancel</button></a>
	</center>
	</p>
  

  
</form>


</body>
</html>



