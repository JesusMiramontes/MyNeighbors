package com.miramontes.myneighbors.repositories;

import com.miramontes.myneighbors.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner, Integer> {}
