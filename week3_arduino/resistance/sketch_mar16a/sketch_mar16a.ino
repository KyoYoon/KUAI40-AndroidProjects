int REDpin = 6;
int YELLOWpin = 5;
int GREENpin = 4;

void setup() {
  // put your setup code here, to run once:
  pinMode(REDpin, OUTPUT);
  pinMode(YELLOWpin, OUTPUT);
  pinMode(GREENpin, OUTPUT);
}

void loop() {
  // put your main code here, to run repeatedly:
  digitalWrite(REDpin, HIGH);
  delay(1000);
  digitalWrite(REDpin, LOW);

  digitalWrite(YELLOWpin, HIGH);
  delay(1000);
  digitalWrite(YELLOWpin, LOW);

  digitalWrite(GREENpin, HIGH);
  delay(1000);
  digitalWrite(GREENpin, LOW);   

}
