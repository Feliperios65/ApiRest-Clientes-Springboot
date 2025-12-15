# ☕ ApiRest-Clientes-Springboot

**Una API RESTful robusta creada con Spring Boot para una gestión eficiente de clientes.**

</div>

## 📖 Descripción

Este proyecto proporciona una API RESTful integral para la gestión de la información de clientes. Desarrollada con Spring Boot, ofrece una solución backend sólida para aplicaciones que requieren un almacenamiento y recuperación fiables de datos de clientes, como sistemas CRM, plataformas de comercio electrónico o herramientas de gestión de servicios. La API prioriza una arquitectura limpia, lo que facilita su integración con diversas aplicaciones frontend.

## ✨ Caracteristicas

- 🎯 **Operaciones CRUD de cliente**: Funcionalidad completa de creación, lectura, actualización y eliminación para entidades cliente.
- 🔒 **Persistencia de datos**: Almacenamiento de datos robusto, generalmente gestionado mediante Spring Data JPA.
- 🌐 **Interfaz RESTful**: Métodos HTTP estándar (GET, POST, PUT, DELETE) para la interacción con recursos.
- ⚙️ **Configurable**: Propiedades de la aplicación fáciles de administrar para la base de datos, el puerto del servidor y otros ajustes.
- 🧪 **Arquitectura comprobable**: Diseñada para facilitar el mantenimiento y las pruebas unitarias y de integración.

## 🛠️ Tech Stack

**Backend:**

[![Java](https://img.shields.io/badge/Java-007396?style=for-the-badge&logo=java&logoColor=white)](https://www.java.com/)

[![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)](https://spring.io/projects/spring-boot)

[![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white)](https://maven.apache.org/)

**Database:**
*
    [![Spring Data JPA](https://img.shields.io/badge/Spring_Data_JPA-6DB33F?style=for-the-badge&logo=spring&logoColor=white)](https://spring.io/projects/spring-data-jpa)
    <!-- TODO: Detect and add specific database badge like MySQL, PostgreSQL, or H2 -->

## 🚀 Inicio rápido

### Requisitos previos
- **Java Development Kit (JDK)**: Versión 8 o superior.
- **Maven**: Versión 3.6 o superior (opcional si se usa Maven Wrapper).
- **Base de datos**: Una instancia de una base de datos relacional (p. ej., MySQL, PostgreSQL o una base de datos H2 integrada).

### Instalación

1.  **Clonar el repositorio**
    ```bash
    git clone https://github.com/Feliperios65/ApiRest-Clientes-Springboot.git
    cd ApiRest-Clientes-Springboot
    ```

2.  **Construye el proyecto**
Usa Maven Wrapper para garantizar compilaciones consistentes sin una instalación global de Maven:
    ```bash
    ./mvnw clean install
    # On Windows:
    # mvnw.cmd clean install
    ```
    Este comando compila el código fuente, ejecuta pruebas y empaqueta la aplicación en un archivo JAR.

3. **Configuración del entorno**
Cree un archivo `application.properties` o `application.yml` en `src/main/resources/` si no existe, o actualice el existente.
    ```properties
    # src/main/resources/application.properties
    server.port=8080

    # Database Configuration (Example for H2 - adjust for MySQL/PostgreSQL)
    spring.datasource.url=jdbc:h2:mem:clientdb
    spring.datasource.username=sa
    spring.datasource.password=
    spring.datasource.driver-class-name=org.h2.Driver
    spring.jpa.hibernate.ddl-auto=update # options: none, update, create, create-drop
    spring.jpa.show-sql=true
    spring.jpa.properties.hibernate.format_sql=true
    ```
    <!-- TODO: Provide a `.env.example` or detailed `application.properties` example if more complex configurations exist. -->

4. **Configuración de la base de datos** (si corresponde)
Si utiliza una base de datos externa (p. ej., MySQL, PostgreSQL), asegúrese de que su servidor de base de datos esté en ejecución y que los detalles de conexión en `application.properties` sean correctos. Spring Data JPA puede crear/actualizar automáticamente el esquema basándose en sus entidades si `spring.jpa.hibernate.ddl-auto` está configurado como `update` o `create`.

5.  **Iniciar el servidor de desarrollo**
    ```bash
    ./mvnw spring-boot:run
    # On Windows:
    # mvnw.cmd spring-boot:run
    ```

6.  **Acceder a la API**
La API se ejecutará en `http://localhost:[puerto detectado, predeterminado 8080]`.


## ⚙️ Configuración

### Application Properties
El archivo de configuración principal es `src/main/resources/application.properties` (o `application.yml`). Aquí puede definir:

| Propiedad | Descripción | Predeterminado | Obligatorio |

|----------|-------------|-------------|----------|

| `server.port` | El puerto en el que se ejecutará la aplicación Spring Boot. | `8080` 

| `spring.datasource.url` | URL JDBC para la conexión a la base de datos. 

| `spring.datasource.username` | Nombre de usuario para acceder a la base de datos.

| `spring.datasource.password` | Contraseña para acceder a la base de datos.

| `spring.jpa.hibernate.ddl-auto` | Estrategia DDL (Lenguaje de Definición de Datos) de Hibernate. `update` es común para desarrollo.

| `spring.jpa.show-sql` | Si se registran las sentencias SQL.

### Archivos de configuración
- `pom.xml`: Define las dependencias del proyecto, los complementos de compilación y los metadatos del proyecto.
- `application.properties`: Configuración principal de Spring Boot para los ajustes de ejecución.


## 📚 API Reference


La API proporciona puntos de conexión para gestionar los datos de los clientes. Todos los puntos de conexión tienen el prefijo `/api`.

### Puntos de conexión

#### Recuperar todos los clientes
`GET /api/v1/cliente`

**Response Example (200 OK):**
```json
[
  {
    "id": 1,
    "firstName": "John",
    "lastName": "Doe",
    "email": "john.doe@example.com",
    "createdAt": "2025-01-01T10:00:00Z"
  },
  {
    "id": 2,
    "firstName": "Jane",
    "lastName": "Smith",
    "email": "jane.smith@example.com",
    "createdAt": "2025-01-02T11:00:00Z"
  }
]
```

#### Recuperar un cliente por ID
`GET /api/v1/cliente/{id}`

**Response Example (200 OK):**
```json
{
  "id": 1,
  "firstName": "John",
  "lastName": "Doe",
  "email": "john.doe@example.com",
  "createdAt": "2025-01-01T10:00:00Z"
}
```
**Response Example (404 Not Found):**
```json
{
  "timestamp": "2025-01-01T12:30:00.000+00:00",
  "status": 404,
  "error": "Not Found",
  "message": "Client not found with ID: 123",
  "path": "/api/v1/clients/123"
}
```

#### Create un nuevo cliente
`POST /api/v1/cliente`

**Request Body:**
```json
{
  "firstName": "Alice",
  "lastName": "Johnson",
  "email": "alice.j@example.com"
}
```

**Response Example (201 Created):**
```json
{
  "id": 3,
  "firstName": "Alice",
  "lastName": "Johnson",
  "email": "alice.j@example.com",
  "createdAt": "2025-01-03T14:00:00Z"
}
```

#### Actualizar un cliente existente
`PUT /api/v1/cliente/{id}`

**Request Body:**
```json
{
  "firstName": "Alicia",
  "lastName": "Johnson",
  "email": "alicia.j@example.com"
}
```

**Response Example (200 OK):**
```json
{
  "id": 3,
  "firstName": "Alicia",
  "lastName": "Johnson",
  "email": "alicia.j@example.com",
  "createdAt": "2025-01-03T14:00:00Z"
}
```
**Response Example (404 Not Found):**
```json
{
  "timestamp": "2025-01-01T12:30:00.000+00:00",
  "status": 404,
  "error": "Not Found",
  "message": "Client not found with ID: 123",
  "path": "/api/v1/clients/123"
}
```

#### Eliminar Cliente por ID
`DELETE /api/v1/cliente/{id}`


**Response Example (204 No Content):**

*(No se devuelve ningún contenido del cuerpo en caso de eliminación exitosa)*

**Response Example (404 Not Found):**
```json
{
  "timestamp": "2025-01-01T12:30:00.000+00:00",
  "status": 404,
  "error": "Not Found",
  "message": "Client not found with ID: 123",
  "path": "/api/v1/clients/123"
}
```

<div align="center">

**⭐ ¡Marca este repositorio con una estrella si te resulta útil!**

Hecho con ❤️ por Feliperios65

</div>
