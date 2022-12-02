package com.sophos.api.laboratory.controller;

import com.sophos.api.laboratory.ServiceImp.AffiliateServiceImp;
import com.sophos.api.laboratory.model.Affiliate;
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
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)

class AffiliateControllerTest {

    @Mock
    AffiliateServiceImp affiliateServiceImp;

    @InjectMocks
    AffiliateController affiliateController;

    @Test
    void getlist200() {
        List<Affiliate> affiliate = new ArrayList<Affiliate>();
        affiliate.add(new Affiliate());
        when(affiliateServiceImp.getlist()).thenReturn(affiliate);
        assertEquals(HttpStatus.OK, affiliateController.getlist().getStatusCode());
    }

    @Test
    void getlist204() {
        List<Affiliate> affiliate = new ArrayList<Affiliate>();
        when(affiliateServiceImp.getlist()).thenReturn(affiliate);
        assertEquals(HttpStatus.NO_CONTENT, affiliateController.getlist().getStatusCode());
    }

    @Test
    void getbyid200() {
        when(affiliateServiceImp.getbyid(anyLong())).thenReturn(Optional.of(new Affiliate()));
        assertEquals(HttpStatus.OK, affiliateController.getbyid(anyLong()).getStatusCode());
    }

    @Test
    void getbyid404() {
        when(affiliateServiceImp.getbyid(anyLong())).thenReturn(Optional.empty());
        assertEquals(HttpStatus.NOT_FOUND, affiliateController.getbyid(anyLong()).getStatusCode());
    }

    @Test
    void post201() {
        Affiliate affiliate = new Affiliate();
        when(affiliateServiceImp.post(affiliate)).thenReturn("Save");
        assertEquals(HttpStatus.CREATED, affiliateController.post(affiliate).getStatusCode());
    }

    @Test()
    void post404() {
        Affiliate affiliate = new Affiliate();
        when(affiliateServiceImp.post(affiliate)).thenReturn("No save");
        assertEquals(HttpStatus.NOT_FOUND, affiliateController.post(affiliate).getStatusCode());
    }

    @Test
    void delete200() {
        when(affiliateServiceImp.delete(anyLong())).thenReturn("deleted");
        assertEquals(HttpStatus.OK, affiliateController.delete(anyLong()).getStatusCode());
    }

    @Test
    void delete204() {
        when(affiliateServiceImp.delete(anyLong())).thenReturn("no deleted");
        assertEquals(HttpStatus.NO_CONTENT, affiliateController.delete(anyLong()).getStatusCode());
    }

    @Test
    void put201() {
        Affiliate affiliate = new Affiliate();
        when(affiliateServiceImp.put(affiliate)).thenReturn(Optional.of(affiliate));
        assertEquals(HttpStatus.CREATED, affiliateController.put(affiliate).getStatusCode());
    }

    @Test
    void put404() {
        Affiliate affiliate = new Affiliate();
        when(affiliateServiceImp.put(affiliate)).thenReturn(Optional.empty());
        assertEquals(HttpStatus.NOT_FOUND, affiliateController.put(affiliate).getStatusCode());
    }
}