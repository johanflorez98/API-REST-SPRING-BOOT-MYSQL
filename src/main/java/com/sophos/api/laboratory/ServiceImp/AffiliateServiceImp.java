package com.sophos.api.laboratory.ServiceImp;

import com.sophos.api.laboratory.Service.AffiliateService;
import com.sophos.api.laboratory.model.Affiliate;
import com.sophos.api.laboratory.repository.AffiliateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AffiliateServiceImp implements AffiliateService {

    @Autowired
    private AffiliateRepository affiliateRepository;

    public List<Affiliate> getlist() {
        return affiliateRepository.findAll();
    }

    public Optional<Affiliate> getbyid(Long id_affiliate) {
        return affiliateRepository.findById(id_affiliate);
    }

    public String post(Affiliate affiliate) {

        try {
            affiliateRepository.save(affiliate);

            return "Save";
        } catch (Exception e) {
            return "No save";
        }

    }

    public Optional<Affiliate> put(Affiliate affiliate) {
        Optional<Affiliate> optionalAffiliate = affiliateRepository.findById(affiliate.getId_affiliate());

        if (optionalAffiliate.isPresent()){
            Affiliate updateAffiliate = optionalAffiliate.get();

            updateAffiliate.setAge(affiliate.getAge());
            updateAffiliate.setMail(affiliate.getMail());
            updateAffiliate.setName(affiliate.getName());

            affiliateRepository.save(updateAffiliate);

            return Optional.ofNullable(updateAffiliate);
        } else {
            return Optional.empty();
        }
    }

    public String delete(Long id_affiliate) {
        Optional<Affiliate> affiliate = affiliateRepository.findById(id_affiliate);
        if (affiliate.isPresent()) {
            affiliateRepository.deleteById(id_affiliate);
            return "deleted";
        } else {
            return "no deleted";
        }
    }
}
