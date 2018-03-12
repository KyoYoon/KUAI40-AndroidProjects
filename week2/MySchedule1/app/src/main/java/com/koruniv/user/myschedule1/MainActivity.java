package com.koruniv.user.myschedule1;

        import android.graphics.Color;
        import android.os.SystemClock;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.CalendarView;
        import android.widget.Chronometer;
        import android.widget.RadioButton;
        import android.widget.TextView;
        import android.widget.TimePicker;
        import android.widget.Toast;

        import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Chronometer chronometer;
    Button btnStart, btnEnd;
    RadioButton rdoCal, rdoTime;

    CalendarView calView;
    TimePicker tPicker;
    TextView tvYear, tvMonth, tvDay, tvHour, tvMinute;

    String strYear, strMonth, strDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("시간 예약");

        // 버튼
        btnStart = (Button) findViewById(R.id.btnStart);
        btnEnd = (Button) findViewById(R.id.btnEnd);

        // 크로노미터
        chronometer = (Chronometer) findViewById(R.id.chronometer1);

        // 라디오 버튼
        rdoCal = (RadioButton) findViewById(R.id.rdoCal);
        rdoTime = (RadioButton) findViewById(R.id.rdoTime);

        // FrameLayout 에 있는 2개의 위젯
        tPicker = (TimePicker) findViewById(R.id.timePicker);
        calView = (CalendarView) findViewById(R.id.calendarView1);

        // 텍스트뷰 (년도, 월, 일, 시, 분)
        tvYear = (TextView) findViewById(R.id.tvYear);
        tvMonth = (TextView) findViewById(R.id.tvMonth);
        tvDay = (TextView) findViewById(R.id.tvDay);
        tvHour = (TextView) findViewById(R.id.tvHour);
        tvMinute = (TextView) findViewById(R.id.tvMinute);

        //tPicker와 calView는 안 보이게 설정
        tPicker.setVisibility(View.INVISIBLE);
        calView.setVisibility(View.INVISIBLE);

        rdoCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tPicker.setVisibility(View.INVISIBLE);
                calView.setVisibility(View.VISIBLE);
            }
        });

        rdoTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tPicker.setVisibility(View.VISIBLE);
                calView.setVisibility(View.INVISIBLE);
            }
        });

        // Timer 시작
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chronometer.setBase(SystemClock.elapsedRealtime());
                chronometer.start();
                chronometer.setTextColor(Color.RED);

            }
        });

        // 년월일을 선택할 때마다 호출되는 메소드로써 사용자 선택한 년, 월, 일을 매개변수로 받는다.
        calView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            public void onSelectedDayChange(CalendarView view, int year,
                                            int month, int dayOfMonth) {
                Toast.makeText(MainActivity.this, "" + year + "/" +
                        (month + 1) + "/" + dayOfMonth, 0).show();

                strYear = Integer.toString(year);
                strMonth = Integer.toString(month+1);
                strDay = Integer.toString(dayOfMonth);

            }
        });

        // Timer 중지 - 예약완료 버튼이 눌렸을 경우
        btnEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chronometer.stop();
                chronometer.setTextColor(Color.BLUE);

                //java.util.Calendar curDate = java.util.Calendar.getInstance();
                //curDate.setTimeInMillis(calView.getDate());



                tvYear.setText(strYear);
                tvMonth.setText(strMonth);
                tvDay.setText(strDay);
                tvHour.setText(Integer.toString(tPicker.getCurrentHour()));
                tvMinute.setText(Integer.toString(tPicker.getCurrentMinute()));
            }
        });

    }
}
