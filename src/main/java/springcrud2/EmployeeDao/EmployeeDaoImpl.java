package springcrud2.EmployeeDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import springcrud2.employeeBean.Employee;

@Repository
public class EmployeeDaoImpl {
	
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	 public void setJdbcTemplate(JdbcTemplate jdbcTemplate)
	    {
	        this.jdbcTemplate = jdbcTemplate;
	    }
	public long create(final Employee emp) {
		
		final String query="insert into employee (name,salary,dept)values(?,?,?)";
		
		KeyHolder holder = new GeneratedKeyHolder();
		jdbcTemplate.update(
	    	    new PreparedStatementCreator() {
	    	        public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
	    	            PreparedStatement pst =
	    	                con.prepareStatement(query, new String[] {"id"});
	    	            pst.setString(1,emp.getName());
	    	            pst.setInt(2,emp.getSalary());
	    	            pst.setString(3, emp.getDept());
	    	            return pst;
	    	        }

				
	    	    },
	    	    holder);
	    	return holder.getKey().intValue();
	    }
		
		/*
		String query="insert into employee (name,salary,dept)values(?,?,?)";
		long result= jdbcTemplate.update(query,Statement.RETURN_GENERATED_KEYS, emp.getName(),emp.getSalary(),emp.getDept(),holder);
		int newUserId = holder.getKey().intValue();
		//user.setId(newUserId);
		return newUserId;
		*/
	
	public Employee retrive(int id) {
		String query="select * from employee where id=?";
		
		/*
		Employee employee=(Employee) jdbcTemplate.queryForObject(query,new Object[] {id},new RowMapper<Employee>()
				{

					public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
						
						Employee employee=new Employee();
						employee.setId(rs.getInt(1));
						employee.setName(rs.getString(2));
						employee.setSalary(rs.getInt(3));
						employee.setDept(rs.getString(4));
						return employee;
					}
			
				}
				
				);
		*/
		
		
		
		  Employee emplo = jdbcTemplate.query(query,new Object[] {id}, new ResultSetExtractor<Employee>()
	        {
	            public Employee extractData(ResultSet rs) throws SQLException, DataAccessException
	            {
	                //List<Employee> list = new ArrayList<Employee>();
	            	 Employee employee = new Employee();
	                while (rs.next())
	                {
	                   
	                    employee.setId(rs.getInt(1));
	                    employee.setName(rs.getString(2));
	                    employee.setSalary(rs.getInt(3));
	                    employee.setDept(rs.getString(4));
	                  
	                    
	                }
	                return employee;
	            }

	        });
		return emplo;
	}

	public int update(Employee emps) {
		
		String query="update employee set name=?,salary=?,dept=? where id=?";
		int result=jdbcTemplate.update(query,emps.getName(),emps.getSalary(),emps.getDept(),emps.getId());
		return result;
	}

	public List<Employee> getAllEmployees() {
		 String sql = "select * from Employee";

	        List<Employee> employeeList = jdbcTemplate.query(sql, new ResultSetExtractor<List<Employee>>()
	        {
	            public List<Employee> extractData(ResultSet rs) throws SQLException, DataAccessException
	            {
	                List<Employee> list = new ArrayList<Employee>();
	                while (rs.next())
	                {
	                    Employee employee = new Employee();
	                    employee.setId(rs.getInt(1));
	                    employee.setName(rs.getString(2));
	                    employee.setSalary(rs.getInt(3));
	                    employee.setDept(rs.getString(4));
	                  
	                    list.add(employee);
	                }
	                return list;
	            }

	        });
	        return employeeList;
	}

	public int removeEmployee(int id) {
		String query="delete from employee where id=?";
		
		int res=jdbcTemplate.update(query,new Object[] {id});
		return res;
	}

}
