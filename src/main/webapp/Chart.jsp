<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <%@page import = "fcu.datavisualization.getdata.GetJson,fcu.datavisualization.getdata.RSData,java.util.ArrayList"%>
    <% 
    GetJson GetJson = new GetJson();
    
    int LateCount[] = new int[6];
    int OntimeCount[] = new int [6];
    int NotCount[] = new int [6];
    
    ArrayList<String> list = new ArrayList<String>();
    
     RSData rsdata = new RSData();
    
    for(int i = 1; i <= 6; i++){
    	System.out.println("HW" + i);
    	rsdata = GetJson.GetDate(i);
    	LateCount[i-1] = rsdata.getLateCount();
        OntimeCount[i-1] = rsdata.getOntimeCount();
        NotCount[i-1] = rsdata.getNotCount();
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
        var LateCount = new Array();
        var OntimeCount = new Array();
        var NotCount = new Array();
        <%for(int i = 0; i < 6; i++){%>
        	LateCount[<%= i %>] = <%=LateCount[i]%>;
        	OntimeCount[<%= i %>] = <%=OntimeCount[i]%>;
        	NotCount[<%= i %>] = <%=NotCount[i]%>;
        <%}%>
        
        var data = google.visualization.arrayToDataTable([
         ['Month', '已交作業', '遲交作業', '未交作業'],
         ['09/27',  OntimeCount[0],LateCount[0],NotCount[0]],
         ['10/14',  OntimeCount[1],LateCount[1],NotCount[1]],
         ['11/11',  OntimeCount[2],LateCount[2],NotCount[2]],
         ['11/25',  OntimeCount[3],LateCount[3],NotCount[3]],
         ['12/05',  OntimeCount[4],LateCount[4],NotCount[4]],
         ['12/20',  OntimeCount[5],LateCount[5],NotCount[5]]
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