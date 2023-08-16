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
      <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
      <link rel="stylesheet" href="./css/admin.css">
    </head>

    <body>

      <main class="container">
        <header class="row text-center">

        </header>
        <section class="row">
          <div class="col  mt-4">
            <div class="card">
              <div class="card-header">
                <h2>List of Category</h2>
              </div>
              <div class="card-body">
                <c:if test="${message != null}">
                  <div class="alert alert-primary" role="alert">
                    <i>${message}</i>
                  </div>
                </c:if>
                <table class="table table-striped table-inverse ">
                  <thead class="thead-inverse">
                    <tr>
                      <th>Category Id</th>
                      <th>Name</th>
                      <th></th>
                    </tr>
                  </thead>
                  <tbody>
                    <c:forEach items="${ categories}" var="category" varStatus="loop">
                      <tr>
                        <td scope="row">${category.categoryId}</td>
                        <td>${category.name }</td>
                        <td>
                          <a href="${pageContext.request.contextPath}/admin/categories/view/${category.categoryId}"
                            class="btn btn-outline-info"><i class="fa fa-info" aria-hidden="true"></i></a>
                          <a href="${pageContext.request.contextPath}/admin/categories/edit/${category.categoryId}"
                            class="btn btn-outline-warning"><i class="fa fa-edit" aria-hidden="true"></i></a>
                          <a href="${pageContext.request.contextPath}/admin/categories/delete/${category.categoryId}"
                            class="btn btn-outline-danger"><i class="fa fa-remove" aria-hidden="true"></i></a>
                        </td>
                      </tr>
                    </c:forEach>


                  </tbody>
                </table>
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
      <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
      <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
      <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
    </body>

    </html>