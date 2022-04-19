package com.recruiting.backend.controller;

import com.recruiting.backend.model.Action;
import com.recruiting.backend.service.ActionService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/action")
public class ActionController {
    private final ActionService actionService;

    public ActionController(ActionService actionService) {
        this.actionService = actionService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Action>> getActionsByCandidateId(@RequestParam("candidateId") Long candidateId) {
        List<Action> actions = actionService.findActionsByCandidateId(candidateId);
        return new ResponseEntity<>(actions, HttpStatus.OK);
    }

    @GetMapping("/find")
    public ResponseEntity<Action> getActionById(@RequestParam("id") Long id) {
        Action action = actionService.findActionById(id);
        return new ResponseEntity<>(action, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Action> addAction(@RequestBody Action action) {
        Action newAction = actionService.addAction(action);
        return new ResponseEntity<>(newAction, HttpStatus.OK);
    }

    @PostMapping("/delete")
    public ResponseEntity<?> deleteAction(@RequestParam("id") Long id) {
        actionService.deleteActionById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/deleteAll")
    public ResponseEntity<?> deleteActionsByCandidateId(@RequestParam("candidateId") Long candidateId) {
        actionService.deleteActionsByCandidateId(candidateId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
