<?php
if (isset($_POST['Email']) && isset($_POST['Password'])) {
    require_once "connect.php";
    require_once "validate.php";
    $email = validate($_POST['Email']);
    $password = validate($_POST['Password']);
    $sql = "select * from khachhang where Email='$email' and Password='$password' ";
    $result = $conn->query($sql);
    if ($result->num_rows > 0) {
        echo "Success";
    }
    else{
        echo "Failure";
    }
}
?>