package com.beta.riderservice.repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.beta.riderservice.entity.Rider;
@Repository
public interface RiderRepository extends JpaRepository<Rider, Integer>{

}
