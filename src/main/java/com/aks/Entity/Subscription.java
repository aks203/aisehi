package com.aks.Entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "SUBSCRIPTION")
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SUBS_ID", nullable = false, unique = true)
    private int subs_id;

    @OneToOne(mappedBy = "subscription")
    private User user;

    @Column(name = "START_DATE", nullable = false)
    private LocalDate startDate;

    @Column(name = "END_DATE", nullable = false)
    private LocalDate endDate;

    @Enumerated(EnumType.ORDINAL)
    private PLAN plan;

    public Subscription() {
    }

    /**
     * @param startDate
     * @param endDate
     * @param plan
     */
    public Subscription(LocalDate startDate, LocalDate endDate, PLAN plan) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.plan = plan;
    }

    /**
     * @param user
     * @param startDate
     * @param endDate
     * @param plan
     */
    public Subscription(User user, LocalDate startDate, LocalDate endDate, PLAN plan) {
        this.user = user;
        this.startDate = startDate;
        this.endDate = endDate;
        this.plan = plan;
    }


    public int getSubs_id() {
        return subs_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public PLAN getPlan() {
        return plan;
    }

    public void setPlan(PLAN plan) {
        this.plan = plan;
    }

    @Override
    public String toString() {
        return "Subscription{" +
                "subs_id=" + subs_id +
                ", user=" + user +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", plan=" + plan +
                '}';
    }
}
