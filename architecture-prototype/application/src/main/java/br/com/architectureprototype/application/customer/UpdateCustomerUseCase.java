package br.com.architectureprototype.application.customer;

import br.com.architectureprototype.application.customer.request.UpdateCustomerRequest;
import br.com.architectureprototype.application.customer.response.CustomerResponse;

public interface UpdateCustomerUseCase {

    CustomerResponse execute(String id, UpdateCustomerRequest request);

}
