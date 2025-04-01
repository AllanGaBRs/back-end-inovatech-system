package com.allan.inovatech.service;

import com.allan.inovatech.dto.request.post.AdmPostDTO;
import com.allan.inovatech.model.entities.Adm;
import com.allan.inovatech.repository.AdmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdmService {

    @Autowired
    private AdmRepository admRepository;

    public Adm createAdm(AdmPostDTO dto){
        Adm adm = new Adm();
        adm.setName(dto.name());
        adm.setEmail(dto.email());
        adm.setPassword(dto.password());
        return admRepository.save(adm);
    }


}
