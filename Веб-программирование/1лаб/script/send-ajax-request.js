$("#submit-button").click(function (e) {
    var form = $("form");

    $.ajax({
        type: "GET",
        url: "ajax.php",
        data: form.serialize(),
        success: function (response) {
            var json = JSON.parse(response);
            if (json.error !== "") {
                console.log(json.error);
                form[0].reset();
            }
            else {
                let tablePrinter = new TablePrinter();
                tablePrinter.run(json.x, json.y, json.R, json.res, json.workTime);
                form[0].reset();
            }
        }
    });
})