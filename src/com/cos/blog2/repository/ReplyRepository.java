package com.cos.blog2.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cos.blog2.db.DBConn;
import com.cos.blog2.model.Reply;
import com.cos.blog2.model.Users;

public class ReplyRepository {

	private static final String TAG = "ReplyRepository :";
	private static ReplyRepository instance = new ReplyRepository();

	public ReplyRepository() {
	}

	public static ReplyRepository getInstance() {
		return instance;
	}

	private Connection conn = null;
	private PreparedStatement psmt = null;
	private ResultSet rs = null;

	public int save(Reply reply) {
		final String SQL = "";
		try {
			conn = DBConn.getcConnection();
			psmt = conn.prepareStatement(SQL);

			// 물음표 완성하기

			return psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG + "save :" + e.getMessage());
		} finally {
			DBConn.close(conn, psmt);
		}
		return -1;
	}

	public int update(Reply reply) {
		final String SQL = "";
		try {
			conn = DBConn.getcConnection();
			psmt = conn.prepareStatement(SQL);

			// 물음표 완성하기
			return psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG + "update :" + e.getMessage());
		} finally {
			DBConn.close(conn, psmt);
		}
		return -1;
	}

	public int deleteById(int id) {
		final String SQL = "";
		try {
			conn = DBConn.getcConnection();
			psmt = conn.prepareStatement(SQL);

			// 물음표 완성하기
			return psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG + "deleteById :" + e.getMessage());
		} finally {
			DBConn.close(conn, psmt);
		}
		return -1;
	}

	public List<Reply> findAll() {
		final String SQL = "";
		List<Reply> replys = new ArrayList<>();
		try {
			conn = DBConn.getcConnection();
			psmt = conn.prepareStatement(SQL);

			// 물음표 완성하기
			return replys;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG + "findAll :" + e.getMessage());
		} finally {
			DBConn.close(conn, psmt, rs);
		}
		return null;
	}

	public Reply findById(int id) {
		final String SQL = "";
		Reply reply = new Reply();
		try {
			conn = DBConn.getcConnection();
			psmt = conn.prepareStatement(SQL);

			// 물음표 완성하기
			return reply;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG + "findById :" + e.getMessage());
		} finally {
			DBConn.close(conn, psmt, rs);
		}
		return null;
	}
}
