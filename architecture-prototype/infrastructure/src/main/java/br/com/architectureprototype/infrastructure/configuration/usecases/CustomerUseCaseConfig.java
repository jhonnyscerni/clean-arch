package br.com.architectureprototype.infrastructure.configuration.usecases;

import br.com.architectureprototype.application.customer.CreateCustomerUseCase;
import br.com.architectureprototype.application.customer.DeleteCustomerUseCase;
import br.com.architectureprototype.application.customer.FindAllCustomersUseCase;
import br.com.architectureprototype.application.customer.FindCustomerUseCase;
import br.com.architectureprototype.application.customer.UpdateCustomerUseCase;
import br.com.architectureprototype.application.customer.impl.CreateCustomerUseCaseImpl;
import br.com.architectureprototype.application.customer.impl.DeleteCustomerUseCaseImpl;
import br.com.architectureprototype.application.customer.impl.FindAllCustomersUseCaseImpl;
import br.com.architectureprototype.application.customer.impl.FindCustomerUseCaseImpl;
import br.com.architectureprototype.application.customer.impl.UpdateCustomerUseCaseImpl;
import br.com.architectureprototype.domain.customer.repository.CustomerRepository;
import br.com.architectureprototype.domain.customer.service.CustomerScoreService;
import java.util.Objects;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerUseCaseConfig {

    private final CustomerRepository customerRepository;
    private final CustomerScoreService customerScoreService;

    public CustomerUseCaseConfig(final CustomerRepository customerRepository,
        final CustomerScoreService customerScoreService) {
        this.customerRepository = Objects.requireNonNull(customerRepository);
        this.customerScoreService = customerScoreService;
    }

    @Bean
    public CreateCustomerUseCase createCustomerUseCase(){
        return new CreateCustomerUseCaseImpl(customerRepository, customerScoreService);
    }

    @Bean
    public DeleteCustomerUseCase deleteCustomerUseCase() {
        return new DeleteCustomerUseCaseImpl(customerRepository);
    }

    @Bean
    public FindCustomerUseCase getCustomerByIdUseCase() {
        return new FindCustomerUseCaseImpl(customerRepository);
    }

    @Bean
    public FindAllCustomersUseCase listCustomersUseCase() {
        return new FindAllCustomersUseCaseImpl(customerRepository);
    }

    @Bean
    public UpdateCustomerUseCase updateCustomerUseCase() {
        return new UpdateCustomerUseCaseImpl(customerRepository);
    }

}
