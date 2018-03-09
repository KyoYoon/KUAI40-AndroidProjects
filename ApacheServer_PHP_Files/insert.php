<?php
error_reporting(E_ALL);
ini_set('display_errors', 1);

//데이터베이스에 연결시도후 실패하면 프로그램 종료
$link = mysqli_connect("localhost", "root", "1234", "testdb");
if(!$link) {
	echo "MySQL Connect Error....";
	echo mysqli_connect_error();
    exit();
}

mysqli_set_charset($link, "utf8");

//POST 값을 읽어들인다.
$name = isset($_POST['name']) ? $_POST['name'] : '';
$address = isset($_POST['address']) ? $_POST['address'] : '';

//각 컬럼에 데이터가 있는 경우만 테이블에 등록한다.
if($name != '' and $address != '') {
	$sql = "insert into Person(name, address) values('$name', '$address')";
	$result = mysqli_query($link, $sql);

	if($result) {
		echo "데이터 입력 성공";
	} else {
		echo "데이터 입력 오류";
		echo mysqli_error($link);
	}
} else {
	echo "데이터를 입력하십시요.";
}

mysqli_close($link);
?>

<?php
//휴대폰으로 접속하지 않은 경우
$android = strpos($_SERVER['HTTP_USER_AGENT'], "Android");

if(!$android) {
?>

<html>
	<body>
		<form action="<?php $_PHP_SELF ?>" method="post">
			Name : <input type="text" name="name" />
			Address : <input type="text" name="address" />
			<input type="submit">
		</form>
	</body>
</html>

<?php
}
?>
