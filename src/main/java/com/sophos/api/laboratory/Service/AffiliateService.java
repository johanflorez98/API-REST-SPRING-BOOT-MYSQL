package com.sophos.api.laboratory.Service;

import com.sophos.api.laboratory.model.Affiliate;

import java.util.List;
import java.util.Optional;

public interface AffiliateService {

    public List<Affiliate> getlist();

    public Optional<Affiliate> getbyid(Long id_affiliate);

    public String post(Affiliate affiliate);

    public Optional<Affiliate> put(Affiliate affiliate);

    public String delete(Long id_affiliate);

}
