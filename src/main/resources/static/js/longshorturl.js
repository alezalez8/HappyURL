$('#longurl').on('submit', function (event) {
    event.preventDefault();
    const url = '/shorten';
    let data = getFormData($(this));
    // let data = $('#longurl input[name = "url"]').val();
    data = JSON.stringify(data);
    console.log(data);

   // postMyData(url, data);
    $(this).trigger('reset');

    $.ajax({
        type: "POST",
        url,
        data,
        contentType: 'application/json',
        dataType: 'json',
        success: function (response) {
            console.log(response);
        }
    });
});


$('#shorturl').on('submit', function(event){
    event.preventDefault();
    let url ='/my/';
    let myindex = $('#shorturl input[name = "shortURL"]').val();
    url = url.concat(myindex);
    console.log(url);

    $.ajax({
        type: "GET",
        url,
        success: function (response) {
            console.log(response);
        }
    });
   // $.get(url);
});

/*function  postMyData(url, data) {
    $.ajax({
        type: "POST",
        url,
        data,
        contentType: 'application/json',
        dataType: 'json',
        success: function (response) {
            console.log(response);
        }
    });
}*/

function getFormData($form) {
    var unindexed_array = $form.serializeArray();
    var indexed_array = {};

    $.map(unindexed_array, function (n, i) {
        indexed_array[n['name']] = n['value'];
    });

    return indexed_array;
}