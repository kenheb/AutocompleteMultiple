package se.kehe.autocomplete;
 
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import se.kehe.pojo.Customer;
 
 
public class AjaxRequest extends HttpServlet {
    
   	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    	/*
    	 * This information could be retrieved from a database!
    	 */
    	List<Customer> list = new ArrayList<Customer>();
    	list.add(new Customer("Erik Svanber", "Husbybacken 34", "456 12", "Huddik", "034-345843"));
    	list.add(new Customer("Lisa Nilsson", "Stenslingan 123", "921 23", "Enskede", "054-474545"));
    	list.add(new Customer("Lennart Gustavsson", "Kungsbacken 90", "234 67", "Farsta", "011-465734"));
    	list.add(new Customer("Elina Hagberg", "Olegs gata 56", "123 56", "Svedmyra", "077-465782"));
    	list.add(new Customer("Ludvig Valberg", "Getfotsbacken 7", "345 87", "Hagby", "055-761234"));
    	list.add(new Customer("Ernst Granberg", "Nordbacken 3", "222 34", "Boden", "066-876345"));
    	list.add(new Customer("Ester Olsson", "Hjulstagatan 56", "132 56", "Botkyrka", "088-465890"));
    	list.add(new Customer("Lotta Hansson", "Kistgatan 3", "145 12", "Stockholm", "077-846572"));
    	
    	PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        response.setHeader("Cache-control", "no-cache, no-store");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Expires", "-1");
        
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        
        String query = request.getParameter("term");
        query = query.toLowerCase();
        
        for(Customer c : list) {
            if(c.getName().toLowerCase().startsWith(query)) {
            	 jsonObject.put("name", c.getName());
                 jsonObject.put("address", c.getAddress());
                 jsonObject.put("zip", c.getZip());
                 jsonObject.put("municipality", c.getMunicipality());
                 jsonObject.put("phone", c.getPhone());
                 
                 jsonObject.put("value", c.getName());
                 jsonObject.put("label", c.getName());
                 
                 jsonArray.add(jsonObject.toString());
               }

        } 
     
        out.println(jsonArray.toString());
        out.close();
        
    }
        
 }
