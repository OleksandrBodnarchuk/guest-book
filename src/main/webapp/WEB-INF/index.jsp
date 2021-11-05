<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="pl">
<head>
    <title>Guest Book</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles.css">
</head>
<body>
<main>
    <section class="form">
        <h1>Guest Book</h1>
        <form method="post">
            <fieldset>
                <legend>Leave a note</legend>
                <label>
                    Your Name
                    <input name="author" placeholder="Your Name">
                </label>
                <label for="content">Message body</label>
                <textarea name="message" placeholder="Write here..." id="content" rows="5"></textarea>
                <button>Comment</button>
            </fieldset>
        </form>
    </section>
    <c:if test="${not empty requestScope.comments}">
        <section class="entries">
            <h2>Notes (${requestScope.comments.size()})</h2>
            <c:forEach var="note" items="${requestScope.comments}">
                <div class="note">
                    <h3><c:out value="Author: ${note.author}"/></h3>
                    <p><c:out value="${note.comment}"/></p>
                </div>
            </c:forEach>
        </section>
    </c:if>
</main>
</body>
</html>