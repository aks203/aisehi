package com.aks.Entity;

import jdk.vm.ci.meta.Local;

import javax.persistence.*;
import java.time.LocalDate;
import java.sql.Date;

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
    private Date startDate;

    @Column(name = "END_DATE", nullable = false)
    private Date endDate;

    @Enumerated(EnumType.ORDINAL)
    private PLAN plan;

    public Subscription() {
    }

    /**
     * @param user
     * @param startDate
     * @param endDate
     * @param plan
     */
    public Subscription(User user, Date startDate, Date endDate, PLAN plan) {
        this.user = user;
        this.startDate = startDate;
        this.endDate = endDate;
        this.plan = plan;
    }

    public Subscription(Date startDate, Date endDate, PLAN plan) {
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
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
