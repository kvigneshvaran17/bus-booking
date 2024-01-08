package com.busbooking.controller;

import com.busbooking.model.busroutemapping.BusRoute;
import com.busbooking.model.busroutemapping.BusRouteRequest;
import com.busbooking.model.busroutemapping.BusRouteStatus;
import com.busbooking.service.busroutemapping.BusRouteMappingServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BusRouteMappingController extends BaseController{
    @Autowired
    BusRouteMappingServiceImpl busRouteMappingService;
    @GetMapping("bus-routes/getAll")
    public ResponseEntity<List<BusRoute>> getAllBusRoutes(HttpServletRequest httpServletRequest) throws BadRequestException {
        checkUserViewAddAccess(httpServletRequest);
        return new ResponseEntity<>(busRouteMappingService.getAllBusRoutes(), HttpStatus.OK);
    }

    @PostMapping("bus-routes/addBusRoute")
    public ResponseEntity<BusRouteStatus> addBusRoute(@RequestBody BusRouteRequest busRoute, HttpServletRequest httpServletRequest) throws BadRequestException {
        checkUserViewAddAccess(httpServletRequest);
        return new ResponseEntity<>(busRouteMappingService.addBusRoute(busRoute), HttpStatus.OK);
    }

    @PutMapping("bus-routes/updateBusRoute/{busRouteId}")
    public ResponseEntity<BusRouteStatus> updateBusRoute(@PathVariable int busRouteId, @RequestBody BusRouteRequest busRoute, HttpServletRequest httpServletRequest) throws BadRequestException {
        checkUserEditAccess(httpServletRequest);
        return new ResponseEntity<>(busRouteMappingService.updateBusRoute(busRouteId, busRoute), HttpStatus.OK);
    }

    @DeleteMapping("bus-routes/deleteBusRoute/{busRouteId}")
    public ResponseEntity<BusRouteStatus> deleteBusRoute(@PathVariable int busRouteId, HttpServletRequest httpServletRequest) throws BadRequestException {
        checkUserEditAccess(httpServletRequest);
        return new ResponseEntity<>(busRouteMappingService.deleteBusRoute(busRouteId), HttpStatus.OK);
    }

    @GetMapping("bus-routes/getRouteWiseBusDetails/{routeId}")
    public ResponseEntity<List<BusRoute>> getRouteWiseBusDetails(@PathVariable int routeId, HttpServletRequest httpServletRequest) throws BadRequestException {
        checkUserViewAddAccess(httpServletRequest);
        return new ResponseEntity<>(busRouteMappingService.getRouteWiseBusDetails(routeId), HttpStatus.OK);
    }
}
