<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Note link</title>
    <link rel="stylesheet" type="text/css" href="assets/style.css">
</head>
<body>
<jsp:include page="fragments/header.jsp" />
<div class="content">
    <div>
        <h1 class="">Note link</h1>
    </div>
    <div>
        <textarea class="textarea_content" readonly="readonly"><%out.print("http://" + request.getServerName() + "/note_get?id=" + request.getAttribute("id"));%></textarea><br>
        <button class="copy_button primary_button">Copy</button>
    </div>
</div>
<jsp:include page="fragments/footer.jsp" />
<script type="text/javascript" src="assets/script.js"></script>
</body>
</html>
