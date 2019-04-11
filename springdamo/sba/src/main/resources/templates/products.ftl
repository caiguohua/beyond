<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">


    <link href="/webjars/bootstrap/4.1.0/css/bootstrap.min.css" rel="stylesheet" />

    <title>Products</title>
</head>
<body>
    <h1>PRODUCT LIST</h1>
    <#list products>
        <table class="table table-hover table-success table-bordered">
            <thead>
                <tr>
                    <th>#</th>
                    <th>NAME</th>
                    <th>PRICE</th>
                </tr>
            </thead>
            <tbody>
                <#items as product>
                    <tr>
                        <td>${product.id}</td>
                        <td>${product.name}</td>
                        <td>${product.price}</td>
                    </tr>
                </#items>
            </tbody>
        </table>
    <#else>
        NO DATA
    </#list>

</body>
</html>