<?php
class Validator {
    public function __construct() {}
    public function check($x, $y, $R) : string {
        if ($this->checkExist($x) && $this->checkExist($y) &&
            $this->checkExist($R)) {
            if ($this->checkType($x) &&
                $this->checkType($y) && $this->checkType($R)) {
                if ($this->checkPositive($R)) {
                    return "";
                }
                else return "Радиус должен быть положительным";
            }
            else return "Данные должны быть типа float";
        }
        else return "Необходимо заполнить все поля";
    }
    public function checkExist($x) : bool {
        return ($x != null);
    }
    public function checkType($x) : bool {
        return (is_numeric($x));
    }
    public function checkPositive(float $x) : bool {
        return ($x > 0);
    }
}