package com.example.demo.controller;

import com.example.demo.model.Payment;
import com.example.demo.model.Profiles;
import com.example.demo.repo.PaymentRepository;
import com.example.demo.repo.ProfileRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
public class AppController {
    public static final Logger LOGGER = LoggerFactory.getLogger(AppController.class);
    private final ProfileRepository profileRepository;
    private final PaymentRepository paymentRepository;

    @Autowired
    public AppController(ProfileRepository profileRepository, PaymentRepository paymentRepository) {
        this.profileRepository = profileRepository;
        this.paymentRepository = paymentRepository;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/api/allProfiles")
    public List<Profiles> getAllProfiles(){
        return profileRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/api/addProfile")
    public String addProfile(@RequestBody Profiles profiles){
        try {
            profileRepository.addProfile(profiles.getUsername(), profiles.getPassword(), profiles.getAge(), profiles.getMobileNo());
            return profiles.getUsername();
        } catch (Exception e) {
            LOGGER.info(e.toString());
            return "Failure";
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/api/allPayments")
    public List<Payment> getAllPayments(){
        return paymentRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/api/addPayment")
    public String addPayment(@RequestBody Payment payment){
        try {
            LOGGER.info(payment.toString());
            paymentRepository.addPayment(payment.getUsername(), payment.getBatch(), payment.getPaymentForMonth());
            return "Success";
        } catch (Exception e) {
            LOGGER.info(e.getMessage());
            return "Failure";
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/api/validateProfile")
    public String validateProfile(@RequestParam String username, @RequestParam String password) {
        try {
            List<String> userList = profileRepository.validateProfile(username, password);
            if (!userList.isEmpty()) {
                return userList.get(0);
            }
        } catch (Exception e){
            LOGGER.info(e.getMessage());
        }
        return "Failure";
    }
}
