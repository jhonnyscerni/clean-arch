package br.com.architectureprototype.application.customer;

import br.com.architectureprototype.application.customer.request.CreateCustomerRequest;
import br.com.architectureprototype.application.customer.response.CustomerResponse;

public interface CreateCustomerUseCase {

    CustomerResponse execute(CreateCustomerRequest request);

}
