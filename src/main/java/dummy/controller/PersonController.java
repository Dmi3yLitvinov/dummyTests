package dummy.controller;

import dummy.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/person")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @GetMapping("/{personId}/canVote")
    public ResponseEntity<Boolean> canVote(@PathVariable Long personId) {
        boolean canVote = personService.canVote(personId);
        return ResponseEntity.ok(canVote);
    }
}
