#include <LiquidCrystal.h>
LiquidCrystal lcd(4, 6, 10, 11, 12, 13);
// Hello라는 글자가 오른쪽으로 움직이도록 하십시오.
// 오른쪽 끝에 가면 마지막 글자가 왼쪽 앞에 나타나서 계속 진행되게 하십시오. 
// abcd efgh ijkl mnop
//String[] alphabet = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p"};
//String alphabet = "abcdefghijklmnop";

//char abc[16] = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p'};
//char hello[5] = {'H','e','l','l','o'};
String helloStr = "Hello";

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

    // 글자가 인덱스 하나 앞으로 이동할 때마다 이전 인덱스에 남아있는 글자를 공백으로 치환 
    if (i - 1 >= 0) {
      lcd.setCursor(i-1, 0);
      lcd.print(" ");
    }

    if (16 - i <= 4) { // 인덱스가 12에 도달할 때 안 보이는 글자를 인덱스 0부터 출력 
      // 나머지 글자 출력 
      // 4 => 4
      // 3 => 3, 4
      // 2 => 2, 3, 4
      // 1 => 1, 2, 3, 4

      //int from = 5 - (16 - i);
      
      lcd.setCursor(0,0);
      lcd.print(helloStr.substring(16-i));    

      lcd.setCursor(i, 0);
      lcd.print(helloStr);
      delay(1000);

      for (int j = 0; j < 16 - i; j++)
      {
         lcd.print(" ");
      }
      
    } else { // 인덱스가 11일때까지는 그냥 글자를 출력 
      lcd.setCursor(i, 0);
      lcd.print(helloStr);
      delay(1000);
    }

    // 마지막 인덱스에 도달했을 때 현재 인덱스에 있는 한 글자 공백으로 바꿈 
    if (i == 15) {
      lcd.setCursor(i, 0);
      lcd.print(" ");
      delay(1000);
    }
    
  }

  
  
}
