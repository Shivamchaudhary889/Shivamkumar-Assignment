<html>
<body>
<?php
$fname=$_POST['fname'];
$lname=$_POST['lname'];
$dob=$_POST['dob'];
$gender=$_POST['gender'];
$address=$_POST['address'];
$nation=$_POST['nation'];
$work=$_POST['work'];
$age=$_POST['age'];
$email=$_POST['email'];
$password=$_POST['password'];



$conn = mysql_connect("localhost", "root", "") or die ("Error connecting to mysql");
mysql_select_db('orphan') or die ('Unable to select  database!');

$query="insert into reg_vol values('$fname','$lname','$dob',$gender','$address','$nation','$work','age','$email','password')";
$result=mysql_query($conn, $query) or die('volunteer already existed.');

if (!mysql_query($query))
  {
  die('Error: ' . mysql_error());
  } 
  
 
  
  
  ?>
 <script>
 alert("you registered successfull please enter the login details"); 
document.location="volunteer.html";
</script>
<?php 
 mysql_close($conn)
?>
</body>
</html>
