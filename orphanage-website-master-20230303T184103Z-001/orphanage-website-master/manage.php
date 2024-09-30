<?php 
$uname=$_POST['uname'];
$pword=$_POST['pword'];

//database connection

$conn=mysql_connect("localhost","root","");
mysql_select_db("orphan");
$result=mysql_query("select * from admin where uname='$uname' and pword= '$pword' ") or die(mysql_error());
$count=mysql_num_rows($result);
if($count==0)
{
?>

<script>
alert("admin does not exit");
document.location="manage.html";
</script>

<?php

}
else
{
while($row=mysql_fetch_array($result))
{
if($uname==$row[0] && $pword==$row[1])
{
?>

<script>
alert("login successfull");
document.location="admindata.php";
</script>

<?php

}
else
{
?>
<script>
alert("admin does not exist");
document.location="manage.html";
</script>
<?php
}
}
}
?>