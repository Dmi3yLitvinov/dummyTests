package dummy.service;

import dummy.dao.PersonRepository;
import dummy.model.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;

    public static final int VOTE_AGE = 18;

    public boolean canVote(Long personId) {
        Person person = personRepository.findOne(personId);
        LocalDate minDateOfBirth = LocalDate.now().minus(VOTE_AGE, ChronoUnit.YEARS);
        return person.getDateOfBirth().isBefore(minDateOfBirth);
    }

    public Person findPerson(Long personId) {
        return personRepository.findOne(personId);
    }
}
