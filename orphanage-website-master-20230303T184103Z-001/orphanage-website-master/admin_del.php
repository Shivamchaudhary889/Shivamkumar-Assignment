
<?php
$email= $_POST['email'];
$table=$_POST['table'];


$conn = mysql_connect("localhost", "root", "") or die ("Error connecting to mysql");
mysql_select_db('orphan') or die ('Unable to select  database!');

$query="DELETE FROM $table WHERE email = '$email' ";

  
if (!mysql_query($query))
  {
  die('Error: ' . mysql_error());
  } 
   
  ?>
 <script>
 alert(" RECORD DELETED "); 
document.location="admin_del.html";
</script>
<?php 
 mysql_close($conn)
?>