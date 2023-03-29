<?php
    require 'connect.php';

    class CHUDE{
        function __construct($macd, $tencd, $hinhcd){
            $this->macd = $macd;
            $this->tencd = $tencd;
            $this->hinhcd = $hinhcd;
        }
    }

    $query = "select * from chudesanpham";
    $data = mysqli_query($conn, $query);
    $arraylist = array();

    while($row=mysqli_fetch_assoc($data))
    {
        array_push($arraylist, new CHUDE($row["MaChuDe"], $row["TenChuDe"], $row["HinhChuDe"]));
    }

    header("Content-type:application/json");
    echo json_encode($arraylist, JSON_UNESCAPED_UNICODE | JSON_PRETTY_PRINT);
?>
