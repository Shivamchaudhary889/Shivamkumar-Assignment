<html>
<body>
<?php
$vname=$_POST['vname'];
$phone=$_POST['phone'];
$nod=$_POST['nod'];


$conn = mysql_connect("localhost", "root", "") or die ("Error connecting to mysql");
mysql_select_db('orphan') or die ('Unable to select  database!');

$query="insert into pro2_vol values('$vname','$phone','$nod')";


if (!mysql_query($query))
  {
  die('Error: ' . mysql_error());
  } 
  
 
  
  
  ?>
 <script>
 alert("You have been volunteered"); 
document.location="project.html";
</script>
<?php 
 mysql_close($conn)
?>
</body>
</html>


