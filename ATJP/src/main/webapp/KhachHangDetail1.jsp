<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chi tiết khách hàng</title>
<link rel="stylesheet" href="css.css">
</head>
<body>
    <h1>Chi tiết khách hàng</h1>
    <table>
        <tr>
            <td>Mã KH:</td>
            <td>${khachHang.maKH}</td>
        </tr>
        <tr>
            <td>Tên KH:</td>
            <td>${khachHang.tenKH}</td>
        </tr>
        <tr>
            <td>Địa chỉ:</td>
            <td>${khachHang.diaChi}</td>
        </tr>
        <tr>
            <td>Số ĐT:</td>
            <td>${khachHang.soDT}</td>
        </tr>
        <tr>
            <td>Địa chỉ email:</td>
            <td>${khachHang.diaChiEmail}</td>
        </tr>
    </table>
    <br>
    <a href="khachhang-update?maKH=${khachHang.maKH}">Sửa thông tin khách hàng</a>
</body>
</html>