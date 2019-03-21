<?php 

//PHP<->app posting code
//SYSC 3010
//Team M6 Plant Pals
//Author: Emma Maddock
//Description: app inserts user-added plant information into plants table

//defining the user and password that already have access to the database
$hostname = 'localhost';
$username = 'apache';
$password = 'Temp123!';
$db = 'web_plants';

//establishing a connection with the web_plants database using the user and password
$conn = mysqli_connect($hostname,$username,$password,$db) or die('Cannot connect to the database');

//receiving the post requests with plant data from the app and assigning them to variables
$plant_name=  $_POST['plantName'];
$ideal_moist= $_POST['idealMoist'];
$position=    $_POST['position'];

//inserting the user's new plant into the plants database
$sql1="insert into plants (plant_name,ideal_moisture,rig_position)  values('".$plant_name."',".$ideal_moist.",".$position.")";
$result1= $conn->query($sql1);

//echoing a success variable to the app
echo 1;

//closing the connection
$conn->close();


?>

