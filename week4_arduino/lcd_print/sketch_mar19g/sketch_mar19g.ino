#include <LiquidCrystal.h>

LiquidCrystal lcd(4, 6, 10, 11, 12, 13);
// 첫 번째 줄에 a 부터 p 까지 순서대로 출력하십시오.
// 단, 화면에는 한 글자만 보이게 하십시오.
// abcd efgh ijkl mnop
//String[] alphabet = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p"};
String alphabet = "abcdefghijklmnop";

char abc[16] = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p'};

void setup() {
  // put your setup code here, to run once:
  Serial.begin(9600);
  lcd.begin(16,2);
}

void loop() {
  // put your main code here, to run repeatedly:
  //lcd.setCursor(0,0);
  //lcd.print(alphabet);

  for (int i = 0; i < 16; i++) {

    if (i - 1 >= 0) {
      lcd.setCursor(i-1, 0);
      lcd.print(" ");
    } 

    lcd.setCursor(i,0);
    lcd.print(abc[i]);
    delay(1000);
    

    if (i == 15) {
      lcd.setCursor(i, 0);
      lcd.print(" ");
      delay(1000);
    }
    
  }

  
  
}
