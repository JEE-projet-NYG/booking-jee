/**
 * User management
 */
function createUser() {
    var request = $.ajax({
        url: "/api/users/"+id,
        type: "put"
    });

    request.success(function (response, textStatus, jqXHR) {
        console.log("success " + response);
    });

    request.fail(function (jqXHR, textStatus, errorThrown) {
        console.log("failure " + errorThrown);
    });
}

function editUser() {

}

$( document ).ready(function() {

    /* When deleting an user */
    $("body").on("click", "#table-users td a.delete", function(e) {

        var tr = $(this).closest('tr');
        var id = tr.find('.id').text();

        var request = $.ajax({
            url: "/api/users/"+id,
            type: "delete"
        });

        request.success(function (response, textStatus, jqXHR) {
            tr.remove();
            $('#alertDeleteUserSuccess').modal('show');
        });

        request.fail(function (jqXHR, textStatus, errorThrown) {
            $('#alertDeleteUserFail').modal('show');
        });
    });
});

