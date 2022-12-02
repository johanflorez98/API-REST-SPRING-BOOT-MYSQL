package com.sophos.api.laboratory.controller;

import com.sophos.api.laboratory.Service.TestService;
import com.sophos.api.laboratory.model.Test;
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

class TestControllerTest {

    @Mock
    TestService testService;

    @InjectMocks
    TestController testController;

    @org.junit.jupiter.api.Test
    void getlist200() {
        List<Test> test = new ArrayList<Test>();
        test.add(new Test());
        when(testService.getlist()).thenReturn(test);
        assertEquals(HttpStatus.OK, testController.getlist().getStatusCode());
    }

    @org.junit.jupiter.api.Test
    void getlist204() {
        List<Test> test = new ArrayList<Test>();
        when(testService.getlist()).thenReturn(test);
        assertEquals(HttpStatus.NO_CONTENT, testController.getlist().getStatusCode());
    }

    @org.junit.jupiter.api.Test
    void getbyid200() {
        when(testService.getbyid(anyLong())).thenReturn(Optional.of(new Test()));
        assertEquals(HttpStatus.OK, testController.getbyid(anyLong()).getStatusCode());
    }

    @org.junit.jupiter.api.Test
    void getbyid404() {
        when(testService.getbyid(anyLong())).thenReturn(Optional.empty());
        assertEquals(HttpStatus.NOT_FOUND, testController.getbyid(anyLong()).getStatusCode());
    }

    @org.junit.jupiter.api.Test
    void post201() {
        Test test = new Test();
        when(testService.post(test)).thenReturn("Save");
        assertEquals(HttpStatus.CREATED, testController.post(test).getStatusCode());
    }

    @org.junit.jupiter.api.Test
    void post404() {
        Test test = new Test();
        when(testService.post(test)).thenReturn("No save");
        assertEquals(HttpStatus.NOT_FOUND, testController.post(test).getStatusCode());
    }

    @org.junit.jupiter.api.Test
    void delete200() {
        when(testService.delete(anyLong())).thenReturn("deleted");
        assertEquals(HttpStatus.OK, testController.delete(anyLong()).getStatusCode());
    }

    @org.junit.jupiter.api.Test
    void delete204() {
        when(testService.delete(anyLong())).thenReturn("no deleted");
        assertEquals(HttpStatus.NO_CONTENT, testController.delete(anyLong()).getStatusCode());
    }

    @org.junit.jupiter.api.Test
    void put201() {
        Test test = new Test();
        when(testService.put(test)).thenReturn(Optional.of(test));
        assertEquals(HttpStatus.CREATED, testController.put(test).getStatusCode());
    }

    @org.junit.jupiter.api.Test
    void put404() {
        Test test = new Test();
        when(testService.put(test)).thenReturn(Optional.empty());
        assertEquals(HttpStatus.NOT_FOUND, testController.put(test).getStatusCode());
    }
}