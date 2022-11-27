$(document).ready(function () {
    $("#allFilms").click(function () {
        $.get("Film?format=xml",function (data,status,request) {
            console.log(getData(request))

        },"xml")
    })
})

function getData(xml) {
    var i;
    var xmlFormat = xml.responseXML
    var tbl ="<table><tr><th>ID</th><th>Title</th><th>Year</th><th>Director</th><th>Stars</th><th>Reviews</th></tr>"
    var e = xmlFormat.getElementsByTagName("film")
    for (i=0; i < e.length; i++){
        tbl += "<tr><td>"+e[i].getElementsByTagName("id")[0].childNodes[0].nodeValue+"</td>"+
            "<td>"+e[i].getElementsByTagName("title")[0].childNodes[0].nodeValue+"</td>"+
            "<td>"+e[i].getElementsByTagName("year")[0].childNodes[0].nodeValue+"</td>"+
            "<td>"+e[i].getElementsByTagName("director")[0].childNodes[0].nodeValue+"</td>"+
            "<td>"+e[i].getElementsByTagName("stars")[0].childNodes[0].nodeValue+"</td>"+
            "<td>"+e[i].getElementsByTagName("review")[0].childNodes[0].nodeValue+"</td>"+"</tr></table>"
    }
document.getElementById("xml").innerHTML = tbl

}