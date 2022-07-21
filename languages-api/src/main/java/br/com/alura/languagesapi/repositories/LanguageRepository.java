package br.com.alura.languagesapi.repositories;

import br.com.alura.languagesapi.entities.Language;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface LanguageRepository extends MongoRepository<Language, String> {

    Optional<Language> findByTitleContainingIgnoreCase(String title);
}
