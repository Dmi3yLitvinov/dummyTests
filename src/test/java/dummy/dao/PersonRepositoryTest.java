package dummy.dao;

import dummy.model.Person;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonRepositoryTest {

    @Autowired
    private PersonRepository personRepository;

    @Before
    public void init() {
        Person person = getPerson(1L);
        personRepository.save(person);
    }

    @Test
    public void addTest(){
        Long id = 1L;
        Person one = personRepository.findOne(id);
        assertEquals(id, one.getId());
    }

    private Person getPerson(Long id) {
        Person person = new Person();
        person.setId(id);
        person.setName("Name");
        person.setSurname("Surname");
        person.setDateOfBirth(LocalDate.now().minus(20, ChronoUnit.YEARS));
        return person;
    }
}
