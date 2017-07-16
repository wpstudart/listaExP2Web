<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Fibonacci</title>
</head>

<body>
    <div id="list" class="content scaffold-list" role="main">

        <table>
            <thead>
                <tr>
                    <th> N </th>
                    <th> Fibonacci </th>\
                </tr>
            </thead>
            <tbody>
            <g:each in="${lista}" status="n" var="instance">
                <tr class="{(i % 2) == 0 ? 'even' : 'odd'}">
                    <td>${fieldValue(bean: instance, field: "n")}</td>
                    <td>${instance.Fibonacci(n)}</td>
                </tr>
            </g:each>
            </tbody>
        </table>


    </div>
</body>
</html>
