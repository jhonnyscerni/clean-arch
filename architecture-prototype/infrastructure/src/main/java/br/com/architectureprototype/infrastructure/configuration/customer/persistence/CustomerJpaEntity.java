package br.com.architectureprototype.infrastructure.configuration.customer.persistence;

import br.com.architectureprototype.domain.customer.Customer;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "customer")
@Table(name = "customer")
public class CustomerJpaEntity {

    @Id
    private String id;
    private String name;
    private LocalDate birthDate;
    private String city;
    private String cpf;

    public CustomerJpaEntity(String id, String name, LocalDate birthDate, String city, String cpf) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.city = city;
        this.cpf = cpf;
    }

    public CustomerJpaEntity() {

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
