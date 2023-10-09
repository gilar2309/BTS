package com.gilar.bts.testBackend.service;

import com.gilar.bts.testBackend.model.ChecklistItem;
import com.gilar.bts.testBackend.repo.ChecklistItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChecklistItemService {

    private final ChecklistItemRepo checklistItemRepo;

    @Autowired
    public ChecklistItemService(ChecklistItemRepo checklistRepo) {
        this.checklistItemRepo = checklistRepo;
    }

    public List<ChecklistItem> findAllChecklist() {
        return checklistItemRepo.findAll();
    }

    public ChecklistItem createChecklistItem(long checklistId, ChecklistItem checklistItem) {
        checklistItem.setChecklistId(checklistId);
        return checklistItemRepo.save(checklistItem);
    }

    public Optional<ChecklistItem> findById(Long id) {
        return checklistItemRepo.findById(id);
    }

    public void deleteById(Long id) {
        checklistItemRepo.deleteById(id);
    }

    public Optional<ChecklistItem> findByChecklistId(Long checklistId) {
        return checklistItemRepo.findByChecklistId(checklistId);
    }

    public Optional<ChecklistItem> findByIdAndChecklistId(long id, Long checklistId) {
        return checklistItemRepo.findByIdAndChecklistId(id, checklistId);
    }

    public ChecklistItem updateChecklistItem(Long id, long checklistId, ChecklistItem checklistItem) {
        checklistItem.setId(id);
        checklistItem.setChecklistId(checklistId);
        return checklistItemRepo.save(checklistItem);
    }
}
