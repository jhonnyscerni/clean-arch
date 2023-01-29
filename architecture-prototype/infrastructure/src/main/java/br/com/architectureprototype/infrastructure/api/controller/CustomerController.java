package br.com.architectureprototype.infrastructure.api.controller;

import br.com.architectureprototype.application.customer.CreateCustomerUseCase;
import br.com.architectureprototype.application.customer.DeleteCustomerUseCase;
import br.com.architectureprototype.application.customer.FindAllCustomersUseCase;
import br.com.architectureprototype.application.customer.FindCustomerUseCase;
import br.com.architectureprototype.application.customer.UpdateCustomerUseCase;
import br.com.architectureprototype.application.customer.request.CreateCustomerRequest;
import br.com.architectureprototype.application.customer.request.UpdateCustomerRequest;
import br.com.architectureprototype.application.customer.response.CustomerResponse;
import br.com.architectureprototype.application.customer.response.PageResponse;
import br.com.architectureprototype.domain.pagination.PaginationRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/customers")
public class CustomerController {

    private final CreateCustomerUseCase createCustomerUseCase;
    private final DeleteCustomerUseCase deleteCustomerUseCase;
    private final FindAllCustomersUseCase findAllCustomersUseCase;
    private final FindCustomerUseCase findCustomerUseCase;
    private final UpdateCustomerUseCase updateCustomerUseCase;

    public CustomerController(
        final CreateCustomerUseCase createCustomerUseCase,
        final DeleteCustomerUseCase deleteCustomerUseCase,
        final FindAllCustomersUseCase findAllCustomersUseCase,
        final FindCustomerUseCase findCustomerUseCase,
        final UpdateCustomerUseCase updateCustomerUseCase
    ) {
        this.createCustomerUseCase = createCustomerUseCase;
        this.deleteCustomerUseCase = deleteCustomerUseCase;
        this.findAllCustomersUseCase = findAllCustomersUseCase;
        this.findCustomerUseCase = findCustomerUseCase;
        this.updateCustomerUseCase = updateCustomerUseCase;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerResponse create(@RequestBody CreateCustomerRequest request) {
        return this.createCustomerUseCase.execute(request);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") String id) {
        this.deleteCustomerUseCase.execute(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public PageResponse<CustomerResponse> find(PaginationRequest pageRequest) {
        return findAllCustomersUseCase.execute(pageRequest);
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerResponse find(@PathVariable("id") String id) {
        return this.findCustomerUseCase.execute(id);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerResponse update(@PathVariable("id") String id, @RequestBody UpdateCustomerRequest request) {
        return this.updateCustomerUseCase.execute(id, request);
    }

}
