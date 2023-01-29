package br.com.architectureprototype.domain.customer;

import java.time.LocalDate;

public class Customer {

    private String id;
    private String name;
    private LocalDate birthDate;
    private String city;
    private String cpf;

    public Customer(String id, String name, LocalDate birthDate, String city, String cpf) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.city = city;
        this.cpf = cpf;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getCity() {
        return city;
    }

    public String getCpf() {
        return cpf;
    }

}
