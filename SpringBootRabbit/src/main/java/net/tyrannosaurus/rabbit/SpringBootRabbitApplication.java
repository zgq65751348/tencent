package net.tyrannosaurus.rabbit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"net.tyrannosaurus.rabbit.*","net.tyrannosaurus.common.*"})
public class SpringBootRabbitApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootRabbitApplication.class,args);
    }
}
