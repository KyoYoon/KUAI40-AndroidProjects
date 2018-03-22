//////////////////////////////////////////////////////////////////////////
/* 
 * 소프트웨어 시리얼 프로그램 
 * ESP8266 AT command 확인용
 * www.make123.co.kr
*/
 
#include <SoftwareSerial.h>
 
SoftwareSerial espSerial(2, 3); // RX, TX
 
void setup() {
  Serial.begin(9600);
  espSerial.begin(9600);
}
 
void loop() { // run over and over
  if (espSerial.available()) {
    Serial.write(espSerial.read());
  }
  if (Serial.available()) {
    espSerial.write(Serial.read());
  }
}

