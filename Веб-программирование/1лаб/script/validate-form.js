const input = document.getElementById('text');
input.addEventListener('keyup', function (){
    const curVal = this.value;
    const regex = /^-?([0-9]+\.?[0-9]*)?$/;
    if (!regex.test(curVal)) {
        const result = curVal.match(/^-?[0-9.]/g, "");
        if (result !== null) {
            this.value = result[0];
        } else {
            this.value = "";
        }
    } else if(this.value > 3 || this.value < -5) {
        this.value = "";
    }
});