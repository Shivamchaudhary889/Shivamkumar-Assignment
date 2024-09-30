<html>
<body>
<?php
$cno=$_POST['cno'];
$expries=$_POST['expries'];
$cvv=$_POST['cvv'];
$amount =$_POST['amount'];
$fname=$_POST['fname'];
$lname=$_POST['lname'];
$address=$_POST['address'];
$country=$_POST['country'];
$state=$_POST['state'];
$postcode=$_POST['postcode'];
$pno=$_POST['pno'];
$email=$_POST['email'];




$conn = mysql_connect("localhost", "root", "") or die ("Error connecting to mysql");
mysql_select_db('orphan') or die ('Unable to select  database!');

$query="insert into pay values('$cno','$expries','$cvv','$amount','$fname','$lname','$address','$country','$state','$postcode','$pno','$email')";


if (!mysql_query($query))
  {
  die('Error: ' . mysql_error());
  } 
  
 
  
  
  ?>
 <script>
 alert("Your payment have succesfully done !. The billing is sent to the given address"); 
document.location="home.html";
</script>
<?php 
 mysql_close($conn)
?>
</body>
</html>

