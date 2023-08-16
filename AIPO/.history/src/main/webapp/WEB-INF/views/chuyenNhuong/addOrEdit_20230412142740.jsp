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
        <form:form action="${pageContext.request.contextPath}/chuyenNhuong/saveOrUpdate" modelAttribute="chuyenNhuong"  method="post">
          <div class="card">
            <div class="card-header">
            <c:if test="${isEdit }"><h2>Edit Product</h2></c:if>
            <c:if test="${!isEdit }"><h2>Add Product</h2></c:if>
              
            </div>
            <div class="card-body">
              <div class="row">
                <div class="col-md-7">
                  <div class="form-group">
                    <label for="id">Id Chuyển Nhượng: </label>
                    <form:input type="text" class="form-control" path="id" id="id" aria-describedby="id" placeholder="id" />
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
                    <form:select class="form-control" path="cauLacBo.idCLB" id="idCLB">
                    	<form:options items="${cauLacBos }" itemValue="idCLB" itemLabel="tenCLB"  />
                    	<%-- <c:forEach items="${categories }" var="category">
                    		 <option ${category.categoryId == product.category.categoryId ? 'selected': '' } value="${category.categoryId }">${category.name }</option>
                    	</c:forEach> --%>
                      
                    </form:select>
                  </div>

                  <div class="form-group">
                    <label for="name">Name</label>
                    <form:input type="text" class="form-control" path="name"  id="name" aria-describedby="nameId" placeholder="name" />
                   	<form:errors class="errors" path="name" />
                    <small id="nameId" class="form-text text-muted">Name is required</small>
                  </div>
                  <div class="form-group">
                    <label for="quantity">Quantity</label>
                    <form:input type="text" class="form-control" path="quantity" id="quantity" aria-describedby="quantityId" placeholder="quantity"/>
                    <small id="quantityId" class="form-text text-muted">quantity is required</small>
                  </div>
                  <div class="input-group form-group">
                   <span class="input-group-text">Unit Price</span>
                   <form:input type="number" path="unitPrice" id="unitPrice" class="form-control" placeholder="Unit Price"/>
                   <span class="input-group-text">$</span>
                  </div>
                  
                  
                
                </div>
                <div class="col-md-3">
                  <img id="image" src="./images/hp.jpg" class="img-fluid" alt="">
                  <div class="form-group">
                    <label for="image">Image file</label>
                    <form:input type="file" class="form-control-file" path="image" id="image" placeholder="productImage" aria-describedby="productImage"/>
                    <small id="image" class="form-text text-muted">productImage Is required</small>
                  </div>
                  <div class="input-group form-group">
                    <span class="input-group-text">Discount</span>
                    <form:input type="number" path="discount" id="discount" class="form-control" placeholder="discount"/>
                    <span class="input-group-text">%</span>
                   </div>
                  <div class="form-group">
                    <label for="status">Satus</label>
                    <form:select class="form-control" path="status" id="status">
                      <form:option value="0">Out Of Stock</form:option>
                      <form:option value="1">On Sale</form:option>
                      <form:option value="2">Featured</form:option>
                      <form:option value="3">Best Seller</form:option>
                      <form:option value="4">Out of Order</form:option>
                    </form:select>
                  </div>
                 
                </div>
              </div>
              <div class="row">
                <div class="col">
                  <div class="form-group">
                    <label for="description">Description</label>
                    <form:textarea class="form-control" path="description" id="description" rows="5"></form:textarea>
                  </div>
                </div>
              </div>
            </div>
            <div class="card-footer text-muted">
              <a href="${pageContext.request.contextPath}/admin/products/add" class="btn btn-success" >New</a>
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
  </body>
</html>