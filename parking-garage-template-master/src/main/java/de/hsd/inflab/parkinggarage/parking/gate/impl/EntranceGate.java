package de.hsd.inflab.parkinggarage.parking.gate.impl;

import de.hsd.inflab.parkinggarage.models.ticket.Ticket;
import de.hsd.inflab.parkinggarage.models.vehicles.Vehicle;
import de.hsd.inflab.parkinggarage.parking.Lot;
import de.hsd.inflab.parkinggarage.parking.gate.iface.Entrance;

import java.time.LocalDateTime;

public class EntranceGate implements Entrance {

    public Ticket processIncoming(Vehicle vehicle, Lot lot, LocalDateTime timeStamp) {
        return Ticket.issue(timeStamp);
    }

}
