package com.gilar.bts.testBackend.repo;

import com.gilar.bts.testBackend.model.ChecklistItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ChecklistItemRepo extends JpaRepository<ChecklistItem, Long> {

    Optional<ChecklistItem> findByChecklistId(long checklistId);
    Optional<ChecklistItem> findByIdAndChecklistId(long id, long checklistId);
}
