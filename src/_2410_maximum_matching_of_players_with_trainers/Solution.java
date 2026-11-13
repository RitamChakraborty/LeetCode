package _2410_maximum_matching_of_players_with_trainers;

import java.util.Arrays;

/**
 * Greedy: Sort the players and trainers with different threads. Then greedily choose the matching players
 * Time: O(N * LogN)
 * Space: O(1)
 */
class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Thread t1 = new Thread(() -> {
            Arrays.sort(players);
        });

        Thread t2 = new Thread(() -> {
            Arrays.sort(trainers);
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (Exception ignore) {}

        int i = 0;
        int j = 0;
        int count = 0;

        while (i < players.length && j < trainers.length) {
            if (players[i] <= trainers[j]) {
                i++;
                j++;
                count++;
            } else {
                j++;
            }
        }

        return count;
    }
}
