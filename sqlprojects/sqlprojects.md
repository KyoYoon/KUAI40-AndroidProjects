# Apache, PHP 서버 설치 및 MySQL 연동준비

## 1. 아파치 서버 설치
1) https://www.apachelounge.com/download/ 에서
   자신의 환경과 맞는 것을 가져온다.
2) 설치된 c:\Apache24\conf 아래에 있는
   환경파일(httpd.conf)를 자신의 환경에 맞게 수정한다.
   a) ServerRoot 경로를 변경한다.
      ServerRoot "c:/apache24"
   b) 포트를 변경한다.
      Listen 80
   c) 웹문서 저장위치 변경
      DocumentRoot "c:/Apache24/htdocs"
   d) ServerName을 변경한다.
      ServerName localhost:80
      ServerName 127.0.0.1:80
3) 윈도우 시스템 환경변수에 경로를 등록한다.
   경로에 c:/Apache24/bin 를 추가한다.
4) 윈도우 서비스에 등록한다.
   관리자 모드로 cmd창을 연다.
   httpd -k install   (설치)
   httpd -k start     (실행)
   httpd -k stop      (정지)
   httpd -k restart   (재실행)
   httpd -k uninstall (제거)
   httpd -k uninstall -n Apache2(서비스이름) (제거)

   ~124.dll 에러가 발생할 경우 아래의 파일을 설치한다.
https://www.microsoft.com/en-us/download/details.aspx?id=52685

=> Download 클릭 후 => 64비트 버전 선택 및 다운로드
   후 설치

## 2. PHP 설치
1) https://windows.php.net/download 에서 php를 다운받아
   설치한다.
   VC14 x64 Thread Safe (2018-Mar-01 06:38:20)

   php7 폴더를 복사해서 사용하고자 하는 곳에 붙여
   넣는다.
   c:\php7
2) php.ini-production 파일을 php.ini라는 이름으로
   저장한다.
3) php.ini 환경파일 설정
   extension_dir = "c:\php7\ext\"

  구버전의 경우 php_mysql.dll 를 php_mysqli.dll로 변경한다
   extension=php_mysql.dll => php_mysqli.dll

   ; 으로 막힌 부분을 풀어준다.
   extension=php_mysqli.dll
   extension=php_pdo_mysql.dll

 4) php.ini 파일을 잘라내어 c:\Windows 폴더로 붙여넣는다.
    복사/붙여넣기가 아니라 꼭 잘라내기를 해야한다.
    왜냐하면 PHP 폴더에도 php.ini가 존재하는 경우에
    windows폴더의 php.ini와 서로 충돌이 발생할 수도 있다.

## 3. 아파치 서버와 PHP를 연동
1) c:\apache24\conf\httpd.conf 파일의 맨 마지막에
   아래의 내용을 추가한다.

PHPIniDir "C:/Windows"
LoadModule php7_module "C:/php7/php7apache2_4.dll"
AddType application/x-httpd-php .html .php

2) 설정이 끝났으면 아파치 서버를 재시작한다.
윈도우 작업관리자의 서비스에 Apache2.4가 있는지 확인

## 4. MySQL DB 접속

1) mysql -u root -p1234
2) 데이터베이스를 생성한다.
   create database testdb;
   생성이 되었는지 확인하다.
   show databases;
3) 사용할 데이터베이스를 선택한다.
  use testdb;
* 테이블들의 목록보기 : show tables;
4) Person 테이블을 생성한다.
  create table Person (
    id	bigint(20)	unsigned not null auto_increment,
    name varchar(255) not null,
    address varchar(255) not null,
    primary key (id)
  ) charset=utf8;
* 테이블 구조보기 (desc Person;)
