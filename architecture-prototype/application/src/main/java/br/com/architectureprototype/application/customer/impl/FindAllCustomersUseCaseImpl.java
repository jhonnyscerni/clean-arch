package br.com.architectureprototype.application.customer.impl;

import br.com.architectureprototype.application.customer.FindAllCustomersUseCase;
import br.com.architectureprototype.application.customer.response.CustomerResponse;
import br.com.architectureprototype.application.customer.response.PageResponse;
import br.com.architectureprototype.domain.customer.Customer;
import br.com.architectureprototype.domain.customer.repository.CustomerRepository;
import br.com.architectureprototype.domain.pagination.Pagination;
import br.com.architectureprototype.domain.pagination.PaginationRequest;
import java.util.stream.Collectors;

public class FindAllCustomersUseCaseImpl implements FindAllCustomersUseCase {

    private CustomerRepository customerRepository;

    public FindAllCustomersUseCaseImpl(
        CustomerRepository customerRepository
    ) {
        this.customerRepository = customerRepository;
    }

    @Override
    public PageResponse<CustomerResponse> execute(PaginationRequest paginationRequest) {
        return convert(customerRepository.find(paginationRequest));
    }

    private PageResponse<CustomerResponse> convert(Pagination<Customer> customers) {
        return new PageResponse<>(
            customers.getContent().stream().map(CustomerResponse::from).collect(Collectors.toList()),
            customers.getPageNumber(),
            customers.size(),
            customers.isLast(),
            customers.totalPages()
        );
    }

}
