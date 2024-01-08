package com.busbooking.dao;

import com.busbooking.model.bus.Bus;
import com.busbooking.model.busroutemapping.BusRoute;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusRouteMappingDao extends CrudRepository<BusRoute, Integer> {
    @Query("SELECT busRoute FROM BusRoute busRoute WHERE busRoute.bus.id = :busId")
    List<BusRoute> findByBusId(@Param("busId") int busId);

    @Query("SELECT busRoute FROM BusRoute busRoute WHERE busRoute.startTime = :startTime AND busRoute.route.id = :routeId")
    List<BusRoute> findByStartTimeAndRouteId(@Param("startTime") String startTime, @Param("routeId") int routeId);

    @Query("SELECT busRoute FROM BusRoute busRoute WHERE busRoute.route.id = :routeId")
    List<BusRoute> findByRouteId(@Param("routeId") int routeId);
}
