<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <title>Artista</title>
    <link rel="stylesheet" href="/css/styles.css">
</head>

<body>

    <h1>
        <c:out value="${artista.nombre}" />
        <c:out value=" ${artista.apellido}" />
    </h1>

    <p><c:out value="${artista.biografia}" /></p>

    <h3>Canciones:</h3>
    <c:forEach var="cancion" items="${artista.canciones}">
        <p><c:out value="${cancion.titulo}" /></p>
    </c:forEach>

    <a href="/artistas">Volver a lista de artistas</a>

    </body>
</html>