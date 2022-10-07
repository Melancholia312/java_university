public class Time {

    private int secs;

    public Time(int secs){
        this.secs = secs % 86400;
    }

    public Time(int hours, int minutes, int seconds){
        this(hours * 3600 + minutes * 60 + seconds);
    }

    public void displayHours(){
        System.out.printf("Часы - %d", secs / 3600);
    }

    public void displayMinutes(){
        System.out.printf("Минуты - %d", secs / 60 % 60);
    }

    public void displaySeconds(){
        System.out.printf("Секунды - %d", secs % 60);
    }

    public String toString(){

        int hours = secs / 3600;
        int minutes = secs / 60 % 60;
        int sec = secs % 60;

        return String.format("%02d:%02d:%02d", hours, minutes, sec);

    }

}
