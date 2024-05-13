 create database Quanly_TaiSan
go
use Quanly_TaiSan

go

create table Department
(
DepartmentID nvarchar(50) primary key,
DepartmentName nvarchar(50),
Manager nvarchar(100),
Address nvarchar(100),
Status bit
)
insert into Department values(N'E200',N'Phong Kỹ Thuật 1',N'Bùi Tiến Quân',N'Tầng 1 - Tòa Vinhome - Hà Nội',1)
insert into Department values(N'E201',N'Phòng kĩ thuật 2',N'Lăng Thanh trúc',N'Tầng 1 - Tòa Ecopack- Hà Nội',0)
insert into Department values(N'E202',N'Phòng kĩ thuật 3',N'Quỷ Lệ',N'Tầng 1 - Tòa Vinhome - Hà Nội',1)
select * from Department
create table Location 
(
LocationID nvarchar(50) primary key ,
LocationName nvarchar(150),
City nvarchar(50),
Country nvarchar(50)
)

insert into Location values(N'01',N'Gia Lâm - Hà Nội',N'Hà Nội',N'Việt Nam')
insert into Location values(N'02',N'Hưng Yên - Hà Nội',N'Hà Nội',N'Việt Nam')
insert into Location values(N'03',N'Cầu Giấy - Hà Nội',N'Hà Nội',N'Việt Nam')
select * from Location
create table Asset_List
(
AssetID int identity primary key,
AssetName nvarchar(100) not null,
image varchar(50),
Description nvarchar(100),
DepartmentID nvarchar(50) Foreign Key references Department(DepartmentID),
LocationID  nvarchar(50) Foreign Key references Location(LocationID),
Quantity int,
status bit
)

insert into Asset_List values(N'May Tinh','acer.jpg',N'Ram 16G',N'E200',N'01',10,1)
insert into Asset_List values(N'Xe may - oto','sh150i.jpg',N'Kim Xăng Fi - To Đẹp',N'E201',N'02',10,0)
insert into Asset_List values(N'Đồ Gia Dụng','maygiat.jpg',N'Giặt Sạch Quần áo',N'E202',N'03',10,0)
select * from Asset_List
SELECT 
    Asset_List.AssetID,
    Asset_List.AssetName,
    Asset_List.Description,
    Department.DepartmentName,
    Location.LocationName,
    Asset_List.Quantity
FROM 
    Asset_List
JOIN 
    Department  ON Asset_List.DepartmentID = Department.DepartmentID
JOIN 
    Location  ON Asset_List.LocationID = Location.LocationID;
create table Assets
(
AsetId int identity primary key,
AsetName nvarchar(100),
SerialNumber int,
image varchar(50),
PurchaseDate date,
PurchaseCost float,
Condition bit,
AssetID int  Foreign Key references Asset_List(AssetID)
)
insert into Assets values(N'Acer ryze5',122301,'acer.jpg','2020-09-20',20000000,1,1)
insert into Assets values(N'SH150I',1223211,'sh150i.jpg','2021-09-20',120000000,1,2)
insert into Assets values(N'May Giat',122302,'maygiat.jpg','2022-09-20',30000000,0,3)

select * from Assets
create table Staff
(
StaffID nvarchar(100) primary key,
FirstName nvarchar(100),
LastName nvarchar(100),
DepartmentID nvarchar(50) Foreign Key references Department(DepartmentID)
)
insert into Staff values(N'P01',N'Tùng Mậu',N'Nguyễn',N'E200')
insert into Staff values(N'P02',N'Lý Thanh',N'Nguyễn',N'E201')
insert into Staff values(N'P03',N'Văn Tùng',N'Nguyễn',N'E202')
select * from Staff

create table Handover
(
HandoverID nvarchar(50) primary key,
Borrower nvarchar(100),
AssetID int  Foreign Key references Asset_List(AssetID),
AsetId int foreign key references Assets(AsetId),
PaymentDate date,
ReturnedDate date
)
insert into Handover values(N'PBG1',N'Nguyen van A',1,1,'2022-02-10','2022-05-10')
insert into Handover values(N'PBG2',N'Nguyen van B',2,2,'2022-02-10','2022-05-10')
insert into Handover values(N'PBG3',N'Nguyen van C',3,3,'2022-02-10','2022-05-10')

select * from Handover
create table Pay_Slip
(
 Pay_Slip_Id nvarchar(100) primary key,
 Borrower nvarchar(100),
 AssetID int  Foreign Key references Asset_List(AssetID),
 AsetId int foreign key references Assets(AsetId),
 PaymentDate date,
 Amount int
 )

 insert into Pay_Slip values(N'p1',N'Nguyen van A',1,1,'2022-02-10',10)
 insert into Pay_Slip values(N'p2',N'Nguyen van B',2,2,'2022-02-10',10)
 insert into Pay_Slip values(N'p3',N'Nguyen van C',3,3,'2022-02-10',10)

 select * from Pay_Slip

 go
CREATE TABLE role(
 id int IDENTITY(1,1) NOT NULL primary key,
 name varchar(50) NULL,
)
GO
CREATE TABLE users(
id int IDENTITY(1,1) NOT NULL primary key,
username varchar(45) NULL,
password varchar(200) NULL
)

select * from users
GO
CREATE TABLE users_roles(
 id int IDENTITY(1,1) NOT NULL primary key,
 userId int NULL foreign key references users(id),
 roleId int NULL foreign key references role(id),
)
GO
INSERT role VALUES (N'ROLE_ADMIN')
GO
INSERT role VALUES (N'ROLE_USER')
GO
INSERT users VALUES (N'admin',
N'$2a$12$s8FyYcAauHqILMBcI6x0BepO5JI.9/C16QRYMswF7Avt0rRkOiR0u')
GO
INSERT users VALUES (N'user',
N'$2a$12$s8FyYcAauHqILMBcI6x0BepO5JI.9/C16QRYMswF7Avt0rRkOiR0u')
GO
INSERT users_roles (userId, roleId) VALUES (1, 1)
GO
INSERT users_roles (userId, roleId) VALUES (1, 2)
GO
INSERT users_roles (userId, roleId) VALUES (2, 2)
select * from role