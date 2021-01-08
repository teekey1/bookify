package com.codecool.bookify.Controller;

import com.codecool.bookify.Model.Appointment;
import com.codecool.bookify.Service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AppointmentController {
    private final AppointmentService appointmentService;

    @Autowired
    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping("/appointments")
    public List<Appointment> getAppointments(){
        return appointmentService.getAll();
    }

    @GetMapping("appointments/{id}")
    public Appointment getAppointment(@PathVariable Long id){
        return appointmentService.getById(id);
    }

    @DeleteMapping("appointments/{id}")
    public void removeAppointment(@PathVariable Long id) {
        appointmentService.delete(id);
    }

    @PostMapping("/appointments")
    public void addAppointment(@RequestBody Appointment appointment){
        appointmentService.insert(appointment);
    }

    @PutMapping("/appointments/{id}")
    public void updateAppointment(@RequestBody Appointment appointment, @PathVariable Long id) {
    }
}
