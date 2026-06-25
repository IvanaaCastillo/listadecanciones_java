<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Agregar Canción</title>
    <link rel="stylesheet" href="/css/styles.css">
</head>

<body>
    <h1>Editar Canción</h1>
    <div class="contenido">
        <form:form action="/canciones/procesa/editar/${cancion.id}" method="post" modelAttribute="cancion">
            <input type="hidden" name="_method" value="put"/>

            <input type="hidden" name="id" value="${cancion.id}" />

                <form:label path="titulo">Titulo</form:label>
                <form:input path="titulo"/>
                <form:errors class="error" path="titulo"/>

                <form:label path="artista">Artista</form:label>
                <form:input path="artista"/>
                <form:errors class="error" path="artista"/>

                <form:label path="album">Album</form:label>
                <form:input path="album"/>
                <form:errors class="error" path="album"/>

                <form:label path="genero">Genero</form:label>
                <form:input path="genero"/>
                <form:errors class="error" path="genero"/>

                <form:label path="idioma">Idioma</form:label>
                <form:input path="idioma"/>
                <form:errors class="error" path="idioma"/>

            <button type="submit">Actualizar Cancion</button>
        </form:form>

        <br>

        <a href="/canciones">Volver a lista de canciones</a>
    </div>
</body>
</html>