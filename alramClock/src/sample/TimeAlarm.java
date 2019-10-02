package sample;

import java.io.Serializable;

public class TimeAlarm implements Serializable {
    private String setHour;
    private String setMinutes;

    public TimeAlarm(String hours, String minutes ) {
        this.setHour = hours;
        this.setMinutes = minutes;
    }

    public String getSetHour() {
        return setHour;
    }

    public String getSetMinutes() {
        return setMinutes;
    }

    public void setSetHour(String setHour) {
        this.setHour = setHour;
    }

    public void setSetMinutes(String setMinutes) {
        this.setMinutes = setMinutes;
    }

    @Override
    public String toString() {
        return "" + setHour + "  :  " + setMinutes;
    }
}
