package sked.ecommerce;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "sked.ecommerce.repository")
public class Streamline{

    public static void main(String[] args) {
        SpringApplication.run(Streamline.class, args);
    }

    }



