<?php
require_once("response/Coordinator.php");
require_once("response/Validator.php");
require_once("database/Connector.php");
require_once("database/Migrations.php");
require_once("database/Query.php");

$x = $_GET["radio"];
$y = $_GET["text"];
$R = (float)$_GET['press_button'];
$dateTime = date(DATE_ATOM);
$startTime = microtime(true);

$validator = new Validator();
$string = $validator->check($x, $y, $R);
echo $string;

$objCoordinator = new Coordinator($x, $y, $R);
$res = $objCoordinator->getAnswer();

$connector = new Connector();
$connection = $connector->connect();

$workTime = microtime(true) - $startTime;

$migrations = new Migrations($connection);
//$migrations->createTable();
$query = new Query($x, $y, $R, $res, $startTime, $workTime);
$migrations->addQuery($query);

$tablePrinter = new TablePrinter($migrations);
$tablePrinter->run();
?>


<?php
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
        <table border="1">
            <caption>Таблица результатов запроса</caption>
            <tr>
                <th>id</th>
                <th>x</th>
                <th>y</th>
                <th>R</th>
                <th>Попадание</th>
                <th>Время запроса</th>
                <th>Время обработки запроса(мкс)</th>
            </tr>
            <?php
            $i = 0;
            while (pg_result_seek($response, $i)) {
                $row = pg_fetch_row($response);
                ?>
                <tr>
                    <td><?php echo $row[0] ?></td>
                    <td><?php echo $row[1] ?></td>
                    <td><?php echo $row[2] ?></td>
                    <td><?php echo $row[3] ?></td>
                    <td><?php echo $row[4] ?></td>
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