package com.sla.bliblinventory.repository;

import com.sla.bliblinventory.model.Karyawan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface KaryawanRepository extends JpaRepository<Karyawan, String> {
    Optional<Karyawan> findByUserName(String id);
}
