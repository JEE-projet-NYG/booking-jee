/**
 * Created by ferrilata on 24/10/15.
 */

$('#resType').change(function(e){
    $('#fakeForm').submit();
});

$('#dateMin').on('input', function(e){
    $('#fakeForm').submit();
});

$('#dateMax').on('input', function(e){
    $('#fakeForm').submit();
});
