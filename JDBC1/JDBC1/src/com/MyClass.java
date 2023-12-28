package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;


public class MyClass {
	public static void main(String[] args) throws SQLException {
		Connection connection=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/decemberpracticejdbc","root","PASSWORD");
		Statement s=connection.createStatement();
		String create="CREATE TABLE STUDENT(ID INT, NAME VARCHAR(255), EMAIL VARCHAR(255), ADDRESS VARCHAR(255))";
//		s.execute(create);
		
		String insert="INSERT INTO STUDENT VALUES(1,'NITISH','NITISH@2002','KADAPA'),(2,'VINAYAKA','VINAYAKA@2002','KANIPAKAM'),(3,'SAI','SAI@2002','SHIRIDI'),(4,'VIRAT','VIRAT@2002','DELHI')";
//		s.executeUpdate(insert);
		
		String updateAge="UPDATE STUDENT SET AGE=19 WHERE ID IN(1,2)";
//		s.executeUpdate(updateAge);
		
		String addColumn="ALTER TABLE STUDENT ADD COLUMN AGE INT";
//		s.execute(addColumn);
		String changeColumnName="ALTER TABLE STUDENT RENAME COLUMN NAME TO MYNAME";
//		s.execute(changeColumnName);
		String changeColumnName1="ALTER TABLE STUDENT MODIFY ID INT PRIMARY KEY";
//		s.execute(changeColumnName1);
		String changeColumnName2="ALTER TABLE STUDENT CHANGE COLUMN ADDRESS MYADDRESS VARCHAR(27)";
//		s.execute(changeColumnName2);
		String columnDrop="ALTER TABLE STUDENT DROP COLUMN AGE";
//		s.execute(columnDrop);
		
		String deleteRow="DELETE FROM STUDENT WHERE ID=3";
//		s.execute(deleteRow);
		
		String TruncateAllRows="TRUNCATE TABLE STUDENT";
//		s.execute(TruncateAllRows);
		
		String dropTable="DROP TABLE STUDENT";
//		s.execute(dropTable);
		
		String query="SELECT * FROM STUDENT";
		ResultSet rs=s.executeQuery(query);
		while(rs.next()) {
			System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
		}
		
		ResultSetMetaData rsmd=rs.getMetaData();
		System.out.println(rsmd.getColumnCount());
		System.out.println(rsmd.getColumnName(2));
		
		String query1="SELECT * FROM STUDENT WHERE ID IN(?,?,?)";
		PreparedStatement ps=connection.prepareStatement(query1);
		ps.setInt(1, 1);
		ps.setInt(2, 2);
		ps.setInt(3, 4);
		
		ResultSet rs1=ps.executeQuery();
		while(rs1.next()) {
			System.out.println(rs1.getString(1)+" "+rs1.getString(2)+" "+rs1.getString(3)+" "+rs1.getString(4));
		}
	}
}
