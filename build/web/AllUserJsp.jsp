<%@page import = "java.util.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User List</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    </head>
    <body>
        <div class="container border-light border vh-100">
            <h2 class="text-muted text-center"> Bebo Employees details </h2>
            <table class="table table-light table-striped border-light">
                <tr>
                    <th>No</th>
                    <th> Name </th>
                    <th> Salary </th>
                    <th> Department </th>
                    <th> Email Id </th>
                </tr>

                <% ArrayList<String[]> al = (ArrayList<String[]>) request.getAttribute("details");
                    int count = 1;%>
                <% for (String[] str : al) {%>
                <tr>
                    <td class="fw-bold"><%=count%></td>

                    <%for (String s : str) {%>
                    <td><%=s%></td>
                    <%}
                        count++;%>
                </tr>
                <% }%>
            </table>
        </div>
    </body>
</html>
