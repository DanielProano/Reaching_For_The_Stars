/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import jakarta.servlet.RequestDispatcher;
import java.sql.SQLException;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;

/**
 *
 * @author smart
 */
@WebServlet(urlPatterns = {"/DisplayServlet1"})

public class DisplayServlet1 extends HttpServlet {

        int counter = 0;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    //method to print the linked list implemented as a stack in a sorted order    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        
        
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) 
        {
           
            //storing the appended parameter values from the URL into variables
            //these values are the conditions for which the table needs to be searched
            String distance_from_earth = request.getParameter("distance_from_earth");
            String distance_from_star = request.getParameter("distance_from_star");
            String radius = request.getParameter("radius");
            String surface = request.getParameter("surface");
            String moon_num = request.getParameter("moon_num");
            String binary_star = request.getParameter("bin_star");
            String star_class = request.getParameter("star_class");
            String star_radius = request.getParameter("star_radius");
            
            
            int binStar = 0;
            switch (binary_star) {
                case "0":
                    binStar = 0;
                    break;
                case "1":
                    binStar = 1;
                    break;
            };
            
            
            int eDistMin, eDistMax;
            switch (distance_from_earth) {
                case "0-10":
                    eDistMin = 0;
                    eDistMax = 10;
                    break;
                case "10-50":
                    eDistMin = 10;
                    eDistMax = 50;
                    break;
                case "50-500":
                    eDistMin = 50;
                    eDistMax = 500;
                    break;
                case "500-2000":
                    eDistMin = 500;
                    eDistMax = 2000;
                    break;
                case "2000+":
                    eDistMin = 2000;
                    eDistMax = 100000;
                    break;
                default:
                    eDistMin = 0;
                    eDistMax = 100000;
                    break;
            }
            
            int minMoon, maxMoon;
            switch (moon_num) {
                case "0-1":
                    minMoon = 0;
                    maxMoon = 1;
                    break;
                case "2-10":
                    minMoon = 2;
                    maxMoon = 10;
                    break;
                case "11+":
                    minMoon = 11;
                    maxMoon = 100000;
                    break;
                default:
                    minMoon = 0;
                    maxMoon = 100000;
                    break;
            }
            
            int minRad, maxRad;
            switch (radius) {
                case "1-5":
                    minRad = 1;
                    maxRad = 5;
                    break;
                case "5-50":
                    minRad = 5;
                    maxRad = 50;
                    break;
                case "50+":
                    minRad = 50;
                    maxRad = 100000;
                    break;
                default:
                    minRad = 0;
                    maxRad = 100000;
                    break;
            }
            
            int sMinDist, sMaxDist;
            switch (distance_from_star) {
                case "0-1":
                    sMinDist = 0;
                    sMaxDist = 1;
                    break;
                case "1-5":
                    sMinDist = 1;
                    sMaxDist = 5;
                    break;
                case "5+":
                    sMinDist = 5;
                    sMaxDist = 100000;
                    break;
                default:
                    sMinDist = 0;
                    sMaxDist = 100000;
                    break;
            }
            
            int minStarRad, maxStarRad;
            switch (star_radius) {
                case "0-1":
                    minStarRad = 0;
                    maxStarRad = 1;
                    break;
                case "1-100":
                    minStarRad = 1;
                    maxStarRad = 100;
                    break;
                case "100-1000":
                    minStarRad = 100;
                    maxStarRad = 1000;
                    break;
                case "1000+":
                    minStarRad = 1000;
                    maxStarRad = 100000;
                    break;
                default:
                    minStarRad = 0;
                    maxStarRad = 100000;
                    break;
            }
            
            int minTemp, maxTemp;
            switch (star_class) {
                case "b":
                    minTemp = 33000;
                    maxTemp = 100000;
                    break;
                case "bw":
                    minTemp = 10000;
                    maxTemp = 33000;
                    break;
                case "w":
                    minTemp = 7500;
                    maxTemp = 10000;
                    break;
                case "yw":
                    minTemp = 6000;
                    maxTemp = 7500;
                    break;
                case "y":
                    minTemp = 5200;
                    maxTemp = 6000;
                    break;
                case "o":
                    minTemp = 3700;
                    maxTemp = 5200;
                    break;
                case "r":
                    minTemp = 2000;
                    maxTemp = 3700;
                    break;
                default:
                    minTemp = 2000;
                    maxTemp = 100000;
                    break;
            }
            
            System.out.println("Hello even before" + minTemp + maxRad);
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/planets?useSSL=false", "root", "boilermake2025!!");
           
            //the aforementioned values of the corresponding variables are present
            /* String sql = "select * from PlanetaryInfo where sy_mnum BETWEEN '"+minMoon+"' AND '"+maxMoon+"' "
                    + "AND cb_flag='"+binStar+"' AND pl_orbsmax BETWEEN '"+sMinDist+"' AND '"+sMaxDist+"' "
                    + "AND pl_rade BETWEEN '"+minRad+"' And '"+maxRad+"' "
                    + "AND st_teff BETWEEN '"+minTemp+"' AND '"+maxTemp+"' "
                    + "AND st_rad BETWEEN '"+minStarRad+"' AND '"+maxStarRad+"'"
                    + "AND sy_dist BETWEEN '"+eDistMin+"' AND '"+eDistMax+"'"; */
            /*String sql = "SELECT * FROM PlanetaryInfo WHERE sy_mnum BETWEEN ? AND ?"
                    + " AND cb_flag=? AND pl_orbsmax BETWEEN ? AND ?"
                    + " AND pl_rade BETWEEN ? AND ?"
                    + " AND st_teff BETWEEN ? AND ?"
                    + " AND st_rad BETWEEN ? AND ?"
                    + " AND sy_dist BETWEEN ? AND ? LIMIT 1;";
            
           
               
               
               ps.setInt(1,minMoon);
               ps.setInt(2,maxMoon);
               ps.setInt(3,binStar);
               ps.setFloat(4,sMinDist);
               ps.setFloat(5,sMaxDist);
               ps.setFloat(6,minRad);
               ps.setFloat(7,maxRad);
               ps.setInt(8,minTemp);
               ps.setInt(9,maxTemp);
               ps.setFloat(10,minStarRad);
               ps.setFloat(11,maxStarRad);
               ps.setFloat(12,eDistMin);
               ps.setFloat(13,eDistMax);*/
            
            String sql = "SELECT * FROM PlanetaryInfo LIMIT 1;";
            PreparedStatement ps=con.prepareStatement(sql);
            
            System.out.println(sql);
              ResultSet rs = ps.executeQuery();
              rs.next();
              
          System.out.println(rs);
            
            /*
            
            
            System.out.println ("Rs.next() is: "+ rs.next());
            
            while (rs.next())
            {
                System.out.println("Hello");
                counter = counter + 1;
               
               out.println("<tr><td>"+rs.getString("pl_name")+"</td><td>"+rs.getString("st_teff")+" K"
                    + "</td><td>"+rs.getString("sy_dist")+" pc</td><td>"+rs.getString("disc_year")+""
                    + "</td></tr>");
            }
                           
            out.println ("</table></body></html>");
          */
            String name = rs.getString("pl_name");
            int year = rs.getInt("disc_year");
            System.out.println(name + year);
            RequestDispatcher rd=request.getRequestDispatcher("page2.jsp?name='"+name+"'&year='"+year+"'");  
            rd.include(request,response); 
           
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.toString());
        }
                
    }
    
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
