package dummy.dao;

import dummy.model.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

    @Query(value = "select format('Hello, %s!', 'World')", nativeQuery = true)
    String executePSQL();
}
