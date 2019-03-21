<?php 

//server <-> app receiving code
//SYSC 3010
//Team M6 Plant Pals
//Author: Emma Maddock
//Description: app receives current plant info from plant_data table

//defining the user and password that already have access to the database
$hostname = 'localhost';
$username = 'apache';
$password = 'Temp123!';
$db = 'web_plants';

//establishing a connection to the database web_plants using the user and password
$conn = mysqli_connect($hostname,$username,$password,$db) or die('Cannot connect to the database');

//queries the current moisture from the last 3 entries of the plant_data table as well as
//the corresponding name from the plants table using a left join and saves it as a result
$sql="SELECT pl.plant_name,pd.current_moisture  FROM plant_data pd LEFT JOIN plants pl ON pd.plant_id=pl.id order by pd.id  limit 3;";
$result= $conn->query($sql);

//creating an array called plants to send back to the app
$plants = array();

//the loop populates the plants array with the name and current moisture of the last
//3 entries from the above result of the query
        while ($row = mysqli_fetch_array($result)) {

                array_push($plants, $row["plant_name"]);
                array_push($plants, $row["current_moisture"]);
        }

//the plants array is encoded into a json object and echoed (sent back) to the app
echo json_encode($plants);

//closing the connection
$conn->close();


?>
