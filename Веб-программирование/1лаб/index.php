<!DOCTYPE html public "-//W3C//DTD HTML 4.01//EN">
<html lang="en">

<head>
    <meta content="text/html" http-equiv="Content-Type">
    <title>Bomb project</title>
    <link rel="stylesheet" href="styles/style.css">
</head>

<body>

<form method="GET" class="main-form" action="/ajax.php">
    <table border="1" class="main-table">
        <tr>
            <td colspan="4">
                <div>
                    <h4 class="header gradient-white">Bushmelev Kostya, Group P3218, Variant 2801</h4>
                </div>
            </td>
        </tr>
        <tr>
            <th>x</th>
            <th>y</th>
            <th>R</th>
            <td rowspan="10"><input type="submit" class="submit-button"></td>
        </tr>

        <tr>
            <td class="radio-button-block">
                <label for="radio1">-2</label>
                <input type="radio" id="radio1" name="radio" value="-2" class="radio-button">
            </td>
            <td rowspan="9" class="input-text-block">
                <label for="text" class="text-label"><div class="gradient-blue">Область определения: [-5, ..., 3]</div></label>
                <input type="text" id="text" name="text" class="input-text">
            </td>
            <td rowspan="2" class="input-button-block">
                <input type="button" id="button1" name="button" value="1" onclick="send.call(this, 1)" class="input-button">
                <input type="hidden" name="press_button" value="" id="press_button">
            </td>
        </tr>
        <tr>
            <td class="radio-button-block">
                <label for="radio2">-1.5</label>
                <input type="radio" id="radio2" name="radio" value="-1.5" class="radio-button">
            </td>
        </tr>
        <tr>
            <td class="radio-button-block">
                <label for="radio3">-1</label>
                <input type="radio" id="radio3" name="radio" value="-1" class="radio-button">
            </td>
            <td rowspan="2" class="input-button-block">
                <input type="button" id="button2" name="button" value="1.5" onclick="send.call(this, 1.5)" class="input-button">
            </td>
        </tr>
        <tr>
            <td class="radio-button-block">
                <label for="radio4">-0.5</label>
                <input type="radio" id="radio4" name="radio" value="-0.5" class="radio-button">
            </td>
        </tr>
        <tr>
            <td class="radio-button-block">
                <label for="radio5">0</label>
                <input type="radio" id="radio5" name="radio" value="0" class="radio-button">
            </td>
            <td rowspan="2" class="input-button-block">
                <input type="button" id="button3" name="button" value="2" onclick="send.call(this, 2)" class="input-button">
            </td>
        </tr>
        <tr>
            <td class="radio-button-block">
                <label for="radio6">0.5</label>
                <input type="radio" id="radio6" name="radio" value="0.5" class="radio-button">
            </td>
        </tr>
        <tr>
            <td class="radio-button-block">
                <label for="radio7">1</label>
                <input type="radio" id="radio7" name="radio" value="1" class="radio-button">
            </td>
            <td rowspan="2" class="input-button-block">
                <input type="button" id="button4" name="button" value="2.5" onclick="send.call(this, 2.5)" class="input-button">
            </td>
        </tr>
        <tr>
            <td class="radio-button-block">
                <label for="radio8">1.5</label>
                <input type="radio" id="radio8" name="radio" value="1.5" class="radio-button">
            </td>
        </tr>
        <tr>
            <td class="radio-button-block">
                <label for="radio9">2</label>
                <input type="radio" id="radio9" name="radio" value="2" class="radio-button">
            </td>
            <td class="input-button-block">
                <input type="button" id="button5" name="button" value="3" onclick="send.call(this, 3)" class="input-button">
            </td>
        </tr>
        <tr>
            <td colspan="4">
                <figure class="img-areas">
                    <img src="img/areas.png" width="420" alt="coordinate area">
                </figure>
            </td>
        </tr>
    </table>
    <div class="message"></div>


    
    <script type="javascript">
        function send(press_value) {
            this.form['press_button'].value = press_value;
        }
    </script>



    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script>
        $('form').on('submit', function (e) {
            e.preventDefault();
            $.ajax({
                url: $(this).attr('action'),
                type: "GET",
                cache: false,
                data: $(this).serialize(),
                success: function (data) {
                    $('.message').html(data);
                },
                error: function (data) { // Данные не отправлены
                    $('.message').html('')
                        .append('<ul class="alert-data error"><li>Произошла ошибка. Не найден URL - ' + $(self).attr('action') + '! Обратитесь в службу поддержки!</li></ul>')
                        .append('<ul class="alert-data error"><li>Данные из формы: ' + $(self).serialize() + '</li></ul>');
                }
            });
        })
    </script>
</form>

</body>
</html>