package com.recruiting.backend.controller;

import com.recruiting.backend.model.Vacancy;
import com.recruiting.backend.service.VacancyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vacancy")
public class VacancyController {
    private final VacancyService vacancyService;

    public VacancyController(VacancyService vacancyService) {
        this.vacancyService = vacancyService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Vacancy>> getAllVacancies() {
        List<Vacancy> vacancies = vacancyService.findAllVacancies();
        return new ResponseEntity<>(vacancies, HttpStatus.OK);
    }

    @GetMapping("/find")
    public ResponseEntity<Vacancy> findVacancyById(@RequestParam("id") Long id) {
        Vacancy vacancy = vacancyService.findVacancyById(id);
        return new ResponseEntity<>(vacancy, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Vacancy> addVacancy(@RequestBody Vacancy vacancy) {
        Vacancy newVacancy = vacancyService.addVacancy(vacancy);
        return new ResponseEntity<>(newVacancy, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Vacancy> updateVacancy(@RequestBody Vacancy vacancy) {
        Vacancy updated = vacancyService.updateVacancy(vacancy);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @Transactional
    @PostMapping("/delete")
    public ResponseEntity<?> deleteVacancyById(@RequestParam("id") Long id) {
        vacancyService.deleteVacancyById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
