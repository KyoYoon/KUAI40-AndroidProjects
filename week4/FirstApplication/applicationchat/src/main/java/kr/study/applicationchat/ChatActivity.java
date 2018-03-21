package kr.study.applicationchat;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Calendar;

public class ChatActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText        mInputMessage;
    private Button          mSendMessage;
    private LinearLayout    mMessageLog;
    private TextView        mCpuMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        // widget을 변수에 연결
        // 사용자 입력필드
        mInputMessage   = (EditText) findViewById(R.id.input_message);
        // SEND 버튼
        mSendMessage    = (Button) findViewById(R.id.send_messsage);
        // 입력된 내용을 표시하는 레이아웃
        mMessageLog     = (LinearLayout) findViewById(R.id.message_log);
        // 컴퓨터가 보낸 메시지를 표시하는 텍스트뷰
        mCpuMessage     = (TextView) findViewById(R.id.cpu_message);
        // 버튼에 리스너 연결
        mSendMessage.setOnClickListener(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



    }

    @Override
    public void onClick(View view) {
        // SEND 버튼을 클릭했을 때
        if (view.equals(mSendMessage)) {
            // 입력한 값을 가져온다.
            String inputText = mInputMessage.getText().toString();
            String answer;
            // 새로운 TextView 를 생성한다.
            TextView userMessage = new TextView(this);
            // TextView에 입력한 값을 넣는다.
            userMessage.setText(inputText);
            userMessage.setGravity(Gravity.END); // 오른쪽 끝에 맞춤

            // TextView 를 View의 맨 뒤에 설정한다.
            mMessageLog.addView(userMessage, 0);

            // 내가 입력한 내용에 맞춰 컴퓨터가 응답한다.
            if (inputText.contains("hello")) {
                answer = "안녕하세요.";
            } else if (inputText.contains("tired")) {
                answer = "힘드셨지요.";
            } else if (inputText.contains("luck")) {
                double random = Math.random() * 5.1d;
                if (random < 1d) {
                    answer = "몹시 나쁨";
                } else if (random < 2d) {
                    answer = "나쁨";
                } else if (random < 3d) {
                    answer = "보통";
                } else if (random < 4d) {
                    answer = "대박";
                } else {
                    answer = "운수대통";
                }
            } else if (inputText.contains("time")) {
                Calendar cal = Calendar.getInstance();
                int hour        = cal.get(Calendar.HOUR);
                int minute      = cal.get(Calendar.MINUTE);
                int second      = cal.get(Calendar.SECOND);
                answer          = String.format("현재시각은 %1$d시 %2$d분 %3$d초입니다.",hour,minute,second);
            } else  {
                answer = "좋은 말씀입니다.";
            }

            // 내부 클래스엣 참조하기 위해서 final 로 선언한다.
            final TextView cpuMessage = new TextView(this);
            cpuMessage.setText(answer);
            cpuMessage.setGravity(Gravity.START);

            mInputMessage.setText("");
            TranslateAnimation userMessageAnimation = new TranslateAnimation(mMessageLog.getWidth(), 0, 0, 0);

            userMessageAnimation.setDuration(1000); // 1 second
            userMessageAnimation.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {

                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    mMessageLog.addView(cpuMessage, 0);
                    TranslateAnimation cpuAnimation = new TranslateAnimation(-mMessageLog.getWidth(), 0, 0, 0);
                    cpuAnimation.setDuration(1000);
                    cpuMessage.setAnimation(cpuAnimation);
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });
            userMessage.startAnimation(userMessageAnimation);


        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_chat, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
