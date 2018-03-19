#include <LiquidCrystal.h>

LiquidCrystal lcd(4, 6, 10, 11, 12, 13);
// Hello라는 글자가 오른쪽으로 움직이도록 하십시오.
// 오른쪽 끝에 가면 마지막 글자가 왼쪽 앞에 나타나서 계속 진행되게 하십시오. 

String movingStr = "Hello, World";
char z = ' ';

void setup() {
  // put your setup code here, to run once:
  Serial.begin(9600);
  lcd.begin(16,2);
}

void loop() {
  // put your main code here, to run repeatedly:
  for (int i = 0; i < 16; i++) {
    lcd.setCursor(i-1, 0);
    lcd.print(z);
    lcd.setCursor(i, 0);
    lcd.print(movingStr);

    // 인덱스가 0이라는 의미는 문자열이 처음 시작했거나 한 바퀴 돌았다는 의미이므로 
    // 마지막에 남은 글자 한 자를 공백으로 치환한다. 
    if (i == 0) {
      lcd.setCursor(15, 0);
      lcd.print(z);
    }

    // 출력할 글자가 누락되기 시작하는 인덱스에 도달하면 
    // 누락된 글자를 0,0 부터 출력한다.
    if (i > 16 - movingStr.length()) {
      
      lcd.setCursor(0, 0);
      lcd.print(movingStr.substring(16-i));

      delay(1000);
     
//      for (int j = 0; j < i; j++) {
//        lcd.setCursor(j, 0);
//        lcd.print(z);
//      }
      
    } 

    delay(1000);
      
  }

}
