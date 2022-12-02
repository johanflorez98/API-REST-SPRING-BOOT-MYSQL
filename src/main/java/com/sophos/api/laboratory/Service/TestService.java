package com.sophos.api.laboratory.Service;

import com.sophos.api.laboratory.model.Test;

import java.util.List;
import java.util.Optional;

public interface TestService {

    public List<Test> getlist();

    public Optional<Test> getbyid(Long id_test);

    public String post(Test test);

    public Optional<Test> put(Test test);

    public String delete(Long id_test);

}
