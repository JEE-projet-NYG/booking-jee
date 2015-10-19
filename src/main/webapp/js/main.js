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

/* Supprime un utilisateur par son id */
function deleteUser(id) {

    var request = $.ajax({
        url: "/api/users/"+id,
        type: "delete"
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