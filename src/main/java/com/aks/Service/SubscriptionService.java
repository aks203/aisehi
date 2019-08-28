package com.aks.Service;

import com.aks.Entity.Subscription;

public interface SubscriptionService {
    Subscription createSubscription(int subsType);

    boolean checkSubscription(int user_id);

    Subscription viewSubscription(int id);

    boolean renewSubscription(int id, int subsType);
}
