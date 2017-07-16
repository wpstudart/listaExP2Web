<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title><g:message code="seqQL"/></title>
</head>

<body>

<div id="list" class="content scaffold-list" role="main">
    <h1><g:message code="seqQL"/></h1>

    <table>
        <thead>
        <tr>

            <th><g:message code="quilos"/></th>

            <th><g:message code="libras"/></th>

        </tr>
        </thead>
        <tbody>
        <g:each in="${lista}" status="i" var="instance">
            <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

                <td>${instance.quilos}</td>
                <td>${fieldValue(bean: instance, field: "libras")}</td>

            </tr>
        </g:each>
        </tbody>
    </table>
</div>
</body>
</html>