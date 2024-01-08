package com.busbooking.controller;

import com.busbooking.model.bus.Bus;
import com.busbooking.model.bus.BusStatus;
import com.busbooking.service.bus.BusServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BusController extends BaseController{
    @Autowired
    BusServiceImpl busServiceImpl;

    @GetMapping("buses/getAllBuses")
    public ResponseEntity<List<Bus>> getAllBuses(HttpServletRequest httpServletRequest) throws BadRequestException {
        checkUserViewAddAccess(httpServletRequest);
        return new ResponseEntity<>(busServiceImpl.getAllBuses(), HttpStatus.OK);
    }

    @PostMapping("buses/addBus")
    public ResponseEntity<BusStatus> addBus(@RequestBody Bus bus, HttpServletRequest httpServletRequest) throws BadRequestException {
        checkUserViewAddAccess(httpServletRequest);
        return new ResponseEntity<>(busServiceImpl.addBus(bus), HttpStatus.OK);
    }

    @PutMapping("buses/updateBus")
    public ResponseEntity<BusStatus> updateBus(@RequestBody Bus bus, HttpServletRequest httpServletRequest) throws BadRequestException {
        checkUserEditAccess(httpServletRequest);
        return new ResponseEntity<>(busServiceImpl.updateBus(bus), HttpStatus.OK);
    }

    @DeleteMapping("buses/deleteBus/{busId}")
    public ResponseEntity<BusStatus> deleteBus(@PathVariable int busId,HttpServletRequest httpServletRequest) throws BadRequestException {
        checkUserEditAccess(httpServletRequest);
        return new ResponseEntity<>(busServiceImpl.deleteBus(busId), HttpStatus.OK);
    }
}
