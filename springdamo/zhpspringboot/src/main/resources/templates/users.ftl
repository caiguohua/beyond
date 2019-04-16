<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">


    <link href="/webjars/bootstrap/4.1.0/css/bootstrap.min.css" rel="stylesheet" />

    <title>Users</title>
</head>
<body>
<h1>USER LIST</h1>
    <#list users>
        <table class="table table-hover table-success table-bordered">
            <thead>
            <tr>
                <th>#</th>
                <th>PNAME</th>
                <th>SEX</th>
                <th>PHONE</th>
                <th>ADDRESS</th>
            </tr>
            </thead>
            <tbody>
                <#items as user>
                <tr>
                    <td>${user.id}</td>
                    <td>${user.name}</td>
                    <td>${user.sex}</td>
                    <td>${user.phone}</td>
                    <td>${user.address}</td>
                </tr>
                </#items>
            </tbody>
        </table>
    <#else>
        NO DATA
    </#list>

</body>
</html>