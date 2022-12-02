package com.sophos.api.laboratory.Service;

import com.sophos.api.laboratory.model.Test;
import com.sophos.api.laboratory.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TestService {

    @Autowired
    private TestRepository testRepository;

    public List<Test> getlist() {
        return testRepository.findAll();
    }

    public Optional<Test> getbyid(Long id_test) {
        return testRepository.findById(id_test);
    }

    public String post(Test test) {
        try {
            testRepository.save(test);

            return "Save";
        } catch (Exception e) {
            return "No save";
        }
    }

    public Optional<Test> put(Test test) {
        Optional<Test> optionalTest = testRepository.findById(test.getId_test());

        if (optionalTest.isPresent()){
            Test updateTest = optionalTest.get();

            updateTest.setName(test.getName());
            updateTest.setDescription(test.getDescription());

            testRepository.save(updateTest);

            return Optional.ofNullable(updateTest);
        } else {
            return Optional.empty();
        }
    }

    public String delete(Long id_test) {
        Optional<Test> test = testRepository.findById(id_test);
        if (test.isPresent()) {
            testRepository.deleteById(id_test);
            return "deleted";
        } else {
            return "no deleted";
        }
    }
}
