public class Time {

    private int secs;

    public Time(int secs){
        this.secs = secs;
    }

    public Time(int hours, int minutes, int seconds){
        this.secs = hours * 3600 + minutes * 60 + seconds;
    }

    public String toString(){

        secs = secs % 86400;

        int hours = secs / 3600;
        int minutes = secs / 60 % 60;
        int sec = secs % 60;

        return String.format("%02d:%02d:%02d", hours, minutes, sec);

    }

}
