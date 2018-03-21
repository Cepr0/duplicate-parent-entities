## Spring Data JPA - duplicated parent entities in 'join fetch' repository query methods 

Repository query methods with 'join fetch' leads to the duplicate parents.
Number of duplicates corresponds to number of nested children.

To workaround this situation we can use 'distinct' in the query.
But this still does not work with projection.

The similar methods with `@EntityGraph` work as expected.

Example:

```java
@Entity
class Parent extends BaseEntity {
	private String name;
	@OneToMany(mappedBy = "parent")
	private List<Child> children;
}

@Entity
class Child extends BaseEntity {
	private String name;
	@ManyToOne(fetch = LAZY)
	private Parent parent;
}

interface ParentProjection {
	Integer getId();
	String getName();
	List<Child> getChildren();
}

interface ParentRepo extends JpaRepository<Parent, Integer> {

	@EntityGraph(attributePaths = "children")
	@Override
	List<Parent> findAll(); // work as expected 

	@Query("select p from Parent p left join fetch p.children")
	List<Parent> findWithQuery(); // has duplicated parents
	
	@Query("select distinct p from Parent p left join fetch p.children")
   	List<Parent> findDistinctWithQuery(); // does not have duplicated parents
	
	@EntityGraph(attributePaths = "children")
	List<ParentProjection> findProjectionsBy(); // work as expected
		
	@Query("select distinct p from Parent p left join fetch p.children")
   	List<ParentProjection> findDistinctProjectionsWithQuery(); // has duplicated parents 
}
```   
    
More tests is ![here](src/test/java/io/github/cepr0/demo/repo/ParentRepoTest.java).