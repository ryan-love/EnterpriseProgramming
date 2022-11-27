$(document).ready(function(){
    $("#getJSON").click(function(){
        $.getJSON(window.location.origin+window.location.pathname+"Film?format=json", function(data){
            console.log(data)
            for (var i = 0; i < data.length; i++){
                document.write("<br><br>array index: " + i);
                var obj = data[i];
                for (var k in obj){
                    var v = obj[k];
                    document.write("<br> - " + k + ": " + v);
                }
            }


            var d = data
                $("#json").html(`${d[i]}`)
                console.log(json)

        });

    });
});