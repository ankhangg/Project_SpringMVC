create database DXC_Website
go

use DXC_Website
go

create table Account (
  User_Name varchar(20) NOT NULL PRIMARY KEY,
  Password  varchar(20) NOT NULL,
  Active bit NOT NULL,
  User_Role varchar(20) NOT NULL,
  Password2 varchar(20) NOT NULL,
);
go

create table Item (
  id bigint NOT NULL PRIMARY KEY,
  nameitem NVARCHAR(255) NULL,
  thumbnail image NULL,
  shortdescription NVARCHAR(500) NULL,
  price bigint NULL,
  createddate date NULL,
  modifieddate date NULL,
  createdby NVARCHAR(255) NULL,
  modifiedby NVARCHAR(255) NULL,
  amountitem int NULL
);
go

create table Customer(
   idcustomer bigint NOT NULL IDENTITY(1,1) PRIMARY KEY,
   customername nvarchar(100) NULL,
   customeraddress nvarchar(100) NULL,
  customerphone char(11) NULL,
    User_Name varchar(20) NULL
);
go

create table Orderr (
   id_order bigint NOT NULL PRIMARY KEY,
   amount bigint NULL,
   order_date datetime NULL,
   order_number bigint NOT NULL,
   id_customer bigint NULL
);
go

create table Order_Detail (
   id_orderdetail bigint NOT NULL PRIMARY KEY,
   total bigint NULL,
   price bigint NULL,
   quanity int NULL,
   item_id bigint NULL,
    id_order bigint NOT NULL
);
go