package com.example.demo.controller;

import com.example.demo.entities.Livre;
import com.example.demo.service.LivreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/emsi_api/livres")
public class LivreController {

    @Autowired
    LivreService livreService;

    @GetMapping
    public List<Livre> getAll()
    {
        return livreService.getAll();
    }

    @GetMapping("/{id}")
    public Livre getLivre(@PathVariable long id)
    {
        return livreService.getLivre(id);
    }

    @PostMapping
    public Livre createLivre(@RequestBody Livre livre) throws ParseException {return  livreService.createLivre(livre);}

    @PutMapping("/{id}")
    public void updateLivre(@PathVariable long id,@RequestBody Livre livre)
    {
        livreService.updateLivre(livre,id);
    }

    @DeleteMapping("/{id}")
    public void deleteLivre(@PathVariable long id)
    {
        livreService.deleteLivre(id);
    }




}
