package com.miramontes.myneighbors.repositories;

import com.miramontes.myneighbors.model.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitorRepository extends JpaRepository<Visitor, Integer> {}
