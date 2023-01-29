package br.com.architectureprototype.infrastructure.configuration.customer.mapper;


import br.com.architectureprototype.domain.customer.Customer;
import br.com.architectureprototype.infrastructure.configuration.customer.persistence.CustomerJpaEntity;
import org.springframework.stereotype.Component;

@Component
public class CustomerDataAccessMapper {

    public Customer customerEntityToCustomer(CustomerJpaEntity customerEntity) {
        return new Customer(
            customerEntity.getId(),
            customerEntity.getName(),
            customerEntity.getBirthDate(),
            customerEntity.getCity(),
            customerEntity.getCpf());
    }

    public CustomerJpaEntity customerToCustomerJpaEntity(Customer customer) {
        return new CustomerJpaEntity(
            customer.getId(),
            customer.getName(),
            customer.getBirthDate(),
            customer.getCity(),
            customer.getCpf());
    }
}
