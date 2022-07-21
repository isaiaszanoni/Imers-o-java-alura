package br.com.alura.languagesapi.services;

import br.com.alura.languagesapi.entities.Language;
import br.com.alura.languagesapi.repositories.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LanguageService {

    @Autowired
    private LanguageRepository repository;

    public List<Language> getLanguages() {
        List<Language> languages = repository.findAll();
        return languages;
    }

    public void addLanguage(Language language) {
        repository.save(language);
    }

    public int putLanguage(Language receivedLanguage) {
        if (repository.findById(receivedLanguage.getId()).isPresent()) {
            Language updateLanguage = new Language(
                    receivedLanguage.getId(),
                    receivedLanguage.getTitle(),
                    receivedLanguage.getImage(),
                    receivedLanguage.getRankPosition()
            );
            repository.save(updateLanguage);
            return 200;
        } else {
            repository.save(receivedLanguage);
            return 201;
        }
    }

    public void deleteLanguage(String title) {
        String id = repository.findByTitleContainingIgnoreCase(title).get().getId();
        repository.deleteById(id);
    }

}
