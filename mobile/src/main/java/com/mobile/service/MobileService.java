package com.mobile.service;

import com.mobile.entity.Mobile;
import com.mobile.repository.MobileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MobileService {
    @Autowired
    private MobileRepository mobileRepository;

    public List<Mobile> getAllMobile(){
        return mobileRepository.findAll();
    }

    public Optional<Mobile> getMobileById(Long id){
        return mobileRepository.findById(id);
    }

    public Mobile saveMobile(Mobile mobile){
        return mobileRepository.save(mobile);
    }
    public void deleteMobile(Long id){
         mobileRepository.deleteById(id);
    }

    public Optional<Mobile> updateMobile(Long id, Mobile newMobile) {
        return mobileRepository.findById(id).map(existingMobile -> {
            existingMobile.setCompanyName(newMobile.getCompanyName());
            existingMobile.setModelName(newMobile.getModelName());
            existingMobile.setModelNumber(newMobile.getModelNumber());
            existingMobile.setPrice(newMobile.getPrice());

            return mobileRepository.save(existingMobile);
        });
    }

}
