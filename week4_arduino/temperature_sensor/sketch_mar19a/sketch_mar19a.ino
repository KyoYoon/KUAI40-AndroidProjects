// 온도 센서 프로그램
// 온도 센서가 주변 온도를 감지하여 결과를 출력해서 보여준다.

float temperature;
float celsius = 0, fahrenheit = 0; 
int   reading;
int   lm35pin = A2;

void setup() {
  // put your setup code here, to run once:
  Serial.begin(9600);
  

}

void loop() {
  // put your main code here, to run repeatedly:
  reading = analogRead(lm35pin);
  celsius = (reading * 5.0 * 100.0) / 1024.0;
  fahrenheit = celsius * 9.0 / 5.0 + 32.0;
  Serial.print(celsius);
  Serial.print(" C" );
  Serial.print(" / ");
  Serial.print(fahrenheit);
  Serial.println(" F ");
  Serial.println("--------------------");
  delay(2000);
  
}
