In order to avoid 1+N queries in Spring Data JPA repository methods when we want 
to get associated entities, we can use the @EntityGraph annotation:
 
 	@EntityGraph(attributePaths = "cars")
 	@Override
 	List<Person> findAll();

or use the `join fetch` when explicitly writing a query:   

	@Query("select p from Person p left join fetch p.cars")
	List<Person> findWithQuery();

But in this case we get duplicate number of 'parent' entities in the returned List<Person>.

To work around this issue we can use 'distinct' in the method name or in the query, for example:

	@EntityGraph(attributePaths = "cars")
	List<Person> findDistinctBy();

	@Query("select distinct p from Person p left join fetch p.cars")
	List<Person> findDistinctWithQuery();

But with projections the last example still does not work and throw 
the exception `InvalidDataAccessApiUsageException: No aliases found in result tuple!`:

	@Query("select distinct p from Person p left join fetch p.cars")
	List<PersonProjection> findDistinctProjectionsWithQuery();

To run this demo type: 

    mvn spring-boot:run -Drun.jvmArguments="-Dspring.profiles.active=dev" 

Then request (see `PersonController` class for the 'type' options):

    GET http://localhost:8080/people                - to invoke findAll() method
    GET http://localhost:8080/people?type=distinct  - to invoke findDistinctBy() method, etc...
    
See tests of all methods in `PersonRepoTest` class.