package org.example.api_rest;

import lombok.*;

@Data @Builder @NoArgsConstructor @AllArgsConstructor

public class Voiture {
    private int id;
    private String marque;
    private int anneeFab;
    private String couleur;
}