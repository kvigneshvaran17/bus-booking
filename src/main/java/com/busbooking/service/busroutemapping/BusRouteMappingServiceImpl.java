package com.busbooking.service.busroutemapping;

import com.busbooking.dao.BusDao;
import com.busbooking.dao.BusRouteMappingDao;
import com.busbooking.dao.RouteDao;
import com.busbooking.model.bus.Bus;
import com.busbooking.model.busroutemapping.BusRoute;
import com.busbooking.model.busroutemapping.BusRouteRequest;
import com.busbooking.model.busroutemapping.BusRouteStatus;
import com.busbooking.model.route.Route;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BusRouteMappingServiceImpl implements BusRouteMappingService{

    @Autowired
    BusRouteMappingDao busRouteMappingDao;
    @Autowired
    BusDao busDao;
    @Autowired
    RouteDao routeDao;
    @Override
    public List<BusRoute> getAllBusRoutes() {
        List<BusRoute> busRoutes= new ArrayList<>();
        busRouteMappingDao.findAll().forEach(busRoutes::add);
        return busRoutes;
    }

    @Override
    public BusRouteStatus addBusRoute(BusRouteRequest busRoute) throws BadRequestException {
        String errorMessage = validateTimeIntersection(busRoute);
        Bus bus = busDao.findById(busRoute.getBus_id()).orElse(null);
        Route route = routeDao.findById(busRoute.getRoute_id()).orElse(null);
        if(bus==null || route==null){
            return new BusRouteStatus(400, "Check for valid bus or route Id", null);
        } else if (errorMessage != null) {
            return new BusRouteStatus(400, errorMessage, null);
        }
        BusRoute busRouteSaved = busRouteMappingDao.save(new BusRoute(bus, route,busRoute.getStartTime(), busRoute.getEndTime()));
        return new BusRouteStatus(200, "Route added", busRouteSaved);
    }

    @Override
    public BusRouteStatus updateBusRoute(int busRouteId, BusRouteRequest busRoute) throws BadRequestException{
        BusRoute busRouteInDb = busRouteMappingDao.findById(busRouteId).orElse(null);
        if(busRouteInDb==null){
            return new BusRouteStatus(400, "Enter valid bus route id", null);
        }
        String errorMessage = validateTimeIntersection(busRoute);
        Bus bus = busDao.findById(busRoute.getBus_id()).orElse(null);
        Route route = routeDao.findById(busRoute.getRoute_id()).orElse(null);
        if(bus==null || route==null){
            return new BusRouteStatus(400, "Check for valid bus or route Id", null);
        } else if (errorMessage != null) {
            return new BusRouteStatus(400, errorMessage, null);
        }
        BusRoute busRouteSaved = busRouteMappingDao.save(new BusRoute(busRouteId, bus, route,busRoute.getStartTime(), busRoute.getEndTime()));
        return new BusRouteStatus(200, "Route updated", busRouteSaved);
    }

    @Override
    public BusRouteStatus deleteBusRoute(int busRouteId) {
        BusRoute busRouteInDb = busRouteMappingDao.findById(busRouteId).orElse(null);
        if(busRouteInDb==null){
            return new BusRouteStatus(400, "Enter valid bus route id to delete", null);
        }
        busRouteMappingDao.deleteById(busRouteId);
        return new BusRouteStatus(200, "Bus route deleted", null);
    }

    @Override
    public List<BusRoute> getRouteWiseBusDetails(int routeId) {
        return busRouteMappingDao.findByRouteId(routeId);
    }

    private String validateTimeIntersection(BusRouteRequest newBusRoute) throws BadRequestException {
        List<BusRoute> existingMappingsForBus = busRouteMappingDao.findByBusId(newBusRoute.getBus_id());
        List<BusRoute> busRoutes = busRouteMappingDao.findByStartTimeAndRouteId(newBusRoute.getStartTime(),newBusRoute.getRoute_id());
        if(!busRoutes.isEmpty()){
            return "Time overlap with existing bus route.";
        }
        for (BusRoute existingBusRoute : existingMappingsForBus) {
            if (isTimeOverlap(existingBusRoute, newBusRoute)) {
                return "Bus is already running in this timeframe.";
            }
        }
        return null;
    }



    private Time convertStringToTime(String time){
        String[] startTimeList = time.split(":");
        return Time.valueOf(LocalTime.of(
                Integer.parseInt(startTimeList[0]),
                Integer.parseInt(startTimeList[1]),
                Integer.parseInt(startTimeList[2])));
    }

    private boolean isTimeOverlap(BusRoute existingBusRoute, BusRouteRequest newBusRoute) {
        return convertStringToTime(existingBusRoute.getStartTime()).before(convertStringToTime(newBusRoute.getEndTime()))
                && convertStringToTime(existingBusRoute.getEndTime()).after(convertStringToTime(newBusRoute.getStartTime()));
    }
}
