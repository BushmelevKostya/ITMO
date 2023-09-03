<?php
class Query {
    private float $x;
    private float $y;
    private float $R;
    private string $result;
    private string $startTime;
    private float $workTime;

    /**
     * @param float $x
     * @param float $y
     * @param float $R
     * @param string $result
     * @param string $startTime
     * @param float $workTime
     */
    public function __construct(float $x, float $y, float $R, string $result, string $startTime, float $workTime)
    {
        $this->x = $x;
        $this->y = $y;
        $this->R = $R;
        $this->result = $result;
        $this->startTime = $startTime;
        $this->workTime = $workTime;
    }

    /**
     * @return float
     */
    public function getX(): float
    {
        return $this->x;
    }

    /**
     * @param float $x
     */
    public function setX(float $x): void
    {
        $this->x = $x;
    }

    /**
     * @return float
     */
    public function getY(): float
    {
        return $this->y;
    }

    /**
     * @param float $y
     */
    public function setY(float $y): void
    {
        $this->y = $y;
    }

    /**
     * @return float
     */
    public function getR(): float
    {
        return $this->R;
    }

    /**
     * @param float $R
     */
    public function setR(float $R): void
    {
        $this->R = $R;
    }

    /**
     * @return string
     */
    public function getResult(): string
    {
        return $this->result;
    }

    /**
     * @param string $result
     */
    public function setResult(string $result): void
    {
        $this->result = $result;
    }

    /**
     * @return string
     */
    public function getStartTime(): string
    {
        return $this->startTime;
    }

    /**
     * @param string $startTime
     */
    public function setStartTime(string $startTime): void
    {
        $this->startTime = $startTime;
    }

    /**
     * @return float
     */
    public function getWorkTime(): float
    {
        return $this->workTime;
    }

    /**
     * @param float $workTime
     */
    public function setWorkTime(float $workTime): void
    {
        $this->workTime = $workTime;
    }


}