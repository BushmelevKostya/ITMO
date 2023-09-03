<?php
class Connector {
    private string $host;
    private string $port;
    private string $dbname;
    private string $user;
    private string $password;

    /**
     * @param string $host
     * @param string $port
     * @param string $dbname
     * @param string $user
     * @param string $password
     */
    public function __construct()
    {
        $data = parse_ini_file("config.ini");
        $this->host = $data["host"];
        $this->port = $data["port"];
        $this->dbname = $data["dbname"];
        $this->user = $data["user"];
        $this->password = $data["password"];
    }

    public function connect() {
        $conn_string = "host=" . $this->host . " port=" . $this->port . " dbname=" . $this->dbname . " user=" . $this->user . " password=" . $this->password;
        return pg_connect($conn_string);
    }
}