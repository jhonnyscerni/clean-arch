package br.com.architectureprototype.infrastructure.service;

import br.com.architectureprototype.domain.customer.service.CustomerScoreService;
import br.com.architectureprototype.infrastructure.service.client.CustomerScoreClient;
import br.com.architectureprototype.infrastructure.service.client.request.CustomerScoreRequest;
import br.com.architectureprototype.infrastructure.service.client.response.CustomerScoreResponse;
import br.com.architectureprototype.infrastructure.service.client.response.CustomerScoreStatusEnum;
import org.springframework.stereotype.Component;

@Component
public class CustomerScoreClientService implements CustomerScoreService {

    private final CustomerScoreClient customerScoreClient;

    public CustomerScoreClientService(final CustomerScoreClient customerScoreClient) {
        this.customerScoreClient = customerScoreClient;
    }

    @Override
    public Boolean isApproved(String cpf) {
        CustomerScoreResponse response = this.customerScoreClient.queryScore(new CustomerScoreRequest(cpf));
        if(response.getStatus() == CustomerScoreStatusEnum.APPROVED) {
            return true;
        } else {
            return false;
        }
    }
}
