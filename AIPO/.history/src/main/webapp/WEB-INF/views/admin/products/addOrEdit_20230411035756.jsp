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
      <section  class="row">
       <div class="col  mt-4">
        <form action="" method="post">
          <div class="card">
            <div class="card-header">
              <h2>Add New Product</h2>
            </div>
            <div class="card-body">
              <div class="row">
                <div class="col-md-7">
                  <div class="form-group">
                    <label for="productId">Product Id: </label>
                    <input type="text" class="form-control" name="productId" id="productId" aria-describedby="productId" placeholder="productId">
                    <small id="productId" class="form-text text-muted">Product Id required</small>
                  </div>
                  <div class="form-group">
                    <label for="name">Name</label>
                    <input type="text" class="form-control" name="name" id="name" aria-describedby="nameId" placeholder="name">
                    <small id="nameId" class="form-text text-muted">Name is required</small>
                  </div>
                  <div class="form-group">
                    <label for="quantity">Quantity</label>
                    <input type="text" class="form-control" name="quantity" id="quantity" aria-describedby="quantityId" placeholder="quantity">
                    <small id="quantityId" class="form-text text-muted">quantity is required</small>
                  </div>
                  <div class="input-group form-group">
                   <span class="input-group-text">Unit Price</span>
                   <input type="number" name="unitPrice" id="unitPrice" class="form-control" placeholder="Unit Price">
                   <span class="input-group-text">$</span>
                  </div>
                  
                  <div class="form-group">
                    <label for="categoryId">Category</label>
                    <select class="form-control" name="categoryId" id="categoryId">
                      <option>C1</option>
                      <option>C2</option>
                      <option>C3</option>
                    </select>
                  </div>
                
                </div>
                <div class="col-md-3">
                  <img src="./images/hp.jpg" class="img-fluid" alt="">
                  <div class="form-group">
                    <label for="productImage">Image file</label>
                    <input type="file" class="form-control-file" name="productImage" id="productImage" placeholder="productImage" aria-describedby="productImage">
                    <small id="productImage" class="form-text text-muted">productImage Is required</small>
                  </div>
                  <div class="input-group form-group">
                    <span class="input-group-text">Discount</span>
                    <input type="number" name="discount" id="discount" class="form-control" placeholder="discount">
                    <span class="input-group-text">%</span>
                   </div>
                  <div class="form-group">
                    <label for="status">Satus</label>
                    <select class="form-control" name="status" id="status">
                      <option>Out Of Stock</option>
                      <option>On Sale</option>
                      <option>Featured</option>
                      <option>Best Seller</option>
                      <option>Out of Order</option>
                    </select>
                  </div>
                 
                </div>
              </div>
              <div class="row">
                <div class="col">
                  <div class="form-group">
                    <label for="description">Description</label>
                    <textarea class="form-control" name="description" id="description" rows="5"></textarea>
                  </div>
                </div>
              </div>
            </div>
            <div class="card-footer text-muted">
              <button class="btn btn-success" >New</button>
              <button class="btn btn-primary" >Save</button>
              <button class="btn btn-danger float-right" >Delete</button>
            </div>
           </div>
        </form>
       </div>

      </section>
      <footer  class="row"></footer>
  </main>




    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
     <jsp:include page="/WEB-INF/views/admin/fragment/boostrapJs.jsp"></jsp:include>       
  </body>
</html>