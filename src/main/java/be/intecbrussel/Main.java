package be.intecbrussel;

import be.intecbrussel.repository.AppointmentRepository;
import be.intecbrussel.model.Appointment;
import be.intecbrussel.service.AppointmentService;

import java.util.Optional;


public class Main {
    public static void main(String[] args) {

        Appointment doctor = new Appointment("123", "RDV doctor", 12,4, 2023, 30,4);
        Appointment kine = new Appointment("345", "RDV kine", 3,6, 2023, 30,9);
        Appointment party = new Appointment("657", "party", 29,4, 2023, 50,21);


        AppointmentService as = new AppointmentService();

        as.createAppointment(doctor);
        as.createAppointment(kine);
        as.createAppointment(party);

        Optional<Appointment> dbAppointment = as.readAppointment("123");
        if (dbAppointment.isPresent()) {
            System.out.println(dbAppointment.get());
        } else {
            System.out.println("No appointment found!");
        }

        as.deleteAppointment("345");

        Optional<Appointment> appointmentToUpdate = as.readAppointment("123");
        if (appointmentToUpdate.isPresent()) {
            Appointment foundAppointment = appointmentToUpdate.get();
            foundAppointment.setTitle(foundAppointment.getTitle()+" specialist");
            as.updateAppointmentButEasier(foundAppointment);
        }
    }
}
