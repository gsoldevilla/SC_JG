$(document).ready(function () {

    $("#cboDepartamento").change(function () {
        $('#cboProvincia').val("");
        $('#cboDistrito').val("");
        var cod_dep = $(this).val();

        $('#cboProvincia option').each(function () {
            var a_prov = $(this).val().split("#");
            if (a_prov[1] == cod_dep || $(this).val()== "") {
                $(this).removeAttr("hidden");
            } else {
                $(this).prop("hidden", "hidden");
            }
        });

        $('#cboDistrito option').each(function () {
            if ($(this).val() != "") {
                $(this).prop("hidden", "hidden");
            }
        });
    });

    $("#cboProvincia").change(function () {
        $('#cboDistrito').val("");
        var a_prov = $(this).val().split("#");

        $('#cboDistrito option').each(function () {
            var a_dist = $(this).val().split("#");
            if (a_dist[2] == a_prov[0] || $(this).val()== "") {
                $(this).removeAttr("hidden");
            } else {
                $(this).prop("hidden", "hidden");
            }
        });
    });

});