package com.example.datepicker;

import android.app.Activity;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends Activity {
    //定义5个记录当前时间的变量
    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatePicker datePicker = (DatePicker) findViewById(R.id.datePicker);//获取ID
        TimePicker timePicker = (TimePicker) findViewById(R.id.timePicker);
        //获取当前的时间:年 月 日 小时 分钟。
        Calendar calendar = Calendar.getInstance();//日历 获取实例
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        hour = calendar.get(Calendar.HOUR);
        minute = calendar.get(Calendar.MINUTE);

        datePicker.init(year, month, day, new OnDateChangedListener() {//初始化DatePicker组件，初始化是指定监听器
            @Override
            public void onDateChanged(DatePicker view, int year, int month, int day) {
                MainActivity.this.year = year;
                MainActivity.this.month = month;
                MainActivity.this.day = day;
                showDate(year,month,day,hour,minute);//显示当前时间 日期
                Toast.makeText(MainActivity.this,"你选择的日期:"+year+"年"+month+"月"+day+"日",Toast.LENGTH_SHORT).show();//显示你选择的时间和日期
            }
        });
        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {//为timepicker指定监听器
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                MainActivity.this.hour = hourOfDay;
                MainActivity.this.minute = minute;
                showDate(year,month,day,hour,minute);//这个是显示当前的时间和日期
                Toast.makeText(MainActivity.this,"你选择的时间为:"+hourOfDay+"时"+minute+"分",Toast.LENGTH_SHORT).show();//这个是显示你选择的日期和时间
            }
        });


    }
    //定义在edittext中显示当前日期 时间的方法
    private void showDate(int year, int month, int day, int hour, int minute) {
        EditText editText = (EditText) findViewById(R.id.editText);
        editText.setText("你选择的日期和时间为:"+year+"年"+month+"月"+day+"日"+hour+"时"+minute+"分");
    }

}
