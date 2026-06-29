<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <title>Lista de Artistas</title>
    <link rel="stylesheet" href="/css/styles.css">
</head>

<body>
    <h1>Artistas</h1>
    <c:forEach var="artista" items="${artistas}">
        <div>
        <a href="/artistas/detalle/${artista.id}">
            <c:out value="${artista.nombre}" />
            <c:out value="${artista.apellido}" />
        </a>
        </div>

        <br>
    </c:forEach>

<a href="/canciones">Ir a canciones</a>
</body>

</html>