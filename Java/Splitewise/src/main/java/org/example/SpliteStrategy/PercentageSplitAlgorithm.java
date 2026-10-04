package org.example.SpliteStrategy;

import org.example.Entity.User;
import org.example.Exception.InvalidPercentageSplitException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PercentageSplitAlgorithm implements SplitAlgorithm {

    @Override
    public Map<User, Double> runAlgorithm(
            double amount,
            List<User> usersInvolved,
            Map<User, Double> metadata) {

        if (metadata == null || metadata.isEmpty()) {
            throw new InvalidPercentageSplitException("Percentage metadata is missing");
        }

        double sum = 0.0;
        for (User user : usersInvolved) {
            if (!metadata.containsKey(user)) {
                throw new InvalidPercentageSplitException(
                        "Missing percentage for user: " + user
                );
            }
            sum += metadata.get(user);
        }

        if (sum < 100.0) {
            throw new InvalidPercentageSplitException(
                    "Total percentage is less than 100: " + sum
            );
        }

        Map<User, Double> result = new HashMap<>();

        for (User user : usersInvolved) {
            double percentage = metadata.get(user);
            double share = (percentage / 100.0) * amount;
            result.put(user, share);
        }

        return result;
    }
}
