#include <ESP8266.h>
#include <ESP8266Client.h>
#include <SoftwareSerial.h>

#define DEBUG true

SoftwareSerial esp8266(2, 3);//RX:2, TX:3
const int LED = 13;

void setup() {
  Serial.begin(9600);
  esp8266.begin(9600); //esp의 bbaurate

  pinMode(LED, OUTPUT);//led 가 꽂힌 핀
  digitalWrite(LED, LOW); //led를 끈상태로 초기화

  //AT Command
  sendData("AT+RST\r\n",2000,DEBUG);//Module 초기화
  sendData("AT+CWMODE=3\r\n",1000,DEBUG);
  
  //우리가 사용할 공유기 설정
  sendData("AT+CWJAP=\"KU_TEMP01_2.4G\",\"korea123!\"\r\n",5000,DEBUG);  
  sendData("AT+CIPMUX=1\r\n",1000,DEBUG); //multiple connection 설정
  sendData("AT+CIPSERVER=1,80\r\n",1000,DEBUG); //포트번호를 80으로 설정
}

void loop() {
  // 웹페이지에서 esp8266으로 메세지가 왔는지 파악한다.
  if(esp8266.available()){
    if(esp8266.find("+IPD,")){//데이터를 받아옴
      delay(1000);//시리얼 버퍼에서 보내져온 데이터가 다 찰 때까지 대기한다.
      //connection ID를 알아내고 아스키코드값으로 48을 빼준다.
      int connectionID=esp8266.read()-48;
      esp8266.find("pin=");
      int pinNumber = (esp8266.read()-48)*10;//첫번째 번호를 구한다.
      pinNumber +=(esp8266.read()-48);//두번째 번호를 구한다.

     
      //핀번호를 구했으므로 해당 핀을 제어한다.
      //해당 핀의 상태를 구한 값을 NOT으로 해서 Toggle시킨다.
      digitalWrite(pinNumber,!digitalRead(pinNumber));

      //연결을 끊는다.
      String closeCommand = "AT+CIPCLOSE=";
      closeCommand+=connectionID;
      closeCommand += "\r\n";
      sendData(closeCommand,1000,DEBUG);
    }
  }

}

String sendData(String command,const int timeout, boolean debug){
  String response="";
  esp8266.print(command);//명령을 esp8266에 보낸다.
  long int time = millis();//현재 시간을 구한다.

  while((time + timeout) > millis()){
    while(esp8266.available()){
      //esp가 가진 데이터를 시리얼 모니터에 출력하기 위해서
      char c = esp8266.read();//다음 문자를 읽어온다.
      response +=c;
    }
  }
  if(debug){
    Serial.print(response);
    
  }
  //esp8266에서 받은 내용을 호출한 곳으로 돌려준다.
  return response;
}

