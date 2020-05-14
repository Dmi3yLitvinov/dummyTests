package dummy.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@Entity
public class Person {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String surname;
    private LocalDate dateOfBirth;
}
