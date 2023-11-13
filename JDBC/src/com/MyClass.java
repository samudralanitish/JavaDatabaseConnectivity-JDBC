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
		Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/bcci","root","Nitish@2002");
		Statement s=connection.createStatement();
		String create="Create table worldcup(id int, team varchar(255),captain varchar(255));";
//		s.execute(create);
		String insert="insert into worldcup values(1,'India', 'Virat Kohli'),(2,'Newzealand','Kane Williamson'),(3,'Australia','Steven Smith'),(4,'Pakistan','Babar Azam');";
//		s.executeUpdate(insert);
		String alterPosition="Alter table worldcup rename column id to position";
//		s.execute(alterPosition);
		String addColumn="Alter table worldcup add column trophies int";
//		s.execute(addColumn);
		String addValues="Update worldcup set trophies=1 where position in(4)";
//		s.executeUpdate(addValues);
		String tableRename="Rename table worldcup to ICCWorldCup2023";
//		s.execute(tableRename);
		String query="select * from ICCWorldCup2023";
		ResultSet rs = s.executeQuery(query);
		while(rs.next()) {
			System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4) );
		}
		System.out.println("done");
		ResultSetMetaData rsmd = rs.getMetaData();
		System.out.println(rsmd.getColumnCount());
		System.out.println(rsmd.getColumnName(2));
		PreparedStatement ps = connection.prepareStatement("select trophies from ICCWorldCup2023 where position in(?,?)");
		ps.setInt(1,1);
		ps.setInt(2, 2);
		ResultSet rs1 = ps.executeQuery(query);
		while(rs.next()) {
			System.out.println(rs1.getInt(1));
		}
	}
}
