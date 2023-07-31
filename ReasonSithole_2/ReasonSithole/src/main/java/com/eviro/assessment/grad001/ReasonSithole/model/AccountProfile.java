package com.eviro.assessment.grad001.ReasonSithole.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter //reducing boilerplate code
@Setter
@Entity
public class AccountProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String surname;
    private String imageFormat;
    private byte[] imageData; // Binary data of the image



    public AccountProfile(String name, String surname, String imageFormat, byte[] imageData) {
        this.name = name;
        this.surname = surname;
        this.imageFormat = imageFormat;
        this.imageData = imageData;
    }


    // Default Constructor
    public AccountProfile() {
    }


}
