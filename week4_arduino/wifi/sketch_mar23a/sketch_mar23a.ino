#include <SoftwareSerial.h>
#include <LiquidCrystal.h>
#define DEBUG true
 
SoftwareSerial esp8266(2,3); //RX는 2번 핀, TX는 3번 핀
LiquidCrystal lcd(12, 11, 7, 6, 5, 4);
 
void setup() {
  // put your setup code here, to run once:
   Serial.begin(9600);
   esp8266.begin(9600); //esp의 보드레이트
 
   lcd.begin(16,2);
   lcd.setCursor(0, 0);
   lcd.print("ESP8266 project3");
   //lcd.setCursor(0, 1);
  
   //lcd.print("hell");
   //lcd.print(sendData("AT+CIFSR\r\n",1000,DEBUG));
  /*AT Command 이용*/
  sendData("AT+RST\r\n", 2000, DEBUG); //reset module
  sendData("AT+CWMODE=3\r\n", 1000, DEBUG); //dual mode로 설정
  sendData("AT+CWJAP=\"KU_TEMP01_2.4G\",\"korea123!\"\r\n", 5000, DEBUG); //사용할 공유기 설정
  sendData("AT+CIFSR\r\n",1000,DEBUG);
  lcd.setCursor(1, 0);
  lcd.print(sendData("AT+CIFSR\r\n",1000,DEBUG));
  sendData("AT+CIPMUX=1\r\n", 1000, DEBUG); //multiple connections 설정
  sendData("AT+CIPSERVER=1,80\r\n", 1000, DEBUG); //포트 번호를 80번으로 설정
  
}
 
void loop() {
  // put your main code here, to run repeatedly:
  if(esp8266.available()){ //esp8266에 웹에서 메시지가 왔는지 파악
    if(esp8266.find("+IPD,")){ //data를 받아옴
      delay(1000); //시리얼 버퍼에서 보내져온 데이터가 다 찰 때까지 대기
      int connectionID=esp8266.read()-48; //connection ID를 알아내고 아스키코드값이므로 48을 빼줌
      esp8266.find("pin=");
      char arr[25]={0,};
      for(int i=0; i<25; i++){
        arr[i]=esp8266.read();
        if(arr[i]=='+') //space
          arr[i]=' ';
      }
      for(int i=0; i<=17; i++){
        if(arr[i]=='H' && arr[i+1]=='T' && arr[i+2]=='T' && arr[i+3]=='P' 
        && arr[i+4]=='/' && arr[i+5]=='1' && arr[i+6]=='.' && arr[i+7]=='1'){
            for(int j=i; j<25; j++)
              arr[j]=' ';
            break;
           }
      }
      sendData("    ", 1000, DEBUG);
      sendData(arr, 1000, DEBUG); //디버깅용
      sendData("    ", 1000, DEBUG);
      lcd.setCursor(0,1);
      lcd.print(arr);
            
      /*연결을 끊음*/
      String closeCommand="AT+CIPCLOSE=";
      closeCommand+=connectionID;
      closeCommand+="\r\n";
      sendData(closeCommand, 1000, DEBUG);
    }
  }
}
 
/*ESP8266의 정보를 알아내고 설정하기 위한 함수 선언*/
String sendData(String command, const int timeout, boolean debug){
  String response = "";
  esp8266.print(command); //command를 ESP8266에 보냄
  long int time=millis();
  
  while((time+timeout)>millis()){
    while(esp8266.available()){
      /*esp가 가진 데이터를 시리얼 모니터에 출력하기 위함*/
      char c=esp8266.read(); //다음 문자를 읽어옴
      response+=c;
    }
  }
  if(debug){
    Serial.print(response);
  }
 
  return response;
}

