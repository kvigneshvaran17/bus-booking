package com.busbooking.dao;


import com.busbooking.model.route.Route;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RouteDao extends CrudRepository<Route, Integer> {
    @Query("SELECT route from Route route where route.routeName = :routeName")
    Optional<Route> findByRouteName(@Param("routeName") String routeName);
}
