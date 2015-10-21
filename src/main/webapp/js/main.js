$( document ).ready(function() {

    /* When creating an user */
    $("body").on("click", "button.createUser", function(e) {
        $('#createUserModal').modal('show');
    });

    $("body").on("click", "button.createResource", function(e) {
        $('#createResourceModal').modal('show');
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

            alertSuccess('Successfully created user.');
            $('#alertSuccess').on('hidden.bs.modal', function () {
                location.reload(); // not ideal but ok for now
            })

        });

        request.fail(function (jqXHR, textStatus, errorThrown) {
            alertFailure('An error occured when creating user.');
        });
    });


    /* When editing an user */
    $("body").on("click", "#table-users td a.edit", function(e) {
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

            alertSuccess('Successfully edited user.');
            $('#alertSuccess').on('hidden.bs.modal', function () {
                location.reload(); // not ideal but ok for now
            })

        });

        request.fail(function (jqXHR, textStatus, errorThrown) {
            alertFailure('An error occured when editing user.');
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
            alertSuccess('Succesfully deleted user.');
        });

        request.fail(function (jqXHR, textStatus, errorThrown) {
            alertFailure('An error occured when deleting user.');
        });
    });

    $('#createResourceForm').on('submit', function(e){
        e.preventDefault();
        var form = $('#createResourceForm').serialize();

        var request = $.ajax({
            url: "/api/resources/",
            type: "put",
            data: form
        });

        request.success(function (response, textStatus, jqXHR) {
            $('#createResourceModal').modal('hide'); // hide the report form
            $('#createResourceForm')[0].reset(); // clear the report form

            alertSuccess('Successfully created resource.');
            $('#alertSuccess').on('hidden.bs.modal', function () {
                location.reload(); // not ideal but ok for now
            })

        });

        request.fail(function (jqXHR, textStatus, errorThrown) {
            alertFailure('An error occured when creating resource.');
        });
    });


    /* When editing an resource */
    $("body").on("click", "#table-resources td a.edit", function(e) {
        var tr = $(this).closest('tr');

        $('#editResourceForm').find('[name="id"]').val(tr.find('.id').text());
        $('#editResourceForm').find('[name="name"]').val(tr.find('.name').text());
        $('#editResourceForm').find('[name="description"]').val(tr.find('.description').text());
        $('#editResourceForm').find('[name="localisation"]').val(tr.find('.localisation').text());

        $('#editResourceModal').modal('show');
    });

    $('#editResourceForm').on('submit', function(e){
        e.preventDefault();

        var form = $('#editResourceForm').serialize();
        var request = $.ajax({
            url: "/api/resources/",
            type: "post",
            data: form
        });

        request.success(function (response, textStatus, jqXHR) {
            $('#editResourceModal').modal('hide'); // hide the report form
            $('#editResourceForm')[0].reset(); // clear the report form

            alertSuccess('Successfully edited resource.');
            $('#alertSuccess').on('hidden.bs.modal', function () {
                location.reload(); // not ideal but ok for now
            })

        });

        request.fail(function (jqXHR, textStatus, errorThrown) {
            alertFailure('An error occured when editing resource.');
        });
    });

    /* When deleting an resource */
    $("body").on("click", "#table-resources td a.delete", function(e) {

        var tr = $(this).closest('tr');
        var id = tr.find('.id').text();

        var request = $.ajax({
            url: "/api/resources/"+id,
            type: "delete"
        });

        request.success(function (response, textStatus, jqXHR) {
            tr.remove();
            alertSuccess('Succesfully deleted resource.');
        });

        request.fail(function (jqXHR, textStatus, errorThrown) {
            alertFailure('An error occured when deleting resource.');
        });
    });
    
});

function alertSuccess(message){
    $("#alertSuccess").find("p").text(message);
    $("#alertSuccess").modal('show');
}

function alertFailure(message){
    $("#alertFailure").find("p").text(message);
    $("#alertFailure").modal('show');
}