package com.miramontes.myneighbors.services;

import com.miramontes.myneighbors.model.House;
import com.miramontes.myneighbors.repositories.HouseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseService {

    private final HouseRepository repository;

    public HouseService(HouseRepository repository) {
        this.repository = repository;
    }

    public List<House> findAll(){
        return repository.findAll();
    }
}
