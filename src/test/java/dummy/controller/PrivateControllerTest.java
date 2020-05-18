package dummy.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import dummy.model.Person;
import dummy.service.PersonService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.net.URI;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@RunWith(SpringRunner.class)
@WebMvcTest(PrivateController.class)
public class PrivateControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private PersonService personService;
    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    @WithMockUser(username = "user", roles = "USER")
    public void requestPerson() throws Exception {
        Long id = 1L;
        Person person = getPerson(id);
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get(URI.create("/protected/person/1"));
        Mockito.when(personService.findPerson(id))
                .thenReturn(getPerson(id));
        mockMvc.perform(request)
                .andExpect(content().string(objectMapper.writeValueAsString(person)));
    }

    private Person getPerson(Long id) {
        Person person = new Person();
        person.setId(id);
        person.setName("name");
        person.setSurname("surname");
        return person;
    }

}
