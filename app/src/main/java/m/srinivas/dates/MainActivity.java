package m.srinivas.dates;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {
   ArrayList<CustomDate> CustomDate;
   RecyclerView recylerview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recylerview = (RecyclerView) findViewById(R.id.recylerview);
        CustomDate = new ArrayList<CustomDate>();

        List<Date> dates = getDates("01-02-2018", "10-02-2018");

        for(Date date:dates){
            String dd = String.valueOf(date);
            CustomDate.add(new CustomDate(dd));
            System.out.println(date);
        }
        recylerview.setLayoutManager(new LinearLayoutManager(this));
        recylerview.setAdapter(new Date_Adapter( getApplicationContext(),CustomDate, R.layout.date));
    }

    private static List<Date> getDates(String dateString1, String dateString2)
    {
        ArrayList<Date> dates = new ArrayList<Date>();
        DateFormat df1 = new SimpleDateFormat("dd-MM-yyyy");

        Date date1 = null;
        Date date2 = null;

        try {
            date1 = df1 .parse(dateString1);
            date2 = df1 .parse(dateString2);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);


        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);

        while(!cal1.after(cal2))
        {
            dates.add(cal1.getTime());
            cal1.add(Calendar.DATE, 1);
        }
        return dates;
    }
}
