package br.com.architectureprototype.application.customer.impl;

import br.com.architectureprototype.application.customer.FindCustomerUseCase;
import br.com.architectureprototype.application.customer.response.CustomerResponse;
import br.com.architectureprototype.domain.customer.Customer;
import br.com.architectureprototype.domain.customer.exception.NotFoundException;
import br.com.architectureprototype.domain.customer.repository.CustomerRepository;

public class FindCustomerUseCaseImpl implements FindCustomerUseCase {

    private CustomerRepository customerRepository;

    public FindCustomerUseCaseImpl(
        CustomerRepository customerRepository
    ) {
        this.customerRepository = customerRepository;
    }

    @Override
    public CustomerResponse execute(String id) {
        Customer customer = customerRepository.find(id).orElseThrow(() -> new NotFoundException("customer", id));
        return CustomerResponse.from(customer);
    }

}
