package br.com.architectureprototype.application.customer.impl;


import br.com.architectureprototype.application.customer.CreateCustomerUseCase;
import br.com.architectureprototype.application.customer.request.CreateCustomerRequest;
import br.com.architectureprototype.application.customer.response.CustomerResponse;
import br.com.architectureprototype.domain.customer.Customer;
import br.com.architectureprototype.domain.customer.exception.BusinessException;
import br.com.architectureprototype.domain.customer.repository.CustomerRepository;
import br.com.architectureprototype.domain.customer.service.CustomerScoreService;

public class CreateCustomerUseCaseImpl implements CreateCustomerUseCase {

    private CustomerRepository customerRepository;
    private CustomerScoreService customerScoreService;

    public CreateCustomerUseCaseImpl(
        CustomerRepository customerRepository,
        CustomerScoreService customerScoreService
    ) {
        this.customerRepository = customerRepository;
        this.customerScoreService = customerScoreService;
    }

    @Override
    public CustomerResponse execute(CreateCustomerRequest request) {
        Customer customer = request.toDomain();
        if (this.customerScoreService.isApproved(customer.getCpf())) {
            return CustomerResponse.from(customerRepository.create(customer));
        } else {
            throw new BusinessException("Your cpf is not approved");
        }
    }

}
