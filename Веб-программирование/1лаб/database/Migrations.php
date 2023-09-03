<?php
class Migrations {
    private $connection;

    /**
     * @param $connection
     */
    public function __construct($connection)
    {
        $this->connection = $connection;
    }

    public function addQuery(Query $objQuery) : PgSql\Result {
        $x = $objQuery->getX();
        $y = $objQuery->getY();
        $R = $objQuery->getR();
        $result = $objQuery->getResult();
        $startTime = $objQuery->getStartTime();
//        $startTime = strtotime($startTime);
        $workTime = $objQuery->getWorkTime();

        $stmtname = "add_query";
        $query =    'insert into query (
                    x, y, R, result, start_time, work_time)
                    VALUES ($1, $2, $3, $4, to_timestamp($5), $6)';

        pg_prepare($this->connection, $stmtname, $query);
        return pg_execute($this->connection, $stmtname, array($x, $y, $R, $result, $startTime, $workTime));
    }

    public function createTable() : PgSql\Result {
        $query =    'create table if not exists query(
                    id serial primary key,
                    x float not null,
                    y float not null,
                    R float not null,
                    result varchar(255) not null,
                    start_time timestamp not null,
                    work_time float not null)';

        return pg_query($this->connection, $query);
    }

    public function getAllInfo() : PgSql\Result {
        $query = 'select * from query';
        $stmtname = "myquery";
        pg_prepare($this->connection, $stmtname, $query);
        return pg_execute($this->connection, $stmtname, array());
    }
}
