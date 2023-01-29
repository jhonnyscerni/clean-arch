package br.com.architectureprototype.application.customer.impl;

import br.com.architectureprototype.application.customer.UpdateCustomerUseCase;
import br.com.architectureprototype.application.customer.request.UpdateCustomerRequest;
import br.com.architectureprototype.application.customer.response.CustomerResponse;
import br.com.architectureprototype.domain.customer.Customer;
import br.com.architectureprototype.domain.customer.exception.NotFoundException;
import br.com.architectureprototype.domain.customer.repository.CustomerRepository;

public class UpdateCustomerUseCaseImpl implements UpdateCustomerUseCase {

    private CustomerRepository customerRepository;

    public UpdateCustomerUseCaseImpl(
        CustomerRepository customerRepository
    ) {
        this.customerRepository = customerRepository;
    }

    @Override
    public CustomerResponse execute(String id, UpdateCustomerRequest request) {
        Customer customer = customerRepository.find(id).orElseThrow(() -> new NotFoundException("customer", id));
        Customer updatedCustomer = new Customer(
            customer.getId(),
            request.getName(),
            customer.getBirthDate(),
            request.getCity(),
            customer.getCpf()
        );
        customerRepository.update(updatedCustomer);
        return CustomerResponse.from(updatedCustomer);
    }

}
