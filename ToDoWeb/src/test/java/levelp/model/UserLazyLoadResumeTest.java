package levelp.model;

import levelp.config.ApplicationConfig;
import levelp.config.EmbeddedDataSourceConfig;
import levelp.config.JpaConfig;
import levelp.config.NoCsrfSecurityConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.transaction.Transactional;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("test")
@WebAppConfiguration
@ContextConfiguration(classes = {
        ApplicationConfig.class,
        EmbeddedDataSourceConfig.class,
        JpaConfig.class,
        NoCsrfSecurityConfig.class
})
public class UserLazyLoadResumeTest {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ContactRepository contactRepository;

    /**
     * При LAZY загрузке загружаются только необходимые данные
     * При EAGER зазгузке загружаются сразу все связанные данные
     */
    @Test
    @Transactional
    public void testLazyResumeLoad() {
        User user = userRepository.findByEmail("1@ya.ru");
        assertNotNull(user);
    }

    @Before
    public void aVoid() {
        User user = userRepository.findByEmail("1@ya.ru");
        if (user == null) {
            User user1 = new User();
            user1.setEmail("1@ya.ru");
            user1.setPassword("password");
            userRepository.save(user1);
        }
    }

    @Test
    @Transactional
    //@Rollback(false) // Чтобы изменения по окончанию теста
    public void testAddContact() {
        User user = userRepository.findByEmail("1@ya.ru");
        assertNotNull(user);
    }
}
