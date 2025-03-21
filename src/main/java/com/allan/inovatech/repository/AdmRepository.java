package com.allan.inovatech.repository;

import com.allan.inovatech.model.entities.Adm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdmRepository extends JpaRepository<Adm, Integer> {
}
