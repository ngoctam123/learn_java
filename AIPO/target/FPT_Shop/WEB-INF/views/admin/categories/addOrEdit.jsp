<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!doctype html>
<html lang="en">
  <head>
    <title>Title</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
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
         <div class="col-md-6 offset-md-3 mt-4">
            <form action="${pageContext.request.contextPath}/admin/categories/saveOrUpdate" method="post">
                <div class="card">
                    <div class="card-header text-center">
                      <h2>Add New Category</h2>
                    </div>
                    <div class="card-body">
                     <div class="form-group">
                       <label for="categoryId">Category ID:</label>
                       <input type="text" class="form-control" name="categoryId" id="categoryId" aria-describedby="categoryId" value="${category.categoryId }" placeholder="category id">
                       <small id="categoryId" class="form-text text-muted">Category id is required</small>
                     </div>
                     <div class="form-group">
                       <label for="name">Name</label>
                       <input type="text" class="form-control" name="name" id="name" aria-describedby="nameId" value="${category.name }" placeholder="name">
                       <small id="nameId" class="form-text text-muted">Name is required</small>
                     </div>

                    </div>
                    <div class="card-footer text-muted">
                      <button class="btn btn-secondary">Reset</button>
                      <a href="${pageContext.request.contextPath}/admin/categories" class="btn btn-success">List category</a>
                      <button class="btn btn-primary"><i class="fa fa-save" aria-hidden="true"></i> Save</button>
                    </div>
                </div>
            </form>
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