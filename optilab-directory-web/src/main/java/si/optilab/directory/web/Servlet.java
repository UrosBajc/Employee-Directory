package si.optilab.directory.web;

import com.google.gson.Gson;
import org.json.JSONObject;
import si.optilab.directory.ejb.beans.EmployeesServiceSBLocal;
import si.optilab.directory.entities.Employee;


import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by Uros on 1. 10. 2016.
 */
@WebServlet(name = "Servlet")
public class Servlet extends HttpServlet {

    private static final Logger LOGGER = Logger.getLogger(Servlet.class.getName());

    @EJB
    private EmployeesServiceSBLocal employeesServiceSB;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //process json
        StringBuffer jb = new StringBuffer();
        String line = null;
        try {
            BufferedReader reader = request.getReader();
            while ((line = reader.readLine()) != null)
                jb.append(line);
        } catch (Exception e) {
            LOGGER.warning(e.getMessage());
        }

        LOGGER.info(jb.toString());

        try {
            JSONObject jsObj = new JSONObject(jb.toString());
            HashMap<String, String> hm = new HashMap<>();
            if(jsObj.has("id")) {
                //id exists if we are updating info about existing user
                hm.put("id", Integer.toString(jsObj.getInt("id")));
            }
            hm.put("name", jsObj.getString("name"));
            hm.put("surname", jsObj.getString("surname"));
            hm.put("internalNumber", jsObj.getString("internalNumber"));
            hm.put("department", jsObj.getString("department"));
            employeesServiceSB.insertEmployee(hm);
        } catch (Exception e) {
            LOGGER.warning(e.getMessage());
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            if(request.getParameter("type").equals("getEmp")) {
                String id = request.getParameter("id");
                LOGGER.info("ID: " + id);
                Employee emp = employeesServiceSB.getEmployee(Integer.parseInt(id));
                String json = new Gson().toJson(emp);
                response.setContentType("application/json");
                response.getWriter().write(json);
            }
            else if(request.getParameter("type").equals("dep")) {
                String dep = request.getParameter("dep");
                List<Employee> employees = employeesServiceSB.getEmployeesByDepartment(dep);
                String json = new Gson().toJson(employees);
                response.setContentType("application/json");
                response.getWriter().write(json);
            }
            else if(request.getParameter("type").equals("delEmp")) {
                String id = request.getParameter("id");
                LOGGER.info("ID: " + id);
                employeesServiceSB.removeEmployee(Integer.parseInt(id));
            }
        }catch (Exception e){
            LOGGER.info("Error : " + e.getMessage());
        }

    }
}
