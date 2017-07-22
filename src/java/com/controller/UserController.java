/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UsuarioDao;
import com.model.Usuario;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;

/**
 *
 * @author Java-Sab
 */
public class UserController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/user.jsp";
    private static String LIST_USER = "/listUser.jsp";
    private static String INSERT = "/addUser.jsp";
    private UsuarioDao dao;

    public UserController() {
        super();
        dao = new UsuarioDao();
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config); //To change body of generated methods, choose Tools | Templates.
        ServletContext context = config.getServletContext();
        context.setAttribute("departamentos", dao.getAllDepartamentos());
        context.setAttribute("provincias", dao.getAllProvincias());
        context.setAttribute("distritos", dao.getAllDistritos());
    }
    
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UserController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UserController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        //processRequest(request, response);
        String forward="";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")){
            int userId = Integer.parseInt(request.getParameter("userId"));
            dao.deleteUser(userId);
            forward = LIST_USER;
            request.setAttribute("users", dao.getAllUsers());    
        } else if (action.equalsIgnoreCase("edit")){
            forward = INSERT_OR_EDIT;
            int userId = Integer.parseInt(request.getParameter("userId"));
            Usuario user = dao.getUserById(userId);
            request.setAttribute("user", user);
        } else if (action.equalsIgnoreCase("listUser")){
            forward = LIST_USER;
            request.setAttribute("users", dao.getAllUsers());
            System.out.println("PASOOOOO**********************ALL USERS");
        } else {
            forward = INSERT;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        System.out.println("PASO***********************PRE FORWARD LIST USER");
        view.forward(request, response);
        System.out.println("PASO***********************POST FORWARD LIST USER");
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
        //processRequest(request, response);
        Usuario user = new Usuario();
        user.setNombres(request.getParameter("firstName"));
        user.setApellidos(request.getParameter("lastName"));
        try {
            Date dob = new SimpleDateFormat("MM/dd/yyyy").parse(request.getParameter("dob"));
            user.setFecNac(dob);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        user.setEmail(request.getParameter("email"));
        user.setCodigoDep(Integer.parseInt(request.getParameter("codigoDep")));
        
        String codigoProv[] = request.getParameter("codigoProv").split("[#]");
        user.setCodigoProv(Integer.parseInt(codigoProv[0]));
        
        String codigoDis[] = request.getParameter("codigoDis").split("[#]");
        user.setCodigoDis(Integer.parseInt(codigoDis[0]));
        
        String userid = request.getParameter("userid");
        if(userid == null || userid.isEmpty())
        {
            dao.addUser(user);
        }
        else
        {
            user.setCodigo(Integer.parseInt(userid));
            System.out.println("EDICION******************");            
            System.out.println(user+"******************");
            dao.updateUser(user);
        }
        RequestDispatcher view = request.getRequestDispatcher(LIST_USER);
        request.setAttribute("users", dao.getAllUsers());
        view.forward(request, response);
        
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
