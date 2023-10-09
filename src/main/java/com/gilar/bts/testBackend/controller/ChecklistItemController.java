package com.gilar.bts.testBackend.controller;

import com.gilar.bts.testBackend.model.ChecklistItem;
import com.gilar.bts.testBackend.service.ChecklistItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ChecklistItemController {

    @Autowired
    private ChecklistItemService checklistItemService;

    @GetMapping("/checklist/{checklistId}/item")
    public ResponseEntity<List<ChecklistItem>> getAllChecklistItem(@PathVariable Long checklistId) {
        Optional<ChecklistItem> result = checklistItemService.findByChecklistId(checklistId);
        if (result.isPresent()) {
            ResponseEntity.ok(result);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/checklist/{checklistId}/item/{checklistItemId}")
    public ResponseEntity<ChecklistItem> getAllChecklistItemByItem(@PathVariable Long checklistId, @PathVariable Long checklistItemId) {
        return checklistItemService.findByIdAndChecklistId(checklistItemId, checklistId)
                .map(checklistItem -> {
                    checklistItemService.deleteById(checklistId);
                    return ResponseEntity.ok(checklistItem);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/checklist/{checklistId}/item")
    @ResponseStatus(HttpStatus.CREATED)
    public ChecklistItem createChecklistItem(@PathVariable Long checklistId, @RequestBody @Validated ChecklistItem checklistItem) {
        return checklistItemService.createChecklistItem(checklistId, checklistItem);
    }

    @PutMapping("/checklist/{checklistId}/item/{checklistItemId}")
    @ResponseStatus(HttpStatus.OK)
    public ChecklistItem createChecklistItem(@PathVariable Long checklistId, @PathVariable Long checklistItemId,
                                             @RequestBody @Validated ChecklistItem checklistItem) {
        return checklistItemService.updateChecklistItem(checklistItemId, checklistId, checklistItem);
    }

    @DeleteMapping("/checklist/{checklistId}/item/{checklistItemId}")
    public ResponseEntity<ChecklistItem> deleteChecklistItem(@PathVariable Long checklistId, @PathVariable Long checklistItemId) {
        return checklistItemService.findByIdAndChecklistId(checklistItemId,checklistId)
                .map(user -> {
                    checklistItemService.deleteById(checklistItemId);
                    return ResponseEntity.ok(user);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}
