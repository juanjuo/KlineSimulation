public class Time { // class in charge of managing time/runtime in the simulation
    private float time;
    private final float DAY = 45000; //12 hours 30 minutes of work in a day, in seconds (7:30am - 8:00pm
    private long runTime; // run time of simulation

    public Time(){
        time = 0;
        runTime = System.nanoTime();
    }

    public void start(){
        time++;
    }

    public long getRunTime(){
        return (System.nanoTime() - runTime);
    }

    public float secondsToHours(){
        float hours = time/3600;
        return hours;
    }

    public float getCurrentTime() {
        return time;
    }
}
