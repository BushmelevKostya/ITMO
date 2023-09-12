<?php
require_once("response/Coordinator.php");
require_once("response/Validator.php");
require_once("database/Connector.php");
require_once("database/Migrations.php");
require_once("database/Query.php");

$y = (float)$_GET["text"];
$x = (float)$_GET["radio"];
$R = (float)$_GET["press_button"];

$runner = new Runner($x, $y, $R);
$runner->run();

class Runner
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

    public function run()
    {
        $startTime = microtime(true);

        $validator = new Validator();
        $string = $validator->check($this->x, $this->y, $this->R);

        $objCoordinator = new Coordinator($this->x, $this->y, $this->R);
        $res = $objCoordinator->getAnswer();

        $workTime = microtime(true) - $startTime;

        $response = array(
            "x" => $this->x,
            "y" => $this->y,
            "R" => $this->R,
            "res" => $res,
            "workTime" => $workTime
        );

        echo json_encode($response);
    }
}