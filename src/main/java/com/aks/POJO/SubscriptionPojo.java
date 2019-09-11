package com.aks.POJO;


import com.aks.Entity.PLAN;

import java.time.LocalDate;

public class SubscriptionPojo {
    private int subs_id;

    private UserPojo user;

    private LocalDate startDate;

    private LocalDate endDate;

    private PLAN plan;

    public SubscriptionPojo() {
    }

    /**
     * @param startDate
     * @param endDate
     * @param plan
     */
    public SubscriptionPojo(LocalDate startDate, LocalDate endDate, PLAN plan) {
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
    public SubscriptionPojo(UserPojo user, LocalDate startDate, LocalDate endDate, PLAN plan) {
        this.user = user;
        this.startDate = startDate;
        this.endDate = endDate;
        this.plan = plan;
    }

    public int getSubs_id() {
        return subs_id;
    }

    public UserPojo getUser() {
        return user;
    }

    public void setUser(UserPojo user) {
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
