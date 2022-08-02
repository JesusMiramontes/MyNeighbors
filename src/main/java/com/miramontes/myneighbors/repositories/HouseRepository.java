package com.miramontes.myneighbors.repositories;

import com.miramontes.myneighbors.model.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseRepository extends JpaRepository<House, Integer> {}
