package de.hsd.inflab.parkinggarage.parking.gate.impl;

import de.hsd.inflab.parkinggarage.models.Receipt;
import de.hsd.inflab.parkinggarage.models.ticket.Ticket;
import de.hsd.inflab.parkinggarage.models.vehicles.Vehicle;
import de.hsd.inflab.parkinggarage.parking.gate.iface.Exit;

import java.time.Duration;
import java.time.LocalDateTime;


public class ExitGateRule3 implements Exit {
    public Receipt processOutgoing(Ticket ticket, Vehicle vehicle, LocalDateTime timeStamp) {
        Duration parkingTime = Duration.between(ticket.getTimeStamp(), timeStamp);
        long minutes = parkingTime.toMinutes();

        int amount = 0;
        if (minutes > 15) {
            int startedHours = (int) Math.ceil(minutes / 60.0);
            amount = startedHours * 2;
        }

        return new Receipt(amount, parkingTime, vehicle.getVehicleType());
    }

}
