package com.cos.blog2.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cos.blog2.db.DBConn;
import com.cos.blog2.model.Board;
import com.cos.blog2.model.Users;

public class BoardRepository {

	private static final String TAG = "BoardRepository :";
	private static BoardRepository instance = new BoardRepository();

	public BoardRepository() {
	}

	public static BoardRepository getInstance() {
		return instance;
	}

	private Connection conn = null;
	private PreparedStatement psmt = null;
	private ResultSet rs = null;

	public int save(Board board) {
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

	public int update(Board board) {
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

	public List<Board> findAll() {
		final String SQL = "";
		List<Board> boards = new ArrayList<>();
		try {
			conn = DBConn.getcConnection();
			psmt = conn.prepareStatement(SQL);

			// 물음표 완성하기
			return boards;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG + "findAll :" + e.getMessage());
		} finally {
			DBConn.close(conn, psmt, rs);
		}
		return null;
	}

	public Board findById(int id) {
		final String SQL = "";
		Board board = new Board();
		try {
			conn = DBConn.getcConnection();
			psmt = conn.prepareStatement(SQL);

			// 물음표 완성하기
			return board;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG + "findById :" + e.getMessage());
		} finally {
			DBConn.close(conn, psmt, rs);
		}
		return null;
	}
}
