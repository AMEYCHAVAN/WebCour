/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/*
 */
@WebServlet(name = "AddCO", urlPatterns = {"/AddCO"})
public class AddCO extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
        //======================================================
            
            int retxount=1;
            int count=1;

if(retxount!=0)
{
String nos1=request.getParameter("coid");
int no1=Integer.parseInt(nos1);

String nos2=request.getParameter("cocid");
int n1=Integer.parseInt(nos2);

String addto=request.getParameter("coto");
String addfrom=request.getParameter("cofrom");
String wt=request.getParameter("cowt");
String amt=request.getParameter("coamt");
String dat=request.getParameter("codate");
//cheack customer is present or not==============
//-----------
if(Pattern.matches("[0-9]+",nos2)==false|| nos2.length()>10 )
{//System.out.println("mm");
 JOptionPane.showMessageDialog(null,
                  "customer ID should be less than 10 digits) :-(",
                  "ERROR MANAGER (^_^)",
                  JOptionPane.ERROR_MESSAGE);
count =0;
}

if(addto.length()>50 )
{//System.out.println("mm");
    JOptionPane.showMessageDialog(null,
                  "addrss should be less than 50 characters:-(",
                  "ERROR MANAGER (^_^)",
                  JOptionPane.ERROR_MESSAGE);
          
count= 0;}


if(addfrom.length()>50 )
{//System.out.println("mm");
    JOptionPane.showMessageDialog(null,
                  "address should be less than 50 characters:-(",
                  "ERROR MANAGER (^_^)",
                  JOptionPane.ERROR_MESSAGE);
         
    
count= 0;}


if(Pattern.matches("[0-9]+",wt)==false|| wt.length()>4 )

{//System.out.println("mm");
    JOptionPane.showMessageDialog(null,
                  "weight should be less than 9999:-(",
                  "ERROR MANAGER (^_^)",
                  JOptionPane.ERROR_MESSAGE);
          
count= 0;}
if(Pattern.matches("[0-9]+",amt)==false|| amt.length()>5)

{//System.out.println("mm");
    JOptionPane.showMessageDialog(null,
                  "amount should be less than 5 99999:-(",
                  "ERROR MANAGER (^_^)",
                  JOptionPane.ERROR_MESSAGE);
          
count= 0;}
else{
count = 1;
}
//-----------------

    
int errflag=0;     
cousys.concourier.createconnection();
           
        ResultSet rs= cousys.concourier.getData("select * from dbcust where cid="+n1+"");
      try{
        
      while(rs.next())
      { errflag=1; }
       
          if(errflag==0)
          {// System.out.println("Not foound!!");
         
          JOptionPane.showMessageDialog(null,
                  "NO Customer Id Found :-(",
                  "ERROR MANAGER (^_^)",
                  JOptionPane.ERROR_MESSAGE);
           return;
          
          }
       
      }
      
      catch(Exception e)
      {
      }

//==================================



    if (count==1) {
        
    
String statem="insert into dbcou values("+no1+","+nos2+",'"+addto+"','"+addfrom+"','"+wt+"','"+amt+"','"+dat+"','BILLED')";
     
 cousys.concourier.execute(statem); 
 
 JOptionPane.showMessageDialog(null,
                  "Data successfully saved(",
                  "DATA MANAGER (^_^)",
                  JOptionPane.INFORMATION_MESSAGE); 
  
 
}


        //====================================================
}
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
