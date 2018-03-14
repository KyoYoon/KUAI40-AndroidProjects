package com.koruniv.user.simplelocation;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);
        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 위치정보 확인을 위한 메소드를 호출한다.
                startLocationService();
            }
        });


    }

    // 위치 정보 확인 메소드
    private void startLocationService() {
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        // 위치정보를 받을 리스너를 생성한다.
        GPSListener gpsListener = new GPSListener();
        long minTime = 10000;
        float minDistance = 0;

        try {

            // GPS를 이용한 위치 요청 (위성)
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, minTime, minDistance, gpsListener);

            // Network를 이용한 위치 요청 (기지국)
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, minTime, minDistance, gpsListener);

            // 예전에 마지막으로 있었던 위치 정보를 담을 변수 선언
            Location lastLocation = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);

            // 위치 확인이 안 되는 경우에 최근에 확인된 위치 정보를 먼저 확인한다.
            if (lastLocation != null) {
                Double latitude = lastLocation.getLatitude();
                Double longitude = lastLocation.getLongitude();

                textView.setText("내 위치\n"+"Latitude: "+latitude+"\n"+"Longitude: "+longitude);
                Toast.makeText(getApplicationContext(), "Last Known Location : "+ latitude + ", "+longitude, Toast.LENGTH_LONG).show();

            }


        } catch (SecurityException e) {
            e.printStackTrace();
        }

        Toast.makeText(getApplicationContext(), "위치확인이 시작되었습니다. 로그를 확인하십시오.", Toast.LENGTH_SHORT).show();

    }

    // Listener 클래스 정의
    private class GPSListener implements LocationListener {

        // 위치정보가 확인될 때 자동으로 호출되는 메소드
        @Override
        public void onLocationChanged(Location location) {
            Double latitude = location.getLatitude();
            Double longitude = location.getLongitude();

            String msg = "Latitude : " + latitude
                    + "\nLongitude : " + longitude;

            Log.i("GPSListener", msg);

            textView.setText("- 나의 위치 -" + "\n" + msg);
            Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle bundle) {

        }

        @Override
        public void onProviderEnabled(String provider) {

        }

        @Override
        public void onProviderDisabled(String provider) {

        }
    }

}
