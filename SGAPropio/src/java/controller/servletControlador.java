/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import model.Alumno;
import model.Asignatura;
import model.Grupo;
import model.ManejoUsuarios;

@WebServlet(name = "servletControlador", urlPatterns = {"/controller/servletControlador"})
public class servletControlador extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException{  
        HttpSession session = req.getSession(true);
        session.setMaxInactiveInterval(-1);
        //Recogemos la acción a realizar
        String accion = req.getParameter("accion");
        switch(accion){
            case "login":
                ManejoUsuarios mu = new ManejoUsuarios();
                if(loginUsuario(req, resp, mu)){
                    req.setAttribute("login", "login");
                    if(mu.tipoUser(req.getParameter("username")).equalsIgnoreCase("Alumno")){
                        session.setAttribute("userobj",mu.setAlumno(req.getParameter("username")));
                    }else if(mu.tipoUser(req.getParameter("username")).equalsIgnoreCase("Profesor")){
                        session.setAttribute("userobj",mu.setProfesor(req.getParameter("username")));
                    }
                    session.setAttribute("login", req.getParameter("username"));
                    session.setAttribute("tipo", mu.tipoUser(req.getParameter("username")));
                    //req.getRequestDispatcher("/WEB-INF/welcome.jsp").forward(req, resp);
                    req.getRequestDispatcher("/WEB-INF/news.jsp").forward(req, resp);
                }else{
                    session.invalidate();
                    req.setAttribute("mensaje", "El usuario o contraseña especificados " + 
                            "no existen en nuestros registros");
                    req.getRequestDispatcher("/index.jsp").forward(req, resp);
                }
            break;
            case "logout":
                session.invalidate();
                resp.sendRedirect(req.getContextPath() + "/index.jsp");
            break;
            case "userinfo":
                if(session != null){
                    req.getRequestDispatcher("/WEB-INF/profile.jsp").forward(req, resp);
                }else{
                    //req.getRequestDispatcher("/WEB-INF/welcome.jsp").forward(req, resp);
                    req.getRequestDispatcher("/WEB-INF/news.jsp").forward(req, resp);
                }
            break;
            case "inicio":
                req.getRequestDispatcher("/WEB-INF/news.jsp").forward(req, resp);
            break;
        }   
    }
    
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException{
        HttpSession session = req.getSession(false);
        if(session != null){
            ManejoUsuarios mu = new ManejoUsuarios();
            String accion = req.getParameter("accion");
            switch(accion){
                case "grupo":
                    Grupo gr = mu.returnGrupo((Alumno) session.getAttribute("userobj"));
                    if(gr != null){
                        session.setAttribute("grupoobj", gr);
                        ArrayList <Asignatura> arrAsignatura = null;
                        arrAsignatura = mu.returnAsignaturas(gr.getId_grupo());
                        if(arrAsignatura != null){
                            session.setAttribute("arrAsignaturas", arrAsignatura);
                            req.getRequestDispatcher("/WEB-INF/clases.jsp").forward(req, resp);
                        }
                    }else{
                        req.getRequestDispatcher("/WEB-INF/news.jsp").forward(req, resp);
                    }
                    break;
                case "tutor":
                    req.getRequestDispatcher("/WEB-INF/tutor.jsp").forward(req, resp);
                    break;
                case "asignatura":
                    req.getRequestDispatcher("/WEB-INF/asignaturas.jsp").forward(req, resp);
                    break;
            }
        }
    }
    
    private static boolean loginUsuario(HttpServletRequest req, HttpServletResponse resp, ManejoUsuarios mu)
            throws IOException, ServletException{
        if(mu.loginUser(req.getParameter("username"), req.getParameter("password")) == true){
            return true;
        }else{
            return false;
        }
    }
    
    
}
