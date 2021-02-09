# Getting Started

## 1° - Iniciar Microservicio

**Para Iniciar el microservicio que lleva la lógica del cálculo de Retiro 10% y de impuesto:**

- Desde consola git, ejecutar el comando 'mvn spring-boot:run'
- Desde algún IDE como IntelliJ, Eclpise o STS, importar el proyecto como 'Proyecto Maven' y buscar la ruta que contiene el proyecto previamente descargado desde Git. Esto incluirá en el IDE el proyecto Maven y de manera gráfica, poder iniciar el microservicio.

## 2° - Iniciar Interfaz Gráfica (Front-end)

* Para ejecutar la interfaz, bastaría con dirigirse a la ruta donde está descargado el microservicio, buscar la siguiente ruta: TrabajoFinalM4SWDGrupo1/src/main/java/com/devops/dxc/devops/web. En esta ruta estará el archivo index.html, el cuál se puede ejecutar dando doble click sobre el archivo.

## 3° - Probar Servicio

* Para probar el servicio desde la interfaz web, se deben llenar los campos 'Sueldo' y 'Ahorro'. Luego, se presiona el botón enviar para poder efectuar la llamada al microservicio que ejecuta los cálculos correspondientes, según el caso de negocio. La interfaz web mostrará los resultados luego de haber hecho la petición al microservicio.