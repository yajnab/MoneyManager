<?php
$servername = "localhost";
$username = "root";
$password = "petrol123";
$dbname = "yajnab";

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);
// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
} 
$myArray = array();
if ($result = $conn->query("SELECT * FROM moneyinventory")) {

    while($row = $result->fetch_array(MYSQL_ASSOC)) {
            $myArray[] = $row;
    }
    echo json_encode($myArray);
}

$result->close();
$conn->close();
?>
