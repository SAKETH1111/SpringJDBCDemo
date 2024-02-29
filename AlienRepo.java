package com.telusko.SpringJDBCDemo;

import com.telusko.SpringJDBCDemo.model.Alien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AlienRepo {
    private JdbcTemplate template;

    public JdbcTemplate getTemplate() {
        return template;
    }
    @Autowired
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public void save(Alien alien){
        String sql = "insert into alien (age,name,tech) values (?,?,?)";
        System.out.println("Saving alien");
        int row =template.update(sql, alien.getAge(),alien.getName(), alien.getTech());
        System.out.println(row +"row affected");
    }

    public List<Alien> getAlienList(){
        System.out.println("List alien");
        String sql = "select * from alien";
//        RowMapper<Alien> mapper = new RowMapper<Alien>(){
//           @Override
//            public Alien mapRow(ResultSet rs, int rowNum) throws SQLException {
//               Alien a = new Alien();
//               a.setAge(rs.getInt(1));
//               a.setName(rs.getString(2));
//               a.setTech(rs.getString(3));
//
//               return a;
//           }
//
//        };
//        List<Alien> aliens = template.query(sql,mapper);
        //or use lambda function
        List<Alien> aliens = template.query(sql, (rs, row) -> {
            Alien a = new Alien();
            a.setAge(rs.getInt(1));
            a.setName(rs.getString(2));
            a.setTech(rs.getString(3));

            return a;
        });
        return aliens;
    }
}
