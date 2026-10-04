package org.example.SpliteStrategy;

import org.example.Entity.User;

import java.util.List;
import java.util.Map;

public interface SplitAlgorithm {
    public Map<User, Double> runAlgorithm(double amount, List<User> usersInvolved, Map<User, Double> metadata);
}
