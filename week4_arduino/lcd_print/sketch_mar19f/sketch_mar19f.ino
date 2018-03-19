#include <LiquidCrystal.h>
// LCD에 글자 출력하기 
LiquidCrystal lcd(4, 6, 10, 11, 12, 13);
void setup() {
  // put your setup code here, to run once:
  Serial.begin(9600);
  lcd.begin(16, 2); // 2 행, 16개 글자 열
  
}

void loop() {
  // put your main code here, to run repeatedly:
  lcd.setCursor(5, 0);
  lcd.print("Hello");
  lcd.setCursor(1, 1);
  lcd.print("Good Morning");
  delay(1000);
  
}
