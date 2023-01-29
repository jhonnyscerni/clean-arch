package br.com.architectureprototype.application.customer;

import br.com.architectureprototype.application.customer.response.CustomerResponse;

public interface FindCustomerUseCase {

    CustomerResponse execute(String id);

}
