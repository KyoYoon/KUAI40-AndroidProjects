int pinNo = 11;
void setup() {

  pinMode(pinNo, OUTPUT);  // 11번 점등 준비 
  Serial.begin(9600);
  
}

void loop() {

  int rtnVal = analogRead(A0); // 사용자가 스위치를 돌릴 때마다 A0에 연결된 장치에서 입력한 값을 읽어들인다.
  int brightVal = rtnVal / 4; // 들어오는 값의 4분의 1의 값을 밝기로 해서 입력함 
  Serial.println(rtnVal);
  analogWrite(pinNo, brightVal); // 11번등 점등 
  delay(10);

  
}
