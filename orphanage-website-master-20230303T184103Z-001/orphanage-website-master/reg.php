

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




