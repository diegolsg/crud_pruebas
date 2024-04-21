package com.covinoc.crud.adapter.daos.Entities;

import com.covinoc.crud.domain.model.Client;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "client")
public class ClientEntity {
    @Id
    @Column(name = "id_client")
    private  Integer idClientEntity;
    @Column(name = "identification_type")
    private String identificationTypeEntity;
    @Column(name = "identification_number")
    private String identificationNumberEntity;
    @Column(name = "first_name")
    private String firstNameEntity;

    @Size(min = 2)
    @Column(name = "last_name")
    private String lastNameEntity;
    @Email(message = "has not been entered in the proper format")
    @Column(name = "email")
    private String emailEntity;
    @Column(name = "birth_date")
    private LocalDate birthDateEntity;
    @Column(name = "creation_date")
    private LocalDateTime creationDateEntity;
    @Column(name = "modification_date")
    private LocalDateTime modificationDateEntity;
    @OneToMany(mappedBy = "clientEntity",cascade = {CascadeType.ALL})
    private List<AccountEntity> accountEntities;


    public ClientEntity() {
    }

    public ClientEntity(Integer idClientEntity, String identificationTypeEntity, String identificationNumberEntity,
                        String firstNameEntity, String lastNameEntity, String emailEntity, LocalDate birthDateEntity,
                        LocalDateTime creationDateEntity, LocalDateTime modificationDateEntity) {
        this.idClientEntity = idClientEntity;
        this.identificationTypeEntity = identificationTypeEntity;
        this.identificationNumberEntity = identificationNumberEntity;
        this.firstNameEntity = firstNameEntity;
        this.lastNameEntity = lastNameEntity;
        this.emailEntity = emailEntity;
        this.birthDateEntity = birthDateEntity;
        this.creationDateEntity = creationDateEntity;
        this.modificationDateEntity = modificationDateEntity;
    }
    public Client getClient(){
        return new Client(
                this.idClientEntity,
                this.identificationTypeEntity,
                this.identificationNumberEntity,
                this.firstNameEntity,
                this.lastNameEntity,
                this.emailEntity,
                this.birthDateEntity,
                this.creationDateEntity,
                this.modificationDateEntity
        );
    }
    public  static ClientEntity of(Client client) {
        return new ClientEntity(
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

    public Integer getIdClientEntity() {
        return idClientEntity;
    }

    public void setIdClientEntity(Integer idClientEntity) {
        this.idClientEntity = idClientEntity;
    }

    public String getIdentificationTypeEntity() {
        return identificationTypeEntity;
    }

    public void setIdentificationTypeEntity(String identificationTypeEntity) {
        this.identificationTypeEntity = identificationTypeEntity;
    }

    public String getIdentificationNumberEntity() {
        return identificationNumberEntity;
    }

    public void setIdentificationNumberEntity(String identificationNumberEntity) {
        this.identificationNumberEntity = identificationNumberEntity;
    }

    public String getFirstNameEntity() {
        return firstNameEntity;
    }

    public void setFirstNameEntity(String firstNameEntity) {
        this.firstNameEntity = firstNameEntity;
    }

    public String getLastNameEntity() {
        return lastNameEntity;
    }

    public void setLastNameEntity(String lastNameEntity) {
        this.lastNameEntity = lastNameEntity;
    }

    public String getEmailEntity() {
        return emailEntity;
    }

    public void setEmailEntity(String emailEntity) {
        this.emailEntity = emailEntity;
    }

    public LocalDate getBirthDateEntity() {
        return birthDateEntity;
    }

    public void setBirthDateEntity(LocalDate birthDateEntity) {
        this.birthDateEntity = birthDateEntity;
    }

    public LocalDateTime getCreationDateEntity() {
        return creationDateEntity;
    }

    public void setCreationDateEntity(LocalDateTime creationDateEntity) {
        this.creationDateEntity = creationDateEntity;
    }

    public LocalDateTime getModificationDateEntity() {
        return modificationDateEntity;
    }

    public void setModificationDateEntity(LocalDateTime modificationDateEntity) {
        this.modificationDateEntity = modificationDateEntity;
    }

    public List<AccountEntity> getAccountEntities() {
        return accountEntities;
    }

    public void setAccountEntities(List<AccountEntity> accountEntities) {
        this.accountEntities = accountEntities;
    }
}
