package crud.api.springstudy.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("local")
public class LocalConfig {

//    @Autowired
//    private UserRepository userRepository;
//
//    @Bean
//    public void startDB() {
//        User u1 = new User(null, "João Geraldo", "joaogeraldo40@gmail.com", "12345");
//        User u2 = new User(null, "Borges Sales", "borgessales@gmail.com", "12345");
//
//        userRepository.saveAll(List.of(u1, u2));
//    }
}
