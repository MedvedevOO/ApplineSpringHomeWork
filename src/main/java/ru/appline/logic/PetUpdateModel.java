package ru.appline.logic;

public class PetUpdateModel {

    /*
    {
    "id" : 3,
    "updatedPet":
        {
            "name": "Masha",
            "type": "cat",
            "age": 2221
        }
}
     */

    private int id;

    private Pet updatedPet;

    public PetUpdateModel(int id, Pet updatedPet) {
        this.id = id;
        this.updatedPet = updatedPet;
    }

    public PetUpdateModel() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Pet getUpdatedPet() {
        return updatedPet;
    }


    public void setUpdatedPet(Pet updatedPet) {
        this.updatedPet = updatedPet;
    }
}
