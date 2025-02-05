<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Editar Usuario</title>
<!-- Cargar Bootstrap 5 desde CDN -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<!-- Enlace al archivo de CSS separado -->
<link href="/css/style.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5 loading-container">
  <div class="card">
    <div class="card-header text-center">
      <h3>Pantalla de carga</h3>
    </div>
    <div class="card-body text-center">
      <!-- Incrustar video de YouTube -->
      <div class="ratio ratio-16x9">
        <iframe 
          id="youtubeVideo"
          src="https://www.youtube.com/embed/gOHnyOQegzQ?enablejsapi=1" 
          title="YouTube video" 
          allowfullscreen>
        </iframe>
      </div>

      <!-- Cita debajo del video -->
      <div class="loading-cita">
        <p>
          "Siempre fui un apasionado de los videojuegos, pero las cosas no habían ido bien últimamente. Las malas decisiones, la soledad y la depresión habían oscurecido mi mundo al punto de que no veía salida. Una noche, mientras estaba sumido en la desesperación y al borde del abismo, decidí que ya no podía más.
        </p>
        <p>
          Con lágrimas en los ojos, me senté frente a la computadora, pensando que vería un último video antes de despedirme. No sabía por qué lo hacía, tal vez para encontrar un último destello de alegría en un mundo que ya no me ofrecía nada. Abrí YouTube y, sin pensarlo demasiado, le di clic a un video de un canal que había comenzado a seguir recientemente: Simpson Gamer.
        </p>
        <p>
          El video comenzaba con su característico saludo, lleno de energía y positividad. A pesar de mi estado de ánimo, su entusiasmo me hizo sonreír por primera vez en semanas. Era un gameplay de uno de mis juegos favoritos. Mientras lo veía jugar, narraba sus experiencias con un sentido del humor contagioso. Su risa era auténtica, y por un momento, olvidé mis problemas.
        </p>
        <p>
          El video no era solo sobre el juego, Simpson Gamer hablaba también de su vida, de los momentos difíciles que había superado y cómo los videojuegos y su comunidad lo habían ayudado a encontrar un propósito. Contó cómo había estado en un lugar oscuro antes, similar al mío, y cómo había encontrado fuerzas en los lugares más inesperados. Sus palabras resonaban conmigo de una manera que no esperaba.
        </p>
        <p>
          Sentí una conexión genuina. Si él pudo salir adelante, tal vez yo también podría. Apagué la computadora con una nueva determinación. En lugar de rendirme, decidí buscar ayuda, hablar con alguien y darme otra oportunidad.
        </p>
        <p>
          A la mañana siguiente, llamé a un amigo y le conté cómo me sentía. Para mi sorpresa, me escuchó con comprensión y me ofreció su apoyo. Ese fue el primer paso de muchos, pero había comenzado un camino hacia la recuperación."
          
          
        </p>
        <footer class="blockquote-footer color-cita">
          @GuillermoOncina - Usuario de YouTube - <cite title="Fuente">El Clic que Salvó Mi Vida</cite>
        </footer>
      </div>

      <!-- Botón de Dashboard (inicialmente deshabilitado) -->
      <div class="d-flex justify-content-center">
        <a href="/loading" class="btn btn-info btn-dashboard" id="dashboardButton">Dashboard</a>
      </div>

      <!-- Barra de carga -->
      <div class="loading-bar-container">
        <div class="loading-bar" id="loadingBar"></div>
      </div>

    </div>
  </div>
</div>

<script>
  let player;
  function onYouTubeIframeAPIReady() {
    player = new YT.Player('youtubeVideo', {
      events: {
        'onStateChange': onPlayerStateChange
      }
    });
  }

  function onPlayerStateChange(event) {
    if (event.data === YT.PlayerState.PLAYING) {
      const videoDuration = player.getDuration();
      const loadingBar = document.getElementById('loadingBar');
      const dashboardButton = document.getElementById('dashboardButton');

      let interval = setInterval(() => {
        const currentTime = player.getCurrentTime();
        const progress = (currentTime / videoDuration) * 100;
        loadingBar.style.width = progress + "%";

        if (progress >= 100) {
          clearInterval(interval);
          dashboardButton.style.pointerEvents = "auto";
          dashboardButton.style.opacity = "1";
        }
      }, 1000);
    }
  }

  // Cargar API de YouTube
  let tag = document.createElement('script');
  tag.src = "https://www.youtube.com/iframe_api";
  let firstScriptTag = document.getElementsByTagName('script')[0];
  firstScriptTag.parentNode.insertBefore(tag, firstScriptTag);
</script>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
</body>
</html>
