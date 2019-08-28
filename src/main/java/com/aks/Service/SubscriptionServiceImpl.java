package com.aks.Service;

import com.aks.Entity.PLAN;
import com.aks.Entity.Subscription;
import com.aks.Entity.User;

import java.time.LocalDate;

public class SubscriptionServiceImpl implements SubscriptionService {

    @Override
    public Subscription createSubscription(int subsType) {
        return new Subscription(LocalDate.now(), LocalDate.now().plusDays(30), subsType == 0 ? PLAN.BASIC : PLAN.PREMIUM);
    }

    @Override
    public boolean checkSubscription(int user_id) {
        return false;
    }

    @Override
    public Subscription viewSubscription(int id) {
        return new Subscription();
    }

    @Override
    public boolean renewSubscription(int id, int subsType) {
       return true;
    }
}
