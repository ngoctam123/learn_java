<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!doctype html>
<html lang="en">

<head>
    <title>Title</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.1.1/css/all.css"
        integrity="sha384-O8whS3fhG2OnA5Kas0Y9l3cfpmYjapjI0E4theH4iuMD+pLhbf6JI0jIMfYcK3yZ" crossorigin="anonymous">
</head>

<body class="bg-outlook">
    <!-- START CONTAINER -->
    <div class="container-fluid">
        <!-- START HEADER -->
        <header class="row justify-content-between align-items-center bg-light py-md-4 border border-secondary">
            <div class="col-md-1 ms-4">
                <h4>LamLT15</h4>
            </div>
            <div class="col-md-1 me-2 text-muted">
                <span>Admin</span>
            </div>
        </header>
        <!-- END HEADER -->
        
        <!-- START BODY -->
        <div class="row mt-2  ">
          <jsp:include page="/WEB-INF/views/fragment/nav.jsp"></jsp:include>

            <!-- START CONTENT -->
            <section class="col-md-8 bg-light border border-secondary rounded session">
                <div class="head_section py-2 border-bottom">
                    <span class="font-weight-normal text-decoration-underline">
                        Basic Infomation
                    </span>
                </div>

                <div class="row justify-content-end">
                    <a class=" btn  btn-secondary col-2 me-5 my-4 py-2 border border-secondary rounded">
                        <i class="fa fa-gears" aria-hidden="true"></i>
                        Configuration
                    </a>
                </div>
                <div class="row  border-bottom">
                    <Strong>
                        Access from the house
                    </Strong>
                </div>
                <div class="row border-bottom mt-2">
                    <span>It is the address to access from the house to the "Aipo". The house of the user, please
                        contact us to this address. </span>
                </div>

                <div class="row mt-2">
                    <span><Strong>Aipo site (in-house)</Strong> &emsp; &emsp; Http:// 1 57.7 .209.80/</span>
                    <hr class="mt-2">
                </div>
                <div class="d-flex justify-content-center">
                    <a href="#" class=" btn btn-outline-secondary">To Edit</a>
                </div>
                <hr>


                <div class="row  border-bottom">
                    <Strong>
                        Access from outsite the company
                    </Strong>
                </div>
                <div class="row border-bottom mt-2">
                    <span>The address for accessing the "Aipo" from outside the company. The user of the outside, please
                        contact us to this address </span>
                </div>

                <div class="row mt-2">
                    <span><Strong>Aipo site (Outside)</Strong> </span>
                    <hr class="mt-2">
                </div>
                <div class="d-flex justify-content-center">
                    <a href="#" class=" btn btn-outline-secondary">To Edit</a>
                </div>
                <hr>
            </section>
            <!-- END CONTENT -->
        </div>
        <!-- END BODY -->
    </div>
    <!-- END CONTAINER -->


    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
    <script defer src="https://use.fontawesome.com/releases/v5.1.1/js/all.js"
        integrity="sha384-BtvRZcyfv4r0x/phJt9Y9HhnN5ur1Z+kZbKVgzVBAlQZX4jvAuImlIz+bG7TS00a"
        crossorigin="anonymous"></script>
    <script src="${pageContext.request.contextPath}/resources/js/index.js"></script>
</body>

</html>