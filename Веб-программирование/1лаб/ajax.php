<?php
if ($_SERVER["REQUEST_METHOD"] == "GET") {
    require_once('response.php');
} else {
    echo "Ошибка: Недопустимый метод запроса.";
}
?>
