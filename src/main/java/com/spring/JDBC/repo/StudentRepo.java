package com.spring.JDBC.repo;

import com.spring.JDBC.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepo {
    private JdbcTemplate jdbc;

    public JdbcTemplate getJdbc() {
        return jdbc;
    }
    @Autowired
    public void setJdbc(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void save(Student s){
        String sql= "insert into student(name,rollno, marks) valeus(?,?,?) ";
        int rows= jdbc.update(sql,s.getName(),s.getRollNO(),s.getMarks());
        System.out.println(rows + "affected");
    }
    public List<Student> findAll(){
        String sql="select * from students";
        RowMapper<Student> mapper= ( rs,  rowNum) -> {
                Student s = new Student();
                s.setRollNO(rs.getInt("rollno"));
                s.setName(rs.getString("name"));
                s.setMarks(rs.getInt("marks"));
                return s;

        };
        return jdbc.query(sql,mapper);
    }
}
