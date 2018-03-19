// 초음파 센서 프로그램 


void setup() {
  // put your setup code here, to run once:
  Serial.begin(9600);
  pinMode(2, OUTPUT); // Trig
  pinMode(3, INPUT);  // Echo
  

}

void loop() {
  // put your main code here, to run repeatedly:
  long duration, cm, inch;
  
  digitalWrite(2, HIGH); // Trig 신호 On
  delayMicroseconds(10); // 10us 유지 
  digitalWrite(2, LOW); // Trig 신호 Off

  duration = pulseIn(3, HIGH); // Echo
  cm = microsecondsToCentimeters(duration); // cm 으로 변환 
  Serial.print("Distance (cm) : ");
  Serial.print(cm);
  Serial.println(" cm");
  Serial.println("-----------------");
  

  inch = microsecondsToInches(duration); // inch 로 변환 
  Serial.print("Distance (inch) : ");
  Serial.print(inch);
  Serial.println(" inch");
  Serial.println("-----------------");
  delay(1000);
  
}

long microsecondsToInches(long microseconds) {
  return microseconds / 74 / 2;
}

long microsecondsToCentimeters(long microseconds) {
  return microseconds / 29 / 2;
}

