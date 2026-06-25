<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Lista de Canciones</title>
    <link rel="stylesheet" href="/css/styles.css">
</head>
<body>

<h1>Catálogo de Canciones</h1>

<div class="container">
    <table>
        <thead>
            <tr>
                <th>Título</th>
                <th>Artista</th>
                <th>Más Información</th>
            </tr>
        </thead>
        <tbody>
            <c:choose>
                <c:when test="${empty canciones}">
                    <tr>
                        <td colspan="3">No hay canciones registradas.</td>
                    </tr>
                </c:when>
                <c:otherwise>
                    <c:forEach var="cancion" items="${canciones}">
                        <tr>
                            <td>${cancion.titulo}</td>
                            <td>${cancion.artista}</td>
                            <td>
                                <a class="btn-detalle" href="/canciones/detalle/${cancion.id}">Detalle</a>
                            </td>
                        </tr>
                    </c:forEach>
                </c:otherwise>
            </c:choose>
        </tbody>
    </table>
    </div>

    <div class="center-btn">
	    <a href="/canciones/formulario/agregar" class="btn btn-success">Agregar Canción</a>
	</div>


</body>
</html>