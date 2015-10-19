/**
 * User management
 */
function createUser() {

}

/* Supprime un utilisateur par son id */
function deleteUser(id) {

    var request = $.ajax({
        url: "/api/users/delete",
        type: "get",
        data: {id: id}
    });

    request.success(function (response, textStatus, jqXHR) {
        console.log("success" + response);
    });

    request.fail(function (jqXHR, textStatus, errorThrown) {
        console.log("failure" + errorThrown);
    });
}

function editUser() {

}