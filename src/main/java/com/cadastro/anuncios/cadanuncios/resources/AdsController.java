package com.cadastro.anuncios.cadanuncios.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.cadastro.anuncios.cadanuncios.entities.Ads;
import com.cadastro.anuncios.cadanuncios.services.AdsServices;

@RestController
@RequestMapping("anuncios")
@CrossOrigin
public class AdsController {
    
    @Autowired
    private AdsServices adsServices;

    @GetMapping("{id}")
    public ResponseEntity<Ads> getAd(@PathVariable int id){
        Ads ads = adsServices.getAdById(id);
        return ResponseEntity.ok().body(ads);
    }

    @GetMapping
    public ResponseEntity<List<Ads>> getAds(){
        List<Ads> ads = adsServices.getAds();
        return ResponseEntity.ok().body(ads);
    }

    @PostMapping
    public ResponseEntity<Ads> saveAd(@RequestBody Ads ads){
        Ads newAd = adsServices.saveAd(ads);

        URI location = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(ads.getId())
            .toUri(); 

        return ResponseEntity.created(location).body(newAd);
    }
}
