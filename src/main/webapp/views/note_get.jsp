<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Get note</title>
    <link rel="stylesheet" type="text/css" href="assets/style.css">
</head>
<body>
<jsp:include page="fragments/header.jsp" />
<div class="content">
    <div>
        <h1 class="">Get note</h1>
    </div>
    <div>
        <textarea class="textarea_content" readonly="readonly"><%out.print(request.getAttribute("content"));%></textarea><br>
        <button class="copy_button primary_button">Copy</button>
    </div>
</div>
<jsp:include page="fragments/footer.jsp" />
<script type="text/javascript" src="assets/script.js"></script>
</body>
</html>
