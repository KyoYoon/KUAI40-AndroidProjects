// Lumen (조도) 관련 프로그램
int led1 = 4;
int led2 = 13;

void setup() {
  // put your setup code here, to run once:
  Serial.begin(9600);
  
  pinMode(led1, OUTPUT);
  pinMode(led2, OUTPUT);
  
  
}

void loop() {
  
  // put your main code here, to run repeatedly:
  // A1 에서 조도를 감지 
  int lumenR = analogRead(A1);

  Serial.println(lumenR);

  if (lumenR < 290) {
    digitalWrite(led1, HIGH);
    digitalWrite(led2, LOW);
  } else {
    digitalWrite(led1, LOW);
    digitalWrite(led2, HIGH);
  }

  delay(300);

}
