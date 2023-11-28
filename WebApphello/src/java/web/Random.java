/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package web;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author Matheus Sinatora
 */
@WebServlet(name = "Random", urlPatterns = {"/random.html"})
public class Random extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        
        int n = 10;
        String msgErro = null;
       
        try {
            n = Integer.parseInt(request.getParameter("n"));
        } catch(Exception ex){
            msgErro = ("Parametos invalidos");
        }

        
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HelloServlet</title>");            
            out.println("</head>");
            out.println("<body style='background-color: #f2f2f2; font-family: \"Arial\";'>");
            out.println("<h4><a href='index.html'>Voltar</a></h4>");
            out.println("<h1>Java EE</h1>");
            out.println("<h2>Intro</h2>");
            out.println("<h2>Randomized Numbers</h2>");
            out.println("<form>");
            out.println("<input type='number' name='n' value='"+n+"'></input>");
            out.println("<input type='submit' value='Generate'>");
            out.println("</form>");
            out.println("<hr>");
            
            if(msgErro != null){
                out.println(msgErro);
            }
            else {
                out.println("<table border='1'>");
                out.println("<tr>");
                out.println("<th>Index</th><th>Number</th>");
                out.println("</tr>");

                for(int i = 1; i <= n; i++){
                    out.println("<tr>");
                    out.println("<th>" + i + "</th>");
                    int r = (int) (100*Math.random());
                    out.println("<th>" + r + "</th>");
                    out.println("</tr>");
                }  out.println("</table>");

                out.println("</body>");
                out.println("</html>");
            }
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
