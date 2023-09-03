<!--вариант 2801-->
<?php

class Coordinator
{
    private float $x;
    private float $y;
    private float $R;

    /**
     * @param float $x
     * @param float $y
     * @param float $R
     */
    public function __construct(float $x, float $y, float $R)
    {
        $this->x = $x;
        $this->y = $y;
        $this->R = $R;
    }

    public function run(): bool
    {
        $x = false;
        if ($this->x >= 0 && $this->y >= 0) {
            $x = $this->triangle();
        } elseif ($this->x <= 0 && $this->y >= 0) {
            $x = $this->circle();
        } elseif ($this->x <= 0 && $this->y <= 0) {
            $x = $this->square();
        }
        return $x;
    }

    private function triangle(): bool
    {
        return ($this->y <= -$this->x + $this->R / 2);
    }

    private function circle(): bool
    {
        return ($this->y <= sqrt(pow($this->R, 2) - pow($this->x, 2)));
    }

    private function square(): bool
    {
        return ($this->x >= -$this->R && $this->y >= -$this->R);
    }

    /**
     * @return mixed
     */
    public function getX()
    {
        return $this->x;
    }

    /**
     * @param mixed $x
     */
    public function setX($x)
    {
        $this->x = $x;
    }

    /**
     * @return mixed
     */
    public function getY()
    {
        return $this->y;
    }

    /**
     * @param mixed $y
     */
    public function setY($y)
    {
        $this->y = $y;
    }

    /**
     * @return mixed
     */
    public function getR()
    {
        return $this->R;
    }

    /**
     * @param mixed $R
     */
    public function setR($R)
    {
        $this->R = $R;
    }

    public function getAnswer(): string
    {
        $result = $this->run();
        if ($result) {
            return "Да";
        } else return "Нет";
    }
}