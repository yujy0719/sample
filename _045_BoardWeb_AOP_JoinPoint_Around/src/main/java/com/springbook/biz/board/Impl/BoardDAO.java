package com.springbook.biz.board.Impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.common.JDBCUtil;

@Repository("boardDAO")
public class BoardDAO{
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	private final String BOARD_INSERT = "INSERT INTO board(seq, title, writer,content)" + "\r\n" +
										"VALUES((SELECT NVL(MAX(seq), 0)+1 FROM board), ?, ?, ?)";
	private final String BOARD_UPDATE = "UPDATE board SET title=?, content=? WHERE seq=?";
	private final String BOARD_DELETE = "DELETE board WHERE seq=?";
	private final String BOARD_GET = "SELECT * FROM board WHERE seq=?";
	private final String BOARD_LIST = "SELECT * FROM board ORDER BY seq DESC";
	
	public void insertBoard(BoardVO vo) {
		System.out.println("===> JDBC로 insertBoard() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_INSERT);
			stmt.setString(1, vo.getTitle());
			stmt.setString(2, vo.getWriter());
			stmt.setString(3, vo.getContent());
			stmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	
	public void updateBoard(BoardVO vo) {
		System.out.println("===> JDBC로 updateBoard() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_UPDATE);
			stmt.setString(1, vo.getTitle());
			stmt.setString(2, vo.getContent());
			stmt.setInt(3, vo.getSeq());
			stmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	
	public void deleteBoard(BoardVO vo) {
		System.out.println("===> JDBC로 updateBoard() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_DELETE);
			stmt.setInt(1, vo.getSeq());
			stmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> JDBC로 getBoard() 기능 처리");
		BoardVO board = null;
		
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_GET);
			stmt.setInt(1, vo.getSeq());
			rs = stmt.executeQuery();
			if(rs.next()) {
				board = new BoardVO();
				board.setSeq(rs.getInt("seq"));
				board.setTitle(rs.getString("title"));
				board.setWriter(rs.getString("writer"));
				board.setContent(rs.getString("content"));
				board.setRegDate(rs.getDate("regdate"));
				board.setCnt(rs.getInt("cnt"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(stmt, conn);
		}
		
		return board;
	}
	
	public List<BoardVO> getBoardList(BoardVO vo){
		System.out.println("===> JDBCV로 getBoardList() 기능 처리");
		List<BoardVO> boardList = new ArrayList<BoardVO>();
		
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_LIST);
			rs = stmt.executeQuery();
			while(rs.next()) {
				BoardVO board = new BoardVO();
				board.setSeq(rs.getInt("seq"));
				board.setTitle(rs.getString("title"));
				board.setWriter(rs.getString("writer"));
				board.setContent(rs.getString("content"));
				board.setRegDate(rs.getDate("regdate"));
				board.setCnt(rs.getInt("cnt"));
				boardList.add(board);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		
		return boardList;
	}
}




















