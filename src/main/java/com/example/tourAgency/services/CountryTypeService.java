package com.example.tourAgency.services;

import com.example.tourAgency.models.Country;
import com.example.tourAgency.models.Type;
import com.example.tourAgency.repositories.CountryRepository;
import com.example.tourAgency.repositories.TypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryTypeService {
    private final CountryRepository countryRepository;
    private final TypeRepository typeRepository;
    public CountryTypeService(CountryRepository countryRepository, TypeRepository typeRepository) {
        this.countryRepository = countryRepository;
        this.typeRepository = typeRepository;
    }
    public List<Country> countryList(){
        return countryRepository.findAll();
    }
    public void createCountry(Country country){
        countryRepository.save(country);
    }
    public void deleteCountry(Long id){
        countryRepository.deleteById(id);
    }
    public Country updatedCountryById(Long id){
        return countryRepository.findById(id).get();
    }
     public List<Type> typeList(){
        return typeRepository.findAll();
    }
    public void createType(Type type){
        typeRepository.save(type);
    }
    public void deleteType(Long id){
        typeRepository.deleteById(id);
    }
    public Type updatedTypeById(Long id){
        return typeRepository.findById(id).get();
    }

}
