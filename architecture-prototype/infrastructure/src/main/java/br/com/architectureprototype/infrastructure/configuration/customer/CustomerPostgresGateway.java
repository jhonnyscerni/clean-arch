package br.com.architectureprototype.infrastructure.configuration.customer;


import br.com.architectureprototype.domain.customer.Customer;
import br.com.architectureprototype.domain.customer.repository.CustomerRepository;
import br.com.architectureprototype.domain.pagination.Pagination;
import br.com.architectureprototype.domain.pagination.PaginationRequest;
import br.com.architectureprototype.infrastructure.configuration.customer.mapper.CustomerDataAccessMapper;
import br.com.architectureprototype.infrastructure.configuration.customer.persistence.CustomerJpaEntity;
import br.com.architectureprototype.infrastructure.configuration.customer.persistence.CustomerJpaRepository;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

@Component
public class CustomerPostgresGateway implements CustomerRepository {

    private final CustomerJpaRepository customerJpaRepository;
    private final CustomerDataAccessMapper customerDataAccessMapper;

    public CustomerPostgresGateway(final CustomerJpaRepository customerJpaRepository, final CustomerDataAccessMapper customerDataAccessMapper) {
        this.customerJpaRepository = Objects.requireNonNull(customerJpaRepository);
        this.customerDataAccessMapper = customerDataAccessMapper;
    }


    @Override
    public Customer create(Customer customer) {
        return save(customer);
    }

    @Override
    public Customer update(Customer customer) {
        return save(customer);
    }

    @Override
    public Optional<Customer> find(String id) {
        return customerJpaRepository.findById(id).map(customerDataAccessMapper::customerEntityToCustomer);
    }

    @Override
    public List<Customer> findAll() {
        return customerJpaRepository.findAll().stream().map(
            customerDataAccessMapper::customerEntityToCustomer).collect(Collectors.toList());
    }

    @Override
    public Pagination<Customer> find(PaginationRequest paginationRequest) {
        final var page = PageRequest.of(
            paginationRequest.getPage(),
            paginationRequest.getSize()
        );

        Page<CustomerJpaEntity> pageResult = customerJpaRepository.findAll(page);

        return new Pagination<>(
            pageResult.getContent().stream().map(customerDataAccessMapper::customerEntityToCustomer).collect(Collectors.toList()),
            pageResult.getNumber(),
            pageResult.getSize(),
            pageResult.getTotalElements()
        );
    }

    @Override
    public void delete(Customer customer) {
        final var anId = customer.getId();
        if (this.customerJpaRepository.existsById(anId)) {
            this.customerJpaRepository.deleteById(anId);
        }
    }

    private Customer save(final Customer customer) {
        return customerDataAccessMapper.customerEntityToCustomer(
            customerJpaRepository.save(
                customerDataAccessMapper.customerToCustomerJpaEntity(customer)
            ));
    }
}
