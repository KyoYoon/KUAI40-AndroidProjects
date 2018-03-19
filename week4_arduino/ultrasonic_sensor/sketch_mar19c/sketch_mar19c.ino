// 초음파 센서로 거리재기 
int trig = 4;
int echo = 3;

// led array (사용할 led 핀 번호를 담은 배열)
int led[] = {5, 6, 7, 8, 9, 10, 11, 12, 13};

void setup() {
  // put your setup code here, to run once:
  pinMode(trig, OUTPUT);
  pinMode(echo, INPUT);

  for (int i = 0; i < 9; i++) {
    pinMode(led[i], OUTPUT);
  }
  
  Serial.begin(9600);
  
}

void loop() {
  // put your main code here, to run repeatedly:
  // 초음파 발사 
  digitalWrite(trig, HIGH);
  delayMicroseconds(10);
  digitalWrite(trig, LOW);

  int duration = pulseIn(echo, HIGH);
  // 편도거리를 cm 으로 바꿔준다.
  int dis = duration / 29 / 2;

  // 물체가 일정거리 내로 점점 가까워지면 led가 순차적으로 
  // 켜지게 한다.
  
  for (int i = 12; i > 3; i--) {

    Serial.print("distance[");
    Serial.print(12-i);
    Serial.print("] = ");
    Serial.println(dis);
    delay(1000);
    
    if ( dis < i ) {
      digitalWrite(led[12-i], HIGH);
    } else {
      digitalWrite(led[12-i], LOW);  
    }
      
  }
  
}
