package com.cos.blog2.action.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.blog2.action.Action;
import com.cos.blog2.model.RoleType;
import com.cos.blog2.model.Users;
import com.cos.blog2.repository.UsersRepository;
import com.cos.blog2.util.Script;

public class UsersJoinProcAction implements Action{
       @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          //유효성 검사 
    if 
    (   
        request.getParameter("username").equals("")||		
        request.getParameter("username") ==null ||	
        request.getParameter("password").equals("")||	
        request.getParameter("password") ==null ||
        request.getParameter("email").equals("")||
        request.getParameter("email") ==null ||
        request.getParameter("address").equals("") ||
        request.getParameter("address") ==null
    		) { 
    	return; 
    }
    	//파라미터 받기
    	String username = request.getParameter("username");
    	String password = request.getParameter("password");
    	String email = request.getParameter("email");
    	String address = request.getParameter("address");
    	String userRole = RoleType.USER.toString();
    	
    	//User 오브젝트 변환 
    	Users user = Users.builder()
    			     .username(username)
    			     .password(password)
    			     .email(email)
    			     .address(address)
    			     .userRole(userRole)
    			     .build();
    	//DB연결 -USerRepository
    	   UsersRepository usersRepository = UsersRepository.getInstance();
    	    int result = usersRepository.save(user); 
    	    
    	    //index.jsp 페이지로 이동 
    	    if(result == 1) { 
    	    	RequestDispatcher dis = request.getRequestDispatcher("index.jsp"); 
    	    	 dis.forward(request, response);
    	    }else { 
    	    	 Script.back("회원가입에 실패하였습니다.", response);
    	    }
    }
}
