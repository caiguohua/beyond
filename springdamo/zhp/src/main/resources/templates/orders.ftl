<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">


    <link href="/webjars/bootstrap/4.1.0/css/bootstrap.min.css" rel="stylesheet" />

    <title>Orders</title>
</head>
<body>
<h1>ORDER LIST</h1>
    <#list orders>
        <table class="table table-hover table-success table-bordered">
            <thead>
            <tr>
                <th>#</th>
                <th>U#</th>
                <th>P#</th>
                <th>MONEY</th>
                <th>DATETIME</th>
            </tr>
            </thead>
            <tbody>
                <#items as order>
                <tr>
                    <td>${order.oid}</td>
                    <td>${order.uid}</td>
                    <td>${order.pid}</td>
                    <td>${order.money}</td>
                    <td>${order.datetime}</td>

                </tr>
                </#items>
            </tbody>
        </table>
    <#else>
        NO DATA
    </#list>

</body>
</html>