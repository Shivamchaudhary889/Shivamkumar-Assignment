<?php 
$email=$_POST['email'];
$password=$_POST['password'];

//database connection

$conn=mysql_connect("localhost","root","");
mysql_select_db("orphan");
$result=mysql_query("select * from adoption where email='$email' and password= '$password' ") or die(mysql_error());
$count=mysql_num_rows($result);
if($count==0)
{
?>

<script>
alert("admin does not exit");
document.location="adoption.html";
</script>

<?php

}
else
{
while($row=mysql_fetch_array($result))
{
if($email==$row[0] && $password==$row[1])
{
?>

<script>
alert("login successfull");
document.location="parent.html";
</script>

<?php

}
else
{
?>
<script>
alert("user does not exist");
document.location="adoption.html";
</script>
<?php
}
}
}
?>
