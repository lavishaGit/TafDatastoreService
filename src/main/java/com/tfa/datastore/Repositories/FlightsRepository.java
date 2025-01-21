package com.tfa.datastore.Repositories;

import com.tfa.datastore.Models.Flights;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightsRepository extends JpaRepository<Flights,Long> {
}
