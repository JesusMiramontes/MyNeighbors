package com.miramontes.myneighbors.services;

import com.miramontes.myneighbors.model.House;
import com.miramontes.myneighbors.repositories.HouseRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class HouseService {

    private final HouseRepository repository;

    public HouseService(HouseRepository repository) {
        this.repository = repository;
    }

    public List<House> findAll() {
        return repository.findAll();
    }
}
