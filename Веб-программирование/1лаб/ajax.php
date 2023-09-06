<?php
require_once("response/Coordinator.php");
require_once("response/Validator.php");
require_once("database/Connector.php");
require_once("database/Migrations.php");
require_once("database/Query.php");

$x = $_GET["x"];
$y = $_GET["y"];
$R = $_GET["R"];

$runner = new Runner($x, $y, $R);
$runner->run();

class Runner {
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

    public function run() {
        $dateTime = date(DATE_ATOM);
        $startTime = microtime(true);

        $validator = new Validator();
        $string = $validator->check($this->x, $this->y, $this->R);
        echo $string;

        $objCoordinator = new Coordinator($this->x, $this->y, $this->R);
        $res = $objCoordinator->getAnswer();

        $connector = new Connector();
        $connection = $connector->connect();

        $workTime = microtime(true) - $startTime;

        $migrations = new Migrations($connection);
//$migrations->createTable();
        $query = new Query($this->x, $this->y, $this->R, $res, $startTime, $workTime);
        $migrations->addQuery($query);

        $tablePrinter = new TablePrinter($migrations);
        $tablePrinter->run();
    }


}

class TablePrinter
{
    private Migrations $migrations;

    /**
     * @param Migrations $migrations
     */
    public function __construct(Migrations $migrations)
    {
        $this->migrations = $migrations;
    }

    public function run(): void
    {
        $response = $this->migrations->getAllInfo();
        ?>
        <table border="1" class="data-table">
            <caption class="gradient-blue">Таблица результатов запроса</caption>
            <tr>
                <th class="data-header">id</th>
                <th class="data-header">x</th>
                <th class="data-header">y</th>
                <th class="data-header">R</th>
                <th class="data-header">Попадание</th>
                <th class="data-header">Время запроса</th>
                <th class="data-header">Время обработки запроса(мкс)</th>
            </tr>
            <?php
            $i = 0;
            while (pg_result_seek($response, $i)) {
                $row = pg_fetch_row($response);
                ?>
                <tr>
                    <td class="id-color"><?php echo $row[0] ?></td>
                    <td><?php echo $row[1] ?></td>
                    <td><?php echo $row[2] ?></td>
                    <td><?php echo $row[3] ?></td>

                    <?php
                    if ($row[4] == "Нет") {
                        ?><td class="red-response"><?php echo $row[4] ?></td>
                    <?php } else {
                        ?><td class="green-response"><?php echo $row[4] ?></td>
                    <?php }
                    ?>

                    <td><?php echo $row[5] ?></td>
                    <td><?php echo round($row[6], 4) ?></td>
                </tr>
                <?php
                $i++;
            }
            ?>
        </table>
        <?php
    }
}

?>