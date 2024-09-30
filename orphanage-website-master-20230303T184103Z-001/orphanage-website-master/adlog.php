<?php
session_start();

?>
<!DOCTYPE html>
<html>
<head>
	<title> Login </title>
	<link rel="shortcut icon" href="images/favicon.png"></link>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
	<link href="css/bootstrap.min.css" rel="stylesheet" ></link>
	<link href="css/bootstrap.css" rel="stylesheet" ></link>
	<link href="css/Default.css" rel="stylesheet" >	</link>
	<script type="text/javascript" src="js/jquery.js"></script>
	<script>
		$(document).ready(function()
		{
			//alert($(window).width());
			var x=(($(window).width())-1024)/2;
			//alert(x);
			$('.wrap').css("left",x+"px");
		});

	</script>
	
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	
	<script type="text/javascript" src="js/bootstrap.js"></script>
	<script type="text/javascript" src="js/man.js"></script>
	
	
</head>
<body>

	<div class="wrap">
		<!-- Header -->
		<div class="header">
			<div style="float:left;width:150px;">
				<img src="images/logo.jpg"/>
			</div>		
			<div>
			<div id="heading">
				<a href="index.html">Indian Railways</a>
			</div>
			</div>
		</div>
		
		<!-- Navigation bar -->
		<div class="navbar navbar-inverse">
			<div class="navbar-inner">
				<div class="container" >
				<a class="brand" href="index.php" >HOME</a>
				<a class="brand" href="train.php" >FIND TRAIN</a>
				<a class="brand" href="reservation.php">RESERVATION</a>
				<a class="brand" href="profile.php">PROFILE</a>
				<a class="brand" href="contact.php">CONTACT</a>
				<a class="brand" href="about.php">ABOUT US</a>
				</div>
			</div>
		</div>
		
		<!-- Login and signup -->
		<div align="center">
		
		<?php
			if(isset($_SESSION['error']))
			{
			 if(isset($_SESSION['name']))
			 {
				//echo "nikul";
			 }
			 else if($_SESSION['error']==15)
			 {
				//echo "hilgr";
		?>
				<div class="alert alert-error"><font size="5"> Please Login First..</font> 
				</div>
		<?php	 }
			}
			//else{ echo "hi";}
		?>
			<br />
			<br />
		<!-- Statring of Form -->

<form id="regForm" action="log.php" method="post" onSubmit="return myfun(this);">

  <h1>Login as Admin!</h1>
  
  <div class="labels">
  <h3>Admin Name:
    <p><input placeholder="Admin Name..." id="uname" name="uname" required></p>
 
 	Password:
    <p><input type="password" placeholder="Password" id="pword" name="pword"></p>
 

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
    
			</table>
			</form>
		</div>
		</div>
		<br/>
		<!-- Footer -->
<footer >
		<div style="width:100%;">
			<div style="float:left;">
			<p class="text-right text-info">  &copy; 2017 Copyright PVT Ltd.</p>	
			</div>
			<div style="float:right;">
			<p class="text-right text-info">	Desinged By : Team Indigo</p>
			</div>
		</div>
		</footer>		
	</div>
</body>
</html>
<?php
if(isset($_SESSION['error']))
{
if($_SESSION['error']==1)
echo "<script>document.getElementById(\"wrong\").style.visibility=\"\";</script>";
session_destroy();
}

?>	