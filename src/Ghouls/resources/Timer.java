package Ghouls.resources;

import Ghouls.Ghouls;

public class Timer {
    private long end;
    private final long start;
    private final long period;

    public Timer(final long period) {
        this.period = period;
        start = System.currentTimeMillis();
        end = start + period;
    }

    public long getElapsed() {
        return System.currentTimeMillis() - start;
    }

    public boolean isRunning() {
        return System.currentTimeMillis() < end;
    }

    public void reset() {
        end = System.currentTimeMillis() + period;
    }


}