package com.sophos.api.laboratory.controller;

import com.sophos.api.laboratory.Service.AppointmentService;
import com.sophos.api.laboratory.model.Appointment;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)

class AppointmentControllerTest {

    @Mock
    AppointmentService appointmentService;

    @InjectMocks
    AppointmentController appointmentController;

    @Test
    void getlist200() {
        List<Appointment> appointment = new ArrayList<Appointment>();
        appointment.add(new Appointment());
        when(appointmentService.getlist()).thenReturn(appointment);
        assertEquals(HttpStatus.OK, appointmentController.getlist().getStatusCode());
    }

    @Test
    void getlist204() {
        List<Appointment> appointment = new ArrayList<Appointment>();
        when(appointmentService.getlist()).thenReturn(appointment);
        assertEquals(HttpStatus.NO_CONTENT, appointmentController.getlist().getStatusCode());
    }

    @Test
    void getbyid200() {
        when(appointmentService.getbyid(anyLong())).thenReturn(Optional.of(new Appointment()));
        assertEquals(HttpStatus.OK, appointmentController.getbyid(anyLong()).getStatusCode());
    }

    @Test
    void getbyid404() {
        when(appointmentService.getbyid(anyLong())).thenReturn(Optional.empty());
        assertEquals(HttpStatus.NOT_FOUND, appointmentController.getbyid(anyLong()).getStatusCode());
    }

    @Test
    void post201() {
        Appointment appointment = new Appointment();
        when(appointmentService.post(appointment)).thenReturn("Save");
        assertEquals(HttpStatus.CREATED, appointmentController.post(appointment).getStatusCode());
    }

    @Test
    void post404() {
        Appointment appointment = new Appointment();
        when(appointmentService.post(appointment)).thenReturn("No save");
        assertEquals(HttpStatus.NOT_FOUND, appointmentController.post(appointment).getStatusCode());
    }

    @Test
    void delete200() {
        when(appointmentService.delete(anyLong())).thenReturn("deleted");
        assertEquals(HttpStatus.OK, appointmentController.delete(anyLong()).getStatusCode());
    }

    @Test
    void delete204() {
        when(appointmentService.delete(anyLong())).thenReturn("no deleted");
        assertEquals(HttpStatus.NO_CONTENT, appointmentController.delete(anyLong()).getStatusCode());
    }

    @Test
    void put201() {
        Appointment appointment = new Appointment();
        when(appointmentService.put(appointment)).thenReturn(Optional.of(appointment));
        assertEquals(HttpStatus.CREATED, appointmentController.put(appointment).getStatusCode());
    }

    @Test
    void put404() {
        Appointment appointment = new Appointment();
        when(appointmentService.put(appointment)).thenReturn(Optional.empty());
        assertEquals(HttpStatus.NOT_FOUND, appointmentController.put(appointment).getStatusCode());
    }
    @Test
    void getbyaffiliate200() {
        List<Appointment> appointment = new ArrayList<Appointment>();
        appointment.add(new Appointment());
        when(appointmentService.getbyaffiliate(anyLong())).thenReturn(appointment);
        assertEquals(HttpStatus.OK, appointmentController.getbyaffiliate(anyLong()).getStatusCode());
    }

    @Test
    void getbyaffiliate404() {
        List<Appointment> appointment = new ArrayList<Appointment>();
        when(appointmentService.getbyaffiliate(anyLong())).thenReturn(appointment);
        assertEquals(HttpStatus.NOT_FOUND, appointmentController.getbyaffiliate(anyLong()).getStatusCode());
    }

    @Test
    void getbydate200() {
        List<Appointment> appointment = new ArrayList<Appointment>();
        appointment.add(new Appointment());
        when(appointmentService.getbydate(anyString())).thenReturn(appointment);
        assertEquals(HttpStatus.OK, appointmentController.getbydate(anyString()).getStatusCode());
    }

    @Test
    void getbydate404() {
        List<Appointment> appointment = new ArrayList<Appointment>();
        when(appointmentService.getbydate(anyString())).thenReturn(appointment);
        assertEquals(HttpStatus.NOT_FOUND, appointmentController.getbydate(anyString()).getStatusCode());
    }
}