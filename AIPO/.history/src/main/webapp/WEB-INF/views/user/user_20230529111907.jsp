<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                    integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
                    crossorigin="anonymous">
                <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
                <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.1.1/css/all.css"
                    integrity="sha384-O8whS3fhG2OnA5Kas0Y9l3cfpmYjapjI0E4theH4iuMD+pLhbf6JI0jIMfYcK3yZ"
                    crossorigin="anonymous">
            </head>

            <body class="bg-outlook">
                <!-- START CONTAINER -->
                <div class="container-fluid">
                    <!-- START HEADER -->
                    <header
                        class="row justify-content-between align-items-center bg-light py-md-4 border border-secondary">
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
                        <!-- START MENNU SIDE -->
                        <jsp:include page="/WEB-INF/views/fragment/nav.jsp"></jsp:include>
                        <!-- END MENU SIDE -->

                        <!-- START CONTENT -->
                        <section class="col-md-8 bg-light border border-secondary rounded session">
                            <div class="head_section py-2 border-bottom">
                                <span class="font-weight-normal text-decoration-underline">
                                    User management
                                </span>
                            </div>

                            <div class="row justify-content-start ">
                                <button type="button" id="addUser" class="btn btn-outline-dark col-2 mt-3 ms-3 "
                                    data-bs-toggle="modal" data-bs-target="#staticBackdrop">To add a user</button>
                            </div>

                            <div class="row">
                                <div class="col-md-3">
                                    <div class="my-3 d-flex">
                                        <select class="form-select form-select-sm" name="search" id="search" onchange="handleSelectedSearch()">
                                            <option selected>====Select====</option>
                                            <c:forEach items="${companies }" var="company">
                                              <option value="${company.companyId}">${company.companyName }</option>
                                            </c:forEach>
                                          
                                         
                                        </select>
                                        <a name="searchBtn" id="searchBtn" class=" ms-2 btn btn-outline-secondary text-black" href="${pageContext.request.contextPath}/user/list?searchSelectBox="
                                            role="button">Button</a>
                                    </div>
                                </div>
                            </div>

                            <div class="row">
                                <a name="" id="" class="btn btn-outline-secondary text-black col-1 ms-2 " href="#"
                                    role="button">Remove</a>
                                <a name="" id="" class="btn btn-outline-secondary text-black col-1 ms-2" href="#"
                                    role="button">to
                                    enable</a>
                                <a name="" id="" class="btn btn-outline-secondary text-black col-1 ms-2" href="#"
                                    role="button">to
                                    disable</a>
                                <a name="" id="" class="btn btn-outline-secondary text-black col-3 ms-2" href="#"
                                    role="button">to
                                    change the order of the user</a>
                            </div>

                            <div class="table-responsive-md">
                                <table class="table table-striped-columns
                    table-hover	
                    table-secondary
                    
                    ">
                                    <thead class="table-light">
                                        <tr>
                                            <th><input type="checkbox" name="checkboxAll" id="checkboxAll" onchange="handleCheckAll(event)"></th>
                                            <th>State</th>
                                            <th>User name</th>
                                            <th>name</th>
                                            <th>Department name</th>
                                            <th>Title</th>
                                            <th>Position</th>
                                        </tr>
                                    </thead>
                                    <tbody class="table-group-divider">
                                    	<c:forEach items="${listUser }" var="user">
                                    	<tr class="table-light">
                                            <td scope="row"><input type="checkbox" name="checkBoxItem" onchange="handleCheckItem()"></td>
                                            <td>${user.position.positionId }</td>
                                            <td>${user.loginName }</td>
                                            <td>${user.firstName } ${user.lastName }</td>
                                            <td>${user.company.companyName }</td>                                            	</td>
                                            <td></td>
                                            <td>${user.position.positionName}</td>
                                        </tr>
                                    	</c:forEach>
                                        
                                    </tbody>
                                    <tfoot>

                                    </tfoot>
                                </table>
                            </div>

                            <div class="row">
                                <a name="" id="" class="btn btn-outline-secondary text-black col-md-1 ms-2" href=""
                                    role="button" >Remove</a>
                                <a name="" id="" class="btn btn-outline-secondary text-black col-md-1 ms-2" href="#"
                                    role="button">To enable</a>
                                <a name="" id="" class="btn btn-outline-secondary text-black col-md-1 ms-2" href="#"
                                    role="button">To disable</a>
                            </div>
                            <!-- Scrollable modal -->
                            <form:form action="${pageContext.request.contextPath}/user/saveOrUpdate/"
                                modelAttribute="user" method="post">
                                <div class="modal fade " id="staticBackdrop" data-bs-backdrop="static"
                                    data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel"
                                    aria-hidden="true">
                                    <div class="modal-dialog modal-dialog-scrollable  modal-xl">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <h1 class="modal-title fs-5" id="staticBackdropLabel"><i
                                                        class="fa fa-arrow-circle-right" aria-hidden="true"></i> Add
                                                    User</h1>
                                                <button type="button" class="btn-close" data-bs-dismiss="modal"
                                                    aria-label="Close"></button>
                                            </div>
                                            <div class="modal-body" id="modal_body_form">
                                                <div class="row">
                                                    <div class="col-md-6">
                                                        <div class="mb-3">
                                                         
                                                            <label for="" class="form-label ">login name <Strong
                                                                    class="text-danger">*</Strong></label>
                                                            <form:input type="text" class="form-control"
                                                                path="loginName" id="" aria-describedby="helpId"
                                                                placeholder=""></form:input>
                                                        </div>

                                                        <div class="mb-3">
                                                            <label for="" class="form-label">password <Strong
                                                                    class="text-danger">*</Strong></label>
                                                            <form:input type="password" class=" form-control "
                                                                path="passwordValue" id="" aria-describedby="helpId"
                                                                placeholder=""></form:input>
                                                        </div>
                                                        <div class="mb-3">
                                                            <label for="" class="form-label ">Password (for
                                                                confirmation) <Strong
                                                                    class="text-danger">*</Strong></label>
                                                            <input type="password" class=" form-control " name="" id=""
                                                                aria-describedby="helpId" placeholder="">
                                                        </div>

                                                        <div class="mb-3">
                                                            <label for="" class="form-label "> name <Strong
                                                                    class="text-danger">*</Strong></label>
                                                            <div class="row d-flex justify-content-around">
                                                                <form:input type="text" class=" form-control col-6"
                                                                path="firstName" id="" aria-describedby="helpId"
                                                                placeholder=""></form:input> -
                                                            <form:input type="text" class=" form-control col-6"
                                                                path="lastName" id="" aria-describedby="helpId"
                                                                placeholder=""></form:input>
                                                            </div>
                                                        </div>
                                                        <div class="mb-3">
                                                            <label for="" class="form-label "> name: fugiana <Strong
                                                                    class="text-danger">*</Strong></label>
                                                         <div class="row d-flex justify-content-around">
                                                            <form:input type="text" class=" form-control col-6"
                                                            path="firstNameKana" id="" aria-describedby="helpId"
                                                            placeholder=""></form:input> -
                                                        <form:input type="text" class=" form-control col-6 "
                                                            path="lastNameKana" id="" aria-describedby="helpId"
                                                            placeholder=""></form:input>
                                                         </div>
                                                        </div>
                                                        <div class="mb-3">
                                                            <label for="" class="form-label "> mail address</label>
                                                            <form:input type="mail" class=" form-control " path="email"
                                                                id="" aria-describedby="helpId" placeholder=""></form:input>
                                                        </div>
                                                        <div class="mb-3">
                                                            <label for="" class="form-label "> Telephone number(outside
                                                                line)</label>
                                                            <form:input type="tel" class=" form-control "
                                                                path="outTelephone" id="" aria-describedby="helpId"
                                                                placeholder=""></form:input>
                                                        </div>
                                                        <div class="mb-3">
                                                            <label for="" class="form-label "> Telephone
                                                                number(extension)</label>
                                                            <form:input type="tel" class=" form-control "
                                                                path="inTelephone" id="" aria-describedby="helpId"
                                                                placeholder=""></form:input>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-6">


                                                        <div class="mb-3">
                                                            <label for="" class="form-label "> Telephone
                                                                number(mobile)</label>
                                                            <form:input type="tel" class=" form-control "
                                                                path="cellularPhone" id="" aria-describedby="helpId"
                                                                placeholder=""></form:input>
                                                        </div>
                                                        <div class="mb-3">
                                                            <label for="" class="form-label "> mobile e-mail
                                                                address</label>
                                                            <form:input type="email" class=" form-control "
                                                                path="cellularMail" id="" aria-describedby="helpId"
                                                                placeholder=""></form:input>
                                                        </div>

                                                        <div class="mb-3">
                                                            <label for="" class="form-label">Mug shot</label>
                                                            <form:input type="file" class="form-control" path="photo"
                                                                id="" placeholder="" aria-describedby="fileHelpId"
                                                                value="Add"></form:input>
                                                        </div>
                                                        <div class="mb-3">
                                                            <label for="" class="form-label">Department</label>
                                                            <div class="row border border-secondary py-3 bg-outlook">
                                                                <div class="col-md-6">
                                                                    <label for="" class="form-label">Department</label>
                                                                    <select class="form-select form-select-sm" name=""
                                                                        id="department" multiple
                                                                        onchange="removeDepartment()">
                                                                    </select>
                                                                </div>
                                                                <div class="col-md-6">
                                                                    <label for="" class="form-label">Department
                                                                        List</label>
                                                                 
                                                                    <select class="form-select form-select-sm" id="departmentList" multiple="multiple" onchange="getSelectedItems()">
															        <c:forEach var="company" items="${companies}">
															            <option value="${company.companyName}">${company.companyName}</option>
															        </c:forEach>
															    </select>
                                                                </div>
                                                            </div>
                                                        </div>

                                                        <div class="mb-3">
                                                            <label for="" class="form-label">Position</label>
                                                            <form:select class="form-select form-select-sm"
                                                                path="position.positionId" id="">
                                                                <form:options items="${positions }"
                                                                    itemValue="positionId" itemLabel="positionName" />
                                                            </form:select>
                                                            <a name="" id="" class="btn btn-secondary" href="#"
                                                                role="button">The
                                                                new input</a>
                                                        </div>
                                                        <label for="" class="form-label">Administrasive
                                                            privileges</label>
                                                        <div class="form-check">
                                                            <input class="form-check-input" type="checkbox" value=""
                                                                id="">
                                                            <label class="form-check-label" for="">
                                                                To adminstrator
                                                            </label>
                                                        </div>



                                                    </div>

                                                </div>


                                            </div>
                                            <div class="modal-footer d-flex justify-content-center ">
                                                <button  class="btn text-white color-main">Adding</button>
                                                <button type="button" class="btn btn-secondary"
                                                    data-bs-dismiss="modal">Close</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </form:form>
                        </section>
                        <!-- END CONTENT -->
                    </div>
                    <!-- END BODY -->
                </div>
                <!-- END CONTAINER -->


                <!-- Optional JavaScript -->
                <!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
                    integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
                    crossorigin="anonymous"></script>
                <script defer src="https://use.fontawesome.com/releases/v5.1.1/js/all.js"
                    integrity="sha384-BtvRZcyfv4r0x/phJt9Y9HhnN5ur1Z+kZbKVgzVBAlQZX4jvAuImlIz+bG7TS00a"
                    crossorigin="anonymous"></script>
                <script src="${pageContext.request.contextPath}/resources/js/index.js"></script>
                <script src="${pageContext.request.contextPath}/resources/js/user.js"></script>
            </body>

            </html>