<?php 
//PHP<->Python client code
//SYSC 3010
//Team M6 Plant Pals
//Author: Emma Maddock
//Description: inserts data from moisture sensors into plant_data table and returns position of plants
//that need to be watered

//defining the user and password that already have access to the database
$hostname = 'localhost';
$username = 'apache';
$password = 'Temp123!';
$db = 'web_plants';

//establishing a connection to web_plants using the user and password
$conn = mysqli_connect($hostname,$username,$password,$db) or die('Cannot connect to the database');

//receiving moisture data from each plant from the moisture sensors through the Python client
//and assigning them to variables. also setting up related rig position as a variable.
$Plant1=$_GET['Plant1'];
$Plant2=$_GET['Plant2'];
$Plant3=$_GET['Plant3'];

$rig_position1=1;
$rig_position2=2;
$rig_position3=3;

//*************************************************************************
//inserting the moisture data from the first moisture sensor into the plant_data table
$sql1="insert into plant_data (current_moisture,date_collected,plant_id)  values(".$Plant1.",NOW(),".$rig_position1.")";
$result1 = $conn->query($sql1);

//inserting the second
$sql2="insert into plant_data (current_moisture,date_collected,plant_id)  values(".$Plant2.",NOW(),".$rig_position2.")";
$result2 = $conn->query($sql2);

//inserting the third
$sql3="insert into plant_data (current_moisture,date_collected,plant_id)  values(".$Plant3.",NOW(),".$rig_position3.")";
$result3 = $conn->query($sql3);
//***************************************************

//for each plant, querying the last entry in plant_data where the current moisture level is
//above the ideal moisture for that particular plant. reverse logic to what is needed, but
//the reason is explained in the next section. these queries turn up empty if the plant is below its ideal moisture.
//************************************************************************************************
//checking the first plant's current moisture against its ideal moisture
$sql4=" SELECT pd.date_collected,pd.plant_id,pd.current_moisture  
        FROM plant_data pd LEFT JOIN plants pl ON pd.plant_id=pl.id  
        where pl.id=1  
        and pd.current_moisture > ( select ideal_moisture from plants where id=1)  
        order by pd.id  desc limit 1;";

$result4 = $conn->query($sql4);

//checking the second plant
$sql5=" SELECT pd.date_collected,pd.plant_id,pd.current_moisture 
        FROM plant_data pd LEFT JOIN plants pl ON pd.plant_id=pl.id  
        where pl.id=2  
        and pd.current_moisture > ( select ideal_moisture from plants where id=2)
        order by pd.id  desc limit 1;";

$result5 = $conn->query($sql5);

//checking the third
$sql6=" SELECT pd.date_collected,pd.plant_id,pd.current_moisture 
        FROM plant_data pd LEFT JOIN plants pl ON pd.plant_id=pl.id  
        where pl.id=3  
        and pd.current_moisture > ( select ideal_moisture from plants where id=3)
        order by pd.id  desc limit 1;";

$result6 = $conn->query($sql6);
//***************************************************

//now going through the result for each plant and echoing the position to be watered
//if its respective query came up null (the logic being the last entry isn't above its ideal moisture,
//so it must be below). if none are empty, they're all above their ideal moisture levels and
//echoes a 0 which means don't water anything.

if (mysqli_num_rows($result4) == 0) { echo 1;exit();}
if (mysqli_num_rows($result5) == 0) { echo 2;exit();}
if (mysqli_num_rows($result6)  ==0) { echo 3;exit();}

//closing the connection
$conn->close();

//echoing a 0 if none of the plants need to be watered since the code will get past the if statements above
        echo 0;
?>

