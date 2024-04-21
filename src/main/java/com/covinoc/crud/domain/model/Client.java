package com.covinoc.crud.domain.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Client {
    private  int idClient;
    private String identificationType;
    private String idenNumber;
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate birthDate;
    private LocalDateTime creationDate;
    private LocalDateTime modificationDate;

    public Client(int idClient, String identificationType, String idenNumber, String firstName,
                  String lastName, String email, LocalDate birthDate, LocalDateTime creationDate,
                  LocalDateTime modificationDate) {
        this.idClient = idClient;
        this.identificationType = identificationType;
        this.idenNumber = idenNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.birthDate = birthDate;
        this.creationDate = creationDate;
        this.modificationDate = modificationDate;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getIdentificationType() {
        return identificationType;
    }

    public void setIdentificationType(String identificationType) {
        this.identificationType = identificationType;
    }

    public String getIdenNumber() {
        return idenNumber;
    }

    public void setIdenNumber(String idenNumber) {
        this.idenNumber = idenNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDateTime getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(LocalDateTime modificationDate) {
        this.modificationDate = modificationDate;
    }
}
