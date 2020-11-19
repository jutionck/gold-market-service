package com.enigmacamp.mandiri.goldmarket.service;

import com.enigmacamp.mandiri.goldmarket.model.nasabah.CreateNasabahRequest;
import com.enigmacamp.mandiri.goldmarket.model.nasabah.NasabahResponse;

public interface NasabahService {

    NasabahResponse create(CreateNasabahRequest createNasabahRequest);

}
