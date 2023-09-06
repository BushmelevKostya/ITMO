<?php
$text = (float)$_GET["text"];
$radio = (float)$_GET["radio"];
$press_button = (float)$_GET["press_button"];


$response = array(
    "text" => $text,
    "radio" => $radio,
    "press_button" => $press_button
);

echo json_encode($response);