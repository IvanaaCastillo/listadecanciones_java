<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Detalle de Canción</title>
    <link rel="stylesheet" href="/css/styles.css">
</head>

<body>
<div class="contend">
    <h1>Detalle de Canción</h1>

                <div class="card">
                    <div class="campo">
                        <span class="etiqueta">ID</span>
                        <span class="valor">${cancion.id}</span>
                    </div>

                    <div class="campo">
                        <span class="etiqueta">Título</span>
                        <span class="valor">${cancion.titulo}</span>
                    </div>

                    <div class="campo">
                        <span class="etiqueta">Artista</span>
                        <span class="valor">${cancion.artista}</span>
                    </div>

                    <div class="campo">
                        <span class="etiqueta">Álbum</span>
                        <span class="valor">${cancion.album}</span>
                    </div>

                    <div class="campo">
                        <span class="etiqueta">Género</span>
                        <span class="valor">${cancion.genero}</span>
                    </div>

                    <div class="campo">
                        <span class="etiqueta">Idioma</span>
                        <span class="valor">${cancion.idioma}</span>
                    </div>

                    <div class="campo">
                        <span class="etiqueta">Fecha de creación</span>
                        <span class="valor">${cancion.fechaCreacion}</span>
                    </div>

                    <div class="campo">
                        <span class="etiqueta">Última actualización</span>
                        <span class="valor">${cancion.fechaActualizacion}</span>
                    </div>
                </div>

                <div class="botones">
                    <a href="/canciones/formulario/editar/${cancion.id}"><button>Editar canción</button></a>

                    <br>
                
        <form action="/canciones/eliminar/${cancion.id}" method="post">
            <input type="hidden" name="_method" value="delete">

            <button type="submit" class="btn-delete">Eliminar canción</button>
        </form>

        <br>

        <a class="btn-volver" href="/canciones"> Volver a lista de canciones</a>

        </div>
</div>
</body>
</html>