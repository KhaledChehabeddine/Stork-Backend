package com.recruiting.backend.service;

import com.recruiting.backend.exception.VacancyNotFoundException;
import com.recruiting.backend.model.Vacancy;
import com.recruiting.backend.repo.VacancyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VacancyService {
    private final VacancyRepo vacancyRepo;

    @Autowired
    public VacancyService(VacancyRepo vacancyRepo) {
        this.vacancyRepo = vacancyRepo;
    }

    public Vacancy addVacancy(Vacancy vacancy) {
        return vacancyRepo.save(vacancy);
    }

    public List<Vacancy> findAllVacancies() {
        return vacancyRepo.findAll();
    }

    public Vacancy findVacancyById(Long id) {
        return vacancyRepo.findVacancyById(id)
                .orElseThrow(() -> new VacancyNotFoundException("Vacancy with id " + id + " not found"));
    }

    public void deleteVacancyById(Long id) {
        vacancyRepo.deleteVacancyById(id);
    }
}
