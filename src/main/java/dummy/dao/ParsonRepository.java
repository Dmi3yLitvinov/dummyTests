package dummy.dao;

import dummy.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParsonRepository extends CrudRepository<Person, Long> {
}
