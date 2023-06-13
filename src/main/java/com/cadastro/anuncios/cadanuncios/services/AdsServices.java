package com.cadastro.anuncios.cadanuncios.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cadastro.anuncios.cadanuncios.entities.Ads;
import com.cadastro.anuncios.cadanuncios.repositories.AdsRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class AdsServices {
    
    @Autowired
    private AdsRepository adsRepository;

    public List<Ads> getAds() {
        return adsRepository.findAll();
    }

    public Ads getAdById(int id) {
        return adsRepository.findById(id).orElseThrow(
            () -> new EntityNotFoundException("Ad não encontrado")
        );
    }

    public Ads saveAd(Ads ads) {
        return adsRepository.save(ads);
    }


}
