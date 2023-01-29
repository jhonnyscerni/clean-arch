package br.com.architectureprototype.application.customer.impl;

import br.com.architectureprototype.application.customer.DeleteCustomerUseCase;
import br.com.architectureprototype.domain.customer.Customer;
import br.com.architectureprototype.domain.customer.exception.NotFoundException;
import br.com.architectureprototype.domain.customer.repository.CustomerRepository;

public class DeleteCustomerUseCaseImpl implements DeleteCustomerUseCase {

    private CustomerRepository customerRepository;

    public DeleteCustomerUseCaseImpl(
        CustomerRepository customerRepository
    ) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void execute(String id) {
        Customer customer = customerRepository.find(id).orElseThrow(() -> new NotFoundException("customer", id));
        customerRepository.delete(customer);
    }

}
