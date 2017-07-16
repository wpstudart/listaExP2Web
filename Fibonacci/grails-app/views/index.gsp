<!DOCTYPE html>
<html>
<head>
    <title>Fibonacci</title>
</head>

<body>
<div id="form" class="content scaffold-create" role="main">

    <g:form controller="fib">

        <fieldset class="buttons">

            <label for="n">
                <g:message code="n"/>
            </label>
            <g:field name="n" type="number" value="0" max="15"/>

            <g:submitButton name="OK" class="OK" value="OK"/>
        </fieldset>
    </g:form>
</div>
</body>
</html>
