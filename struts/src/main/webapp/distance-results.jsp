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
    <p><s:property value="response"/>!</p>
    <br>
    <form action="distance.action">
        <p>What distance in meters would you like to analyze?</p>
        <input type="number" name="meters"/>
        <input type="submit" value="Submit"/>
    </form>
    <br>
    <hr>
    <br>
    <p>Click <a href="index.html">here</a> to go back to the home page</p>
    <br>
</main>
</body>
</html>