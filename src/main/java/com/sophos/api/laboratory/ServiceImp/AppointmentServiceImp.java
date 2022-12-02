package com.sophos.api.laboratory.ServiceImp;

import com.sophos.api.laboratory.Service.AppointmentService;
import com.sophos.api.laboratory.model.Affiliate;
import com.sophos.api.laboratory.model.Appointment;
import com.sophos.api.laboratory.model.Test;
import com.sophos.api.laboratory.repository.AffiliateRepository;
import com.sophos.api.laboratory.repository.AppointmentRepository;
import com.sophos.api.laboratory.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentServiceImp implements AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private AffiliateRepository affiliateRepository;

    @Autowired
    private TestRepository testRepository;

    public List<Appointment> getlist() {
        return appointmentRepository.findAll();
    }

    public Optional<Appointment> getbyid(Long id_appointment) {
        return appointmentRepository.findById(id_appointment);
    }

    public String post(Appointment appointment) {

        Optional<Affiliate> AffiliateOptional = affiliateRepository.findById(appointment.getAffiliate().getId_affiliate());

        Optional<Test> TestOptional = testRepository.findById(appointment.getTest().getId_test());

        if (AffiliateOptional.isPresent() && TestOptional.isPresent()) {
            appointment.setAffiliate(AffiliateOptional.get());
            appointment.setTest(TestOptional.get());

            try {
                appointmentRepository.save(appointment);

                return "Save";
            } catch (Exception e) {
                return "No save";
            }
        } else {
            return "No save";
        }
    }

        /*Optional<Affiliate> AffiliateOptional = affiliateRepository.findById(appoinments.getAffiliates().getId_affiliate());

        Optional<Test> TestOptional = testRepository.findById(appoinments.getTests().getId_test());

        if (AffiliateOptional.isPresent() && TestOptional.isPresent()) {
            appoinments.setAffiliates(AffiliateOptional.get());
            appoinments.setTests(TestOptional.get());

            return appointmentRepository.save(appoinments);
        } else {
            return null;
        }
    }*/

    public Optional<Appointment> put(Appointment appointment) {

        Optional<Affiliate> AffiliateOptional = affiliateRepository.findById(appointment.getAffiliate().getId_affiliate());

        Optional<Test> TestOptional = testRepository.findById(appointment.getTest().getId_test());

        Optional<Appointment> optionalAppointment = appointmentRepository.findById(appointment.getId());

        if (AffiliateOptional.isPresent() && TestOptional.isPresent() && optionalAppointment.isPresent()){
            Appointment updateAppointment = optionalAppointment.get();

            updateAppointment.setAffiliate(AffiliateOptional.get());
            updateAppointment.setTest(TestOptional.get());
            updateAppointment.setDate(appointment.getDate());
            updateAppointment.setHour(appointment.getHour());

            appointmentRepository.save(updateAppointment);

            return Optional.ofNullable(updateAppointment);
        } else {
            return Optional.empty();
        }
    }

    public String delete(Long id_appointment) {
        Optional<Appointment> appointments = appointmentRepository.findById(id_appointment);
        if (appointments.isPresent()) {
            appointmentRepository.deleteById(id_appointment);

            return "deleted";
        } else {
            return "no deleted";
        }
    }

    public List<Appointment> getbyaffiliate(Long id_affiliate){

        return appointmentRepository.getbyaffiliate(id_affiliate);
    }

    public List<Appointment> getbydate(String date){

        return appointmentRepository.getbydate(date);
    }
}
