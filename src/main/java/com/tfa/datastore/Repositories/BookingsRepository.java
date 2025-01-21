package com.tfa.datastore.Repositories;

import com.tfa.datastore.Models.Bookings;
import com.tfa.datastore.Models.Flights;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingsRepository  extends JpaRepository<Bookings,Long> {
    List<Bookings> findByUserId(Long userId);   //SELECT * FROM bookings WHERE user_id = :userId
}
