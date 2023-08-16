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
         <div class="col-md-6 offset-md-3 mt-4">
            <form:form action="${pageContext.request.contextPath}/admin/categories/saveOrUpdate" modelAttribute="category" method="post">
                <div class="card">
                    <div class="card-header text-center">
                      <h2>Add New Product</h2>
                    </div>
                    <div class="card-body">
                     <div class="form-group">
                       <label for="productId">Product ID:</label>
                       <form:input type="text" class="form-control" path="productId" id="productId" aria-describedby="productId"  placeholder="category id" readonly="true" />
                      	<form:errors class="errors" path="productId" />
                      	
                       <small id="productId" class="form-text text-muted">Product id is required</small>
                     </div>
                     <div class="form-group">
                       <label for="name">Name</label>
                       <form:input type="text" class="form-control" path="name" id="name" aria-describedby="nameId" placeholder="name"/>
                   		  	<form:errors class="errors" path="name" />
                       <small id="nameId" class="form-text text-muted">Name is required</small>
                     </div>

                    </div>
                    <div class="card-footer text-muted">
                      <button class="btn btn-secondary">Reset</button>
                      <a href="${pageContext.request.contextPath}/admin/categories" class="btn btn-success">List category</a>
                      <button class="btn btn-primary"><i class="fa fa-save" aria-hidden="true"></i> 
                      	<c:if test="${!isEdit}">
                      	<span>Save</span>
                      </c:if>
                    	<c:if test="${isEdit}">
                      	<span>Update</span>
                      </c:if> 
                    
                      </button>
                      
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