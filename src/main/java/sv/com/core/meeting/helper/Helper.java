package sv.com.core.meeting.helper;

public class Helper {


    public int increaseTime(int time){
        int newtime = time;
        String minutes = Integer.toString(time);
        minutes = minutes.substring(minutes.length()-2);
        if(minutes.equals("30"))//if the hour has 30 minutes
            newtime = time + 70;
        else
            newtime = time + 30;

        if(newtime==1200)//luch time 12-13
            newtime=(newtime+100);

        return newtime;
    }
}
