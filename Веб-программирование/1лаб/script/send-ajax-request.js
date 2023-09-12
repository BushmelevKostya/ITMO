$("#submit-button").click(function (e) {
    // e.preventDefault();
    var form = $("form");

    $.ajax({
        type: "GET",
        url: "ajax.php",
        data: form.serialize(),
        success: function (response) {
            alert(response);
            $('.data-table').html(response);
            form[0].reset();
        }
    });
})