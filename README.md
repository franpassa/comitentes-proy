## API Comitentes Proy

Plataforma diseñada para operaciones CRUD sobre Comitentes, Mercados y Paises.

## Funcionalidades y datos precargados

- Sobre los comitentes, se pueden realizar consultas, altas, bajas, modificaciones y eliminaciones de sus respectivos registros en la base de datos.
- Sobre los mercados, se pueden realizar consultas y altas de sus respectivos registros en la base de datos.
- Sobre los paises, solamente se pueden realizar consultas a la base de datos (se encuentran precargados y fijos los paises "Argentina" y "Uruguay").
- Además, hay un endpoint adicional "/stats", que trae la información del porcentaje de mercado que acapara cada una de las empresas en cada pais.

Al iniciar la aplicación se crearán las tablas con sus relaciones en una base de datos SQL. Los datos precargados se encuentran en la ruta del proyecto 'src\main\resources\data.sql'.
No se podrán crear elementos que se relacionen con otros elementos que no hayan sido creados previamente mientras la aplicación se encuentra corriendo o esten en los datos precargados.

## Requisitos previos

Para poder ejecutar la aplicación localmente son necesarios los siguientes requisitos:

- **Java Development Kit (JDK) 8 o superior:** *[Descargar](https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html)*
- **Maven:** *[Instalación](https://maven.apache.org/install.html)*
- **PostgreSQL:** *[Descargar](https://www.postgresql.org/download/)*

## Configuración de la base de datos

1. Crear una base de datos PostgreSQL local.
2. Modificar el archivo `application.properties` ubicado en `src/main/resources`, cambiando las variables de entorno que allí figuran por los datos de la base de datos local creada o en su defecto, cargar las variables de entorno en el sistema o IDE correspondiente.

## Ejecución local

1. **Clonar repositorio:**

   ```bash
   git clone https://github.com/tu_usuario/comitentes-app.git

2. **Navegar al directorio del proyecto:**

   ```bash
   cd comitentes-app

3. **Compilar proyecto utilizando Maven:**

   ```bash
   mvn clean package

4. **Ejecutar la aplicación Spring Boot:**

   ```bash
   java -jar target/comitentes-app-1.0-SNAPSHOT.jar

5. **Acceder a la aplicación por el navegador web:**
   
   - La aplicación estará disponible en la siguiente url:

   ```bash
   http://localhost:8080/swagger-ui/index.html

## Uso de aplicación desplegada en Render

- **Nota:** Luego de no usarse por mucho tiempo, la aplicación entra en stand-by, por lo tanto, hay que esperar a que el servidor responda por primera vez, esto puede demorar hasta 3 minutos.
El free-tier, proporciona mayor velocidad a mayor uso de la aplicación pero reduce los recursos considerablemente cuando no está en uso.

**La aplicación se encuentra disponible en la siguiente url:**

```bash
https://comitentes-proy.onrender.com/swagger-ui/index.html
   
