/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.student;

import dal.SessionDBContext;
import dal.TimeslotDBContext;
import entity.Session;
import entity.Timeslot;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.DateTimeHelper;

/**
 *
 * @author User
 */
public class TimetableController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException, SQLException, ParseException {
        int instructorid = Integer.parseInt(request.getParameter("id"));
        String r_from = request.getParameter("from");
        String r_to = request.getParameter("to");
        ArrayList<Date> dates = new ArrayList<>();
        
        if(r_from == null)//this week
        {
            dates = DateTimeHelper.getCurrentWeekDates();
        }
        else
        {
            try {
                dates = DateTimeHelper.getSqlDatesInRange(r_from, r_to);
            } catch (ParseException ex) {
                Logger.getLogger(TimetableController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
         TimeslotDBContext timeDB = new TimeslotDBContext();
         ArrayList<Timeslot> slots = timeDB.list();
         
         SessionDBContext sessDB = new SessionDBContext();
        ArrayList<Session> sessions = sessDB.getSessions(instructorid, dates.get(0), dates.get(dates.size()-1));
         request.setAttribute("slots", slots);
         request.setAttribute("dates", dates);
         request.setAttribute("from", dates.get(0));
         request.setAttribute("to", dates.get(dates.size()-1));
         request.setAttribute("sessions", sessions);
         
         
         request.getRequestDispatcher("view/instructor/timetable.jsp").forward(request, response);
        
        
    } 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException | ParseException ex) {
            Logger.getLogger(TimetableController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request,response);
        } catch (SQLException | ParseException ex) {
            Logger.getLogger(TimetableController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
