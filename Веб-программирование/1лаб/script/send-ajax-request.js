$("#submit-button").click(function (e) {
    // e.preventDefault();
    var form = $("form");

    $.ajax({
        type: "GET",
        url: "ajax.php",
        data: form.serialize(),
        success: function (response) {
            var json = JSON.parse(response);
            alert(json);
            let tablePrinter = new TablePrinter();
            tablePrinter.run(json.x, json.y, json.R, json.res, json.workTime);
            form[0].reset();
        }
    });
})