<?php
// getjson.php
$link = mysqli_connect("localhost", "root", "1234", "testdb");

if (!link) {
  echo "MYSQL 접속 에러 : ";
  echo mysqli_connect_error();
  exit();
}

mysqli_set_charset($link, "utf8");

$sql = "select * from Person";

$result = mysqli_query($link, $sql);
$data = array();
if ($result) {

  while ($row = mysqli_fetch_array($result)) {
    array_push($data,
        array('id'=>$row[0],
        'name'=>$row[1],
        'address'=>$row[2]
        ));
  }

  //echo "<pre>";
  //print_r($data);
  //echo "</pre>";

  // 출력형식을 JSON으로 변환
  header('Content-Type: application/json; charset=utf8');
  $json = json_encode(array("webnautes"=>$data), JSON_PRETTY_PRINT+JSON_UNESCAPED_UNICODE);
  echo  $json;


} else {
  echo "SQL문 처리 중 에러발생";
  echo mysqli_error($link);
}

mysqli_close($link);

?>
