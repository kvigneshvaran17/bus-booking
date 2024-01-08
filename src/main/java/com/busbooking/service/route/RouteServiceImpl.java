package com.busbooking.service.route;

import com.busbooking.dao.RouteDao;
import com.busbooking.model.route.Route;
import com.busbooking.model.route.RouteStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RouteServiceImpl implements RouteService{

    @Autowired
    RouteDao routeDao;

    @Override
    public List<Route> getAllRoutes() {
        List<Route> routeList = new ArrayList<>();
        routeDao.findAll().forEach(routeList::add);
        return routeList;
    }

    @Override
    public RouteStatus addRoute(Route route) {
        Optional<Route> routeInDb = routeDao.findByRouteName(route.getRouteName());
        Route route1 = routeInDb.orElse(null);
        if(route.getRouteName()==null){
            return new RouteStatus(400, "Enter routeName", null);
        } else if (route1!=null) {
            return new RouteStatus(400, "Route already present", route1);
        }
        Route routeSaved = routeDao.save(route);
        return new RouteStatus(200, "Route added", routeSaved);
    }
}
