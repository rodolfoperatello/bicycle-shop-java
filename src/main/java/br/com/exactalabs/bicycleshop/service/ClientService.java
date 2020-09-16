package br.com.exactalabs.bicycleshop.service;

import br.com.exactalabs.bicycleshop.entity.Adress;
import br.com.exactalabs.bicycleshop.entity.Client;
import br.com.exactalabs.bicycleshop.repository.AdressRepository;
import br.com.exactalabs.bicycleshop.repository.ClientRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ClientService {

    private ClientRepository clientRepository;
    private AdressRepository adressRepository;

    public ClientService(ClientRepository clientRepository, AdressRepository adressRepository) {
        this.clientRepository = clientRepository;
        this.adressRepository = adressRepository;
    }


    public Adress saveAdress(Adress adress) {
        return this.adressRepository.save(adress);
    }

    public void deleteAdressById(Long id) {
        this.adressRepository.deleteById(id);
    }

    public void updateAdress(Adress adress) {
        this.adressRepository.save(adress);
    }

    public Adress findAdressById(Long id) {
        return this.adressRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Endereço não encontrado"));
    }

    @Transactional
    public Client saveClient(Client client) {
        this.adressRepository.saveAll(client.getAdressList());
        return this.clientRepository.save(client);
    }

    @Transactional
    public void deleteClientById(Long id) {
        var client = this.clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        var adresses = client.getAdressList();

        this.clientRepository.deleteById(id);
        this.adressRepository.deleteAll(adresses);
    }

    public void updateClient(Client client) {
        this.clientRepository.save(client);
    }

    public Page<Client> findAllClients(Integer pageNumber){
        var pageRequest = PageRequest.of(pageNumber, 30);
        return this.clientRepository.findAll(pageRequest);
    }

    public Client findClientById(Long id){
        return this.clientRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    }


}
