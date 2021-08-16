<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Get file</title>
    <link rel="stylesheet" type="text/css" href="assets/style.css">
</head>
<body>
<jsp:include page="fragments/header.jsp" />
<div class="content">
    <div>
        <h1>Get file</h1>
    </div>
    <div>
        <form method="get" action="file">
            <input type="hidden" name="id" value=<%out.print(request.getParameter("id"));%>>
            <button class="button download_file_button" type="submit">Download</button>
        </form>
    </div>
</div>
<jsp:include page="fragments/footer.jsp" />
<script type="text/javascript" src="assets/script.js"></script>
</body>
</html>
