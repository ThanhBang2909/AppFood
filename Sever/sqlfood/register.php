<?php
if (isset($_POST['Email']) && isset($_POST['Password']) && isset($_POST['fullName']) && isset($_POST['DiaChi']) && isset($_POST['Phone'])) {
    require_once "connect.php";
    require_once "validate.php";
    $email = validate($_POST['Email']);
    $password = validate($_POST['Password']);
    $fullName = validate($_POST['fullName']);
    $address = validate($_POST['DiaChi']);
    $phone = validate($_POST['Phone']);
    $sql = "insert into khachhang values ('$email', '$password', '$fullName', '$address', '$phone')";
    if (!$conn->query($sql)) {
        echo "Failure";
    }else{
        echo "Success";
    }
}
?>