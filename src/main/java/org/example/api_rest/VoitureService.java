package org.example.api_rest;

import jakarta.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class VoitureService {
    private List<Voiture> voitures = new ArrayList<>();

    public void create(Voiture voiture){
        voitures.add(voiture);
    }

    public List<Voiture> read(){
        return voitures;
    }

    public Voiture readById(int id){
        for(Voiture voiture : voitures){
            if(voiture.getId() == id){
                return voiture;
            }
        }
        return null;
    }

    public Voiture update(int id, Voiture voiture) {
        for (int i = 0; i < voitures.size(); i++) {
            if (voitures.get(i).getId() == id) {
                voitures.set(i, voiture);
                return voiture;
            }
        }
        return null;
    }

    public void delete(int id) {
        for (int i = 0; i < voitures.size(); i++) {
            if (voitures.get(i).getId() == id) {
                voitures.remove(i);
            }
        }
    }
}