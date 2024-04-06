package in.co.rays.test;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.dto.EmployeeDTO;
import in.co.rays.model.EmployeeModel;
@WebServlet("/EmployeeListCtl")
public class EmployeeListCtl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pageNo=1;
		int pageSize=10;
		String op=request.getParameter("operation");
		EmployeeDTO	dto=null;
		EmployeeModel model=new EmployeeModel();
		List list=model.search(dto,0,0);
		
		RequestDispatcher rd=request.getRequestDispatcher("EmployeeListView.jsp");
		request.setAttribute("List", list);
		rd.forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  	
		System.out.println("in do post method");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		int pageNo = 1;
		int pageSize = 10;
		String op = request.getParameter("operation");
		System.out.println("op= " + op);
		System.out.println("name" + request.getParameter("name"));
		EmployeeDTO dto = new EmployeeDTO();
		EmployeeModel model = new EmployeeModel();
		System.out.println("yash..");

		if (op.equals("search")) {
			System.out.println("yessss");
			dto.setName(request.getParameter("name"));
		}
		if (op.equalsIgnoreCase("delete")) {
			System.out.println("pahuch gya hu");
			String[] ids = request.getParameterValues("ids");
			for (String id : ids) {
				EmployeeDTO dto1 = new EmployeeDTO();
				dto1.setId(Integer.parseInt(id));
				model.delete(dto1);
			}

		}

		List list = model.search(dto, 0, 0);
		System.out.println("yes222.");
		request.setAttribute("List", list);
		RequestDispatcher rd = request.getRequestDispatcher("EmployeeListView.jsp");
		rd.forward(request, response);

	}
		
	}

