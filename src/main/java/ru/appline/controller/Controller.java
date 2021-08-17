package ru.appline.controller;

import jdk.internal.org.objectweb.asm.tree.analysis.Value;
import org.springframework.web.bind.annotation.*;
import ru.appline.logic.Pet;
import ru.appline.logic.PetModel;
import ru.appline.logic.PetUpdateModel;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class Controller {
    private  static  final PetModel petModel = PetModel.getInstance();
    private static final AtomicInteger newId = new AtomicInteger(1);

    @PostMapping(value = "/createPet", consumes = "application/json", produces = "text/html")
    public String createPet(@RequestBody Pet pet) {
        String reply;
        if (newId.get() == 1) {
            reply = "Поздравляем с вашим первым питомцем!";
        }
        else {
            reply = "Питомец успешно создан!";
        }

        petModel.add(pet,newId.getAndIncrement());

        return reply;
    }

    @GetMapping(value = "/getAll", produces = "application/json")
    public Map<Integer, Pet> getAll() {
        return petModel.getAll();
    }

    /*
        {
            "id" : 3
        }
     */
    @GetMapping(value = "/getPet", consumes = "application/json", produces = "application/json")
    public Pet getPet(@RequestBody Map<String,Integer> id) {
        return petModel.getFromList(id.get("id"));
    }

    @DeleteMapping(value = "/remPet", consumes = "application/json", produces = "text/html")
    public String removePet(@RequestBody Map<String,Integer> id) {
        petModel.remove(id.get("id"));
        return "Питомца больше нет:(";
    }

    @PutMapping(value = "/updPet", consumes = "application/json", produces = "text/html")
    public String updatePet(@RequestBody PetUpdateModel petData) {
        petModel.add(petData.getUpdatedPet(),petData.getId());

        return "Питомец успешно изменен!";
    }
}
