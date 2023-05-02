# JPA y Spring data

### Swagger url

http://localhost:8080/swagger-ui/index.html#

## ORM 
La traducción de modelo relacional a objetos Java se conoce como ORM. a través de JPA (Java Persistence Api) un desarrollador puede guardar, obtener, actualizar y mapear información en base de datos a través de objetovs Java.

## JPA (Java Persistence Api)
JPA es una especificación que contiene múltiples implementaciones, las más populares son:
- Hibernate
- EclipseLink
- TopLink

## Entity
Una entidad es una clase cuyos objetos serás persistidos en base de datos, se creará una entidad para representar una tabla, cada instancia de la clase será un registro de la base de datos, a continuación algunas anotaciones importantes:
- @Entity: Se aplica en clases e indica que la clase será una entidad
- @Table: Se aplica en clases e indica el nombre de la tabla que se va a mapear
- @Id: Se aplica a atributos e indica que el campo será la llave primaria.
- @GeneratedValue: Se aplica en llaves primarias e indica la forma en la que se generarán.

## Relaciones
JPA permite realizar las siguientes relaciones entre entidades:
- @OneToOne
- @ManyToOne
- @ManyToMany

## Spring data
Spring data permite tomar el patrón de diseño DAO (Data Access Object), en Spring data el principal componente es el Repository y sus principales interfaces son:
- CrudRepository
- PagingAndSortingRepository, provee toda la info de CrudRepository más los métodos findAll(Sort sort) y findAll(Pageable p)
- JpaRepository, provee toda la info de PagingAndSortingRepository más List<T> findAll(), findAll(Sort sort), flush(), saveAndFlush() y deleteInBatch()

Al crear una interface que herede de ellas se tendrá una implementación de un DAO con los métodos básicos para implementar un CRUD (Create, Read, Update y Delete).

Spring data no sólo soporta JPA, también se puede utilizar con:
- LDAP
- MongoDB
- Redis
- REST
- Cassandra
- Solr
- Couchbase
- ElasticSearch
- etc.

## Query methods
En caso de que la operación que se desea realizar no se encuentre disponible en los métodos heredados del repositorio, se deberá definir un método como los siguientes:
- find...By...()
- read...By...()
- query...By...()
- count...By...()
- get...By...()

Es posible agregar cláusulas como distinct, condiciones que incluyan And y Or. By actua como delimitador para especificar el campo.

### Ejemplos de query methods
- findByEmailAndLastName(String email, String lastName)
- findDistinctNameByFirstName(String firstName)
- findByFirstNameOrLastName(String firstName, String lastName)
- findByFirstNameIgnoreCase(String firstName)
- findByFirstNameAsc(String firstName)
- findByFirstNameDesc(String firstName)

No es necesario implementar los métodos, al seguir la convención d enombres, Spring data creará la implementación por nosotros.

- Las operaciones se pueden concatenar, así que se pueden utilizar múltiples AND y OR. También soporta el uso de operadores como Between, LessThan, GreaterThan y Like.
- Los métodos soportan IgnoreCase para propiedades individuales
- Es posible aplicar un ordenamiento agregando OrderBy. En ese caso, es posible incluir Asc o Desc.
- Es posible limitar el número de resultados utilizando first y top. Por ejemplo: findFirstByFirst10Name(String firstName), findTop3ByFirstName(String firstName)

## Customer queries
Si se desea ejecutar una query que no esté soportada por query method, es posible utilizar la anotación @Query
