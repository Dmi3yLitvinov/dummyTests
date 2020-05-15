package dummy.service;

import dummy.dao.PersonRepository;
import dummy.model.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PersonServiceTest {

    @InjectMocks
    private PersonService personService;
    @Mock
    private PersonRepository personRepository;

    @Test
    public void canVote_expectTrue_test() {
        Long id = 1L;
        Person twentyYearsOldMan = getPerson(id, LocalDate.now().minus(20, ChronoUnit.YEARS));
        when(personRepository.findOne(id)).thenReturn(twentyYearsOldMan);

        boolean canVote = personService.canVote(id);

        assertTrue(canVote);
    }

    @Test
    public void canVote_expectFalse_test() {
        Long id = 1L;
        Person sixteenYearsOldMan = getPerson(id, LocalDate.now().minus(16, ChronoUnit.YEARS));
        when(personRepository.findOne(id)).thenReturn(sixteenYearsOldMan);

        boolean canVote = personService.canVote(id);

        assertFalse(canVote);
    }

    private Person getPerson(Long id, LocalDate localDate) {
        Person person = new Person();
        person.setId(id);
        person.setName("Name");
        person.setSurname("Surname");
        person.setDateOfBirth(localDate);
        return person;
    }
}
