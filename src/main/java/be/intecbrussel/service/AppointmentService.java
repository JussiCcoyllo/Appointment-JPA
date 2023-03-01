package be.intecbrussel.service;

import be.intecbrussel.connection.EntityManagerProvider;
import be.intecbrussel.repository.AppointmentRepository;
import be.intecbrussel.model.Appointment;
import jakarta.persistence.EntityManager;

import java.util.Optional;

public class AppointmentService {
    private AppointmentRepository appointmentRepository = new AppointmentRepository();

    public void createAppointment(Appointment appointment){
        EntityManager em = EntityManagerProvider.getEntityManager();
        appointmentRepository.createRepository(em, appointment);
        em.close();
    }

    public Optional<Appointment> readAppointment(String id) {
        EntityManager em = EntityManagerProvider.getEntityManager();
        Optional<Appointment> optionalAppointment = appointmentRepository.readAppointment(em, id);
        em.close();
        return optionalAppointment;
    }

    public void deleteAppointment(String id) {
        EntityManager em = EntityManagerProvider.getEntityManager();
        Optional<Appointment> appointment = appointmentRepository.readAppointment(em, id);

        if (appointment.isPresent()) {
            appointmentRepository.deleteAppointment(em, appointment.get());
        }
        em.close();
    }
    public void updateAppointment(Appointment appointment) {
        EntityManager em = EntityManagerProvider.getEntityManager();

        String appointmentName = appointment.getId();
        Optional<Appointment> dbOptionalAppointment = appointmentRepository.readAppointment(em, appointmentName);

        if (dbOptionalAppointment.isEmpty()) {
            em.close();
            return;
        }

        Appointment dbAppointment = dbOptionalAppointment.get(); // This object is in the PC
        dbAppointment.updateWith(appointment);

        appointmentRepository.createRepository(em, dbAppointment);

        em.close();
    }

    public void updateAppointmentButEasier(Appointment appointment){
        EntityManager em = EntityManagerProvider.getEntityManager();
        appointmentRepository.updateAppointment(em, appointment);
        em.close();
    }
}
