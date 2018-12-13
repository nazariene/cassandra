package jar;

import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRest {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/test")
    public String getUsers() {
        StringBuilder sb = new StringBuilder();
        userRepository.findAll().forEach(item -> sb.append(item + "\n"));
        return sb.toString();
    }

    @PostMapping("/test")
    @Transactional
    public void addUser() {
        int randomSeed = ThreadLocalRandom.current().nextInt();
        UserEntity newUser = new UserEntity(randomSeed, "family" + randomSeed, "given" + randomSeed, "prof" + randomSeed);
        userRepository.save(newUser);
    }
}
