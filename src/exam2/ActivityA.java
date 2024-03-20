package exam2;

import java.util.Comparator;

public class ActivityA implements Comparator<ActivityA> {
    int start, finish;

    ActivityA(int start, int finish) {
        this.start = start;
        this.finish = finish;
    }

    @Override
    public int compare(ActivityA o1, ActivityA o2) {
        int n = 0;
        if (o1.start + o1.finish <= o2.start + o2.finish) n = -1;
        else  n = 1;
        return n;
    }
}
