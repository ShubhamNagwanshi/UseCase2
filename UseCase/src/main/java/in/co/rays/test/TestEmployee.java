package in.co.rays.test;

import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

import in.co.rays.dto.EmployeeDTO;
import in.co.rays.model.EmployeeModel;

public class TestEmployee {

	public static void main(String[] args) throws Exception {
//		testAdd();
//		testUpdate();
//		testDelete();
//		testFindByPk();
		testSearch();
	}

	private static void testSearch() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		EmployeeDTO dto = new EmployeeDTO();
//		dto.setName("Shubham");
		dto.setDob(sdf.parse("2022-03-10"));
		EmployeeModel model = new EmployeeModel();
		 List  list= model.search(dto, 0, 0);
		 Iterator it=list.iterator();
		 while (it.hasNext()) {
			dto =  (EmployeeDTO) it.next();
			
			System.out.println(dto.getName());
			System.out.println(dto.getDob());
			System.out.println(dto.getCompany());
			System.out.println(dto.getAddress());
			System.out.println(dto.getSalary());
			
			
		 }
	}

	private static void testFindByPk() throws Exception {
		
	
		
		EmployeeModel model = new EmployeeModel();
		EmployeeDTO dto = model.findByPk(1);
		
		System.out.println(dto.getName());
		System.out.println(dto.getDob());
		System.out.println(dto.getCompany());
		System.out.println(dto.getAddress());
		System.out.println(dto.getSalary());
		
	}

	private static void testDelete() throws Exception {

		EmployeeDTO dto = new EmployeeDTO();
		
		dto.setId(2);
		
		EmployeeModel model = new EmployeeModel();
		
		model.delete(dto);
		
	}

	private static void testUpdate() throws Exception{
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		EmployeeDTO dto = new EmployeeDTO();
		
		dto.setId(2);
		dto.setName("Rahul");
		dto.setDob(sdf.parse("2022-03-10"));
		dto.setCompany("Infosys");
		dto.setSalary("45000");
		dto.setAddress("Indore");
		
		EmployeeModel model = new EmployeeModel();
		  
		model.update(dto);
		
	}

	private static void testAdd() throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		EmployeeDTO dto = new EmployeeDTO();
		
		dto.setName("Naman");
		dto.setDob(sdf.parse("2023-03-10"));
		dto.setCompany("Wipro");
		dto.setSalary("45000");
		dto.setAddress("Indore");
		
		EmployeeModel model = new EmployeeModel();
		  
		model.add(dto);
		
	}
}
