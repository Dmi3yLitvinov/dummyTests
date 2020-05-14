package dummy.dao;

import dummy.model.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ParsonRepositoryTest {

    @Autowired
    private ParsonRepository personRepository;

    @Test
    public void addTest(){
        Long id = 1L;
        Person person = getPerson(1L);
        personRepository.save(person);
        Person one = personRepository.findOne(id);
        System.out.println(one);
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
