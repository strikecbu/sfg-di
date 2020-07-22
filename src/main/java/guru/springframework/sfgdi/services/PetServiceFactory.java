package guru.springframework.sfgdi.services;


public class PetServiceFactory {

    public PetService createService(String pet) {
        switch (pet) {
            case "dog":
                return new DogPetService();
            case "cat":
                return new CatPetService();
            default:
                throw new IllegalArgumentException();
        }
    }

}
