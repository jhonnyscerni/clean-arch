package br.com.architectureprototype.application.customer;

import br.com.architectureprototype.application.customer.response.CustomerResponse;
import br.com.architectureprototype.application.customer.response.PageResponse;
import br.com.architectureprototype.domain.pagination.PaginationRequest;

public interface FindAllCustomersUseCase {

    PageResponse<CustomerResponse> execute(PaginationRequest paginationRequest);

}
