<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <%@page import = "fcu.datavisualization.getdata.GetJson"%>
    <% 
    GetJson GetDay = new GetJson();
    int OntimeCount = 0;
    int LateCount = 0;
    int output = 3;
    output = GetDay.GetDate("2016-09-21 15:32:55");
    if(output == 1){
    	LateCount++;
    }
    else if(output == 0){
    	OntimeCount++;
    }
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawVisualization);


      function drawVisualization() {
        // Some raw data (not necessarily accurate)
        var LateCount = <%=LateCount%>;
        var OntimeCount = <%=OntimeCount%>;
        var data = google.visualization.arrayToDataTable([
         ['Month', '已交作業', '遲交作業', '未交作業'],
         ['09/20',  LateCount,      OntimeCount,          3],
         ['12/06',  35,      1,          5],
         ['12/20',  28,      2,         12],
         ['01/08',  38,      10,         2],
         ['01/12',  25,      3,         15]
      ]);

    var options = {
      title : '作業狀況',
      vAxis: {title: '人數'},
      hAxis: {title: '日期'},
      seriesType: 'bars',
      series: {5: {type: 'line'}}
    };

    var chart = new google.visualization.ComboChart(document.getElementById('chart_div'));
    chart.draw(data, options);
  }
    </script>
  </head>
  <body>
    <div id="chart_div" style="width: 900px; height: 500px;"></div>
  </body>
</html>