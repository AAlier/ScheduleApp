package alier.android.com.scheduleapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import alier.android.com.scheduleapp.schedule.MonthLoader;
import alier.android.com.scheduleapp.schedule.WeekView;
import alier.android.com.scheduleapp.schedule.WeekViewEvent;

public class MainActivity extends AppCompatActivity implements MonthLoader.MonthChangeListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WeekView weekView = (WeekView) findViewById(R.id.weekView);
        weekView.setMonthChangeListener(this);
    }

    @Override
    public List<? extends WeekViewEvent> onMonthChange(int newYear, int newMonth) {
        List<WeekViewEvent> events = new ArrayList<WeekViewEvent>();
        Calendar startTime = Calendar.getInstance();
        startTime.set(Calendar.HOUR_OF_DAY, 13);
        startTime.set(Calendar.MINUTE, 0);
        Calendar endTime = Calendar.getInstance();
        endTime.set(Calendar.HOUR_OF_DAY, 14);
        endTime.set(Calendar.MINUTE, 15);

        if(newYear == startTime.get(Calendar.YEAR) && newMonth == startTime.get(Calendar.MONTH))
            events.add(new WeekViewEvent(1, "Math", startTime, endTime));

        return events;
    }
}
