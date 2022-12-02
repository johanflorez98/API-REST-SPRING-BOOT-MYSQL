package com.sophos.api.laboratory.Service;

import com.sophos.api.laboratory.model.Appointment;

import java.util.List;
import java.util.Optional;

public interface AppointmentService {

    public List<Appointment> getlist();

    public Optional<Appointment> getbyid(Long id_appointment);

    public String post(Appointment appointment);

    public Optional<Appointment> put(Appointment appointment);

    public String delete(Long id_appointment);

    public List<Appointment> getbyaffiliate(Long id_affiliate);

    public List<Appointment> getbydate(String date);

}
