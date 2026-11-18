package de.hsd.inflab.parkinggarage.parking.gate.iface;

import de.hsd.inflab.parkinggarage.models.ticket.Ticket;
import de.hsd.inflab.parkinggarage.models.vehicles.Vehicle;
import de.hsd.inflab.parkinggarage.parking.Lot;


import java.time.LocalDateTime;

public interface Entrance {
    public Ticket processIncoming(Vehicle vehicle, Lot lot, LocalDateTime timeStamp);
}
