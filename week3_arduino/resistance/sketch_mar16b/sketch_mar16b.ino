int buttonPin = 8;
int ledPin = 13;

void setup() {
  // put your setup code here, to run once:
  pinMode(buttonPin, INPUT_PULLUP);
  pinMode(ledPin, OUTPUT);
  
}

void loop() {
  // put your main code here, to run repeatedly:
  if(digitalRead(buttonPin) == LOW) { // 버튼이 눌리면 
    digitalWrite(ledPin, HIGH); 
  } else {  // 버튼이 다시 올라오면 
    digitalWrite(ledPin, LOW);
  }

}
