# API-REST-SPRING-BOOT-MYSQL

Se muestra el desarrollo de una  API Rest, utilizando el framework Spring Boot y una base de datos correspondiente a MySQL.

Dicha API Rest brinda los diferentes servicios requeridos para llevar una agenda de forma adecuada en la asignación de citas en un laboratorio. Servicios como crear (POST), modificar (PUT), listar (GET) (general o mediante ID) y eliminar (DELETE) afiliado, exámenes y citas. Adicionalmente se ofrece un filtrado de citas por afiliado (GET BY ID) y por fecha de asignación (GET BY DATE). 

Las respectivas validación de la API Rest se llevaron a cabo en [Postman](https://www.postman.com/). El proyecto está a disposición de ser probado de forma directa en dicha plataforma.

Los endpoints establecidos para cada uno de los servicios se muestran acontinuación (se asume un servidor local asignado por defecto mediante Spring Boot, ubicado en el puerto 8080):

- [x] Afiliados:

  - Método POST: `localhost:8080/api/Affiliate`. Este recibe como parámetro una estructura de tipo JSON, como se muestra:
    
    ```
    {
      "name": "Afiliado 1",
      "age": 22,
      "mail": "afiliado1@correo.com"
    }
    ```
    
  - Método GET (general): `localhost:8080/api/Affiliate`. Este muestra una lista genral del total de afiliados registrados.
  
  - Método GET (por ID de afiliado): `localhost:8080/api/Affiliate?affiliateID=xxx`. Este recibe como parámetro el ID de un afiliado y muestra sus respectivos atributos.
  
  - Método PUT: `localhost:8080/api/Affiliate`. Este recibe como parámetro una estructura de tipo JSON, como se muestra:
    
    ```
    {
      "id_affiliate: 1,
      "name": "Afiliado 1",
      "age": 22,
      "mail": "afiliado1@correo.com"
    }
    ```
 
