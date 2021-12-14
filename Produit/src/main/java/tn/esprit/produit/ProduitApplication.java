package tn.esprit.produit;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import tn.esprit.produit.Produit;
import tn.esprit.produit.ProduitRepository;

import java.util.stream.Stream;

@SpringBootApplication
@EnableEurekaClient
public class ProduitApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProduitApplication.class, args);
    }
    @Bean
    ApplicationRunner init(ProduitRepository repository) {
        return args -> {
            Stream.of("Mariem", "Sarra", "Mohamed").forEach(nom -> {
                repository.save(new Produit(nom));
            });
            repository.findAll().forEach(System.out::println);
        };
    }

}
