-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th3 27, 2023 lúc 09:14 AM
-- Phiên bản máy phục vụ: 10.4.24-MariaDB
-- Phiên bản PHP: 8.0.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `foodapp`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chitiethoadon`
--

CREATE TABLE `chitiethoadon` (
  `MaHD` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `MaSanPham` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `SoLuong` int(11) NOT NULL,
  `DonGia` int(11) NOT NULL,
  `ThanhTien` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chudesanpham`
--

CREATE TABLE `chudesanpham` (
  `MaChuDe` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `TenChuDe` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `HinhChuDe` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `chudesanpham`
--

INSERT INTO `chudesanpham` (`MaChuDe`, `TenChuDe`, `HinhChuDe`) VALUES
('CF', 'Café', 'cafe.jpeg'),
('DAN', 'Đồ ăn nhanh', 'pizza.png'),
('DU', 'Đồ uống', 'tra.jpeg'),
('TS', 'Trà sữa', 'ts.jpeg');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hoadon`
--

CREATE TABLE `hoadon` (
  `MaHD` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `Email` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `ThanhTien` int(11) NOT NULL,
  `DanhGia` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `TrangThai` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `khachhang`
--

CREATE TABLE `khachhang` (
  `Email` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `Password` text COLLATE utf8_unicode_ci NOT NULL,
  `fullName` text COLLATE utf8_unicode_ci NOT NULL,
  `DiaChi` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `Phone` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `khachhang`
--

INSERT INTO `khachhang` (`Email`, `Password`, `fullName`, `DiaChi`, `Phone`) VALUES
('abc', '123', 'nguyenvana', '237/3', '0123154651'),
('dtt2000@gmail.com', '2000', 'Adidas', 'Ding Xong', '9924392'),
('dtt2002@gmail.com', '1234', 'Thanh Thien', '340 tdt', '039565031'),
('dtt2003@gmail.com', '123', 'dsdsad', 'sadasd', '526505'),
('Email', 'Password', 'fullName', 'DiaChi', 'Phone'),
('hoangphuc@gmail.com', '123', 'Hoang Phuc', '340tdt', '08881913121'),
('thaodien@gmail.com', '123456', 'Thao Dien', '237/3', '113');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `khachhangdanhgia`
--

CREATE TABLE `khachhangdanhgia` (
  `Email` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `MaSanPham` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `NgayDanhGia` date NOT NULL,
  `SoSao` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sanpham`
--

CREATE TABLE `sanpham` (
  `MaSanPham` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `MaChuDe` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `TenSanPham` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `GiaSanPham` int(11) NOT NULL,
  `HinhSanPham` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `mota` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `sanpham`
--

INSERT INTO `sanpham` (`MaSanPham`, `MaChuDe`, `TenSanPham`, `GiaSanPham`, `HinhSanPham`, `mota`) VALUES
('CF01', 'CF', 'Café đen đá', 20000, 'cfdenda.jpeg', 'Cà phê là một loại thức uống được ủ từ hạt cà phê rang, lấy từ quả của cây cà phê. Các giống cây cà phê được bắt nguồn từ vùng nhiệt đới châu Phi và các vùng Madagascar, Comoros, Mauritius và Réunion trên các khu vực thuộc đường xích đạo.'),
('CF02', 'CF', 'Café sữa đá', 20000, 'cfsuada.png', 'Cà phê là một loại thức uống được ủ từ hạt cà phê rang, lấy từ quả của cây cà phê. Các giống cây cà phê được bắt nguồn từ vùng nhiệt đới châu Phi và các vùng Madagascar, Comoros, Mauritius và Réunion trên các khu vực thuộc đường xích đạo.'),
('CF03', 'CF', 'Café nóng', 20000, 'cfnong.jpeg', 'Cà phê là một loại thức uống được ủ từ hạt cà phê rang, lấy từ quả của cây cà phê. Các giống cây cà phê được bắt nguồn từ vùng nhiệt đới châu Phi và các vùng Madagascar, Comoros, Mauritius và Réunion trên các khu vực thuộc đường xích đạo.'),
('DAN01', 'DAN', 'Hamburger', 30000, 'hamburger.jpeg', 'Hamburger là một loại thức ăn bao gồm bánh mì kẹp thịt xay ở giữa. Miếng thịt có thể được nướng, chiên, hun khói hay nướng trên lửa.'),
('DAN02', 'DAN', 'Gà rán', 20000, 'garan.jpeg', 'Gà rán miền Nam Hoa Kỳ, hay còn gọi là gà rán, là một món ăn xuất xứ từ miền Nam Hoa Kỳ; nguyên liệu chính là những miếng thịt gà đã được lăn bột rồi chiên trên chảo, chiên ngập dầu, chiên áp suất hoặc chiên không dầu.'),
('DAN03', 'DAN', 'Khoai tây chiên', 20000, 'khoaitay.jpeg', 'Khoai tây chiên kiểu Pháp, hay French-fried potatoes là khoai tây chiên giòn cắt thành sợi hoặc hình que.'),
('DAN04', 'DAN', 'Pizza', 40000, 'pizza.png', 'Pizza, Tiếng La tinh thường đọc là Pi-da, là loại bánh dẹt, tròn được chế biến từ bột mì, nấm men... sau khi đã được ủ bột để nghỉ ít nhất 24 tiếng đồng hồ và nhào nặn thành loại bánh có hình dạng tròn và dẹt, và được cho vào lò nướng chín trước khi ăn.'),
('DAN05', 'DAN', 'Hotdog', 25000, 'hotdog.jpeg', 'Hot dog là một loại đồ ăn nhanh của Mỹ. Là bánh mì kẹp xúc xích, thường có thêm mù tạt, nước sốt cà chua, hành, mayonnaise, gia vị có thể có hoặc không có dưa cải Đức.'),
('DU01', 'DU', 'Trà trái cây', 25000, 'tratraicay.jpeg', 'Trà trái cây nhiệt đới được kết hợp giữa vị trà thơm nhẹ cùng nhiều loại trái cây giòn mát, ngọt thanh đem đến một món thức uống giải khát cực kỳ hiệu quả trong mùa hè oi bức.'),
('DU02', 'DU', 'Trà tắc', 20000, 'tratac.jpeg', 'Trà tắc thơm ngon, mát lạnh chua chua ngọt ngọt sẽ là một thức uống giúp gia đình bạn xua tan đi cái nắng nóng oi ả của ngày hè.'),
('DU03', 'DU', 'Nước có ga', 15000, 'nuoccoga.png', 'Nước có ga là nước có chứa khí carbon dioxide hòa tan, được bơm nhân tạo bằng áp lực hoặc xảy ra do quá trình địa chất tự nhiên. Cacbonic bão hòa làm cho các bong bóng nhỏ hình thành, tạo cho nước có các sủi bọt.'),
('DU04', 'DU', 'Trà ổi', 25000, 'traoi.jpeg', 'Trà ổi hỗ trợ giảm cân Orihiro được chiết xuất từ 100% lá ổi tự nhiên chứa polyphenol, carotenoid, flavonoid, tannin, acid psiditanic có khả năng ngăn chặn sự chuyển hóa tinh bột thành đường. Nhờ thế, khi uống trà ổi thường xuyên sẽ hỗ trợ rất tốt cho việ'),
('DU05', 'DU', 'Hồng trà', 20000, 'hongtra.jpeg', 'Hồng trà hay Trà Đen là một loại trà. Thông thường, nó có vị mạnh mẽ hơn so với các loại khác của trà như trà xanh. Nó cũng có nhiều caffeine hơn. Tên gọi hồng trà bắt nguồn từ màu sắc của nước trà, được dùng phổ biến tại các nước Đông Á và một số nơi khá'),
('TS01', 'TS', 'Trà sữa TS', 25000, 'truyenthong.jpeg', 'Trà sữa Đài Loan được nổi tiếng trên toàn thế giới với hương vị đậm đà mà không thể lẫn vào đâu được. Chắc chắn khi đặt chân tới Đài Loan, bạn không thể quên thưởng thức một ly trà sữa đâu nhé!'),
('TS02', 'TS', 'Trà sữa thái xanh', 25000, 'thaixanh.jpeg', 'Trà sữa là một trong những thức uống rất được mọi người ưa chuộng bởi sự hòa quyện giữa vị đắng của trà và vị béo ngọt của sữa. Chính bởi sự yêu thích ấy mà hãy theo chân Điện máy XANH vào bếp để thực hiện ngay 2 cách làm trà thái xanh và trà thái đỏ thơm'),
('TS03', 'TS', 'Trà sữa trân châu', 35000, 'duongden.jpeg', 'Trà sữa trân châu đường đen được yêu thích nhờ sự kết hợp hết sức hoàn hảo giữa vị trà sữa thơm béo và trân châu đường đen mềm, ngọt. Vậy để làm một ly trà sữa trân châu đường đen tại nhà liệu có dễ dàng? Hôm nay, cùng vào bếp học ngay cách làm món trà sữ'),
('TS04', 'TS', 'Trà sữa socolate', 20000, 'socolate.jpeg', 'Trà bá tước hay còn có tên gọi là Earl Grey, đây là một loại trà được kết hợp giữa hương vị trà đen và tinh dầu của vỏ cam Bergamot. Tuy nhiên, có người lại cho rằng trà bá tước chính là hỗn hợp của vị cam đắng từ vùng Địa Trung Hải với vị chanh từ vùng Đ'),
('TS05', 'TS', 'Trà sữa Machiato', 30000, 'machiato.png', 'Trà sữa Machiato Không độ có đường chai 268ml với nguồn nguyên liệu tự nhiên, có vị ngon được kết hợp bởi tinh chất của lá trà xanh Thái Nguyên hòa quyện với vị mát lành của sữa tự nhiên và hương thơm ngậy của kem sữa Macchiato.');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `chitiethoadon`
--
ALTER TABLE `chitiethoadon`
  ADD PRIMARY KEY (`MaHD`,`MaSanPham`),
  ADD KEY `pk_masp` (`MaSanPham`);

--
-- Chỉ mục cho bảng `chudesanpham`
--
ALTER TABLE `chudesanpham`
  ADD PRIMARY KEY (`MaChuDe`);

--
-- Chỉ mục cho bảng `hoadon`
--
ALTER TABLE `hoadon`
  ADD PRIMARY KEY (`MaHD`,`Email`),
  ADD KEY `pk_email` (`Email`);

--
-- Chỉ mục cho bảng `khachhang`
--
ALTER TABLE `khachhang`
  ADD PRIMARY KEY (`Email`) USING BTREE;

--
-- Chỉ mục cho bảng `khachhangdanhgia`
--
ALTER TABLE `khachhangdanhgia`
  ADD PRIMARY KEY (`Email`,`MaSanPham`),
  ADD KEY `pk_masanpham` (`MaSanPham`);

--
-- Chỉ mục cho bảng `sanpham`
--
ALTER TABLE `sanpham`
  ADD PRIMARY KEY (`MaSanPham`,`MaChuDe`),
  ADD KEY `pk_macd` (`MaChuDe`);

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `chitiethoadon`
--
ALTER TABLE `chitiethoadon`
  ADD CONSTRAINT `pk_mahd` FOREIGN KEY (`MaHD`) REFERENCES `hoadon` (`MaHD`),
  ADD CONSTRAINT `pk_masp` FOREIGN KEY (`MaSanPham`) REFERENCES `sanpham` (`MaSanPham`);

--
-- Các ràng buộc cho bảng `hoadon`
--
ALTER TABLE `hoadon`
  ADD CONSTRAINT `pk_email` FOREIGN KEY (`Email`) REFERENCES `khachhang` (`Email`);

--
-- Các ràng buộc cho bảng `khachhangdanhgia`
--
ALTER TABLE `khachhangdanhgia`
  ADD CONSTRAINT `pk_eamil` FOREIGN KEY (`Email`) REFERENCES `khachhang` (`Email`),
  ADD CONSTRAINT `pk_masanpham` FOREIGN KEY (`MaSanPham`) REFERENCES `sanpham` (`MaSanPham`);

--
-- Các ràng buộc cho bảng `sanpham`
--
ALTER TABLE `sanpham`
  ADD CONSTRAINT `pk_macd` FOREIGN KEY (`MaChuDe`) REFERENCES `chudesanpham` (`MaChuDe`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
