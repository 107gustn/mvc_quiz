package com.care.mvc_quiz.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.care.mvc_quiz.dao.MemberDAO;
import com.care.mvc_quiz.dto.MemberDTO;

@Service //연산 담당
public class MemberService {
	@Autowired //객체 연결
	MemberDAO dao; //Service에서 DAO로 이동
	
	public MemberService() {
		System.out.println("service 생성");
	}
	
	public void register(MemberDTO dto) {
		dao.register(dto); //dao를 통해 dto값 DB에 저장
	}
	
	public void list(Model model) {
		//ArrayList<MemberDTO> list = dao.list(); //모든값을 list에 저장
		//model.addAttribute("list", list ); //모든 값 list 정보 값을 list라는 이름의 key로 model에 저장
		model.addAttribute("list", dao.list() );
	}

}
