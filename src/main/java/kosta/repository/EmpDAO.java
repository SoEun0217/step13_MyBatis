package kosta.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kosta.dto.EmpDTO;

public class EmpDAO {
	/**
	 * 모든 사원의 이름 검색
	 * */
	public static void selectEname() {
		SqlSession session = null;
		//연결, 실행, 닫기
		try {
		session = DbUtil.getSession();//jdbc와 다르게 예외처리 안해주어도됨
		
		List<String>list = 
				session.selectList("empMapper.selectEname");//namespace이름.id
		System.out.println("******** ename 정보 ***********");
		System.out.println(list);
		}finally {
			DbUtil.sessionClose(session);
		}
	}//selectEname
	
	/**
	 * 등록하기
	 * */
	public static void insert(EmpDTO empDTO) {
		SqlSession session = null;
		boolean state = false;
		try {
			session  = DbUtil.getSession();
			state = session.insert("empMapper.insert", empDTO)> 0 ? true:false;
		} finally {
			DbUtil.sessionClose(session, state);
		}
	}

	
	/**
	 * 삭제하기
	 * */
	public static void delete(int empno) {
		SqlSession session = null;
		boolean state = false;
		try {
			session = DbUtil.getSession();
			state = session.delete("empMapper.delete", empno)>0 ?true:false;
		}finally {
			DbUtil.sessionClose(session, state);
		}
	}
		
	/**
	 * 수정하기
	 * */
	public static void update(EmpDTO empDTO) {
		SqlSession session = null;
		boolean state = false;
		try {
			session = DbUtil.getSession();
			state = session.update("empMapper.update", empDTO)>0?true:false;
		} finally {
			DbUtil.sessionClose(session, state);
		}
	}
		
	/**
	 * 전체 검색
	 * */
	public static void selectAll() {
		SqlSession session = null;
		try {
			session = DbUtil.getSession();
			List<EmpDTO>list=session.selectList("empSelectMapper.selectAll");
			for(EmpDTO e:list) {
				System.out.println(e);
			}
		} finally {
			DbUtil.sessionClose(session);
		}
	}
	
	/**
	 * empno에 해당하는 레코드 검색
	 * */
	public static void searchByempNo(int empno) {
		SqlSession session = null;
		try {
			session = DbUtil.getSession();
			//session.selectList("empSelectMapper.selectByempNo", empno);
			EmpDTO dto = session.selectOne("empSelectMapper.selectByempNo", empno);
			System.out.println(dto);
		}finally {
			DbUtil.sessionClose(session);
		}
	}
	
	public static void searchBySal(int sal) {
		SqlSession session = null;
		try {
			session = DbUtil.getSession();
			List<EmpDTO>list = session.selectList("empSelectMapper.selectBySal",sal);
			for(EmpDTO e :list) {
				System.out.println(e);
			}
		} finally {
			DbUtil.sessionClose(session);
		}
	}
	
	
	public static void selectByMinMax(int min,int max) {
		SqlSession session = null;
		Map<String, Integer>map = new HashMap<String, Integer>();
		map.put("min", min);
		map.put("max", max);
		try {
			session = DbUtil.getSession();
			List<EmpDTO>list = session.selectList("empSelectMapper.searchByMinMax",map);
			for(EmpDTO e :list) {
				System.out.println(e);
			}
		} finally {
			DbUtil.sessionClose(session);
		}
	}
	
	public static void selectOrder(String column) {
		SqlSession session = null;
		try {
			session = DbUtil.getSession();
			List<EmpDTO>list = session.selectList("empSelectMapper.selectOrder",column);
			for(EmpDTO e :list) {
				System.out.println(e);
			}
		} finally {
			DbUtil.sessionClose(session);
		}
	}
	
	public static void selectByString(String column,String value) {
		SqlSession session = null;
		Map<String, String>map = new HashMap<String, String>();
		map.put("column", column);
		map.put("value",value);
		try {
			session = DbUtil.getSession();
			List<EmpDTO>list = session.selectList("empSelectMapper.selectByString",map);
			for(EmpDTO e :list) {
				System.out.println(e);
			}
		} finally {
			DbUtil.sessionClose(session);
		}
	}
	
	public static void selectByJob(String job) {
		SqlSession session= null;
		try {
			session = DbUtil.getSession();
			List<EmpDTO>list = session.selectList("empMapper.selectByJob",job);
			for(EmpDTO e :list) {
				System.out.println(e);
			}
		} finally {
			DbUtil.sessionClose(session);
		}
	}
	
}//클래스끝
