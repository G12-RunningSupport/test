<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no">
    <meta charset="utf-8">
    <title>Directions service</title>
    <style>
      #map {
        height: 80%;
      }
      html, body {
        height: 100%;
        margin: 0;
        padding: 0;
      }
      #floating-panel {
        position: absolute;
        top: 10px;
        left: 25%;
        z-index: 5;
        background-color: #fff;
        padding: 5px;
        border: 1px solid #999;
        text-align: center;
        font-family: 'Roboto','sans-serif';
        line-height: 30px;
        padding-left: 10px;
      }
    </style>
  </head>
  <body>
    <div id="map"></div>
    <from method="route" action="calculateAndDisplayRoute(start, end)">
	    出発地:<input id="start" type="text" value="名古屋駅"/><br/>
	    到着地:<input id="end" type="text" value="春日井駅"/><br/> 
    	<!--input type="submit" value="検索" class="square_btn1" /><br/-->
    </from>
  	<form method="GET" action="/webapp/RouteUpdateServlet">
  		<div id="date"></div>
    	スタート時間:<input name="startTime" type="text" value="9:00" >　フィニッシュ時間:<input name="finishTime" type="text" value="13:00">　　入力例）17:00 ※半角英数字<br>
    	<div id=dis></div>
    	<input type="submit" value="確定" class="square_btn1">
    </form>
	<script>
  		var hiduke = new Date();
  		var year = hiduke.getFullYear();
  		var month = hiduke.getMonth()+1;
  		var day = hiduke.getDate();
  		document.getElementById("date").innerHTML ="日付:<input name=\"date\" type=\"text\" value=\""+year+"-"+month+"-"+day+"\" 　入力例）2018-1-11 ※半角英数字/>";
  	</script>
    
    <!-- p id=res></p -->
    <script>
      function initMap() {
        var directionsService = new google.maps.DirectionsService;
        var directionsDisplay = new google.maps.DirectionsRenderer;
        var map = new google.maps.Map(document.getElementById('map'), {
          zoom: 7,
          center: {lat: 85, lng: 135}
        });
        directionsDisplay.setMap(map);

        var onChangeHandler = function() {
          calculateAndDisplayRoute(directionsService, directionsDisplay);
        };
        document.getElementById('start').addEventListener('change', onChangeHandler);
        document.getElementById('end').addEventListener('change', onChangeHandler);
      }

      function calculateAndDisplayRoute(directionsService, directionsDisplay) {
        directionsService.route({
          origin: document.getElementById('start').value,
          destination: document.getElementById('end').value,
          travelMode: 'WALKING'
        }, function(response, status) {
          if (status === 'OK') {
            directionsDisplay.setDirections(response);
        	/*document.getElementById("res").innerHTML = JSON.stringify(response.routes[0].legs[0]);*/
        	document.getElementById("dis").innerHTML = "総距離＝<input name=\"distance\" type=\"text\" value=\""+response.routes[0].legs[0].distance.text+"\" readonly/>";
          } else {
            window.alert('Directions request failed due to ' + status);
          }
        });
      }
    </script>
	<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBsBOA04JHFBv-rvZukhm3ZCajNCpCOeL4&callback=initMap" async defer></script>
	</body>
</html>