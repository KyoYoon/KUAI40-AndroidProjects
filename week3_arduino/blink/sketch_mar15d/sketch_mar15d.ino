void setup() {
  // put your setup code here, to run once:
  pinMode(13, OUTPUT); // 13번 포트
  pinMode(12, OUTPUT); // 12번 포트
  pinMode(11, OUTPUT); // 11번 포트
  
}

void loop() {

  for (int i = 0; i < 255; i++) {
    
    analogWrite(11, i); // 여기에서 i는 전등의 밝기를 결정하는 수 (254가 제일 밝고 0은 꺼진 상태)
    delay(20);
  }

  for (int i = 254; i >= 0; i--) {
    
    analogWrite(11, i);
    delay(20);
  }  
  
}
