<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách khách hàng</title>
</head>
<body>
    <h1>Danh sách khách hàng</h1>
    <table>
        <thead>
            <tr>
                <th>Mã KH</th>
                <th>Tên KH</th>
                <th>Địa chỉ</th>
                <th>Số ĐT</th>
                <th>Địa chỉ email</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="khachHang" items="${khachHangList}">
                <tr>
                    <td>${khachHang.maKH}</td>
                    <td>${khachHang.tenKH}</td>
                    <td>${khachHang.diaChi}</td>
                    <td>${khachHang.soDT}</td>
                    <td>${khachHang.diaChiEmail}</td>
                    <td>
                        <a href="khachhang-detail?maKH=${khachHang.maKH}">Chi tiết</a>
                        <a href="khachhang-update?maKH=${khachHang.maKH}">Sửa</a>
                        <a href="khachhang-delete?maKH=${khachHang.maKH}">Xóa</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <br>
    <a href="khachhang-add">Thêm khách hàng mới</a>
</body>
</html>