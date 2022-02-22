<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    </head>
    <body>
        <script>

        </script>
        <%
            String creation_message = (String) request.getAttribute("creation_message");
            String deletion_message = (String) request.getAttribute("deletion_message");
            String updation_message = (String) request.getAttribute("updation_message");
        %>
        <% if (creation_message != null) {%>
        <script>alert("Record inserted successfully");</script>
        <% }%>
        <% if (deletion_message != null) {%>
        <script>alert("Record Deleted successfully");</script>
        <% }%>

        <% if (updation_message != null) {%>
        <script>alert("Record updated successfully");</script>
        <% }%>
        <div class="container vh-100 border border-light">
            <div class="d-flex justify-content-between p-2">
                <h1 class="text-muted text-center ">Employee management system</h1>
                <a href="AllUserFind" class="btn btn-success">Get employees list</a>

            </div>


            <div class="d-flex flex-column align-items-center justify-content-between mt-3 p-3 border ">
                <div class="w-100">
                    <form action="CreateServlet" method="POST">
                        <div class="mb-3 d-flex border">
                            <input type="text" name="name" class="form-control m-3" id="name" aria-describedby="nameHelp" placeholder="Enter your name">
                            <input type="email" name="email" class="form-control m-3" id="email" aria-describedby="nameHelp" placeholder="Enter your email">
                            <input type="text" name="salary" class="form-control m-3" id="salary" aria-describedby="nameHelp" placeholder="Enter your phone number">
                            <input type="text" name="department" class="form-control m-3" id="department" aria-describedby="nameHelp" placeholder="Enter your department">
                        </div>
                        <input type="submit" name="Create" value="Create" class="btn btn-primary w-15 mx-2 flex-end">
                    </form>


                </div>

                <div class="w-100 mt-3">
                    <form action="FindUser" method="POST">
                        <div class="mb-3 d-flex border">
                            <input type="email" name="email" class="form-control m-3" id="email" aria-describedby="nameHelp" placeholder="Enter your email">
                            <input type="text" name="salary" class="form-control m-3" id="salary" aria-describedby="nameHelp" placeholder="Enter your phone number">
                        </div>
                        <input type="submit" name="Find user" value="Find user" class="btn btn-secondary w-15 mx-2 flex-end ">
                    </form>
                </div>

                <div class="w-100 mt-3">
                    <form action="DeleteUser" method="POST">
                        <div class="mb-3 d-flex border">
                            <input type="email" name="email" class="form-control m-3" id="email" aria-describedby="nameHelp" placeholder="Enter your email">
                        </div>
                        <input type="submit" name="Find user" value="Delete user" class="btn btn-danger w-15 mx-2 flex-end ">
                    </form>
                </div>

                <div class="w-100">
                    <form action="UpdateUser" method="POST">
                        <div class="mb-3 d-flex border">
                            <input type="email" name="email" class="form-control m-3" id="email" aria-describedby="nameHelp" placeholder="Enter your email">
                            <input type="text" name="name" class="form-control m-3" id="name" aria-describedby="nameHelp" placeholder="Enter your name">
                            <input type="text" name="salary" class="form-control m-3" id="salary" aria-describedby="nameHelp" placeholder="Enter your phone number">
                            <input type="text" name="department" class="form-control m-3" id="department" aria-describedby="nameHelp" placeholder="Enter your department">
                        </div>
                        <input type="submit" name="Update user" value="Update user" class="btn btn-warning w-15 mx-2 flex-end text-white">
                    </form>


                </div>

            </div>
        </div>
    </body>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</html>
