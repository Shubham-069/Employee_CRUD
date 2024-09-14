package com.crud.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.crud.model.Employee;


public class EmpDao {
	
	
	public static final String URL = "jdbc:mysql://localhost:3306/test";
	public static final String User = "root";
	public static final String Password= "root";
	
	private Connection getConnection() throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		return DriverManager.getConnection(URL, User, Password);
	}
	
	// Add Employee
    public void addEmployee(Employee emp) throws SQLException {
        String sql = "INSERT INTO emp_crud (name, email, password, contact, address) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection=getConnection();
    			PreparedStatement st=connection.prepareStatement(sql)){
    			st.setString(1, emp.getName());
    			st.setString(2, emp.getEmail());
    			st.setString(3, emp.getPassword());
    			st.setString(4, emp.getContact());
    			st.setString(5, emp.getAddress());
    			
    			st.executeUpdate();
    		} catch (SQLException e) {	
    			e.printStackTrace();
    		}
    		
    	}
    
    //login 
    public Boolean isUserRegistered(String email, String password) {
		boolean isRegistered=false;
		
		String sql="SELECT 1 FROM emp_crud WHERE email=? AND password=? ";
		
		try (Connection connection=getConnection();
    			PreparedStatement st=connection.prepareStatement(sql)){
			
			st.setString(1, email);
			st.setString(2, password);
			
			ResultSet rs=st.executeQuery();
			
			isRegistered=rs.next();
		}catch (SQLException e) {	
			e.printStackTrace();
		}
		return isRegistered;
	}
    
    
 // Get all Employees
    public List<Employee> getAllEmployee(){
		List<Employee> emps=new ArrayList<>();
		String sql="SELECT * FROM emp_crud";
		try (Connection connection=getConnection();
			PreparedStatement st=connection.prepareStatement(sql)){
			
			ResultSet rs=st.executeQuery();
			
			while(rs.next()) {
				Employee emp=new Employee();
				emp.setId(rs.getInt("id"));
				emp.setName(rs.getString("name"));
				emp.setEmail(rs.getString("email"));
				emp.setContact(rs.getString("contact"));
				emp.setAddress(rs.getString("address"));
				
				emps.add(emp);
				
			}
		} catch (SQLException e) {	
			e.printStackTrace();
		}
		return emps;
		
	}
    
    // Delete Employee
    public void deleteEmployee(int id) {
        String sql = "DELETE FROM emp_crud WHERE id = ?";
        try (Connection connection = getConnection();
             PreparedStatement st = connection.prepareStatement(sql)) {

            // Set the ID parameter for the DELETE query
            st.setInt(1, id);

            // Execute the update query (delete operation)
            int rowsAffected = st.executeUpdate();

            // Optionally, check if the delete was successful
            if (rowsAffected > 0) {
                System.out.println("Employee with ID " + id + " was deleted successfully.");
            } else {
                System.out.println("No employee found with ID " + id);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
 // Update Employee
    public void updateEmployee(Employee emp) throws SQLException {
        String sql = "UPDATE emp_crud SET name = ?, email = ?, contact = ?, address = ? WHERE id = ?";

        Connection connection = getConnection();
        PreparedStatement st = connection.prepareStatement(sql);
        st.setString(1, emp.getName());
        st.setString(2, emp.getEmail());
        st.setString(3, emp.getContact());
        st.setString(4, emp.getAddress());
        st.setInt(5, emp.getId());
//        st.executeUpdate();
     // Execute the update query
        int rowsAffected = st.executeUpdate();

        // Check if the update was successful
        if (rowsAffected > 0) {
            System.out.println("Update successful.");
        } else {
            System.out.println("Update failed. No rows affected.");
        }
       
    }
    
    public Employee getEmployeeById(int id) {
        Employee emp = null;
        String sql = "SELECT * FROM emp_crud WHERE id = ?";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                emp = new Employee();
                emp.setId(resultSet.getInt("id"));
                emp.setName(resultSet.getString("name"));
                emp.setEmail(resultSet.getString("email"));
                emp.setContact(resultSet.getString("contact"));
                emp.setAddress(resultSet.getString("address"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return emp;
    }



}
