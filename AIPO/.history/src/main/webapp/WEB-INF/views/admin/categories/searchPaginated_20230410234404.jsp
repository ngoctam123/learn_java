<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <!doctype html>
    <html lang="en">
      <head>
        <title>Title</title>
        <!-- Required meta tags -->
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="./css/admin.css">
    </head>
      <body>
    
        <main class="container">
            <header  class="row text-center">
                
            </header>
            <section  class="row">
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
                  <div class="row my-2">
                    <div class="col">
                      <form action="${pageContext.request.contextPath}/admin/categories/searchpaginated">
                        <div class="form-inline float-left">
                          <label for="name">Name:</label>
                          <input type="text" class="form-control" name="name" id="name" aria-describedby="helpId" placeholder="name">
                          <button class="btn btn-outline-primary">Search</button>
                        </div>
  
                      </form>
                      <div>
                        <a href="${pageContext.request.contextPath}/admin/categories/add" class="btn btn-outline-primary float-right">Add new catrgory</a>
                      </div>
                    </div>
                  </div>
                  <c:if test="${!categoryPage.hasContent() }">
                  <div class="row">
                    <div class="col">
                      <div class="alert alert-danger" role="alert">
                        <strong>No Categories Found</strong>
                      </div>
                    </div>
                  </div>
                  </c:if>
                  
                  <table class="table table-striped table-inverse ">
                  <c:if test="${categoryPage.hasContent() }">
                    <thead class="thead-inverse">
                      <tr>
                        <th>Category Id</th>
                        <th>Name</th>
                        <th></th>
                      </tr>
                      </thead>
                      <tbody>
                        <c:forEach items="${ categoryPage.content}" var="category" varStatus="loop">
                         <tr>
                          <td scope="row">${category.categoryId}</td>
                          <td>${category.name }</td>
                          <td>
                            <a href="${pageContext.request.contextPath}/admin/categories/view/${category.categoryId}" class="btn btn-outline-info"><i class="fa fa-info" aria-hidden="true"></i></a>
                            <a href="${pageContext.request.contextPath}/admin/categories/edit/${category.categoryId}" class="btn btn-outline-warning"><i class="fa fa-edit" aria-hidden="true"></i></a>
                            <a href="${pageContext.request.contextPath}/admin/categories/delete/${category.categoryId}" class="btn btn-outline-danger"><i class="fa fa-remove" aria-hidden="true"></i></a>
                          </td>
                        </tr>
                        </c:forEach>
                       
                        
                      </tbody>
                  </c:if>
                    
                   </table>
                </div>
                <div class="card-footer text-muted">
                  <form action="">
                    <div class="form-group">
                      <label for="size">Page size:</label>
                      <select name="size" id="size" class="form-control"
                      onchange="this.form.submit()">

                        <option selected="${categoryPage.size==5 }" value="5">5</option>
                        <option  selected="${categoryPage.size==10 }" value="10">10</option>
                        <option  selected="${categoryPage.size==15 }" value="15">15</option>
                        <option  selected="${categoryPage.size==20 }" value="20">20</option>
                        <option  selected="${categoryPage.size==30 }" value="30">30</option>
                      </select>
                      
                    </div>
                  </form>

                  <nav aria-label="Page navigation">
                  <c:if test="${categoryPage.getTotalPages() > 0 }">
                  	
                  <ul class="pagination justify-content-center">
                      <li class="${1== categoryPage.number + 1 ? 'page-item active' : 'page-item' }">
                        <a href="${pageContext.request.contextPath}/admin/categories/searchpaginated?name=${name}&size=${categoryPage.size}&page=${1}"
                        class="page-link">First</a>
                      </li>
                     
                      	 <c:forEach items="${pageNumbers }" var="pageNumber" >
                      	 <c:if test="${categoryPage.totalPages > 1 }">
                      	 	 <li class="${pageNumber == categoryPage.number + 1 ? 'page-item active' : 'page-item'}">
                      	 	 	  <a href="${pageContext.request.contextPath}/admin/categories/searchpaginated?name=${name}&size=${categoryPage.size}&page=${pageNumber}"
                        class="page-link">${pageNumber}</a>
                      	 	 
                      	 	 </li>
                      	 </c:if>
                      	 </c:forEach>
                      
                     
                      <li class="${categoryPage.totalPages == categoryPage.number + 1 ? 'page-item active' : 'page-item' }">
                        <a href="${pageContext.request.contextPath}/admin/categories/searchpaginated?name=${name}&size=${categoryPage.size}&page=${categoryPage.totalPages}"
                        class="page-link">Last</a>
                      </li>
                    </ul>
                    </c:if>
                    
                  </nav>
                </div>
               </div>
             </div>
    
            </section>
            <footer  class="row"></footer>
        </main>
    
    
    
        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
      </body>
    </html>