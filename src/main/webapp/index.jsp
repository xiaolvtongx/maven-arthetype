<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>聊城市银行分布地图</title>
    <link rel="stylesheet" href="https://unpkg.com/leaflet@1.7.1/dist/leaflet.css"/>
    <style>
        #map {
            position: absolute;
            top: 60px;
            bottom: 0;
            width: 100%;
        }

        #searchInput,
        #searchButton,
        #sortOptions {
            display: inline-block;
            margin: 10px;
        }
    </style>
</head>
<body>
<div style="height: 60px;">
    <label for="searchInput"></label><input id="searchInput" type="text" placeholder="输入银行名称">
    <button id="searchButton">搜索</button>
    <label for="sortOptions"></label><select id="sortOptions">
    <option value="name">名称</option>
    <option value="address">地址</option>
    <option value="distance">距离</option>
</select>
</div>
<div id="map"></div>
<script src="https://unpkg.com/leaflet@1.7.1/dist/leaflet.js"></script>
<script src="js/jquery-3.6.4.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.5.1/sockjs.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>
<script src="map.js"></script>

</body>
</html>
