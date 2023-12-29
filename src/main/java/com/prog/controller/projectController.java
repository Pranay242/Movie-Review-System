package com.prog.controller;



import com.mysql.cj.util.StringUtils;
import com.prog.entity.adminPageAtributeCollector;
import com.prog.repository.MySQLConnection;
import com.prog.repository.UserDao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.prog.entity.homePageAtributeCollector;
import com.prog.entity.movieFeedbackCollector;


import org.springframework.web.bind.annotation.ModelAttribute;


@Controller
public class projectController {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private MySQLConnection mySQLConnection;
	
	
	@GetMapping("/")
	public String home1()
	{
		return "htmlFile/homepage1";
	}
	
	@GetMapping("adminpage2.html")
	public String home2()
	{
		return "htmlFile/adminpage2";
	}
	
	@GetMapping("homepage1.html")
	public String home3()
	{		
		return "htmlFile/homepage1";
	}
	@GetMapping("/reg1")
	public String home4()
	{
		return "htmlFile/homepage1";
	}
	

	//access table name in database
	private String trimStringForTicketNumber(String s) {
		if(!StringUtils.isNullOrEmpty(s) && s.length() > 3) {
			return s.substring(0, s.length() - 3);
		} else {
			return s;
		}
	}

	
	//thymeleaf
	
	@PostMapping("/reg1")
	public String empreg1(@ModelAttribute homePageAtributeCollector s1)
	{
		System.out.println(s1);
		try
		{
			String q = "SELECT count(1) from " + trimStringForTicketNumber(s1.getMRS_Number()) + " WHERE MRSNumber = :number ";
			MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
			mapSqlParameterSource.addValue("number", s1.getMRS_Number());
			Integer integer = mySQLConnection.getNamedParameterJdbcTemplate().queryForObject(q, mapSqlParameterSource, new RowMapper<Integer>() {
				@Override
				public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
					return rs.getInt(1);
				}
			});
			if(integer > 0) {
				return "htmlFile/feedback3";
			} else {
				return "htmlFile/homepage1";
			}
		}
		catch (BadSqlGrammarException e) {
            // Handle the BadSqlGrammarException here
            // You can log the exception or return a specific error response
			return "htmlFile/homepage1";

        } catch (Exception e) {
            // Handle other exceptions if needed
			return "htmlFile/homepage1";
        }
	}
	
	//for adminUploadMrs
	@PostMapping("/reg2")
	public String empreg2(@ModelAttribute adminPageAtributeCollector s2)
	{
	   System.out.println(s2);
	   boolean b = userDao.count(s2.getUsername(),s2.getPassword());
	   System.out.println(b);
	   if(b) {
	       return "htmlFile/afterAdminLogin";
	   } else {
		   return "htmlFile/adminpage2";
	   }
	}
	
	
	@PostMapping("/")
	public String empreg3(homePageAtributeCollector s1,@ModelAttribute movieFeedbackCollector s3)
	{
		System.out.println(s3);
		String update = "UPDATE " + trimStringForTicketNumber(s1.getMRS_Number()) + " SET mood1=:mood , msgfeedback=:feedback WHERE MRSNumber=:number ";
		MapSqlParameterSource updateMapSqlParameterSource = new MapSqlParameterSource();
		updateMapSqlParameterSource.addValue("number", s1.getMRS_Number());
		updateMapSqlParameterSource.addValue("mood", s3.getMood1());
		updateMapSqlParameterSource.addValue("feedback", s3.getMsgfeedback());

		mySQLConnection.getNamedParameterJdbcTemplate().update(update, updateMapSqlParameterSource);
		return "htmlFile/homepage1";
	}
	
	
}
