if ($("#updateSuccessMessage").html() != "") {
    $('#updateSuccessMessage').show();
    setTimeout(function() {
        $('#updateSuccessMessage').hide();
    }, 3000);
}