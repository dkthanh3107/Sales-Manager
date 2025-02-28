USE [master]
GO
/****** Object:  Database [BanHang]    Script Date: 7/31/2023 5:09:30 AM ******/
CREATE DATABASE [BanHang]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'BanHang', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER4\MSSQL\DATA\BanHang.mdf' , SIZE = 4096KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'BanHang_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER4\MSSQL\DATA\BanHang_log.ldf' , SIZE = 2304KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [BanHang] SET COMPATIBILITY_LEVEL = 110
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [BanHang].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [BanHang] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [BanHang] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [BanHang] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [BanHang] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [BanHang] SET ARITHABORT OFF 
GO
ALTER DATABASE [BanHang] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [BanHang] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [BanHang] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [BanHang] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [BanHang] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [BanHang] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [BanHang] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [BanHang] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [BanHang] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [BanHang] SET  DISABLE_BROKER 
GO
ALTER DATABASE [BanHang] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [BanHang] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [BanHang] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [BanHang] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [BanHang] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [BanHang] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [BanHang] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [BanHang] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [BanHang] SET  MULTI_USER 
GO
ALTER DATABASE [BanHang] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [BanHang] SET DB_CHAINING OFF 
GO
ALTER DATABASE [BanHang] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [BanHang] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [BanHang] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [BanHang] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'BanHang', N'ON'
GO
ALTER DATABASE [BanHang] SET QUERY_STORE = OFF
GO
USE [BanHang]
GO
/****** Object:  Table [dbo].[HoaDon]    Script Date: 7/31/2023 5:09:30 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDon](
	[MaHoaDon] [varchar](10) NOT NULL,
	[MaNV] [varchar](10) NOT NULL,
	[NgayBan] [date] NOT NULL,
	[MaKhach] [varchar](10) NOT NULL,
	[TongTien] [float] NOT NULL,
	[GhiChu] [nvarchar](100) NULL,
 CONSTRAINT [PK_HoaDon] PRIMARY KEY CLUSTERED 
(
	[MaHoaDon] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HoaDonChiTiet]    Script Date: 7/31/2023 5:09:30 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDonChiTiet](
	[MaHoaDonCT] [int] IDENTITY(1,1) NOT NULL,
	[MaHoaDon] [varchar](10) NOT NULL,
	[MaSP] [varchar](10) NOT NULL,
	[SoLuong] [int] NOT NULL,
	[TongTien] [float] NULL,
	[GhiChu] [nvarchar](100) NULL,
 CONSTRAINT [PK_HoaDonChiTiet] PRIMARY KEY CLUSTERED 
(
	[MaHoaDonCT] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 7/31/2023 5:09:30 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhachHang](
	[MaKhach] [varchar](10) NOT NULL,
	[TenKhach] [nvarchar](50) NULL,
	[sdt] [varchar](10) NULL,
	[DiaChi] [nvarchar](50) NULL,
 CONSTRAINT [PK_KhachHang] PRIMARY KEY CLUSTERED 
(
	[MaKhach] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[LoaiSanPham]    Script Date: 7/31/2023 5:09:30 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LoaiSanPham](
	[MaLoai] [varchar](10) NOT NULL,
	[TenLoai] [nvarchar](50) NULL,
 CONSTRAINT [PK_LoaiSanPham] PRIMARY KEY CLUSTERED 
(
	[MaLoai] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 7/31/2023 5:09:30 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhanVien](
	[MaNV] [varchar](10) NOT NULL,
	[TenNV] [nvarchar](50) NOT NULL,
	[MatKhau] [varchar](50) NOT NULL,
	[NgaySinh] [date] NULL,
	[DiaChi] [nvarchar](100) NULL,
	[GioiTinh] [bit] NULL,
	[sdt] [varchar](10) NULL,
	[VaiTro] [bit] NOT NULL,
	[Hinh] [nvarchar](50) NULL,
 CONSTRAINT [PK_NhanVien] PRIMARY KEY CLUSTERED 
(
	[MaNV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhaPhanPhoi]    Script Date: 7/31/2023 5:09:30 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhaPhanPhoi](
	[MaNhaPhanPhoi] [varchar](10) NOT NULL,
	[TenNPP] [nvarchar](100) NOT NULL,
	[sdt] [varchar](10) NOT NULL,
	[email] [nvarchar](50) NOT NULL,
	[DiaChi] [nvarchar](100) NOT NULL,
	[GhiChu] [nvarchar](50) NULL,
 CONSTRAINT [PK_NhaPhanPhoi] PRIMARY KEY CLUSTERED 
(
	[MaNhaPhanPhoi] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PhieuNhap]    Script Date: 7/31/2023 5:09:30 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PhieuNhap](
	[MaPN] [varchar](10) NOT NULL,
	[MaNV] [varchar](10) NOT NULL,
	[MaNhaPhanPhoi] [varchar](10) NOT NULL,
	[TongTien] [float] NOT NULL,
	[NgayNhap] [date] NOT NULL,
	[NghiChu] [varchar](150) NULL,
 CONSTRAINT [PK_PhieuNhap] PRIMARY KEY CLUSTERED 
(
	[MaPN] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PhieuNhapCT]    Script Date: 7/31/2023 5:09:30 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PhieuNhapCT](
	[MaCTPN] [int] IDENTITY(1,1) NOT NULL,
	[MaPN] [varchar](10) NOT NULL,
	[MaSP] [varchar](10) NOT NULL,
	[SoLuong] [int] NOT NULL,
	[DonGia] [float] NOT NULL,
	[TongTien] [float] NOT NULL,
	[ChuThich] [nvarchar](150) NULL,
 CONSTRAINT [PK_PhieuNhapCT] PRIMARY KEY CLUSTERED 
(
	[MaCTPN] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SanPham]    Script Date: 7/31/2023 5:09:30 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SanPham](
	[MaSP] [varchar](10) NOT NULL,
	[TenSP] [nvarchar](100) NULL,
	[SoLuong] [int] NOT NULL,
	[GiaNhap] [float] NOT NULL,
	[GiaBan] [float] NOT NULL,
	[Anh] [nvarchar](50) NULL,
	[GhiChu] [nvarchar](150) NULL,
	[LoaiSP] [varchar](10) NOT NULL,
 CONSTRAINT [PK_SanPham] PRIMARY KEY CLUSTERED 
(
	[MaSP] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaNV], [NgayBan], [MaKhach], [TongTien], [GhiChu]) VALUES (N'PX001', N'PhuongLP', CAST(N'2023-07-31' AS Date), N'KH002', 40000, N'')
GO
SET IDENTITY_INSERT [dbo].[HoaDonChiTiet] ON 

INSERT [dbo].[HoaDonChiTiet] ([MaHoaDonCT], [MaHoaDon], [MaSP], [SoLuong], [TongTien], [GhiChu]) VALUES (1048, N'PX001', N'1', 2, 40000, N'')
SET IDENTITY_INSERT [dbo].[HoaDonChiTiet] OFF
GO
INSERT [dbo].[KhachHang] ([MaKhach], [TenKhach], [sdt], [DiaChi]) VALUES (N'KH001', N'Lê Phước Lâm Phương', N'076483473', N'Quảng Trị')
INSERT [dbo].[KhachHang] ([MaKhach], [TenKhach], [sdt], [DiaChi]) VALUES (N'KH002', N'Hoàng Hồng Quân', N'077585823', N'KonTum')
INSERT [dbo].[KhachHang] ([MaKhach], [TenKhach], [sdt], [DiaChi]) VALUES (N'KH003', N'Bùi Quan Trường ', N'08313718', N'Gia Lai')
INSERT [dbo].[KhachHang] ([MaKhach], [TenKhach], [sdt], [DiaChi]) VALUES (N'KH004', N'Huyền', N'09876543', N'Sài Gòn')
GO
INSERT [dbo].[LoaiSanPham] ([MaLoai], [TenLoai]) VALUES (N'1', N'Truyện tranh')
GO
INSERT [dbo].[NhanVien] ([MaNV], [TenNV], [MatKhau], [NgaySinh], [DiaChi], [GioiTinh], [sdt], [VaiTro], [Hinh]) VALUES (N'PhuongLP', N'Lê Phước Lâm Phương', N'1', CAST(N'2000-04-20' AS Date), N'Quảng Chị', 0, N'076473884', 0, N'tranh-dan-tuong-cho-be-doremon-1-214.jpg')
INSERT [dbo].[NhanVien] ([MaNV], [TenNV], [MatKhau], [NgaySinh], [DiaChi], [GioiTinh], [sdt], [VaiTro], [Hinh]) VALUES (N'ThanhND', N'Thành Nguyễn', N'1', CAST(N'2000-10-31' AS Date), N'Quảng Nôm', 1, N'085364753', 1, N'tranh-dan-tuong-cho-be-doremon-1-214.jpg')
GO
INSERT [dbo].[NhaPhanPhoi] ([MaNhaPhanPhoi], [TenNPP], [sdt], [email], [DiaChi], [GhiChu]) VALUES (N'GB01', N'Gigabyte HCM', N'0758446323', N'gigabyteHCM@gmail.com', N'Quận 1, TP Hồ Chí Minh', NULL)
GO
INSERT [dbo].[PhieuNhap] ([MaPN], [MaNV], [MaNhaPhanPhoi], [TongTien], [NgayNhap], [NghiChu]) VALUES (N'PN001', N'PhuongLP', N'GB01', 1000000, CAST(N'2023-07-31' AS Date), N'')
GO
SET IDENTITY_INSERT [dbo].[PhieuNhapCT] ON 

INSERT [dbo].[PhieuNhapCT] ([MaCTPN], [MaPN], [MaSP], [SoLuong], [DonGia], [TongTien], [ChuThich]) VALUES (1018, N'PN001', N'1', 50, 20000, 1000000, N'ko co')
SET IDENTITY_INSERT [dbo].[PhieuNhapCT] OFF
GO
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [SoLuong], [GiaNhap], [GiaBan], [Anh], [GhiChu], [LoaiSP]) VALUES (N'1', N'Doremon', 48, 10000, 20000, N'tranh-dan-tuong-cho-be-doremon-1-214.jpg', N'ko co', N'1')
GO
ALTER TABLE [dbo].[PhieuNhap] ADD  CONSTRAINT [DF_PhieuNhap_TongTien]  DEFAULT ((0)) FOR [TongTien]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_KhachHang] FOREIGN KEY([MaKhach])
REFERENCES [dbo].[KhachHang] ([MaKhach])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_KhachHang]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_NhanVien] FOREIGN KEY([MaNV])
REFERENCES [dbo].[NhanVien] ([MaNV])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_NhanVien]
GO
ALTER TABLE [dbo].[HoaDonChiTiet]  WITH CHECK ADD  CONSTRAINT [FK_HoaDonChiTiet_HoaDon] FOREIGN KEY([MaHoaDon])
REFERENCES [dbo].[HoaDon] ([MaHoaDon])
GO
ALTER TABLE [dbo].[HoaDonChiTiet] CHECK CONSTRAINT [FK_HoaDonChiTiet_HoaDon]
GO
ALTER TABLE [dbo].[HoaDonChiTiet]  WITH CHECK ADD  CONSTRAINT [FK_HoaDonChiTiet_SanPham] FOREIGN KEY([MaSP])
REFERENCES [dbo].[SanPham] ([MaSP])
GO
ALTER TABLE [dbo].[HoaDonChiTiet] CHECK CONSTRAINT [FK_HoaDonChiTiet_SanPham]
GO
ALTER TABLE [dbo].[PhieuNhap]  WITH CHECK ADD  CONSTRAINT [FK_PhieuNhap_NhanVien] FOREIGN KEY([MaNV])
REFERENCES [dbo].[NhanVien] ([MaNV])
GO
ALTER TABLE [dbo].[PhieuNhap] CHECK CONSTRAINT [FK_PhieuNhap_NhanVien]
GO
ALTER TABLE [dbo].[PhieuNhap]  WITH CHECK ADD  CONSTRAINT [FK_PhieuNhap_NhaPhanPhoi] FOREIGN KEY([MaNhaPhanPhoi])
REFERENCES [dbo].[NhaPhanPhoi] ([MaNhaPhanPhoi])
GO
ALTER TABLE [dbo].[PhieuNhap] CHECK CONSTRAINT [FK_PhieuNhap_NhaPhanPhoi]
GO
ALTER TABLE [dbo].[PhieuNhapCT]  WITH CHECK ADD  CONSTRAINT [FK_PhieuNhapCT_PhieuNhap] FOREIGN KEY([MaPN])
REFERENCES [dbo].[PhieuNhap] ([MaPN])
GO
ALTER TABLE [dbo].[PhieuNhapCT] CHECK CONSTRAINT [FK_PhieuNhapCT_PhieuNhap]
GO
ALTER TABLE [dbo].[PhieuNhapCT]  WITH CHECK ADD  CONSTRAINT [FK_PhieuNhapCT_SanPham] FOREIGN KEY([MaSP])
REFERENCES [dbo].[SanPham] ([MaSP])
GO
ALTER TABLE [dbo].[PhieuNhapCT] CHECK CONSTRAINT [FK_PhieuNhapCT_SanPham]
GO
ALTER TABLE [dbo].[SanPham]  WITH CHECK ADD  CONSTRAINT [FK_SanPham_LoaiSanPham] FOREIGN KEY([LoaiSP])
REFERENCES [dbo].[LoaiSanPham] ([MaLoai])
GO
ALTER TABLE [dbo].[SanPham] CHECK CONSTRAINT [FK_SanPham_LoaiSanPham]
GO
/****** Object:  StoredProcedure [dbo].[sp_ThongkeDoanhThu]    Script Date: 7/31/2023 5:09:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

create proc [dbo].[sp_ThongkeDoanhThu](@startDate date, @endDate date)
as begin
		select 
			HoaDonChiTiet.MaHoaDonCT MaHoaDonCT, 
			HoaDon.MaHoaDon MaHoaDon,
			SanPham.TenSP TenSP,
			HoaDonChiTiet.SoLuong SoLuong,
			HoaDon.NgayBan NgayBan,
			HoaDonChiTiet.TongTien TongTien
			
			from HoaDon inner join HoaDonChiTiet on HoaDon.MaHoaDon=HoaDonChiTiet.MaHoaDon
			inner join SanPham on HoaDonChiTiet.MaSP= SanPham.MaSP
			where convert(date,convert(varchar,HoaDon.NgayBan,5),5) between @startDate  and @endDate
	end

GO
/****** Object:  StoredProcedure [dbo].[sp_ThongkeDoanhThu1]    Script Date: 7/31/2023 5:09:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO


create proc [dbo].[sp_ThongkeDoanhThu1](@startDate date, @endDate date)
as begin
		select 
			HoaDonChiTiet.MaHoaDonCT MaHoaDonCT, 
			HoaDon.MaHoaDon MaHoaDon,
			SanPham.TenSP TenSP,
			HoaDonChiTiet.SoLuong SoLuong,
			HoaDon.NgayBan NgayBan,
			HoaDonChiTiet.TongTien TongTien
			
			from HoaDon inner join HoaDonChiTiet on HoaDon.MaHoaDon=HoaDonChiTiet.MaHoaDon
			inner join SanPham on HoaDonChiTiet.MaSP= SanPham.MaSP
			where HoaDon.NgayBan between @startDate  and @endDate
	end


GO
/****** Object:  StoredProcedure [dbo].[sp_TongTien]    Script Date: 7/31/2023 5:09:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[sp_TongTien](@start date)
	as 
	begin
		select sum(TongTien) as 'TongTien'
		from HoaDon where  NgayBan >= @start 
	end
GO
/****** Object:  StoredProcedure [dbo].[ThongKeSP]    Script Date: 7/31/2023 5:09:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

create proc [dbo].[ThongKeSP](@starDate date, @endDate date)
as
	begin
		select HoaDonChiTiet.MaSP as 'MaSP', SanPham.TenSP as'TenSP',count(HoaDonChiTiet.SoLuong) as'TongLuongBan'
from SanPham inner join HoaDonChiTiet on SanPham.MaSP=HoaDonChiTiet.MaSP 
inner join HoaDon on HoaDonChiTiet.MaHoaDon=HoaDon.MaHoaDon
where HoaDon.NgayBan between @starDate and @endDate
group by HoaDonChiTiet.MaSP,SanPham.TenSP 
order by COUNT(HoaDonChiTiet.MaSP) desc
	end


GO
/****** Object:  Trigger [dbo].[tgr_updateDonHang_updateKho]    Script Date: 7/31/2023 5:09:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create trigger [dbo].[tgr_updateDonHang_updateKho] on [dbo].[HoaDonChiTiet] after update as
begin
	update SanPham
	set SoLuong = SanPham.SoLuong - 
	(select SoLuong from inserted where MaSP=SanPham.MaSP)+
	(select SoLuong from deleted where MaSP = SanPham.MaSP)
	from SanPham join deleted on SanPham.MaSP=deleted.MaSP
end
GO
ALTER TABLE [dbo].[HoaDonChiTiet] ENABLE TRIGGER [tgr_updateDonHang_updateKho]
GO
/****** Object:  Trigger [dbo].[trg_DatHang]    Script Date: 7/31/2023 5:09:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create trigger [dbo].[trg_DatHang] on [dbo].[HoaDonChiTiet] AFTER INSERT AS
Begin
	update SanPham
	set SoLuong = SanPham.SoLuong -(select SoLuong from inserted where MaSP = SanPham.MaSP)
	from SanPham
	join inserted on SanPham.MaSP = inserted.MaSP
end
GO
ALTER TABLE [dbo].[HoaDonChiTiet] ENABLE TRIGGER [trg_DatHang]
GO
/****** Object:  Trigger [dbo].[xoaHoaDon_updateKho]    Script Date: 7/31/2023 5:09:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create trigger [dbo].[xoaHoaDon_updateKho] on [dbo].[HoaDonChiTiet] for delete as
begin
	update SanPham
	set SoLuong = SanPham.SoLuong +(select SoLuong from deleted where MaSP = SanPham.MaSP)
	from SanPham
	join deleted on SanPham.MaSP = deleted.MaSP
end
GO
ALTER TABLE [dbo].[HoaDonChiTiet] ENABLE TRIGGER [xoaHoaDon_updateKho]
GO
/****** Object:  Trigger [dbo].[tgr_NhapHang_capnhapSP]    Script Date: 7/31/2023 5:09:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create trigger [dbo].[tgr_NhapHang_capnhapSP] on [dbo].[PhieuNhapCT] after insert as
 begin
		update SanPham
		set SoLuong = SanPham.SoLuong + (select SoLuong from inserted where MaSP = SanPham.MaSP)
		from SanPham join inserted on SanPham.MaSP=inserted.MaSP
 end
GO
ALTER TABLE [dbo].[PhieuNhapCT] ENABLE TRIGGER [tgr_NhapHang_capnhapSP]
GO
/****** Object:  Trigger [dbo].[tgr_SuaPhieu_CapNhapKho]    Script Date: 7/31/2023 5:09:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
 create trigger [dbo].[tgr_SuaPhieu_CapNhapKho] on [dbo].[PhieuNhapCT] for update as 
 begin	
	update SanPham
	set SoLuong = SanPham.SoLuong + 
	(select SoLuong from inserted where MaSP=SanPham.MaSP)-
	(select SoLuong from deleted where MaSP = SanPham.MaSP)
	from SanPham join deleted on SanPham.MaSP=deleted.MaSP
end
GO
ALTER TABLE [dbo].[PhieuNhapCT] ENABLE TRIGGER [tgr_SuaPhieu_CapNhapKho]
GO
USE [master]
GO
ALTER DATABASE [BanHang] SET  READ_WRITE 
GO
