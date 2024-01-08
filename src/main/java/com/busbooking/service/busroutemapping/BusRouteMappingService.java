package com.busbooking.service.busroutemapping;

import com.busbooking.model.busroutemapping.BusRoute;
import com.busbooking.model.busroutemapping.BusRouteRequest;
import com.busbooking.model.busroutemapping.BusRouteStatus;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BusRouteMappingService {
    List<BusRoute> getAllBusRoutes();

    BusRouteStatus addBusRoute(BusRouteRequest busRoute) throws BadRequestException;

    BusRouteStatus updateBusRoute(int busRouteId, BusRouteRequest busRoute) throws BadRequestException;

    BusRouteStatus deleteBusRoute(int busRouteId);

    List<BusRoute> getRouteWiseBusDetails(int routeId);
}
