<?php
    require 'connect.php';

    class CHUDE{
        function __construct($masp, $macd, $tensp, $giasp, $hinhsp, $mota){
            $this->masp = $masp;
            $this->macd = $macd;
            $this->tensp = $tensp;
            $this->giasp = $giasp;
            $this->hinhsp = $hinhsp;
            $this->mota = $mota;
        }
    }

    $query = "select * from sanpham";
    $data = mysqli_query($conn, $query);
    $arraylist = array();

    while($row=mysqli_fetch_assoc($data))
    {
        array_push($arraylist, new CHUDE($row["MaSanPham"],$row["MaChuDe"], $row["TenSanPham"], $row["GiaSanPham"],$row["HinhSanPham"], $row["mota"]));
    }

    header("Content-type:application/json");
    echo json_encode($arraylist, JSON_UNESCAPED_UNICODE | JSON_PRETTY_PRINT);
