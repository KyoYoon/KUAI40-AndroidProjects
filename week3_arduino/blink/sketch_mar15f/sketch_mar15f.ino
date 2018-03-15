#define C 262 // 도 
#define D 294 // 레
#define E 330 // 미 
#define F 349 // 파 
#define G 392 // 솔 
#define A 440 // 라 
#define B 494 // 시

int piezoPin = 8;
int tempo = 200;
int notes[25] = {G, G, A, A, G, G, E, G, G, E, E, D,
                 G, G, A, A, G, G, E, G, E, D, E, C};

void setup() {

  // 아두이노에 부착된 스피커를 통해 소리를 출력하는 프로그램
  // 학교종이 땡땡이란 노래가 들리게 된다. 
  pinMode(piezoPin, OUTPUT);  // 8번을 통한 출력 설정
  
}

void loop() {

  // 음계를 통한 소리 출력 
  for (int i = 0; i < 12; i++) {
    tone(piezoPin, notes[i], tempo);
    delay(300);
  }
  delay(200);
  for (int i = 12; i < 25; i++) {
    tone(piezoPin, notes[i], tempo);
    delay(300);
  }
  
}
