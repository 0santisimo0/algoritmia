package exam2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class GreedyTask {
    static int maximumActivities(ActivityA[] activities) {
        int n = activities.length;
        int totalTime = 0;

        Arrays.sort(activities, new ActivityA(0, 0));

        System.out.println("Order.-");
        ArrayList<ActivityA> resultList = new ArrayList<>();

        for (int j = 0; j < n; j++) {
            int res = 100;
            ActivityA activityA = new ActivityA(0,0);
            for (int i = 0; i < n; i++) {
                if (activities[j].start - activities[i].start < res || activities[i].start - activities[j].start < res) {
                    res = activities[j].start - activities[i].start;
                    activityA = activities[j];
                }
            } resultList.add(activityA);
            System.out.println("(" + activities[j].start + ", " + activities[j].finish + ")");
        }

        for (int i = 0; i < resultList.size(); i++) {
            System.out.println(resultList.get(i).start + ", "+ resultList.get(i).finish);
        }

        return totalTime;
    }

    public static void main(String[] args) {
        //Scanner scanner = new Scanner(System.in);
        final int N = 5;
        ActivityA[] activities = new ActivityA[N];
        activities[0] = new ActivityA(4, 5);
        activities[1] = new ActivityA(4, 1);
        activities[2] = new ActivityA(30, 4);
        activities[3] = new ActivityA(6, 30);
        activities[4] = new ActivityA(2, 3);
        maximumActivities(activities);
    }
}
