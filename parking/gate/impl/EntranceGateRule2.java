package de.hsd.inflab.parkinggarage.parking.gate.impl;

import de.hsd.inflab.parkinggarage.models.ticket.Ticket;
import de.hsd.inflab.parkinggarage.models.vehicles.Vehicle;
import de.hsd.inflab.parkinggarage.models.vehicles.VehicleTypes;
import de.hsd.inflab.parkinggarage.parking.Lot;

import java.time.LocalDateTime;

public class EntranceGateRule2 extends EntranceGateRule1{

    //@Override
    public Ticket processIncoming(Vehicle vehicle, Lot lot, LocalDateTime timeStamp) {
        if (vehicle.getVehicleType() ==  VehicleTypes.SEMI && lot.calculateOccupancy() >= 0.8) {
            return Ticket.denyEntry("Keine LKW-Zufahrt ab 80 % Auslastung");
        }
    return super.processIncoming(vehicle, lot, timeStamp);
    //return Ticket.issue(LocalDateTime.of(2026, 10, 6, 12, 0));

    }
}
