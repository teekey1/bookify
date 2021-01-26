package com.codecool.bookify.controller;

import com.codecool.bookify.model.Appointment;
import com.codecool.bookify.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {
    private final AppointmentService appointmentService;

    @Autowired
    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping()
    public List<Appointment> getAppointments(){
        return appointmentService.getAll();
    }

    @GetMapping(value = "/{id}")
    public Appointment getAppointment(@PathVariable Long id){
        return appointmentService.getById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void removeAppointment(@PathVariable Long id) {
        appointmentService.delete(id);
    }

    @PostMapping()
    public void addAppointment(@RequestBody Appointment appointment){
        appointmentService.insert(appointment);
    }

    @PutMapping(value = "/{id}")
    public void updateAppointment(@RequestBody Appointment appointment, @PathVariable Long id) {
    }
}
