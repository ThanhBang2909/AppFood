<?php
require 'connect.php';

$macd = array();
$machude = isset($_GET['macd']) ? $_GET['macd'] : null;


class SANPHAM{
    public $masp;
    public $machude;
    public $tensp;
    public $giasp;
    public $hinhsp;
    public $mota;

    function __construct($masp, $machude, $tensp, $giasp, $hinhsp, $mota){
        $this->masp = $masp;
        $this->machude = $machude;
        $this->tensp = $tensp;
        $this->giasp = $giasp;
        $this->hinhsp = $hinhsp;
        $this->mota = $mota;
    }
}

if($machude == null){
    $query = "SELECT * FROM sanpham";
} else {
    $query = "SELECT * FROM sanpham WHERE MaChuDe=?";
}

$data = mysqli_query($conn, $query);
$arraylist = array();

while($row=mysqli_fetch_assoc($data))
{
    array_push($arraylist, new SANPHAM($row["MaSanPham"], $row["MaChuDe"], $row["TenSanPham"],
     $row["GiaSanPham"],$row["HinhSanPham"],$row["mota"]));
}

header("Content-type:application/json");
echo json_encode($arraylist, JSON_UNESCAPED_UNICODE | JSON_PRETTY_PRINT);
?>
