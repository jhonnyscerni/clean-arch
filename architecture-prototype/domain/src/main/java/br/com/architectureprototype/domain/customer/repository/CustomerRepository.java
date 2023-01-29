package br.com.architectureprototype.domain.customer.repository;

import br.com.architectureprototype.domain.customer.Customer;
import br.com.architectureprototype.domain.pagination.Pagination;
import br.com.architectureprototype.domain.pagination.PaginationRequest;
import java.util.List;
import java.util.Optional;

public interface CustomerRepository {

    Customer create(Customer customer);

    Customer update(Customer customer);

    Optional<Customer> find(String id);

    List<Customer> findAll();

    Pagination<Customer> find(PaginationRequest page);

    void delete(Customer customer);

}
