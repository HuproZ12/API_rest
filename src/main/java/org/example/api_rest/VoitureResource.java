package org.example.api_rest;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("/voiture")
public class VoitureResource {
    private final VoitureService voitureService;

    @Inject
    public VoitureResource(VoitureService voitureService){
        this.voitureService = voitureService;
    }

    @POST @Path("/create") @Consumes(MediaType.APPLICATION_JSON) @Produces(MediaType.TEXT_PLAIN)
    public String create(Voiture voiture){
        voitureService.create(voiture);
        return "Voiture ajoutée !";
    }

    @GET @Path("/read") @Produces(MediaType.APPLICATION_JSON)
    public List<Voiture> read(){
        return voitureService.read();
    }

    @GET @Path("/read/{id}") @Produces(MediaType.APPLICATION_JSON)
    public Voiture readById(@PathParam("id") int id){
        return voitureService.readById(id);
    }

    @PUT @Path("/update/{id}") @Consumes(MediaType.APPLICATION_JSON) @Produces(MediaType.TEXT_PLAIN)
    public String update(@PathParam("id") int id, Voiture voiture) {
        Voiture updatedVoiture = voitureService.update(id, voiture);
        if (updatedVoiture != null) {
            return "Voiture mise à jour !";
        } else {
            return "Voiture non trouvée !";
        }
    }

    @DELETE @Path("/delete/{id}")
    public String delete(@PathParam("id") int id){
        voitureService.delete(id);
        return "Voiture supprimée !";
    }
}
