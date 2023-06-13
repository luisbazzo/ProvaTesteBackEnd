package com.cadastro.anuncios.cadanuncios.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cadastro.anuncios.cadanuncios.entities.Ads;

public interface AdsRepository extends JpaRepository <Ads, Integer>{
    
}
