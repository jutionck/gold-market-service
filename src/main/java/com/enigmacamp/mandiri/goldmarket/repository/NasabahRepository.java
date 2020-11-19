package com.enigmacamp.mandiri.goldmarket.repository;

import com.enigmacamp.mandiri.goldmarket.entity.Nasabah;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NasabahRepository extends JpaRepository<Nasabah, String> {

}
