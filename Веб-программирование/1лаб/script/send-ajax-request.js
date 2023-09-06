$('form').on('submit', function (e) {
    e.preventDefault();
    $.ajax({
        url: $(this).attr('action'),
        type: "GET",
        cache: false,
        data: $(this).serialize(),
        success: function (data) {
            var response = JSON.parse(data);
            var x = response.radio;
            var y = response.text;
            var R = response.press_button;
            $.ajax({
                type: "GET",
                url: "ajax.php",
                data: {x: x, y: y, R: R},
                success: function (response) {
                    $('.data-table').html(response);
                }
            })
        }
    });
})