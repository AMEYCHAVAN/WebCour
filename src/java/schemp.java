
import java.sql.ResultSet;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**

 */
@WebServlet(name = "schemp", urlPatterns = {"/schemp"})
public class schemp extends HttpServlet {

   
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
           //===========================================================
            
           String nos=request.getParameter("eid");
 
 
 
if(Pattern.matches("[0-9]+",nos)==false|| nos.length()>5 )
{//System.out.println("mm");
JOptionPane.showMessageDialog(null,
                  "Please check your id again :-(",
                  "ERROR MANAGER (^_^)",
                  JOptionPane.ERROR_MESSAGE);
    return;}


 int no1=Integer.parseInt(nos);

int errflag=0;     
cousys.concourier.createconnection();
           
 ResultSet rs= cousys.concourier.getData("select * from dbemp where eid="+no1+"");
    
       try{   
      while(rs.next())
      {errflag=1;
      //  int t= Integer.parseInt(rs.getString(1))+1;
         // jTextField2.setText(rs.getString(2));
        //  jTextArea1.setText(rs.getString(3));
        //  jTextField4.setText(rs.getString(4));
                  
    
           
      
             
        
       out.println("<h1>Id     " +nos + "</h1>");
      out.println("<h1>Name    " + rs.getString(2) + "</h1>");
      out.println("<h1>Phone   " + rs.getString(3) + "</h1>");
      out.println("<h1>Address " + rs.getString(4) + "</h1>");
       
             
             
             
             
             
             
      }
       if(errflag==0)
          { //System.out.println("Not foound!!");
           JOptionPane.showMessageDialog(null,
                  "NO Id Found :-(",
                  "ERROR MANAGER (^_^)",
                  JOptionPane.ERROR_MESSAGE);
          
          
          }
       }
       catch(Exception e)
       {}
            
      //============================================================
          
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