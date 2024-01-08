package com.busbooking.controller;

import com.busbooking.model.route.Route;
import com.busbooking.model.route.RouteStatus;
import com.busbooking.service.route.RouteService;
import com.busbooking.service.route.RouteServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RouteController extends BaseController{

    @Autowired
    RouteServiceImpl routeServiceImpl;
    @PostMapping("routes/addRoute")
    public ResponseEntity<RouteStatus> addRoute(@RequestBody Route route,HttpServletRequest httpServletRequest) throws BadRequestException{
        checkUserViewAddAccess(httpServletRequest);
        return new ResponseEntity<>(routeServiceImpl.addRoute(route), HttpStatus.OK);
    }

    @GetMapping("routes/getAllRoutes")
    public ResponseEntity<List<Route>> getAllRoutes(HttpServletRequest httpServletRequest) throws BadRequestException {
        checkUserViewAddAccess(httpServletRequest);
        return new ResponseEntity<>(routeServiceImpl.getAllRoutes(), HttpStatus.OK);
    }
}
