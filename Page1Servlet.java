/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.databind.ObjectMapper; // For JSON
import java.net.URLEncoder; // For URL encodin

/**
 *
 * @author smart
 */
@WebServlet(urlPatterns = {"/page1_servlet"})
public class Page1Servlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/javascript");
        try (PrintWriter out = response.getWriter()) {
            String distance_from_earth = request.getParameter("d_f_e");
            String distance_from_star = request.getParameter("dfs");
            String radius = request.getParameter("rad");
            String surface = request.getParameter("surf");
            String moon_num = request.getParameter("mnum");
            String binary_star = request.getParameter("bs");
            String star_class = request.getParameter("sc");
            String star_radius = request.getParameter("sr");
            
            
            int binStar = 0; // Default value
            if (binary_star != null) { // Check for null
                try { // Handle potential NumberFormatException
                    binStar = Integer.parseInt(binary_star); // Parse to int
                } catch (NumberFormatException e) {
                    // Log the error or handle it as needed.  For now, use the default.
                    System.err.println("Invalid binaryStar value: " + binary_star);
                }
            }
            
            System.out.println("Hello");
            /*
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
            }*/
            /*
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
                   */ 
        
            PlanetSearchQuery query = new PlanetSearchQuery();
            query.setDistanceFromEarth(distance_from_earth);
            query.setDistanceFromStar(distance_from_star);
            query.setRadius(radius);
            query.setSurface(surface);
            query.setMoonNum(moon_num);
            query.setBinaryStar(binStar);
            query.setStarClass(star_class);
            query.setStarRadius(star_radius);
        
        
        
            
            
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonData = objectMapper.writeValueAsString(query);
            
            String javascript = """
                async function fetchExoplanets() {
                    try {
                        const searchCriteria = JSON.parse('%s'); // Parse the JSON

                        let url = `https://exoplanetarchive.ipac.caltech.edu/TAP/sync?query=select+pl_name,hd_name,sy_snum,sy_pnum,sy_mnum,cb_flag,disc_year,pl_orbper,pl_orbsmax,pl_rade,pl_masse,pl_dens,pl_orbeccen,pl_eqt,pl_orbincl,st_spectype,st_teff,st_rad,st_mass,st_lum,st_logg,st_age,st_dens,st_vsin,sy_dist+from+pscomppars+where+`;

                        // Construct the WHERE clause dynamically based on searchCriteria
                        let whereClause = [];

                        if (searchCriteria.distanceFromEarth) {
                          const [min, max] = searchCriteria.distanceFromEarth.split(" - ").map(Number);
                            whereClause.push(`sy_dist BETWEEN ${min} AND ${max}`);
                        }
                        if (searchCriteria.distanceFromStar) {
                            const [min, max] = searchCriteria.distanceFromStar.split(" - ").map(Number);
                            whereClause.push(`pl_orbsmax BETWEEN ${min} AND ${max}`);
                        }
                        if (searchCriteria.radius) {
                            const [min, max] = searchCriteria.radius.split(" - ").map(Number);
                            whereClause.push(`pl_rade BETWEEN ${min} AND ${max}`);
                        }
                        // Add other criteria similarly...

                        if (searchCriteria.moonNum) {
                            const [min, max] = searchCriteria.moonNum.includes("+")
                                ? [Number(searchCriteria.moonNum.replace("+", "")), Infinity]
                                : searchCriteria.moonNum.split(" - ").map(Number);
                            whereClause.push(`sy_mnum BETWEEN ${min} AND ${max}`);
                        }

                        if (searchCriteria.binaryStar !== null) {
                            whereClause.push(`cb_flag = ${searchCriteria.binaryStar}`);
                        }
                        if (searchCriteria.starClass) {
                            whereClause.push(`st_spectype = '${searchCriteria.starClass}'`);
                        }
                        if (searchCriteria.starRadius) {
                            const [min, max] = searchCriteria.starRadius.split(" - ").map(Number);
                            whereClause.push(`st_rad BETWEEN ${min} AND ${max}`);
                        }


                        if (whereClause.length > 0) {
                            url += whereClause.join(" AND ");
                        }

                        url += "&format=json";

                        const response = await fetch(url);
                        if (!response.ok) {
                            console.error(`HTTP Error: ${response.status}`);
                            return;
                        }

                        const data = await response.json();
                        // ... process and display the data ...
                        console.log(data); // Example: log the data to the console

                    } catch (error) {
                        console.error(error);
                    }
                }

                fetchExoplanets();
            """.formatted(jsonData);

        out.println(javascript);
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

class PlanetSearchQuery {
    private String distanceFromEarth;
    private String distanceFromStar;
    private String radius;
    private String surface;
    private String moonNum;
    private Integer binaryStar;
    private String starClass;
    private String starRadius;

    // Getters and setters for all properties
    public String getDistanceFromEarth() { return distanceFromEarth; }
    public void setDistanceFromEarth(String distanceFromEarth) { this.distanceFromEarth = distanceFromEarth; }
    public String getDistanceFromStar() { return distanceFromStar; }
    public void setDistanceFromStar(String distanceFromStar) { this.distanceFromStar = distanceFromStar; }
    public String getRadius() { return radius; }
    public void setRadius(String radius) { this.radius = radius; }
    public String getSurface() { return surface; }
    public void setSurface(String surface) { this.surface = surface; }
    public String getMoonNum() { return moonNum; }
    public void setMoonNum(String moonNum) { this.moonNum = moonNum; }
    public Integer getBinaryStar() { return binaryStar; }
    public void setBinaryStar(Integer binaryStar) { this.binaryStar = binaryStar; }
    public String getStarClass() { return starClass; }
    public void setStarClass(String starClass) { this.starClass = starClass; }
    public String getStarRadius() { return starRadius; }
    public void setStarRadius(String starRadius) { this.starRadius = starRadius; }
}