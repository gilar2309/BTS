package com.gilar.bts.testBackend.service;

import com.gilar.bts.testBackend.model.Checklist;
import com.gilar.bts.testBackend.repo.ChecklistRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChecklistService {

    private final ChecklistRepo checklistRepo;

    @Autowired
    public ChecklistService(ChecklistRepo checklistRepo) {
        this.checklistRepo = checklistRepo;
    }

    public List<Checklist> findAllChecklist() {
        return checklistRepo.findAll();
    }

    public Checklist createChecklist(Checklist checklist) {
        return checklistRepo.save(checklist);
    }

    public Optional<Checklist> findById(Long id) {
        return checklistRepo.findById(id);
    }

    public void deleteById(Long id) {
        checklistRepo.deleteById(id);
    }
}
