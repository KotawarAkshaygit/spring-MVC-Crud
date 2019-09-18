package springmaven.employee.dao;

import java.io.IOException;
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
import org.springframework.stereotype.Service;

import springmaven.pojo.Employee;

@Service
@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	/*public Number create(Employee employee) {
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		 jdbcTemplate.update("Insert into employee (name,salary,dept)values (?,?,?)",employee.getName(),employee.getSalary(),employee.getDept()
				,new String []{"id"} ,keyHolder);
		Number key=keyHolder.getKey();
		return key;
	}
	*/
	  public long create(final Employee employee) 
	  {
		    final PreparedStatementCreator psc = new PreparedStatementCreator() 
		    {
		      public PreparedStatement createPreparedStatement(final Connection connection) throws SQLException {
		        final PreparedStatement ps = connection.prepareStatement("INSERT INTO employee(name,salary,dept) VALUES (?,?,?)",
		            Statement.RETURN_GENERATED_KEYS);
		        ps.setString(1, employee.getName());
		        ps.setInt(2,employee.getSalary());
		        ps.setString(3, employee.getDept());
		        return ps;
		      }
		    };
		    // The newly generated key will be saved in this object
		    final KeyHolder holder = new GeneratedKeyHolder();

		    jdbcTemplate.update(psc, holder);
		    
		    final long newNameId = holder.getKey().longValue();
		    return newNameId;
		  
		
	  }
	public Employee retrive(int id) throws DataAccessException {
	
		String query="select * from employee where id=?";
		
		@SuppressWarnings("unchecked")
		Employee emp=jdbcTemplate.query(query,new Object[] {id},new ResultSetExtractor()
				{
					public Employee extractData(ResultSet rs) throws SQLException,DataAccessException
					{
						Employee empss=new Employee();
						if(rs ==null)
						{
							return null;
						}
						else
						{
						while(rs.next())
						{
							
							empss.setId(rs.getInt(1));
							empss.setName(rs.getString(2));
							empss.setSalary(rs.getInt(3));
							empss.setDept(rs.getString(4));
							return empss;
						}
						}
						return empss;
					}
				}
				
				
				);
		/*
		EmployeeResultSet rowMapper = new EmployeeResultSet();
	
		 Employee employee=(Employee) jdbcTemplate.queryForObject(query,rowMapper,id);
		return  employee;
		*/
		return emp;
		
	}

	public int update(Employee employee) {
		
		
		return jdbcTemplate.update("update employee set name=?,salary=?,dept=? where id=?",employee.getName(),employee.getSalary(),employee.getDept(),employee.getId());
		
	}

	public List<Employee> getAllEmployees() {
	
		String query="select * from employee";
		
		List<Employee> employeeList=jdbcTemplate.query(query,new ResultSetExtractor<List<Employee>>()
		{
			public List<Employee> extractData(ResultSet rs) throws SQLException,DataAccessException
			{
				List<Employee> list=new ArrayList<Employee>();
				
				while(rs.next())
				{
					Employee empss=new Employee();
					empss.setId(rs.getInt(1));
					empss.setName(rs.getString(2));
					empss.setSalary(rs.getInt(3));
					empss.setDept(rs.getString(4));
					list.add(empss);
					
				}
				return list;
			}
			
		});
			
	
	return employeeList;
	}

	public int removeEmployee(int id) {
		
		String query="delete from employee where id=?";
		int result=jdbcTemplate.update(query, new Object[] {id});
		return result;
	}

	public Employee edit(int id) {


		String query="select * from employee where id=?";
		Employee employee=(Employee) jdbcTemplate.queryForObject(query,new Object[] {id},new RowMapper<Employee>()
				{
	            public Employee mapRow(ResultSet rs, int rowNum) throws SQLException 
	            {
	            	
	                Employee employee = new Employee();
	                employee.setId(rs.getInt(1));
	                employee.setName(rs.getString(2));
	                employee.setSalary(rs.getInt(3));
	                employee.setDept(rs.getString(4));
	                return employee;
	            	
				
				
	            }
				}
				); 
		return  employee;
	}

}
