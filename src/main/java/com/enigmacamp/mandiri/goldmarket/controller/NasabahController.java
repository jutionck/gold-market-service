package com.enigmacamp.mandiri.goldmarket.controller;

import com.enigmacamp.mandiri.goldmarket.model.nasabah.CreateNasabahRequest;
import com.enigmacamp.mandiri.goldmarket.model.nasabah.NasabahResponse;
import com.enigmacamp.mandiri.goldmarket.service.NasabahService;
import com.enigmacamp.mandiri.goldmarket.utils.WebResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/nasabah")
public class NasabahController {

    @Autowired
    NasabahService nasabahService;

    @PostMapping(
            value = "",
            produces = "application/json",
            consumes = "application/json"
    )
    public WebResponse<NasabahResponse> create(@RequestBody CreateNasabahRequest createNasabahRequest) {

        NasabahResponse newNasabah = nasabahService.create(createNasabahRequest);
        WebResponse<NasabahResponse> response = new WebResponse<>();
        response.setCode(200);
        response.setStatus(HttpStatus.CREATED);
        response.setData(newNasabah);

        return response;
    }
}
