/**
 * User management
 */
function editUser() {

}

$( document ).ready(function() {

    /* When creating an user */
    $("body").on("click", "button.create", function(e) {
        $('#createUserModal').modal('show');
    });

    $('#createUserForm').on('submit', function(e){
        e.preventDefault();

        var request = $.ajax({
            url: "/api/users/",
            type: "post",
            data: $('#createUserForm').serialize()
        });

        request.success(function (response, textStatus, jqXHR) {
            $('#createUserModal').modal('hide'); // hide the report form
            $('#createUserForm')[0].reset(); // clear the report form

            // FIXME
            $('#alertDeleteUserSuccess').modal('show');

        });

        request.fail(function (jqXHR, textStatus, errorThrown) {
            // FIXME
            $('#alertDeleteUserFail').modal('show');
        });
    });


    /* When editing an user */
    $("body").on("click", "#table-users td a.edit", function(e) {
        /*
         var tr = $(this).closest('tr');
         var id = tr.find('.id').text();

         var request = $.ajax({
         url: "/api/users/",
         type: "put",
         data : ""
         });

         request.success(function (response, textStatus, jqXHR) {
         $('#alertDeleteUserSuccess').modal('show');
         });

         request.fail(function (jqXHR, textStatus, errorThrown) {
         $('#alertDeleteUserFail').modal('show');
         });
         */
    });

0
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

