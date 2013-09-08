/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

 
@WebServlet(name = "Addemployee", urlPatterns = {"/Addemployee"})
public class Addemployee extends HttpServlet {

        protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
          
      //==================================      
            
cousys.concourier.createconnection();



String nos=request.getParameter("eid");
String name=request.getParameter("ename");
String add=request.getParameter("eadd");
String pho=request.getParameter("epho");



int no1=Integer.parseInt(nos);

 


if(Pattern.matches("[a-zA-Z]+",name)==false || name.length()>20 )
{//System.out.println("hahaha");
 JOptionPane.showMessageDialog(null,
                  "Please enter name properly :-(",
                  "ERROR MANAGER (^_^)",
                  JOptionPane.ERROR_MESSAGE);
return;}


if(Pattern.matches("[0-9]+",pho)==false|| pho.length()>13 )
{//System.out.println("mm");
 JOptionPane.showMessageDialog(null,
                  "please enter phone  number properly(13) :-(",
                  "ERROR MANAGER (^_^)",
                  JOptionPane.ERROR_MESSAGE);

return;}




String statem="insert into dbemp values("+no1+",'"+name+"','"+add+"','"+pho+"')";
        
        
 cousys.concourier.execute(statem); 
 
 JOptionPane.showMessageDialog(null,
                  "Data successfully saved(",
                  "DATA MANAGER (^_^)",
                  JOptionPane.INFORMATION_MESSAGE); 
         
     
     //=======================================================================       
        } finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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
