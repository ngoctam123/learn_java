 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!doctype html>
<html lang="en">
  <head>
    <title>Title</title>
    <!-- Required meta tags -->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
   <jsp:include page="/WEB-INF/views/admin/fragment/boostrapCss.jsp"></jsp:include>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin.css">
     <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
  <body>

    <main class="container">
      <header  class="row text-center">
          
      </header>
       <jsp:include page="/WEB-INF/views/admin/fragment/nav.jsp"></jsp:include>
      <section  class="row">
       <div class="col  mt-4">
        <form:form action="${pageContext.request.contextPath}/chuyenNhuong/saveOrUpdate" onsubmit="return validate()" modelAttribute="chuyenNhuong"  method="post">
          <div class="card">
            <div class="card-header">
            <c:if test="${isEdit }"><h2>Edit Product</h2></c:if>
            <c:if test="${!isEdit }"><h2>Add Product</h2></c:if>
              
            </div>
            <div class="card-body">
              <div class="row">
                <div class="col">
                  <div class="form-group">
                    <label for="id">Id Chuyển Nhượng: </label>
                    <form:input type="text" class="form-control" path="id" id="id" aria-describedby="id" placeholder="id" readonly="true"  />
                    <small id="id" class="form-text text-muted">Product Id required</small>
                  </div>

                  <div class="form-group">
                    <label for="idCauThu">Tên Cầu Thủ:</label>
                    <form:select class="form-control" path="cauThu.idCauThu" id="idCauThu">
                    	<form:options items="${cauThus }" itemValue="idCauThu" itemLabel="tenCauThu"  />
                    	<%-- <c:forEach items="${categories }" var="category">
                    		 <option ${category.categoryId == product.category.categoryId ? 'selected': '' } value="${category.categoryId }">${category.name }</option>
                    	</c:forEach> --%>
                      
                    </form:select>
                  </div>

                  

                  <div class="form-group">
                    <label for="idCLB">Câu lạc bộ sẽ chuyển đến:</label>
                    <form:select class="form-control" path="cauLacBo.idCLB" id="idCLB" onchange="validate(fasle)">
                    	<form:options items="${cauLacBos }" itemValue="idCLB" itemLabel="tenCLB"  />
                    	<%-- <c:forEach items="${categories }" var="category">
                    		 <option ${category.categoryId == product.category.categoryId ? 'selected': '' } value="${category.categoryId }">${category.name }</option>
                    	</c:forEach> --%>
                      
                    </form:select>
                  </div>


                  <div class="input-group form-group my-2">
                    <span class="input-group-text">Số tiền chuyển nhượng</span>
                    <form:input type="number" path="tienChuyenNhuong" id="tienChuyenNhuong" class="form-control" placeholder="Unit Price"/>
                    <span class="input-group-text">VND</span>
                   </div>

                  <div class="form-group">
                    <label for="thoiGianChuyenNhuong">Thời gian chuyển nhượng:</label>
                    <form:input type="text" class="form-control" path="thoiGianChuyenNhuong"  id="thoiGianChuyenNhuong" aria-describedby="thoiGianChuyenNhuongId" placeholder="thoiGianChuyenNhuong" />
                   	<form:errors class="errors" path="thoiGianChuyenNhuong" />
                    <small id="thoiGianChuyenNhuongId" class="form-text text-muted">thoiGianChuyenNhuong is required</small>
                  </div>
                 
                  
                  
                  
                
                </div>
               
            </div>
            <div class="card-footer text-muted">
              <a href="${pageContext.request.contextPath}/chuyenNhuong/add" class="btn btn-success" >New</a>
              <c:if test="${!isEdit }">
              
              <button class="btn btn-primary" >Save</button>
              </c:if>
               <c:if test="${isEdit }">
              
              <button class="btn btn-primary" >Update</button>
              </c:if>
              <c:if test="${isEdit }">
              <a href="${pageContext.request.contextPath}/admin/products/delete/${product.productId}" class="btn btn-danger float-right" >Delete</a>
              </c:if>
            </div>
           </div>
        </form:form>
       </div>

      </section>
      <footer  class="row"></footer>
  </main>




    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
     <jsp:include page="/WEB-INF/views/admin/fragment/boostrapJs.jsp"></jsp:include>     
     <script src="${pageContext.request.contextPath}/resources/js/validate.js"></script>  
  </body>
</html>