package com.cadastro.anuncios.cadanuncios.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cadastro.anuncios.cadanuncios.entities.Ads;
import com.cadastro.anuncios.cadanuncios.repositories.AdsRepository;

public class AdsServices {
    
    @Autowired
    private AdsRepository adsRepository;

    public List<Ads> getAds() {
        return null;
    }

    public static Ads getAdById(int id) {
        return null;
    }

    public Ads saveAd(Ads ads) {
        return adsRepository.save(ads);
    }


}
