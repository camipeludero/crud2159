package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Alumnos;
import model.AlumnosDAO;

/**
 *
 * @author camip
 */
@WebServlet(name = "AlumnosController", urlPatterns = {"/AlumnosController"})
public class AlumnosController extends HttpServlet {

     @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AlumnosDAO alumnosDao = new AlumnosDAO();
        String accion;
        RequestDispatcher dispatcher = null;
        accion = req.getParameter("accion");
        
        if(accion == null || accion.isEmpty()){
            
            dispatcher = req.getRequestDispatcher("views/alumnos.jsp");
            
        } else if(accion.equals("nuevo")){
            
            dispatcher = req.getRequestDispatcher("views/nuevo.jsp");
            
        } else if(accion.equals("modificar")){
            
            dispatcher = req.getRequestDispatcher("views/modificar.jsp");
            
        } else if(accion.equals("actualizar")){
            
            int id = Integer.parseInt(req.getParameter("id"));
            String nombre = req.getParameter("nombre");
            String apellido = req.getParameter("apellido");
            String mail = req.getParameter("mail");
            
            Alumnos alumno = new Alumnos(id, nombre, apellido, mail);
            alumnosDao.actualizarAlumno(alumno);
            //insertar alerta de actualizado
            dispatcher = req.getRequestDispatcher("views/alumnos.jsp");
            
        } else if(accion.equals("eliminar")){
            
            int id = Integer.parseInt(req.getParameter("id"));
            alumnosDao.eliminarAlumno(id);
            //insertar alerta de eliminado
            dispatcher = req.getRequestDispatcher("views/alumnos.jsp");
            
        } else if(accion.equals("insertar")){
            
            String nombre = req.getParameter("nombre");
            String apellido = req.getParameter("apellido");
            String mail = req.getParameter("mail");
            Alumnos alumno = new Alumnos(0, nombre, apellido, mail);
            alumnosDao.insertarAlumno(alumno);
            //insertar alerta de insertado
            dispatcher = req.getRequestDispatcher("views/alumnos.jsp");
            
        }
        
        dispatcher.forward(req, resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    public String getServletInfo() {
        return super.getServletInfo(); //To change body of generated methods, choose Tools | Templates.
    }

   

}
