# NisumTest App


### Requisitos previos
Antes de comenzar, asegúrate de tener los siguientes requisitos previos instalados en tu sistema:

- Java Development Kit (JDK) 17.
- Maven 3.8.2

### Ejecutar la aplicación
Para ejecutar la aplicacion ejecutar este comando:

```bash
mvn spring-boot:run
```
 
### Base de datos
la aplicación corre con una base de datos H2 en memoria.

para ingresar a la consola de la base de datos, ingresar a este link desde el navegador

http://localhost:8080/h2

y usar estos datos para la conexion
- Driver Class: org.h2.Driver
- JDBC URL: jdbc:h2:~/nisum
- User Name: andrey
- Password: 123san

### Probar la aplicación
Despues de ejecutar la aplicación puedes usar este curl en postman para testear la api de creacion de usuario 

```text
curl --location 'http://localhost:8080/api/users' \
--header 'Accept: application/json' \
--header 'Content-Type: application/json' \
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhbmRyZXlAaG90bWFpbC5jb20iLCJpYXQiOjE2ODc2MzYxNDB9.x7_WN-T5Iqh9e7Eu_8zA9E5skszAdz-7-T-p-ZKAAog' \
--data-raw '{
    "name":"Andrey",
    "email":"andressy@hotmail.com",
    "password":"andrey123!",
    "phones":[
        {
            "number": "1234567",
            "cityCode": "1",
            "countryCode": "57"
            }
    ]
}'
```
la api requiere de auntenticación, asi que para poder consumir la aplicacion se requiere de un jwt 
que contenga el sub con el email de un usuario que este registrado en la base de datos y tenga estado activo, 
en este caso el usuario del token es ´andrey@hotmail.com´, el cual esta en la ingesta de datos
del archivo ´data.sql´ ubicado en el package de ´resources´y que contiene el script para la creación de las tablas
y la ingesta del usuario valido para testear.

### Correr unit test
Para ejecutar los test unitarios ejecutar este comando

```bash
mvn verify
```

### Documentacion con Swagger
Para ver la documentacion de la api en swagger, ingresar a este link en el navegador

http://localhost:8080/swagger-ui/index.html