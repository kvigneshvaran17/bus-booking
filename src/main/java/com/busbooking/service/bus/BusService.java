package com.busbooking.service.bus;

import com.busbooking.model.bus.Bus;
import com.busbooking.model.bus.BusStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BusService {
    BusStatus updateBus(Bus bus);
    BusStatus deleteBus (Integer busId);
    BusStatus addBus(Bus bus);
    List<Bus> getAllBuses();
}
