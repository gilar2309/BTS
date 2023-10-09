package com.gilar.bts.testBackend.model;

import javax.persistence.*;

@Entity
@Table(name = "ChecklistItem")
public class ChecklistItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 100)
    private String itemName;

    @Column(nullable = false)
    private long checklistId;

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return this.id;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemName() {
        return this.itemName;
    }

    public void setChecklistId(long checklistId) {
        this.checklistId = checklistId;
    }

    public long getChecklistId() {
        return this.checklistId;
    }
}
