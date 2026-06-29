<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <title>Agregar Artista</title>
    <link rel="stylesheet" href="/css/styles.css">
</head>

<body>
    <h1>Agregar Nueva Artista</h1>
        <form:form modelAttribute="artista" method="post" action="/artistas/procesa/agregar">

        <div>
            <form:label path="nombre">Nombre:</form:label>
            <form:input type="text" path="nombre"/>
            <form:errors path="nombre"/>
        </div>

        <div>
            <form:label path="apellido">Apellido:</form:label>
            <form:input type="text" path="apellido"/>
            <form:errors path="apellido"/>
        </div>
        
        <div>
            <form:label path="biografia">Biografía:</form:label>
            <form:input type="text" path="biografia"/>
            <form:errors path="biografia"/>
        </div>


        <button type="submit">Agregar Artista</button>

    </form:form>

    <br>

    <a href="/artistas">Volver a lista</a>

</body>
</html>