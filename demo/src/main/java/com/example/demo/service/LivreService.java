package com.example.demo.service;


import com.example.demo.entities.Livre;
import com.example.demo.repos.LivreRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

@Service
public class LivreService {

    @Autowired
    LivreRepos livreRepository;

    public List<Livre> getAll()
    {
        return livreRepository.findByOrderByTitreAsc();
    }

    public Livre getLivre(long id)
    {
        Livre livre_1=livreRepository.findById(id).get();
        Livre livre_2=livreRepository.findById(id).get();
        livre_1.setDderniereConsultation(new Date());
        livreRepository.save(livre_1);
        return livre_2;
    }

    public Livre createLivre(Livre livre) throws ParseException {
        return livreRepository.save(livre);
    }
    public void updateLivre(Livre livre,long id)
    {   Livre oldLivre=livreRepository.findById(id).get();
        if(oldLivre!=null)
        {
            oldLivre.setDderniereConsultation(new Date());
            oldLivre.setAuteur(livre.getAuteur());
            oldLivre.setDsortie(livre.getDsortie());
            oldLivre.setDisponible(livre.isDisponible());
            oldLivre.setTitre(livre.getTitre());
            livreRepository.save(oldLivre);
        }
    }
    public void deleteLivre(long id)
    {
        livreRepository.deleteById(id);
    }
}
