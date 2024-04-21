package com.covinoc.crud.adapter.api.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.covinoc.crud.domain.model.Client;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class ClientDto {
    private  int idClient;
    private String identificationType;

    private String idenNumber;
    @Size(min=2,message = "The name field must have at least two characters")
    private String firstName;
    @NotEmpty
    @Size(min=2,message = "The last name field must have at least two characters")
    private String lastName;
    @Email(message = "has not been entered in the proper format")
    private String email;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;
    private LocalDateTime creationDate;
    private LocalDateTime modificationDate;

    public ClientDto(int idClient, String identificationType, String idenNumber, String firstName, String lastName,
                     String email, LocalDate birthDate, LocalDateTime creationDate, LocalDateTime modificationDate) {
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
    public Client getClientDto(){
        return new Client(
                this.idClient,
                this.identificationType,
                this.idenNumber,
                this.firstName,
                this.lastName,
                this.email,
                this.birthDate,
                this.creationDate,
                this.modificationDate
        );
    }
    public  static ClientDto of(Client client){
        return new ClientDto(
                client.getIdClient(),
                client.getIdentificationType(),
                client.getIdenNumber(),
                client.getFirstName(),
                client.getLastName(),
                client.getEmail(),
                client.getBirthDate(),
                client.getCreationDate(),
                client.getModificationDate()
        );
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
