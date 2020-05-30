package com.cos.blog2.action.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.blog2.action.Action;
import com.cos.blog2.model.Users;
import com.cos.blog2.repository.UsersRepository;
import com.cos.blog2.util.Script;

public class UsersLoginProcAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1.유효성 체크
		if (request.getParameter("username") == null || request.getParameter("username").equals("")
				|| request.getParameter("password") == null || request.getParameter("password").equals("")) {
			// request로부터 상대방의 ip 주소등을 로그로 남기는게 좋다고 함
			return;
		}

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		UsersRepository usersRepository = UsersRepository.getInstance();
		// 세션 사용자 정보를 다 담고 있어야 하므로 사용자 정보 전체 받아옴
		Users user = usersRepository.findByUsernameAndPassword(username, password);

		if (user != null) {
			HttpSession session = request.getSession();

			// 자기만의 session id에 principal이 존재하므로 여러 클라이언트 간에 구분 가능함
			session.setAttribute("principal", user); // principal: 인증주체

			Script.herf("로그인 성공", "/blog2/board?cmd=home", response);
		} else {
			Script.back("로그인 실패", response);
		}
	}
}
