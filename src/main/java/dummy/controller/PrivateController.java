package dummy.controller;

import dummy.model.Person;
import dummy.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/protected/person")
@RequiredArgsConstructor
public class PrivateController {

    private final PersonService personService;

    @GetMapping("/{personId}")
    public ResponseEntity<Person> getAnyPerson(@PathVariable Long personId) {
        return ResponseEntity.ok(personService.findPerson(personId));
    }

}
