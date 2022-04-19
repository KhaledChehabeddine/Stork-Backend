package com.recruiting.backend.repo;

import com.recruiting.backend.model.Vacancy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface VacancyRepo extends JpaRepository<Vacancy, Long> {
    void deleteVacancyById(Long id);
    Optional<Vacancy> findVacancyById(Long id);
    Optional<List<Vacancy>> findVacanciesByJobTitle(String jobTitle);
    Optional<List<Vacancy>> findVacanciesByCountry(String country);
    Optional<List<Vacancy>> findVacanciesByCity(String city);
}
