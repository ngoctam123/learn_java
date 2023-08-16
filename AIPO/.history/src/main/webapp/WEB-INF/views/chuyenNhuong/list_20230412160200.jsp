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
                <h2>List of chuyen nhuong</h2>
              </div>
              <div class="card-body">
                <c:if test="${message != null}">
                  <div class="alert alert-primary" role="alert">
                    <i>${message}</i>
                  </div>
                </c:if>
                <div>
                  <a href="${pageContext.request.contextPath}/chuyenNhuong/add"
                    class="btn btn-outline-primary my-2 float-right">Add new Chuyển nhượng</a>
                </div>
                <table class="table table-striped table-inverse table-responsive-md">
                  <thead class="thead-inverse">
                    <tr>
                      <th><input type="checkbox" class="form-check-input"></th>
                      <th>Id</th>
                      <th>Tên Cầu Thủ</th>
                      <th>Ngày sính</th>
                      <th>Câu Lạc Bộ Chuyển Nhượng</th>
                      <th>Thời gian chuyển nhượng</th>
                      
                      <th></th>
                    </tr>
                  </thead>
                  <tbody>
                    <c:forEach items="${chuyenNhuongs }" var="chuyenNhuong" varStatus="loop">
                      <tr>
                        <td><input type="checkbox" name="" class="form-check-inline" id=" "></td>
                        <td>${chuyenNhuong.id}</td>
                        <td>${chuyenNhuong.cauThu.tenCauThu}</td>
                        <td>${chuyenNhuong.cauLacBo.tenCLB}</td>
                        <td>${chuyenNhuong.thoiGianChuyenNhuong}</td>

                        
                        <td>
                          <a href="${pageContext.request.contextPath}/admin/products/view/${product.productId}"
                            class="btn btn-outline-info"><i class="fa fa-info" aria-hidden="true"></i></a>
                          <a href="${pageContext.request.contextPath}/chuyenNhuong/edit/${chuyenNhuong.id}"
                            class="btn btn-outline-warning"><i class="fa fa-edit" aria-hidden="true"></i></a>
                          <a onclick="showConfirmModalDialog(${chuyenNhuong.id}, '${chuyenNhuong.cauThu.tenCauThu}')" data-bs-toggle="modal" data-bs-target="#confirmationId"class="btn btn-outline-danger"><i
                              class="fa fa-remove" aria-hidden="true"></i></a>
                          <!-- <a href="${pageContext.request.contextPath}/admin/products/delete/${product.productId}"
                            class="btn btn-outline-danger"><i class="fa fa-remove" aria-hidden="true"></i></a> -->
                        </td>
                      </tr>
                    </c:forEach>


                  </tbody>
                </table>
                <script>
                  const showConfirmModalDialog = (id, name) => {
                    var productName = document.querySelector('#productName');
                    productName.textContent = name;
                    var yesOption = document.querySelector('#yesOption');
                    yesOption.setAttribute('href', `${pageContext.request.contextPath}/chuyenNhuong/delete/`+id)
                    // var confirmationId = document.querySelector('#confirmationId')
                    // confirmationId.className = 'show';
                    // confirmationId.display = 'block';
                  }
                </script>

                <!-- Modal -->
                <!-- Modal trigger button -->


                <!-- Modal Body -->
                <!-- if you want to close by clicking outside the modal, delete the last endpoint:data-bs-backdrop and data-bs-keyboard -->
                <div class="modal fade" id="confirmationId" tabindex="-11" data-bs-backdrop="static"
                  data-bs-keyboard="false" role="dialog" aria-labelledby="modalTitleId" aria-hidden="true">
                  <div class="modal-dialog modal-dialog-scrollable modal-dialog-centered modal-sm" role="document">
                    <div class="modal-content">
                      <div class="modal-header">
                        <h5 class="modal-title" id="modalTitleId">Confirmation</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                      </div>
                      <div class="modal-body">
                        Do you want to delete "<span id="productName"></span>"?"
                      </div>
                      <div class="modal-footer">
                        <a id="yesOption" type="button" class="btn btn-danger">Yes</a>
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">No</button>
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