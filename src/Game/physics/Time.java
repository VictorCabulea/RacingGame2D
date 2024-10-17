package Game.physics;

import java.awt.*;

public class Time {

    private long min;
    private long sec;
    private long milisec;

    private long minF;
    private long secF;
    private long milisecF;

    private long minTOTAL;
    private long secTOTAL;
    private long milisecTOTAL;

    private long minPENALTY;
    private long secPENALTY;
    private long milisecPENALTY;

    private long time_init;
    private long time_current;
    private long time_final;
    private long time_penalty;

    private long total_time;
    private long TIME_TO_BEAT = 75000;

    private int contor_sec;
    private int contor_secF;
    private int contor_secTOTAL;
    private int contor_secPENALTY;

    private final int MAX_NUMBER_OF_LAPS = 5;
    private int lapCount;

    private int winVariable;

    private int var = 0;

    public Time() {
        time_init = System.currentTimeMillis();
        time_current = 0;
        time_final = 0;
        time_penalty = 0;

        total_time = 0;

        lapCount = 0;

        this.min = 0;
        this.sec = 0;
        this.milisec = 0;

        this.minF = 0;
        this.secF = 0;
        this.milisecF = 0;

        this.minTOTAL = 0;
        this.secTOTAL = 0;
        this.milisecTOTAL = 0;

        this.minPENALTY = 0;
        this.secPENALTY = 0;
        this.milisecPENALTY = 0;

        winVariable = 0;

        var = 0;
    }

    public void update() {
        time_current = System.currentTimeMillis() - time_init;
        min = (int) time_current / 60000;
        sec = time_current / 1000 - 60 * min;
        milisec = (time_current - sec) % 1000;

        if (time_final / 1000 > 0.8) {// pentru a fi contorizat un tur, timpul trebuie sa fie mai mare de 0.8 secunde
            minF = (int) time_final / 60000;
            secF = time_final / 1000 - 60 * minF;
            milisecF = (time_final - secF) % 1000;
            time_init = System.currentTimeMillis();

            if(lapCount<6)
                total_time=total_time+time_final;
            //total_time va aduna timpii de pe fiecare tur

            lapCount=lapCount+1;
        }

        if(lapCount > MAX_NUMBER_OF_LAPS) {// inseamna ca s-au terminat tururile cronometrate
            // se adauga la total_time timpul de penalizare acumulat
            if (var == 0) {
                total_time = total_time + time_final + time_penalty;
                var = 1;
                //am utilizat variabila var pe post de flag pentru a asigura adunarea timpului de penalizare o singura data
            }

            minPENALTY = (int) time_penalty / 60000;
            secPENALTY = time_penalty / 1000 - 60 * minPENALTY;
            milisecPENALTY = (time_penalty - secPENALTY) % 1000;

            minTOTAL = (int) total_time / 60000;
            secTOTAL = total_time / 1000 - 60 * minTOTAL;
            milisecTOTAL = (total_time - secTOTAL) % 1000;

            if(total_time<TIME_TO_BEAT) {
                winVariable=1;
            }
        }
    }

    public void render(Graphics g){

        if(TIME_TO_BEAT==75000)
            g.drawString("Time To Beat: 1:15.000", 1100, 50);
        if(TIME_TO_BEAT==90000)
            g.drawString("Time To Beat: 1:30.000", 1100, 50);

        if(lapCount>0 && lapCount<=MAX_NUMBER_OF_LAPS) {
            if (sec < 10)
                g.drawString("Time: " + min + ":0" + sec + "." + milisec, 30, 100);
            else if (sec >= 10)
                g.drawString("Time: " + min + ":" + sec + "." + milisec, 30, 100);
        }

        if(lapCount>1 && lapCount<=MAX_NUMBER_OF_LAPS){// pentru a se afisa suma timpilor
            if (secF < 10)
                g.drawString("Last Lap: " + minF + ":0" + secF + "." + milisecF, 1100, 100);
            else if (secF >= 10)
                g.drawString("Last Lap: " + minF + ":" + secF + "." + milisecF, 1100, 100);
        }

        if(lapCount>MAX_NUMBER_OF_LAPS){
            if (secTOTAL < 10){
                g.drawString("Total Time: " + minTOTAL + ":0" + secTOTAL + "." + milisecTOTAL, 1100, 100);
            }
            else if (secTOTAL >= 10){
                g.drawString("Total Time: " + minTOTAL + ":" + secTOTAL + "." + milisecTOTAL, 1100, 100);
            }

            if(time_penalty>0) {
                if (secPENALTY < 10)
                    g.drawString("Penalty Time: " + minPENALTY + ":0" + secPENALTY + "." + milisecPENALTY, 1100, 150);
                else
                    g.drawString("Penalty Time: " + minPENALTY + ":" + secPENALTY + "." + milisecPENALTY, 1100, 150);
            }
            else
                g.drawString("Penalty Time: 0" ,1100, 150);

            if(total_time<TIME_TO_BEAT) {
                g.drawString("Your time is better than the target time. Congratulation!", 300, 300);
                g.drawString("To go to the next level, press N", 300, 350);
            }else if(total_time>=TIME_TO_BEAT){
                g.drawString("You failed to beat the target time. Try again!", 300, 300);
            }
        }
    }

    public void TimePenalty(){
        time_penalty=time_penalty+100;
    }


    //////////////////////////////////////////////////////////////////////////////////////////////////

    public long getTime_init() {
        return time_init;
    }

    public void setTime_init() {
        this.time_init = System.currentTimeMillis();
    }

    public long getTime_current() {
        return time_current;
    }

    public void setTime_current() {
        this.time_current = 0;
    }

    public long getTime_final() {
        return time_final;
    }

    public void setTime_final() {
        this.time_final = time_current;
    }

    public int getLapCount() {
        return lapCount;
    }

    public void setLapCount(int lapCount) {
        this.lapCount = lapCount;
    }

    public int getWinVariable() {
        return winVariable;
    }

    public void setWinVariable(int winVariable) {
        this.winVariable = winVariable;
    }

    public long getTIME_TO_BEAT() {
        return TIME_TO_BEAT;
    }

    public void setTIME_TO_BEAT(long TIME_TO_BEAT) {
        this.TIME_TO_BEAT = TIME_TO_BEAT;
    }

    public long getTotal_time() {
        return total_time;
    }

    public void setTotal_time(long total_time) {
        this.total_time = total_time;
    }
}