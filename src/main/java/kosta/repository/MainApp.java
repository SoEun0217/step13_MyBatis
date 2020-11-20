package kosta.repository;

import kosta.dto.EmpDTO;

public class MainApp {

	public static void main(String[] args) {
		System.out.println("1. ename 정보 list~");
		EmpDAO.selectEname();
		/*
		 * System.out.println("====================="); System.out.println("2. 등록하기");
		 * EmpDAO.insert(new EmpDTO(9898,"소은","개발자",5000,null));
		 */
		/*
		 * System.out.println("======================="); System.out.println("3. 삭제하기");
		 * EmpDAO.delete(9000);
		 */
		System.out.println("====================");
		System.out.println("4. 수정하기");
		EmpDAO.update(new EmpDTO(0,"수정","바보바",2000,null));
		
		System.out.println("=====================");
		System.out.println("5. 전체검색");
		EmpDAO.selectAll();
		
		System.out.println("==================");
		System.out.println("6. 번호 검색");
		EmpDAO.searchByempNo(7566);
		
		System.out.println("===================");
		System.out.println("7. 급여가 얼마 이하인 사원");
		EmpDAO.searchBySal(15000);
		
		System.out.println("===================");
		System.out.println("8. 급여의 범위에 따라");
		EmpDAO.selectByMinMax(2000, 3000);
		
		System.out.println("====================");
		System.out.println("9. 컬럼별 정렬하기");
		EmpDAO.selectOrder("sal");
		
		System.out.println("====================");
		System.out.println("10. 컬럼에 포함된 레코드찾기");
		EmpDAO.selectByString("ename","a");
		
		System.out.println("====================");
		System.out.println("11. 직업검색");
		EmpDAO.selectByJob("SALESMAN");
	}
}
	
	
