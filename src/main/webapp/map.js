var map = L.map('map').setView([36.456974, 115.967184], 13);
var markers = [];

L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
    // L.tileLayer(''file:///path/to/your/tiles/tile.openstreetmap.org/{z}/{x}/{y}.png', {
    attribution: 'Map data &copy; <a href="https://www.openstreetmap.org/">OpenStreetMap</a> contributors',
    maxZoom: 18,
    tileSize: 256
}).addTo(map);


L.marker([36.456974, 115.967184]).addTo(map)
    .bindPopup('聊城')
    .openPopup();

function displayBankBranches(data) {
    for (var i = 0; i < data.length; i++) {
        var marker = L.marker([data[i].latitude, data[i].longitude]).addTo(map);
        marker.bindPopup('<b>' + data[i].name + '</b><br />' + data[i].address);
        markers.push(marker);
    }
}


function updateBankBranch(results) {
    // 移除地图上所有标记
    for (var i = 0; i < markers.length; i++) {
        map.removeLayer(markers[i]);
    }
    markers = [];

    // 循环遍历每个银行分支机构对象
    $.each(results, function(key, val) {

        // 创建标记并添加到地图上
        var marker = L.marker([val.latitude, val.longitude]).addTo(map);

        // 在标记上绑定名称和地址信息
        marker.bindPopup("<b>" + val.name + "</b><br>" + val.address);

        // 将标记添加到全局变量markers数组中
        markers.push(marker);
    });
}
// 加载银行分支机构数据
$.getJSON("/api/bank-branches", function(data) {
    displayBankBranches(data);
});

// 点击搜索按钮时更新标记
$("#searchButton").click(function() {

    // 获取用户输入的搜索词、分页信息和排序方式
    var searchTerm = $("#searchInput").val();
    var pageIndex = 0;
    var pageSize = 10;
    var sortBy = $("#sortOptions").val();

    // 加载匹配搜索词的银行分支机构数据
    $.getJSON("/api/bank-branches", {searchTerm: searchTerm, pageIndex: pageIndex, pageSize: pageSize, sortBy: sortBy}, function(data) {
        updateBankBranch(data);
    });
});


var socket = new WebSocket('ws://localhost:8081/bankmap-websocket');
var stompClient = Stomp.over(socket);

stompClient.connect({}, function () {
    stompClient.subscribe('/topic/notifications', function (message) {
        fetch("/api/bank-branches")
            .then(function(response) {
                return response.json();
            })
            .then(function(data) {
                updateBankBranch(data);
            });
    });
});