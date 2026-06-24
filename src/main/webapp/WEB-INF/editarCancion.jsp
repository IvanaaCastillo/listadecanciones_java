<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
<head>
    <title>Agregar Canción</title>
    <link rel="stylesheet" href="/css/styles.css">
</head>

<body>
    <h1>Editar Canción</h1>
    <div class="contenido">
        <form:form action="/canciones/procesa/editar/${cancion.id}" method="POST" modelAttribute="cancion">
            <input type="hidden" name="_method" value="PUT"/>

            <input type="hidden" value="${cancion.id} name="id" />

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

            <button type="submit">Guardar cambios</button>
        </form:form>

        <br>

        <a href="/canciones">Volver a lista de canciones</a>
    </div>
</body>
