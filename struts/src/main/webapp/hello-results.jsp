<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Struts Example</title>
</head>
<body>
<main>
    <form action="hello.action">
        <p>May I ask your name?</p>
        <input type="text" name="firstName" value="World"/>
        <input type="submit" value="Submit"/>
    </form>
    <br />
    <hr>
    <p>Hello <s:property value="firstName"/>!</p>
    <br />
    <hr>
    <p>Getting bored? Try our <a href="distance.html">Distance Analyzer</a></p>
</main>
</body>
</html>