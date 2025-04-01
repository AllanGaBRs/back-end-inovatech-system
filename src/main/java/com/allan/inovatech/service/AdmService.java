package com.allan.inovatech.service;

import com.allan.inovatech.dto.request.post.AdmPostDTO;
import com.allan.inovatech.dto.request.put.AdmPutDTO;
import com.allan.inovatech.model.entities.Adm;
import com.allan.inovatech.model.enums.AccountStatus;
import com.allan.inovatech.repository.AdmRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

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

    public Adm updateAdm(Integer id, AdmPutDTO dto){
        Adm adm = admRepository.findById(id).orElseThrow(()
            -> new EntityNotFoundException("Adm not found"));
        if(adm.getAccountStatus() == AccountStatus.INATIVO){
            throw new IllegalStateException("Adm inativo");
        }
        adm.setName(dto.name());
        adm.setEmail(dto.email());
        return admRepository.save(adm);
    }

    public void deleteAdm(Integer id){
        Adm adm = admRepository.findById(id).orElseThrow(()
                -> new EntityNotFoundException("Adm not found"));
        if(adm.getAccountStatus() == AccountStatus.INATIVO){
            throw new IllegalStateException("Adm já está inativo");
        }
        adm.setAccountStatus(AccountStatus.INATIVO);
        admRepository.save(adm);
    }

    public void activeAdm(Integer id){
        Adm adm = admRepository.findById(id).orElseThrow(()
                -> new EntityNotFoundException("Adm not found"));
        if(adm.getAccountStatus() == AccountStatus.ATIVO){
            throw new IllegalStateException("Adm já está ativo");
        }
        adm.setAccountStatus(AccountStatus.ATIVO);
        admRepository.save(adm);
    }

    public void uploadProfilePicture(Integer admId, MultipartFile file) {
        try {
            Adm adm = admRepository.findById(admId)
                    .orElseThrow(() -> new RuntimeException("Adm not found"));

            if(adm.getAccountStatus() == AccountStatus.INATIVO){
                throw new IllegalStateException("Adm inativo");
            }

            adm.setProfilePic(file.getBytes());
            admRepository.save(adm);

        } catch (IOException e) {
            throw new RuntimeException("Erro ao salvar imagem", e);
        }
    }

    public byte[] getProfilePicture(Integer admId) {
        Adm adm = admRepository.findById(admId)
                .orElseThrow(() -> new RuntimeException("Adm not found"));

        if(adm.getAccountStatus() == AccountStatus.INATIVO){
            throw new IllegalStateException("Adm inativo");
        }

        if (adm.getProfilePic() == null) {
            throw new RuntimeException("Nenhuma imagem encontrada");
        }

        return adm.getProfilePic();
    }

}
