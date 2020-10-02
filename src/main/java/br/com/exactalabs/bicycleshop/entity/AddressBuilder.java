package br.com.exactalabs.bicycleshop.entity;


public class AddressBuilder {

    private String street;
    private String district;
    private String city;
    private String state;
    private String zipCode;
    private String number;
    private String complement;

    public AddressBuilder setStreet(String street){
        this.street = street;
        return this;
    }

    public AddressBuilder setDistrict(String district){
        this.district = district;
        return this;
    }

    public AddressBuilder setCity(String city){
        this.city = city;
        return this;
    }

    public AddressBuilder setState(String state){
        this.state = state;
        return this;
    }

    public AddressBuilder setZipCode(String zipCode){
        this.zipCode = zipCode;
        return this;
    }

    public AddressBuilder setNumber(String number){
        this.number = number;
        return this;
    }

    public AddressBuilder setComplement(String complement){
        this.complement = complement;
        return this;
    }

    public Address createAddress(){
        return new Address(street, district, city, state, zipCode, number, complement);
    }


}
