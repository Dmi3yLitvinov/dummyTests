package dummy.dao;

import dummy.psql.DummyPostgreSQLContainer;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("postgres")
public class PostgresRepositoryTest {

    @Autowired
    private PersonRepository personRepository;

    @ClassRule
    public static DummyPostgreSQLContainer container = DummyPostgreSQLContainer.getInstance();

    @Test
    public void testHelloWorld(){
        String helloWorld = personRepository.executePSQL();
        assertEquals("Hello, World!", helloWorld);
    }

}
