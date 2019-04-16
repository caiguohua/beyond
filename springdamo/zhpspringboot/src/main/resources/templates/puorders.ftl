<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">


    <link href="/webjars/bootstrap/4.1.0/css/bootstrap.min.css" rel="stylesheet" />

    <title>Puorders</title>
</head>
<body>
<h1>PUORDER LIST</h1>
    <#list puorders>
        <table class="table table-hover table-success table-bordered">
            <thead>
            <tr>
                <th>#</th>
                <th>MONEY</th>
                <th>DATETIME</th>
                <th>PRICE</th>
                <th>PRODUCTNAME</th>
                <th>USERNAME</th>
                <th>PHONE</th>
                <th>ADDRESS</th>
            </tr>
            </thead>
            <tbody>
                <#items as puorder>
                <tr>
                    <td>${puorder.oid}</td>
                    <td>${puorder.money}</td>
                    <td>${puorder.datetime}</td>
                    <td>${puorder.price}</td>
                    <td>${puorder.pname}</td>
                    <td>${puorder.name}</td>
                    <td>${puorder.phone}</td>
                    <td>${puorder.address}</td>
                </tr>
                </#items>
            </tbody>
        </table>
    <#else>
        NO DATA
    </#list>

</body>
</html>