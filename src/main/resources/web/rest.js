$(document).ready(function () {
    $.ajax({
        url: "http://localhost:8080/analysis/all",
        crossDomain: true
    }).then(function (data) {
        var html = "<thead>\n" +
            "<tr>\n" +
            "<th>ID</th>\n" +
            "<th>Date</th>\n" +
            "<th>Product number</th>\n" +
            "<th>Lot number</th>\n" +
            "<th>Type</th>\n" +
            "<th>Reason</th>\n" +
            "<th>Runs</th>\n" +
            "<th>Notes</th>\n" +
            "<th>Chemist</th>\n" +
            "<th>Created at</th>\n" +
            "</tr>\n" +
            "</thead>\n" +
            "<tbody>\n";
        for (var i = 0; i < data.length; i++) {
            html += "<tr><td>" + data[i].id + "</td>"
            html += "<td>" + data[i].date + "</td>"
            html += "<td>" + data[i].productNumber + "</td>"
            html += "<td>" + data[i].lotNumber + "</td>"
            html += "<td>" + data[i].type + "</td>"
            html += "<td>" + data[i].reason + "</td>"
            html += "<td>" + data[i].numberRuns + "</td>"
            html += "<td>" + data[i].notes + "</td>"
            html += "<td>" + data[i].chemist + "</td>"
            html += "<td>" + data[i].createdAt + "</td></tr></tbody>"
        }
        $('#analyses').append(html);
        $('#analyses').DataTable();
    });


});