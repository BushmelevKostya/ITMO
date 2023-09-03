<?php
$text = (float)$_POST["text"];
$radio = (float)$_POST["radio"];
$press_button = (float)$_POST["press_button"];


$response = array(
    "text" => $text,
    "radio" => $radio,
    "press_button" => $press_button
);

echo json_encode($response);