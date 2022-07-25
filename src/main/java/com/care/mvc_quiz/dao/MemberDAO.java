package com.care.mvc_quiz.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.care.mvc_quiz.dto.MemberDTO;

@Repository //DB에서 데이터를 가져와서 Service로 넘겨줌 //연산X
public class MemberDAO {
	
	private ArrayList<MemberDTO> list;
	public MemberDAO() {
		list = new ArrayList<MemberDTO>();
	}
	
	public void register(MemberDTO dto) {
		list.add(dto);
	} //DB에 저장이 끝나면 원래 함수부분으로 되돌아감
	
	public ArrayList<MemberDTO> list() { //회원정보가 list에 다 저장되어 있으므로 list 반환시켜줌
		// select * from table;
		return list;
	}

}
