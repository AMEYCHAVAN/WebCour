
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

/*

 */
@WebServlet(name = "chkstat", urlPatterns = {"/chkstat"})
public class chkstat extends HttpServlet {

   
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
           //===========================================================
            
           String nos=request.getParameter("coid");
            String sub1name=request.getParameter("s1");
                        String sub2name=request.getParameter("s2");

 if(sub1name!=null )
 { 
 
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
           
 ResultSet rs= cousys.concourier.getData("select * from dbcou where coid="+no1+"");
    
       try{   
      while(rs.next())
      {errflag=1;
   
            
      out.println("<h1>Courier Id     " +nos + "</h1>");
      out.println("<h1>Cusromer id    " + rs.getString(2) + "</h1>");
      out.println("<h1>to    " + rs.getString(3) + "</h1>");
      out.println("<h1>from   " + rs.getString(4) + "</h1>");
      out.println("<h1>wt " + rs.getString(5) + "</h1>");
      out.println("<h1>amt   " + rs.getString(6) + "</h1>");
      out.println("<h1>date " + rs.getString(7) + "</h1>");  
      out.println("<h1>status " + rs.getString(8) + "</h1>");  
             
             
             
             
             
             
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
 }    //++    
 
 if(sub2name!=null)
 {
     
     int no1=Integer.parseInt(nos);
 
String comboo=request.getParameter("menu");
// out.print(""+comboo);
String statem="update dbcou set costatus = '"+comboo+"' where coid ="+no1;
 cousys.concourier.execute(statem); 
out.print("Saved Sucessfully");

 
        
        
       // out.println("http://localhost:8084/WebCour/index.jsp");

 }
 
 
 
 
 
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