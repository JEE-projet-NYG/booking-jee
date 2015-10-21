$( document ).ready(function() {

    /* When creating an user */
    $("body").on("click", "button.create", function(e) {
        $('#createUserModal').modal('show');
    });

    $('#createUserForm').on('submit', function(e){
        e.preventDefault();
        var form = $('#createUserForm').serialize().replace("admin=on", "admin=true");

        var request = $.ajax({
            url: "/api/users/",
            type: "put",
            data: form
        });

        request.success(function (response, textStatus, jqXHR) {
            $('#createUserModal').modal('hide'); // hide the report form
            $('#createUserForm')[0].reset(); // clear the report form

            $('#alertCreateUserSuccess').modal('show');
            $('#alertCreateUserSuccess').on('hidden.bs.modal', function () {
                location.reload(); // not ideal but ok for now
            })

        });

        request.fail(function (jqXHR, textStatus, errorThrown) {
            $('#alertCreateUserFail').modal('show');
        });
    });


    /* When editing an user */
    $("body").on("click", "a.edit", function(e) {
        var tr = $(this).closest('tr');

        $('#editUserForm').find('[name="id"]').val(tr.find('.id').text());
        $('#editUserForm').find('[name="login"]').val(tr.find('.login').text());
        $('#editUserForm').find('[name="password"]').val(tr.find('.password').text());
        $('#editUserForm').find('[name="lastname"]').val(tr.find('.lastname').text());
        $('#editUserForm').find('[name="firstname"]').val(tr.find('.firstname').text());
        $('#editUserForm').find('[name="mailAddress"]').val(tr.find('.mailAddress').text());
        $('#editUserForm').find('[name="phoneNumber"]').val(tr.find('.phoneNumber').text());
        $('#editUserForm').find('[name="admin"]').prop('checked', tr.find('.admin').children('i').hasClass('glyphicon-check'));

        $('#editUserModal').modal('show');
    });

    $('#editUserForm').on('submit', function(e){
        e.preventDefault();

        var form = $('#editUserForm').serialize().replace("admin=on", "admin=true");
        var request = $.ajax({
            url: "/api/users/",
            type: "post",
            data: form
        });

        request.success(function (response, textStatus, jqXHR) {
            $('#editUserModal').modal('hide'); // hide the report form
            $('#editUserForm')[0].reset(); // clear the report form

            $('#alertEditUserSuccess').modal('show');
            $('#alertEditUserSuccess').on('hidden.bs.modal', function () {
                location.reload(); // not ideal but ok for now
            })

        });

        request.fail(function (jqXHR, textStatus, errorThrown) {
            $('#alertCreateUserFail').modal('show');
        });
    });

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

