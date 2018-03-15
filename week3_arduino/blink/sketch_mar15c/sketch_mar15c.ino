void setup() {
  // put your setup code here, to run once:
  pinMode(13, OUTPUT); // 13번 포트
  pinMode(12, OUTPUT); // 12번 포트 
  pinMode(11, OUTPUT); // 11번 포트  
  Serial.begin(9600); // 시리얼 모니터에서 볼 수 있게 설정 
  

}

void loop() {

  // 시리얼모니터에서 입력이 있는지 검사 (시리얼모니터 창에서 값을 입력 후 전송버튼을 눌렀다면)
  if (Serial.available()) {
    char inChar = Serial.read();
    if (inChar == '1') { // 입력한 값이 1이었다면
      digitalWrite(13, HIGH); // 13번 점등 (켜기)
      digitalWrite(12, HIGH); // 12번 점등 (켜기)
      digitalWrite(11, HIGH); // 11번 점등 (켜기)
    } else if (inChar == '0') { // 입력한 값이 0이었다면 
      digitalWrite(13, LOW);  // 13번 소등 (끄기)
      digitalWrite(12, LOW);  // 12번 소등 (끄기)
      digitalWrite(11, LOW);  // 11번 소등 (끄기)
    }
  }
  
  
}
