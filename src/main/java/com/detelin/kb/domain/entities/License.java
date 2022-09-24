package com.detelin.kb.domain.entities;

import com.detelin.kb.domain.enums.LicenseName;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "license")

public class License extends BaseEntity {
    private LicenseName name;
    private LocalDate startDate;
    private LocalDate endDate;
    private List<User> userId;
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
    @Column (name = "start_date")


    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
    @Column (name = "end_date")

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
    @Column (name = "user_id")
    @OneToMany(targetEntity = User.class,fetch = FetchType.EAGER)

    public List<User> getUserId() {
        return userId;
    }

    public void setUserId(List<User> userId) {
        this.userId = userId;
    }
}
