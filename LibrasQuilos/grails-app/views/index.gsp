<!DOCTYPE html>
<html>
<head>
    <title><g:message code="seqQL"/></title>
</head>

<body>
<div id="form" class="content scaffold-create" role="main">

    <g:form controller="QL">

        <fieldset class="buttons">

            <label for="minVal">
                <g:message code="minVal"/>
            </label>
            <g:field name="minVal" type="number" value="0" min="-200"/>

            <label for="maxVal">
                <g:message code="maxVal"/>
            </label>
            <g:field name="maxVal" type="number" value="0" max="200"/>

            <label for="inc">
                <g:message code="inc"/>
            </label>

            <g:select name="inc" from="${['5', '10']}"/>

            <g:submitButton name="OK" class="OK" value="OK"/>
        </fieldset>
    </g:form>
</div>
</body>
</html>