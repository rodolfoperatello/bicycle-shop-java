package br.com.exactalabs.bicycleshop.service;

import br.com.exactalabs.bicycleshop.entity.Address;
import br.com.exactalabs.bicycleshop.entity.Customer;
import br.com.exactalabs.bicycleshop.repository.AdressRepository;
import br.com.exactalabs.bicycleshop.repository.CustomerRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;
    private AdressRepository adressRepository;

    public CustomerService(CustomerRepository customerRepository, AdressRepository adressRepository) {
        this.customerRepository = customerRepository;
        this.adressRepository = adressRepository;
    }


    public Address saveAdress(Address address) {
        return this.adressRepository.save(address);
    }

    public void deleteAdressById(Long id) {
        this.adressRepository.deleteById(id);
    }

    public void updateAdress(Address address) {
        this.adressRepository.save(address);
    }

    public Address findAdressById(Long id) {
        return this.adressRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Endereço não encontrado"));
    }

    @Transactional
    public Customer saveClient(Customer customer) {
        return this.customerRepository.save(customer);
    }

    @Transactional
    public void deleteClientById(Long id) {
        var client = this.customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        this.customerRepository.deleteById(id);
    }

    public void updateClient(Customer customer) {
        this.customerRepository.save(customer);
    }

    public Page<Customer> findAllClients(Integer pageNumber){
        var pageRequest = PageRequest.of(pageNumber, 30);
        return this.customerRepository.findAll(pageRequest);
    }

    public Customer findClientById(Long id){
        return this.customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    }


}
