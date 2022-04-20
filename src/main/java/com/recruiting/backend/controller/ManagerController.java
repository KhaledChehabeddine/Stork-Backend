package com.recruiting.backend.controller;

import com.recruiting.backend.model.Manager;
import com.recruiting.backend.service.ManagerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class ManagerController {

    private final ManagerService managerService;

    public ManagerController(ManagerService managerService) { this.managerService = managerService; }

    @GetMapping("/all")
    public ResponseEntity<List<Manager>> getAllEmployees() {
        List<Manager> managers = managerService.findAllManagers();
        return new ResponseEntity<>(managers, HttpStatus.OK);
    }

    @GetMapping("/find")
    public ResponseEntity<Manager> getEmployeeById(@RequestParam("id") Long id) {
        Manager manager = managerService.findManagerById(id);
        return new ResponseEntity<>(manager, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Manager> addEmployee(@RequestBody Manager manager) {
        Manager newManager = managerService.addManager(manager);
        return new ResponseEntity<>(newManager, HttpStatus.CREATED);
    }

    @Transactional
    @PostMapping("/delete")
    public ResponseEntity<?> deleteEmployee(@RequestParam("id") Long id) {
        managerService.deleteManager(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Manager> updateEmployee(@RequestBody Manager manager) {
        Manager updatedManager = managerService.updateManager(manager);
        return new ResponseEntity<>(updatedManager, HttpStatus.OK);
    }

}
