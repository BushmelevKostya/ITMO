<?php
require_once("response/Coordinator.php");
require_once("response/Validator.php");
require_once("database/Connector.php");
require_once("database/Migrations.php");
require_once("database/Query.php");

//$x = $_GET["x"];
//$y = $_GET["y"];
//$R = $_GET["R"];

$x = (float)$_GET["text"];
$y = (float)$_GET["radio"];
$R = (float)$_GET["press_button"];

?>

<script>
    console.log("зашел в ajax");
    var x = <?php echo $x; ?>;
    var y = <?php echo $y; ?>;
    var R = <?php echo $R; ?>;
</script>


<?php
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
echo $string;

$objCoordinator = new Coordinator($this->x, $this->y, $this->R);
$res = $objCoordinator->getAnswer();

$workTime = microtime(true) - $startTime;

?>
<!DOCTYPE html>
<html>
<head>
    <title>Передача переменных из PHP в JavaScript</title>
</head>
<body>
<table border="1" class="data-table" id="data-table">
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
    <tbody id="data-body">

    </tbody>
</table>

<script>
    class Query {
        constructor(id, x, y, R, result, workTime) {
            this._id = id;
            this._x = x;
            this._y = y;
            this._R = R;
            this._result = result;
            this._workTime = workTime;
        }

        get id() {
            return this._id;
        }

        set id(value) {
            this._id = value;
        }

        get x() {
            return this._x;
        }

        set x(value) {
            this._x = value;
        }

        get y() {
            return this._y;
        }

        set y(value) {
            this._y = value;
        }

        get R() {
            return this._R;
        }

        set R(value) {
            this._R = value;
        }

        get result() {
            return this._result;
        }

        set result(value) {
            this._result = value;
        }

        get workTime() {
            return this._workTime;
        }

        set workTime(value) {
            this._workTime = value;
        }
    }

    class TablePrinter {
        constructor() {
        }

        run() {
            var array;
            try {
                var stringArray = localStorage.getItem("array");
                array = JSON.parse(stringArray);
            } catch
                (error) {
                console.log(error);
            } finally {
                array = array || [];
                let res = <?php echo $res; ?>;
                let workTime = <?php echo $workTime; ?>;
                let id = array.length || 0;
                id += 1;

                let query = new Query(id, x, y, R, res, workTime);

                array.push(query);
                stringArray = JSON.stringify(array);
                localStorage.setItem("array", stringArray);
            }

            let stringObject = localStorage.getItem("array");
            var object = JSON.parse(stringObject);

            let size = object.length;

            var tbody = document.getElementById("data-table");

            for (let i = 0; i < size; i++) {
                var row = tbody.insertRow(-1);

                var cell = row.insertCell(0);
                let data = object[i]._id;
                let newData = document.createTextNode(data);
                cell.classList.add('id-color');
                cell.appendChild(newData);
                cell = row.insertCell(1);
                data = object[i]._x;
                newData = document.createTextNode(data);
                cell.appendChild(newData);
                cell = row.insertCell(2);
                data = object[i]._y;
                newData = document.createTextNode(data);
                cell.appendChild(newData);
                cell = row.insertCell(3);
                data = object[i]._R;
                newData = document.createTextNode(data);
                cell.appendChild(newData);
                cell = row.insertCell(4);
                data = object[i]._result;
                if (data) {
                    data = "Да";
                    cell.classList.add('green-response');
                } else {
                    data = "Нет";
                    cell.classList.add('red-response');
                }
                newData = document.createTextNode(data);
                cell.appendChild(newData);
                cell = row.insertCell(5);
                data = new Date().toLocaleString();
                newData = document.createTextNode(data);
                cell.appendChild(newData);
                cell = row.insertCell(6);
                data = object[i]._workTime.toFixed(6);
                newData = document.createTextNode(data);
                cell.appendChild(newData);
            }
            console.log(object);
        }
    }

    let tablePrinter = new TablePrinter();
    tablePrinter.run();
</script>
<?php
}
}

?>
</body>
</html>