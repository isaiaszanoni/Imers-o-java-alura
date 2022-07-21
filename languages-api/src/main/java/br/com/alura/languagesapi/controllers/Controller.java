package br.com.alura.languagesapi.controllers;

import br.com.alura.languagesapi.entities.Language;
import br.com.alura.languagesapi.services.LanguageService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("")
public class Controller {

    @Autowired
    private LanguageService service;

    @GetMapping("/languages")
    public List<Language> getLanguages() {
        return service.getLanguages();
    }

    @PostMapping("/languages")
    public void postLanguage(@RequestBody Language lang) {
        service.addLanguage(lang);
    }

    @PutMapping("/languages")
    public ResponseEntity putLanguage(@RequestBody Language language) {
        return ResponseEntity.status(service.putLanguage(language)).build();
    }

    @DeleteMapping("/languages")
    public void deleteLanguage(@RequestParam(value = "title") String title) {
        service.deleteLanguage(title);
    }

}
