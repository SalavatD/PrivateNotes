<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Private notes</title>
    <link rel="stylesheet" type="text/css" href="assets/style.css">
</head>
<body>
<jsp:include page="fragments/header.jsp"/>
<div class="content">
    <div>
        <h1 class="">New note</h1>
    </div>
    <div>
        <form action="note_link" method="post">
            <textarea name="note_content" rows="4" placeholder="Write your note here..."></textarea><br>
            <input type="submit" class="primary_button"/>
        </form>
    </div>
</div>
<jsp:include page="fragments/footer.jsp"/>
<script type="text/javascript" src="assets/script.js"></script>
</body>
</html>
