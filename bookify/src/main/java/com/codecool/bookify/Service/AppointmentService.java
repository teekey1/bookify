package com.codecool.bookify.Service;

import com.codecool.bookify.Exceptions.NotFoundException;
import com.codecool.bookify.Model.Appointment;
import com.codecool.bookify.Repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService implements HelperService<Appointment>{

    private final AppointmentRepository appointmentRepository;

    @Autowired
    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public List<Appointment> getAll() {
        return appointmentRepository.findAll();
    }

    @Override
    public Appointment getById(Long id) {
        Optional<Appointment> appointment = appointmentRepository.findById(id);
        if (appointment.isPresent()) return appointment.get();
        throw new NotFoundException();
    }

    @Override
    public void update(Appointment appointment, Long id) {
    }

    @Override
    public void insert(Appointment appointment) {
        appointmentRepository.save(appointment);
    }

    @Override
    public void delete(Long id) {
        appointmentRepository.deleteById(id);
    }
}
