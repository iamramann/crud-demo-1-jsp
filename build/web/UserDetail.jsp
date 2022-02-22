<%@page import = "java.util.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>user</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    </head>
    <body>
        <div class="container border border-solid vh-100 d-flex justify-content-center align-items-center flex-column bg-light">
            <h2 class="text-muted text-center"> Employee details </h2>
            <table class="table table-striped table-primary">
                <%
                    HashMap<String, String> details = (HashMap<String, String>) request.getAttribute("user");
                    for (Map.Entry<String, String> m : details.entrySet()) {
                %>
                <tr>
                    <td><%=m.getKey()%></td>
                    <td><%=m.getValue()%></td>
                </tr>
                <%}%>

            </table>
        </div>
    </body>
</html>
