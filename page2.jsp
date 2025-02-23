<%-- 
    Document   : page2
    Created on : Feb 23, 2025, 7:36:10 AM
    Author     : smart
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css_page1.css" rel="stylesheet">
        <title>Found Your Exoplanet!</title>
    </head>
    <body>
    <center> <h1>Results</h1> </center>
        
        <form action="merge_final.html" method="GET">
            
        <center> <table> <tr>
        <td>
            <label for="name">Name: </label>
            <input type="text" id="name" name="name" value=<%=request.getParameter("name")%> readonly>
        </select>
        </td>
        <td>
        <label for="year">Discovery Year: </label>
            <input type="text" id="year" name="year" value=<%=request.getParameter("year")%> readonly>
        </td>
                </tr></table></center>
        <br><br>
                <center> <input type="submit" value="Visualize it!"> </center>
        </form>
        
        
    </body>
</html>
