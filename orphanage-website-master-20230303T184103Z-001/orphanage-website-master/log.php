<?php
session_start();

$uname=$_POST['uname'];
$pword=$_POST['pword'];

require('firstimport.php');

$tbl_name="admin"; // Table name

mysqli_select_db($conn,"$db_name")or die("cannot select DB");


$sql="SELECT * FROM $tbl_name WHERE uname='$uname' and pword='$pword'";
echo "$sql";

$result=mysqli_query($conn,$sql) or trigger_error(mysql_error.$sql);

//$row=mysql_fetch_array($result);

//echo "\n\n ..nam..".$row['f_name']."\n\n ..pass..".$row['password'];

if(mysqli_num_rows($result) < 1)
{
	echo " .... LOGIN TRY  ....";
	$_SESSION['error'] = "1";
	header("location:adlog.php"); //
}
else
{
	$_SESSION['uname'] = $uname; // Make it so the username can be called by $_SESSION['name']    //
	echo " ....   LOGIN  ....";
	echo $_SESSION['name'];
	header("location:adlog.php");    //
}

?>

	