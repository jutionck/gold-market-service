package com.enigmacamp.mandiri.goldmarket.service.impl;

import com.enigmacamp.mandiri.goldmarket.entity.Nasabah;
import com.enigmacamp.mandiri.goldmarket.model.nasabah.CreateNasabahRequest;
import com.enigmacamp.mandiri.goldmarket.model.nasabah.NasabahResponse;
import com.enigmacamp.mandiri.goldmarket.repository.NasabahRepository;
import com.enigmacamp.mandiri.goldmarket.service.NasabahService;
import com.enigmacamp.mandiri.goldmarket.utils.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class NasabahServiceImpl implements NasabahService {

    @Autowired
    NasabahRepository nasabahRepository;

    @Override
    public NasabahResponse create(CreateNasabahRequest createNasabahRequest) {

//        ValidationUtil validationUtil = new ValidationUtil();
//        validationUtil.validation(createNasabahRequest);

        Date createdAt = new Date();
        Nasabah nasabah = new Nasabah(
                createNasabahRequest.getFirstName(),
                createNasabahRequest.getLastName(),
                createNasabahRequest.getBirthdayDate(),
                createNasabahRequest.getAddress(),
                createNasabahRequest.getStatus(),
                createNasabahRequest.getUserName(),
                createNasabahRequest.getPassword(),
                createNasabahRequest.getEmail(),
                createdAt,
                null
        );
        nasabahRepository.save(nasabah);
        return convertCustomerToCustomerResponse(nasabah);
    }

    private NasabahResponse convertCustomerToCustomerResponse(Nasabah nasabah) {
        NasabahResponse nasabahResponse = new NasabahResponse();
        nasabahResponse.setId(nasabah.getId());
        nasabahResponse.setFirstName(nasabah.getFirstName());
        nasabahResponse.setLastName(nasabah.getLastName());
        nasabahResponse.setBirthdayDate(nasabah.getBirthdayDate());
        nasabahResponse.setAddress(nasabah.getAddress());
        nasabahResponse.setStatus(nasabah.getStatus());
        nasabahResponse.setUserName(nasabah.getUserName());
        nasabahResponse.setPassword(nasabah.getPassword());
        nasabahResponse.setEmail(nasabah.getEmail());
        nasabahResponse.setCreatedAt(nasabah.getCreatedAt());
        nasabahResponse.setUpdatedAt(nasabah.getUpdatedAt());
        return nasabahResponse;
    }

}
