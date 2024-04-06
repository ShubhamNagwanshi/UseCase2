import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.dto.EmployeeDTO;
import in.co.rays.model.EmployeeModel;
@WebServlet("/EmployeeCtl")
public class EmployeeCtl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		EmployeeDTO dto = null;
		EmployeeModel model = new EmployeeModel();
		
		String id = request.getParameter("id");
		
		if(id != null) {
			dto = model.findByPk(Integer.parseInt(id));
			request.setAttribute("dto", dto);
		}
		RequestDispatcher rd = request.getRequestDispatcher("EmployeeView.jsp");
		rd.forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		EmployeeModel model = new EmployeeModel();
		
		String id = request.getParameter("id");
		
		EmployeeDTO dto = new EmployeeDTO();
		
		dto.setName(request.getParameter("name"));
		
		try {
			dto.setDob(sdf.parse(request.getParameter("dob")));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		dto.setAddress(request.getParameter("address"));
		dto.setSalary(request.getParameter("salary"));
		dto.setCompany(request.getParameter("company"));
		
		String op = request.getParameter("operation");
	
		if(op.equalsIgnoreCase("update")) {
			dto.setId(Integer.parseInt("id"));
			
			request.setAttribute("msg", "Employee Updated Successfully");
			request.setAttribute("dto", dto);
			
			System.out.println("update method");
			RequestDispatcher rd = request.getRequestDispatcher("EmployeeView.jsp");
			rd.forward(request, response);
			
		} else if (op.equalsIgnoreCase("save")) {
			model.add(dto);
			request.setAttribute("msg", "Employee Added");
			
			RequestDispatcher rd = request.getRequestDispatcher("EmployeeView.jsp");
			rd.forward(request, response);
		}else if (op.equalsIgnoreCase("AddEmploye")) {
			response.sendRedirect("EmployeeView.jsp");

		} else if (op.equalsIgnoreCase("cancel")) {
			response.sendRedirect("EmployeeListCtl");

		}
	
	}
}
