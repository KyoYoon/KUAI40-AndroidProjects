// 사람이 스위치를 키면 길을 건널 수 있게 설계된 신호등 프로그램 

#define pinHumanG 10 // 녹색 신호 (사람) 
#define pinHumanR 9  // 적색 신호 (사람)
#define pinHumanSW 8 // 스위치 

#define pinCarG 13 // 녹색 신호 (차량)
#define pinCarY 12 // 노랑색 신호 (차량)
#define pinCarR 11 // 적색 신호 (차량)

#define TIME_USE_HUMAN 5 // 녹색신호등이 점등될 때 사람이 건너가는 데 걸리는 시간 (초)
#define BLINK_COUNT 5    // 녹색신호등일 깜빡깜빡거리는 시간 (초) => (사람보고 빨리 건너라고 경고를 주는 의미)

#define C 262 // 도 
#define D 294 // 레
#define E 330 // 미 
#define F 349 // 파 
#define G 392 // 솔 
#define A 440 // 라 
#define B 494 // 시

int piezoPin = 7;
int tempo = 200;
int notes[25] = {G, G, A, A, G, G, E, G, G, E, E, D,
                 G, G, A, A, G, G, E, G, E, D, E, C};

unsigned long prevTime;

void musicPlay() {
  // put your main code here, to run repeatedly:
  for(int i = 0; i < 12; i++) {
    tone(piezoPin, notes[i], tempo);
    delay(300);
  }
  delay(200);
  for(int i = 12; i<35; i++) {
    tone (piezoPin, notes[i], tempo);
    delay(300);
  }
}

void initLED() {

  // 교통 시스템이 시작될 때 신호등 초기상태 
  
  // 자동차들이 달리고 있는 상황 
  digitalWrite(pinCarG, HIGH); 
  digitalWrite(pinCarY, LOW); 
  digitalWrite(pinCarR, LOW);

  // 보행자는 대기하는 상태 
  digitalWrite(pinHumanG, LOW);
  digitalWrite(pinHumanR, HIGH);

  prevTime = millis();
   
}

void changeLED() {

  // 버튼을 누르면 1초간 대기한다.
  delay(1000);
  Serial.println("Please Wait for a second...");

  // 차량신호등의 녹색불이 소등되고 노란불이 점등되었다가 소등된다. (차량이 마저 지나갈 시간을 준다)
  digitalWrite(pinCarG, LOW);
  digitalWrite(pinCarY, HIGH);
  Serial.println("Turn on car's yellow led during 2 seconds");
  delay(2000);
 

  // 차량신호등의 노란불이 꺼지고 차량신호등의 빨간불이 켜진다. 
   digitalWrite(pinCarY, LOW);
   digitalWrite(pinCarR, HIGH);
    
   // 사람쪽 신호등의 빨간불이 꺼지고 녹색불이 꺼진다.  
   digitalWrite(pinHumanR, LOW);
   digitalWrite(pinHumanG, HIGH); 

   // 사람이 건널 수 있게 5초간 지연시킨다.
   //delay(TIME_USE_HUMAN * 1000);

   musicPlay();

   // 녹색불을 5초간 깜빡거리게 만든다.
   Serial.println("5 seconds remain using cross line ... ");
   
  
   for (int i = 0; i < BLINK_COUNT; i++) {
      digitalWrite(pinHumanG, LOW);
      delay(500);
      digitalWrite(pinHumanG, HIGH);
      delay(500);
   }
   
   // 보행자가 다 건너게 되면 다시 차량이 운행할 수 있는 상태로 만든다.
   Serial.println("Start Traffic Light System...");

   // 신호등을 초기상태로 전환한다.
   initLED();
  
}

void setup() {
  // put your setup code here, to run once:
  Serial.begin(9600);
  
  pinMode(pinCarG, OUTPUT);
  pinMode(pinCarY, OUTPUT);
  pinMode(pinCarR, OUTPUT);
  
  pinMode(pinHumanG, OUTPUT);
  pinMode(pinHumanR, OUTPUT);
  pinMode(pinHumanSW, INPUT_PULLUP);

  Serial.println("Start Traffic Light System...");

  // 초기 상태를 설정함 (차는 다니고 사람은 신호등 앞에서 기다리는 상황)
  initLED();
  
}

void loop() {
  
  // put your main code here, to run repeatedly:
  int sw = digitalRead(pinHumanSW); // 보행자가 스위치를 누르거나 뗐을 때 넘어오는 값 저장 

  /* 보행자가 스위치를 누르는 상황은 자동차 신호등이 녹색인 상태에서만 작동하도록 한다. */
  // 보행자가 버튼을 눌렀을 때 자동차 신호등이 녹색인 상황이라면 
  if (sw == LOW && digitalRead(pinCarG) == HIGH) { 
    changeLED();
  } else {

    unsigned long currentTime = millis();

    // 10초간 아무도 누르지 않았다면 자동으로 보행자가 건널 수 있는 상태로 변경 (현실에서는 3분 딜레이 ㅎㅎ)
    if (currentTime > prevTime + (10 * 1000)) {
      /* 아무도 보행스위치를 10초간 누르지 않은 상태이므로 10초가 넘으면 자동으로 보행상태로 바꿔준다. */
      changeLED();
    }
    
  }

}
