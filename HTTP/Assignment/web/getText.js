$(document).ready(function(){
    $("#getText").click(function(){
        $.get(window.location.origin+window.location.pathname+"Film?format=text", function(data){
            var d = new Array(data.split("Film"))

            for (let i = 0; i < d.length ; i++) {

                var arr = d[i];
                for (var j  = 0; j < arr.length; j++) {

                    arr[j].match(/id=[0-9][^,]*/g) ? $("#text").append($('<li>').html(`${arr[j].match(/id=[0-9][^,]*/g) }`)) : console.log("id")
                    arr[j].match(/title=[a-zA-Z0-9][^,]*/g) ? $("#text").append($('<li>').html(`${arr[j].match(/title=[a-zA-Z0-9][^,]*/g)}`)): console.log("title")
                    arr[j].match(/year=[0-9][^,]*/g) ? $("#text").append($('<li>').html(`${arr[j].match(/year=[0-9][^,]*/g)}`)) : console.log("year")
                    arr[j].match(/director=[a-zA-Z0-9][^,]*/g) ? $("#text").append($('<li>').html(`${arr[j].match(/director=[a-zA-Z0-9][^,]*/g)}`)) : console.log("director")
                    arr[j].match(/stars=[a-zA-Z0-9][^,]*/g) ? $("#text").append($('<li>').html(`${arr[j].match(/stars=[a-zA-Z0-9][^,]*/g)}`)) : console.log("stars")
                    arr[j].match(/review=[a-zA-Z0-9][^\]/]*/g) ? $("#text").append($('<li>').html(`${arr[j].match(/review=[a-zA-Z0-9][^\]/]*/g)}`)) : console.log("review")
                    console.log(arr[j])

                }
            }

        });

    });
});