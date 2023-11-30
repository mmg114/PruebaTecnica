# Prueba Tecnica

### Como Ejecutar la app

La app esta construida sobre java 21 y para ejecutarla se puede 

* java -jar PruebaTecnica-0.0.1-SNAPSHOT.jar

Para generar el jar se puede realizar descargando el codigo y compilandolo con el siguiente comando

* mvn install

Este se debe ejecutar en la carpeta del proyecto el cual generara una carpeta llamada tarjet la cual dentro de esta se
encontrara el arhivo

### Swagger 

al desplegar la app el swagger se podra acceder en la siguiente url 

* http://localhost:8080/swagger-ui/index.html

### H2
NOTA: la base de datos se ejecuta solo al correr la app por el comando spring.jpa.hibernate.ddl-auto=create

A la base de datos pueden acceder con el siguiente enlace y el usuario y password son los siguientes

* Driver Class:org.h2.Driver
* JDBC URL:jdbc:h2:mem:PruebaTecnica
* User Name:Mauricio
* Password:920929

http://localhost:8080/h2-console/login.jsp
