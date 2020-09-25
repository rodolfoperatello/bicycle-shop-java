package br.com.exactalabs.bicycleshop.service;

import br.com.exactalabs.bicycleshop.entity.Address;
import br.com.exactalabs.bicycleshop.entity.Customer;
import br.com.exactalabs.bicycleshop.repository.AddressRepository;
import br.com.exactalabs.bicycleshop.repository.CustomerRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;
    private AddressRepository addressRepository;

    public CustomerService(CustomerRepository customerRepository, AddressRepository addressRepository) {
        this.customerRepository = customerRepository;
        this.addressRepository = addressRepository;
    }

    private PageRequest createPageRequest(Integer pageNumber, Integer size){
        var pageRequest = PageRequest.of(pageNumber, size);
        return pageRequest;
    }

    @Transactional
    public Customer saveCustomer(Customer customer) {
        return this.customerRepository.save(customer);
    }

    @Transactional
    public void deleteCustomerById(Long id) {
        var customer = this.customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        this.customerRepository.deleteById(id);
    }

    public void updateCustomer(Customer customer) {
        this.customerRepository.save(customer);
    }

    public Page<Customer> findAllCustomers(Integer pageNumber){
        var pageRequest = createPageRequest(pageNumber, 30);
        return this.customerRepository.findAll(pageRequest);
    }

    public Customer findCustomerById(Long id){
        return this.customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    }


}
