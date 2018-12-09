package gon.study.springboot.commweb;

import gon.study.springboot.commweb.repository.BoardRepository;
import gon.study.springboot.commweb.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CommWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(CommWebApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner(BoardRepository boardRepository,
                                    UserRepository userRepository) {
        return (args) -> {

        };
    }
}
