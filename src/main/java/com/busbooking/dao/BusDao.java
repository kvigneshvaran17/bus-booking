package com.busbooking.dao;

import com.busbooking.model.bus.Bus;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BusDao extends CrudRepository<Bus, Integer> {
    @Query("SELECT bus from Bus bus where bus.regNumber = :regNumber")
    Optional<Bus> findByRegNo(@Param("regNumber") String regNumber);
}
