# Wary-u (backend)

API REST de Wary-u, una aplicación para reportar y consultar incidentes de seguridad en cada zona. Es un proyecto de curso en equipo (Grupo 5) de la UPC, carrera de Ingeniería de Sistemas de Información.

## Problema que resuelve

Muchas personas en el Perú se sienten inseguras al desplazarse por su zona y no cuentan con información actualizada de lo que ocurre cerca. Wary-u permite registrar incidentes y consultarlos por categoría, distrito y usuario.

## Funcionalidades

- Registro de usuarios y login con autenticación JWT, con roles
- Registro y consulta de incidencias (por categoría, por distrito, incidencias activas y propias)
- Conteo de incidencias por categoría y por distrito
- Gestión de categorías de incidencia y de distritos
- Zonas preferidas por usuario
- Comentarios, foros, grupos y evidencias
- Perfil del usuario autenticado (`/mi-perfil`)

## Tecnologías

| Parte | Tecnologías |
| --- | --- |
| Backend | Java 17, Spring Boot, Spring Security, Spring Data JPA |
| Autenticación | JWT (jjwt) |
| Base de datos | PostgreSQL (script en `database/wayru.sql`) |
| Documentación de la API | springdoc OpenAPI (Swagger) |
| Otros | ModelMapper, Docker |

## Cómo ejecutarlo

### Variables de entorno

```bash
SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5432/wayru
SPRING_DATASOURCE_USERNAME=tu_usuario
SPRING_DATASOURCE_PASSWORD=tu_contraseña
```

Crea la base de datos en PostgreSQL y carga el script `database/wayru.sql`.

### Con Maven

```bash
./mvnw spring-boot:run
```

### Con Docker

```bash
docker build -t wayru-grupo5 .
docker run -p 8080:8080 \
  -e SPRING_DATASOURCE_URL -e SPRING_DATASOURCE_USERNAME -e SPRING_DATASOURCE_PASSWORD \
  wayru-grupo5
```

La API queda en `http://localhost:8080`. La documentación Swagger suele estar en `/swagger-ui/index.html` (verifica la ruta en tu configuración).

## Estructura del proyecto

```
src/main/java/pe/edu/upc/wayrugrupo5/
  Controllers/          Endpoints REST
  Entities/             Modelo de datos (JPA)
  DTOS/                 Objetos de transferencia
  Repositories/         Acceso a datos
  ServicesInterfaces/   Contratos de los servicios
  ServicesImplements/   Lógica de negocio
  securities/           JWT y configuración de seguridad
  Configs/              CORS y OpenAPI
database/wayru.sql      Script de la base de datos
```

## Autoría

Proyecto realizado por el Grupo 5 (UPC). Los aportes de cada persona se pueden ver en la pestaña Contributors y en el historial de commits del repositorio.

- Leonel Venicius Jimenez Solis ([LinkedIn](https://www.linkedin.com/in/leonel-venicius-jimenez-solis-0198a42b0/)), con las cuentas `loganZG15` y `leonel`: desarrollo de la mayor parte del backend (49 de los 55 commits), incluyendo la API de incidencias, categorías y distritos, la seguridad con JWT y roles, el perfil de usuario y la configuración con Docker.
- Otros integrantes del grupo: contribuciones puntuales (ver Contributors).

## Estado del proyecto

Proyecto finalizado y funcional. Se desarrolló como trabajo del curso Arquitectura de aplicaciones web en la UPC y quedó concluido al terminar el ciclo.
