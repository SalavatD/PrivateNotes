<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Upload file</title>
    <link rel="stylesheet" type="text/css" href="assets/style.css">
</head>
<body>
<jsp:include page="fragments/header.jsp"/>
<div class="content">
    <div>
        <h1>New file</h1>
    </div>
    <div>
        <form action="file_link" method="post" enctype="multipart/form-data">
            <label class="button"><input class="select_file_input" type="file" name="file" required/>Browse file</label><br>
            <input type="submit" class="primary_button"/>
        </form>
    </div>
</div>
<jsp:include page="fragments/footer.jsp"/>
<script type="text/javascript" src="assets/script.js"></script>
</body>
</html>
