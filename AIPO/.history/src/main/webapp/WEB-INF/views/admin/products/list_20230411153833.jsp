<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
      <link rel="stylesheet" href="./css/admin.css">
    </head>

    <body>

      <main class="container">
        <header class="row text-center">

        </header>
        <jsp:include page="/WEB-INF/views/admin/fragment/nav.jsp"></jsp:include>
        <section class="row">
          <div class="col  mt-4">
            <div class="card">
              <div class="card-header">
                <h2>List of Product</h2>
              </div>
              <div class="card-body">
                <c:if test="${message != null}">
                  <div class="alert alert-primary" role="alert">
                    <i>${message}</i>
                  </div>
                </c:if>
                <div>
                  <a href="${pageContext.request.contextPath}/admin/products/add"
                    class="btn btn-outline-primary my-2 float-right">Add new product</a>
                </div>
                <table class="table table-striped table-inverse table-responsive-md">
                  <thead class="thead-inverse">
                    <tr>
                      <th><input type="checkbox" class="form-check-input"></th>
                      <th></th>
                      <th>Name</th>
                      <th>Quantity</th>
                      <th>Unit Price</th>
                      <th>Discount</th>
                      <th>Status</th>
                      <th>Category</th>
                      <th></th>
                    </tr>
                  </thead>
                  <tbody>
                    <c:forEach items="${products }" var="product" varStatus="loop">
                      <tr>
                        <td><input type="checkbox" name="" class="form-check-inline" id=" "></td>
                        <td><img src="./images/asus.jpg" alt="" width="70px" class="img-fluid"></td>
                        <td>${product.name}</td>
                        <td>${product.quantity}</td>
                        <td>${product.unitPrice}</td>
                        <td>${product.discount}</td>
                        <td>${product.status}</td>
                        <td>${product.category.name}</td>
                        <td>
                          <a href="${pageContext.request.contextPath}/admin/products/view/${product.productId}"
                            class="btn btn-outline-info"><i class="fa fa-info" aria-hidden="true"></i></a>
                          <a href="${pageContext.request.contextPath}/admin/products/edit/${product.productId}"
                            class="btn btn-outline-warning"><i class="fa fa-edit" aria-hidden="true"></i></a>
                          <a onclick="showConfirmModalDialog(1, 'asd')" class="btn btn-outline-danger"><i
                              class="fa fa-remove" aria-hidden="true"></i></a>
                          <a href="${pageContext.request.contextPath}/admin/products/delete/${product.productId}"
                            class="btn btn-outline-danger"><i class="fa fa-remove" aria-hidden="true"></i></a>
                        </td>
                      </tr>
                    </c:forEach>


                  </tbody>
                </table>
                <script>
                  const showConfirmModalDialog = (id, name) => {
                    var productName = document.querySelector('#productName');
                    productName.innerText = name;
                    var yesOption = document.querySelector('#yesOption');
                    yesOption.setAttribute('href', '${pageContext.request.contextPath}/admin/products/delete/${product.productId}')
                    var confirmationId = document.querySelector('#confirmationId')
                    confirmationId.modal = 'show';
                  }
                </script>

                <!-- Modal -->
                <div class="modal fade" id="confirmationId" tabindex="-1" aria-labelledby="exampleModalLabel"
                  aria-hidden="true">
                  <div class="modal-dialog">
                    <div class="modal-content">
                      <div class="modal-header">
                        <h1 class="modal-title fs-5" id="exampleModalLabel">Confirmation</h1>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                      </div>
                      <div class="modal-body">
                        Do you want to delete "<span id="productName"></span>"?"
                      </div>
                      <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                        <button type="button" class="btn btn-primary">Save changes</button>
                      </div>
                    </div>
                  </div>
                </div>

              </div>
              <div class="card-footer text-muted">
                <nav aria-label="Page navigation">
                  <ul class="pagination justify-content-center">
                    <li class="page-item disabled">
                      <a class="page-link" href="#" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                        <span class="sr-only">Previous</span>
                      </a>
                    </li>
                    <li class="page-item active"><a class="page-link" href="#">1</a></li>
                    <li class="page-item"><a class="page-link" href="#">2</a></li>
                    <li class="page-item">
                      <a class="page-link" href="#" aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                        <span class="sr-only">Next</span>
                      </a>
                    </li>
                  </ul>
                </nav>
              </div>
            </div>
          </div>

        </section>
        <footer class="row"></footer>
      </main>



      <!-- Optional JavaScript -->
      <!-- jQuery first, then Popper.js, then Bootstrap JS -->
      <jsp:include page="/WEB-INF/views/admin/fragment/boostrapJs.jsp"></jsp:include>
    </body>

    </html>