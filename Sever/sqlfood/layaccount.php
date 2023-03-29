<?php
    require 'connect.php';

    class CHUDE{
        function __construct($email, $fullname, $Password, $Diachi, $Phone){
            $this->Email = $email;
            $this->fullName = $fullname;
            $this->Password = $Password;
            $this->DiaChi = $Diachi;
            $this->Phone = $Phone;
        }
    }

    $query = "select * from khachhang";
    $data = mysqli_query($conn, $query);
    $arraylist = array();

    while($row=mysqli_fetch_assoc($data))
    {
        array_push($arraylist, new CHUDE($row["Email"], $row["fullName"], $row["Password"], $row["DiaChi"], $row["Phone"]));
    }

    header("Content-type:application/json");
    echo json_encode($arraylist, JSON_UNESCAPED_UNICODE | JSON_PRETTY_PRINT);
?>
