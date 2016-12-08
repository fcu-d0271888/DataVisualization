<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% int a = 20; %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawChart);
      function drawChart() {
	var b = <%=a%>;
        var data = google.visualization.arrayToDataTable([
          ['時間', '人數'],
          ['10',  b],
          ['20',  0],
          ['30',  1],
          ['40',  0],
	  	  ['50',  0],
          ['60',  2],
          ['70',  0],
          ['80',  0],
	 	  ['90',  2],
	      ['100', 1]
        ]);

        var options = {
          title: '成績分布圖',
          hAxis: {title: '分數',  titleTextStyle: {color: '#333'}},
          vAxis: {minValue: 0}
        };

        var chart = new google.visualization.AreaChart(document.getElementById('chart_div'));
        chart.draw(data, options);
      }
    </script>
  </head>
  <body>
    <div id="chart_div" style="width: 100%; height: 500px;"></div>
  </body>
</html>