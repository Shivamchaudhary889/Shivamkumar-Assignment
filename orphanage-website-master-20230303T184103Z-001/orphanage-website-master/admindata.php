
  <!DOCTYPE html>
<html>
<head>
      <link rel="stylesheet" type="text/css" href="css/button.css">
    <link href="css/menu.css" rel="stylesheet" type="text/css">

  <title>
    ADMIN PAGE!
  </title>


  
<style >
  
  body
  {
    background-color: #C0C0C0;
    background-repeat: no-repeat;
    background-size: 100%;

  }
</style>
</head>

  <body>
      <!-- Menu Bar-->
  
<center>
<div class="dropdown">
  <a href="manage.html">
  <button class="dropbtn">LOGOUT</button></a>
</div>
</center>
</div>
<center>
</br></br></br></br></br></br>
  <a href="admin_volunteer.html"><button  class="btn success ">Add Volunteer </button></a>
  <a href="admin_reg.html"> <button  class="btn success ">Add Parent Account</button></a>
  <a href="admin_del.html"> <button class="btn danger">Delete</button></a>
</center>
    <h1> REGISTRATION TABLE</h1>
<table border="1">

<?php

mysql_connect("localhost","root","") or die(mysql_error());

mysql_select_db("orphan") or die(mysql_error());
				
$result=mysql_query("select * from reg") or die(mysql_error());

while($row=mysql_fetch_array($result))
{
	
echo "<tr><td>";
echo $row[0];
echo "</td><td>";

echo $row[1];
echo "</td><td>";

echo $row[2];
echo "</td><td>";

echo $row[3];
echo "</td><td>";

echo $row[4];
echo "</td><td>";

echo $row[5];
echo "</td><td>";

echo $row[6];
echo "</td><td>";

echo $row[7];
echo "</td><td>";

echo $row[8];
echo "</td><td>";

echo $row[9];
echo "</td><td>";

echo $row[10];
echo "</td></tr>";

}
?>
</table>
<h1> DONATION PAYMENT</h1>
<table border="1">
<?php

mysql_connect("localhost","root","") or die(mysql_error());

mysql_select_db("orphan") or die(mysql_error());
        
$result=mysql_query("select * from pay") or die(mysql_error());

while($row=mysql_fetch_array($result))
{
  
echo "<tr><td>";
echo $row[0];
echo "</td><td>";

echo $row[1];
echo "</td><td>";

echo $row[2];
echo "</td><td>";

echo $row[3];
echo "</td><td>";

echo $row[4];
echo "</td><td>";

echo $row[5];
echo "</td><td>";

echo $row[6];
echo "</td><td>";

echo $row[7];
echo "</td><td>";

echo $row[8];
echo "</td><td>";

echo $row[9];
echo "</td><td>";

echo $row[10];
echo "</td></tr>";

}
?>
</table>

<h1> PARENTAL LOGIN DETAILS </h1>
<table border="1">
<?php

mysql_connect("localhost","root","") or die(mysql_error());

mysql_select_db("orphan") or die(mysql_error());
        
$result=mysql_query("select * from adoption") or die(mysql_error());

while($row=mysql_fetch_array($result))
{
  
echo "<tr><td>";
echo $row[0];
echo "</td><td>";

echo $row[1];
echo "</td></tr>";

}
?>
</table>

<h1> PROJECT 1 VOLUNTEERS DETAILS</h1>
<table border="1">
<?php

mysql_connect("localhost","root","") or die(mysql_error());

mysql_select_db("orphan") or die(mysql_error());
        
$result=mysql_query("select * from pro1_vol") or die(mysql_error());

while($row=mysql_fetch_array($result))
{
  
echo "<tr><td>";
echo $row[0];
echo "</td><td>";

echo $row[1];
echo "</td><td>";

echo $row[2];
echo "</td></tr>";

}
?>
</table>

<h1> PROJECT 1 VOLUNTEERS PAYMENT DETAILS</h1>
<table border="1">
<?php

mysql_connect("localhost","root","") or die(mysql_error());

mysql_select_db("orphan") or die(mysql_error());
        
$result=mysql_query("select * from pay") or die(mysql_error());

while($row=mysql_fetch_array($result))
{
  
echo "<tr><td>";
echo $row[0];
echo "</td><td>";

echo $row[1];
echo "</td><td>";

echo $row[2];
echo "</td><td>";

echo $row[3];
echo "</td><td>";

echo $row[4];
echo "</td><td>";

echo $row[5];
echo "</td><td>";

echo $row[6];
echo "</td><td>";

echo $row[7];
echo "</td><td>";

echo $row[8];
echo "</td><td>";

echo $row[9];
echo "</td><td>";

echo $row[10];
echo "</td></tr>";

}
?>
</table>
<h1> VOLUNTEERS REGISTRATION DETAILS</h1>
<table border="1">
<?php

mysql_connect("localhost","root","") or die(mysql_error());

mysql_select_db("orphan") or die(mysql_error());
        
$result=mysql_query("select * from reg_vol") or die(mysql_error());

while($row=mysql_fetch_array($result))
{
  
echo "<tr><td>";
echo $row[0];
echo "</td><td>";

echo $row[1];
echo "</td><td>";

echo $row[2];
echo "</td><td>";

echo $row[3];
echo "</td><td>";

echo $row[4];
echo "</td><td>";

echo $row[5];
echo "</td><td>";

echo $row[6];
echo "</td><td>";

echo $row[7];
echo "</td><td>";

echo $row[8];
echo "</td><td>";


echo $row[9];
echo "</td></tr>";

}
?>
</table>
</body>
</html>

