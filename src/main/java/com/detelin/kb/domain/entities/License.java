package com.detelin.kb.domain.entities;

import com.detelin.kb.domain.enums.LicenseName;
import jakarta.persistence.*;

@Entity
@Table(name = "license")
public class License extends BaseEntity {
    private LicenseName name;

    public License() {
    }
    @Column(name = "name")
    @Enumerated(value = EnumType.STRING)
    public LicenseName getName() {
        return name;
    }

    public void setName(LicenseName name) {
        this.name = name;
    }
}
