<%-- 
    Document   : page1
    Created on : Feb 22, 2025, 2:24:07 PM
    Author     : smart
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css_page1.css" rel="stylesheet">
        <title>Reaching For The Stars</title>
    </head>
    <body>
        
        <h1><center> Reaching For The Stars</center></h1>
        
        <form action="DisplayServlet1" method="GET">
            
            <h3> <center> Search for a Planet! </center> </h3>
                <legend></legend>
                
        <br> <br>
        <center> <table> <tr>
        <td>
        <select name="distance_from_earth" id="d_f_e"> 
            <option name="-1" value="-1" disabled selected> Distance from Earth (pc)</option>
            <option name="0-10" value="0-10"> 0 - 10 </option>
            <option name="10-50" value="10-50"> 10 - 50 </option>
            <option name="50-500" value="50-500"> 50 - 500 </option>
            <option name="500-2000" value="500-2000"> 500 - 2000 </option>
            <option name="2000+" value="2000+"> 2000+ </option>
        </select>
        </td>
        <td>
        <select name="distance_from_star" id="dfs"> 
            <option name="-1" value="-1" disabled selected> Distance from Star (AU)</option>
            <option name="0-1" value="0-1"> 0 - 1 </option>
            <option name="1-5" value="1-5"> 1 - 5 </option>
            <option name="5+" value="5+"> 5+ </option>
        </select>
        </td>
        <td>
        <select name="radius" id="rad"> 
            <option name="-1" value="-1" disabled selected> Radius (in terms of Earth) </option>
            <option name="1-5" value="1-5"> 1 - 5 </option>
            <option name="5-50" value="5-50"> 5 - 50 </option>
            <option name="50+" value="50+"> 50+ </option>
        </select>
        </td>
               
        <td>
        <select name="surface" id="surf"> 
            <option name="-1" value="-1" disabled selected> Surface </option>
            <option name="rocky" value="rocky"> Rocky </option>
            <option name="gas" value="gas"> Gaseous </option>
            <option name="water" value="water"> Water </option>
            <option name="earth-like" value="earth-like"> Earth-like </option>
        </select>
        </td>
         </tr>
                <tr>
        <td>
        <select name="moon_num" id="mnum">
            <option name="-1" value="-1"> Number of Moons </option>
            <option name="0-1" value="0-1"> 0 - 1 </option>
            <option name="2-10" value="2-10"> 2 - 10 </option>
            <option name="11+" value="11+"> 11+ </option>

        </select>
        </td>
        <td>
        <select name="bin_star" id="bs"> 
            <option name="-1" value="-1" disabled selected> Binary Star </option>
            <option name="0" value="0"> 0 </option>
            <option name="1" value="1"> 1 </option>
        </select>
        </td>
        <td>
        <select name="star_class" id="sc"> 
            <option name="-1" value="-1" disabled selected> Star Class </option>
            <option name="b" value="bv"> Blue </option>
            <option name="bw" value="bw"> Blue-white </option>
            <option name="w" value="w"> White </option>
            <option name="yw" value="yw"> Yellow-white </option>
            <option name="y" value="y"> Yellow </option>
            <option name="o" value="o"> Orange </option>
            <option name="r" value="r"> Red </option>
        </select>
        </td> 
        <td>
        <select name="star_radius" id="sr"> 
            <option name="-1" value="-1" disabled selected> Star Radius (in terms of Sun) </option>
            <option name="0-1" value="0-1" > 0 - 1 </option>
            <option name="1-100" value="1-100" > 1 - 100 </option>
            <option name="100-1000" value="100-1000" > 100 - 1000 </option>
            <option name="1000+" value="1000+" > 1000+ </option>
        </select>
        </td>
                </tr> </table> </center> <br> <br>
                <center> <input type="submit" value="Find me a planet!"> </center>
        </form>
    </body>
</html>
