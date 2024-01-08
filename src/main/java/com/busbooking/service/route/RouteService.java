package com.busbooking.service.route;

import com.busbooking.model.route.Route;
import com.busbooking.model.route.RouteStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RouteService {
    List<Route> getAllRoutes();
    RouteStatus addRoute(Route route);
}
