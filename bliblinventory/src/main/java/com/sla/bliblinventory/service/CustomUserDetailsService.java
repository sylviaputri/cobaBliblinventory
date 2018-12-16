package com.sla.bliblinventory.service;

import com.sla.bliblinventory.model.CustomUserDetails;
import com.sla.bliblinventory.model.Karyawan;
import com.sla.bliblinventory.repository.KaryawanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private KaryawanRepository karyawanRepository;

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        Optional<Karyawan> optionalKaryawan = karyawanRepository.findByUserName(id);

        optionalKaryawan
                .orElseThrow(() -> new UsernameNotFoundException("Username not faound"));
        return  optionalKaryawan
                .map(CustomUserDetails::new).get();
    }
}
