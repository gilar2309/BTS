package com.gilar.bts.testBackend.repo;

import com.gilar.bts.testBackend.model.Checklist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChecklistRepo extends JpaRepository<Checklist, Long> {
}
