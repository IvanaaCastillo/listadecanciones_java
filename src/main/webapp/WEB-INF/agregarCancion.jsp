<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <title>Agregar Canción</title>
    <link rel="stylesheet" href="/css/styles.css">
</head>

<body>
    <h1>Agregar Nueva Canción</h1>
        <form:form modelAttribute="cancion" method="post" action="/canciones/procesa/agregar">

        <div>
            <form:label path="titulo">Titulo:</form:label>
            <form:input type="text" path="titulo"/>
            <form:errors path="titulo"/>
        </div>

        <div>
            <label for="artistaId">Artista:</label>
            <select name="artistaId" id="artistaId">
                <option value="">Seleccione un artista</option>
                <c:forEach var="artista" items="${artistas}">
                    <option value="${artista.id}">${artista.nombre} ${artista.apellido}</option>
                </c:forEach>
            </select>
        </div>
        
        <div>
            <form:label path="album">Album:</form:label>
            <form:input type="text" path="album"/>
            <form:errors path="album"/>
        </div>

        <div>
            <form:label path="genero">Genero:</form:label>
            <form:input type="text" path="genero"/>
            <form:errors path="genero"/>
        </div>

        <div>
            <form:label path="idioma">Idioma:</form:label>
            <form:input type="text" path="idioma"/>
            <form:errors path="idioma"/>
        </div>

        <button type="submit">Agregar Cancion</button>

    </form:form>

    <br>

    <a href="/canciones">Volver a lista</a>

</body>
</html>