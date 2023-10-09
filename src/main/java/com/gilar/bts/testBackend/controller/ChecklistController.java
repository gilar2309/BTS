package com.gilar.bts.testBackend.controller;

import com.gilar.bts.testBackend.model.Checklist;
import com.gilar.bts.testBackend.service.ChecklistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ChecklistController {

    @Autowired
    private ChecklistService checklistService;

    @GetMapping("/checklist")
    public List<Checklist> getAllChecklist() {
        return checklistService.findAllChecklist();
    }

    @PostMapping("/checklist")
    @ResponseStatus(HttpStatus.CREATED)
    public Checklist createChecklist(@RequestBody @Validated Checklist checklist) {
        return checklistService.createChecklist(checklist);
    }

    @DeleteMapping("/checklist/{checklistId}")
    public ResponseEntity<Checklist> deleteChecklist(@PathVariable Long checklistId) {
        return checklistService.findById(checklistId)
                .map(user -> {
                    checklistService.deleteById(checklistId);
                    return ResponseEntity.ok(user);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}
