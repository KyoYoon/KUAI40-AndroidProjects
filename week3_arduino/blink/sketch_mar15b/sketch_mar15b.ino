void setup() {
  // put your setup code here, to run once:
  pinMode(13, OUTPUT); // 13번 포트
  pinMode(12, OUTPUT); // 12번 포트 
  pinMode(11, OUTPUT); // 11번 포트  
  Serial.begin(9600); // 시리얼 모니터에서 볼 수 있게 설정 
  

}

void loop() {
  // put your main code here, to run repeatedly:
  digitalWrite(13, HIGH);   // turn the 13th LED on (HIGH is the voltage level)
  Serial.println("13 Pin On...\n");
  delay(1000);                       // wait for a second
  digitalWrite(13, LOW);    // turn the 13th LED off by making the voltage LOW
  Serial.println("13 Pin Off...\n");
  delay(1000);                       // wait for a second

  digitalWrite(12, HIGH);   // turn the 12th LED on (HIGH is the voltage level)
  Serial.println("12 Pin On...\n");
  delay(1000);                       // wait for a second
  digitalWrite(12, LOW);    // turn the 12th LED off by making the voltage LOW
  Serial.println("12 Pin Off...\n");
  delay(1000);                       // wait for a second

  digitalWrite(11, HIGH);   // turn the 11th LED on (HIGH is the voltage level)
  Serial.println("11 Pin On...\n");
  delay(1000);                       // wait for a second
  digitalWrite(11, LOW);    // turn the 11th LED off by making the voltage LOW
  Serial.println("11 Pin Off...\n");
  delay(1000);                       // wait for a second
  
  
}
