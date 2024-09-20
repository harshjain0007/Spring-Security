package com.mobile.controller;

import com.mobile.entity.Mobile;
import com.mobile.service.MobileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MobileController {
    @Autowired
    private MobileService mobileService;

    @GetMapping
    public List<Mobile> getMobile(){
        return mobileService.getAllMobile();
    }
    @GetMapping("/{id}")
    public Optional<Mobile> getMobileById(@PathVariable Long id){
        return mobileService.getMobileById(id);
    }
    @PostMapping("add")
    public Mobile addMobile(@RequestBody Mobile mobile){
        return mobileService.saveMobile(mobile);
    }
    @DeleteMapping("/{id}")
    public void deleteMobile(@PathVariable Long id){
         mobileService.deleteMobile(id);
        System.out.println("DELETED ");
    }


    @PutMapping("/{id}")
    public ResponseEntity<Optional<Mobile>> updateMobile(@PathVariable Long id, @RequestBody Mobile mobile){
        Optional<Mobile> updatedMobile = mobileService.updateMobile(id,mobile);
        return ResponseEntity.ok(updatedMobile);
    }

}
