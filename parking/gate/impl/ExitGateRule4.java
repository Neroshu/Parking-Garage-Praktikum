package de.hsd.inflab.parkinggarage.parking.gate.impl;

import de.hsd.inflab.parkinggarage.models.Receipt;
import de.hsd.inflab.parkinggarage.models.ticket.Ticket;
import de.hsd.inflab.parkinggarage.models.vehicles.Vehicle;
import de.hsd.inflab.parkinggarage.models.vehicles.VehicleTypes;

import java.time.LocalDateTime;

public class ExitGateRule4 extends ExitGateRule3 {

    public Receipt processOutgoing(Ticket ticket, Vehicle vehicle, LocalDateTime timeStamp) {
        Receipt baseReceipt = super.processOutgoing(ticket, vehicle, timeStamp);
        int amount = baseReceipt.getAmount();

        if (amount > 0) {
            VehicleTypes type = vehicle.getVehicleType();
            if (type == VehicleTypes.SEMI) {
                amount += 5;
            } else if (type == VehicleTypes.MOTORCYCLE) {
                amount -= 1;
            }
            if (amount < 0) {
            amount = 0;
        }
        }

        return new Receipt(amount, baseReceipt.getParkingTime(), vehicle.getVehicleType());
    }
}
