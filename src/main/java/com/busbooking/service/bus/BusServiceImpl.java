package com.busbooking.service.bus;

import com.busbooking.dao.BusDao;
import com.busbooking.model.bus.Bus;
import com.busbooking.model.bus.BusStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BusServiceImpl implements BusService{

    @Autowired
    BusDao busDao;

    @Override
    public BusStatus updateBus(Bus busData) {
        if(busData.getBusType()==null || busData.getRegNumber()==null){
            return new BusStatus(400, "Enter both regNo and busType", null);
        }
        Optional<Bus> busOptional = busDao.findById(busData.getId());
        if(busOptional.isPresent()){
            Bus bus = busDao.save(busData);
            return new BusStatus(200, "Bus updated successfully", bus);
        }
        return new BusStatus(404, "Bus not found", null);
    }

    @Override
    public BusStatus deleteBus(Integer busId) {
        Optional<Bus> busOptional = busDao.findById(busId);
        if(busOptional.isPresent()){
            busDao.deleteById(busId);
            return new BusStatus(200, "Bus deleted successfully", null);
        }
        return new BusStatus(404, "Bus not found", null);
    }

    @Override
    public BusStatus addBus(Bus busData) {
        Optional<Bus> busOptional = busDao.findByRegNo(busData.getRegNumber());
        if(busOptional.isPresent()){
            return new BusStatus(400, "Bus already present", null);
        }
        Bus bus = busDao.save(busData);
        return new BusStatus(200, "Bus added", bus);
    }

    @Override
    public List<Bus> getAllBuses() {
        List<Bus> busList = new ArrayList<>();
        busDao.findAll().forEach(busList::add);
        return busList;
    }
}
