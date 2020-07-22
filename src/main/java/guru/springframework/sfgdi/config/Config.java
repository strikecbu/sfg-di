package guru.springframework.sfgdi.config;

import guru.springframework.sfgdi.services.CatPetService;
import guru.springframework.sfgdi.services.DogPetService;
import guru.springframework.sfgdi.services.PetServiceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration
public class Config {

    @Bean
    public PetServiceFactory petServiceFactory() {
        return new PetServiceFactory();
    }

    @Bean
    @Profile("cat")
    public CatPetService catPetService(PetServiceFactory petServiceFactory) {
        return (CatPetService)petServiceFactory.createService("cat");
    }

    @Bean
    @Profile({"dog", "default"})
    @Primary
    public DogPetService dogPetService(PetServiceFactory petServiceFactory) {
        return (DogPetService)petServiceFactory.createService("dog");
    }


}
