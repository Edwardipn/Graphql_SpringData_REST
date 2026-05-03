# Graphql_SpringData_REST
LaTecnologiaAvanza

Configuración necesaria para GraphiQL en Spring Boot

Dependencia → spring-boot-starter-graphql
Propiedad → spring.graphql.graphiql.enabled=true
Schema → Archivo src/main/resources/graphql/schema.graphqls con definiciones de tipos (solo type, no operaciones)
Controller → Clase @Controller con métodos @QueryMapping
Query en schema → Definir en .graphqls los mismos métodos del @Controller
Tipos válidos → Cada campo debe tener tipo definido (String, Int, Float, Boolean, ID o tipos personalizados)
(Opcional) Logs debug → logging.level.org.springframework.graphql=DEBUG

http://localhost:8080/graphiql?path=/graphql

sube src/, pom.xml, .gitignore y README.md; y el proyecto debe ser Spring web