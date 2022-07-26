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
		ArrayList<MemberDTO> list = dao.list(); //모든값을 list에 저장
		model.addAttribute("list", list ); //모든 값 list 정보 값을 list라는 이름의 key로 model에 저장
		//model.addAttribute("list", dao.list() );//select * from table
	}
//	public ArrayList<MemberDTO> getList(){
//		return dao.list();
//	}
	
	public void info(Model model, String id) {
		//select * from table where id = id
		ArrayList<MemberDTO> list = dao.list(); //모든 정보를 가져옴
		for(MemberDTO dto : list) { //list값을 하나씩 dto에 저장해줌
			if( dto.getId().equals(id) ) {
				model.addAttribute("dto", dto); //한명에 대한 정보를 가져옴 //해당 객체 dto라는 이름으로 저장된다
				break;
			}
		}
	}
	
	public int logchk(MemberDTO dto) {
		ArrayList<MemberDTO> list = dao.list(); //모든 정보를 가져옴
		for(MemberDTO d : list) { //list값을 하나씩 dto에 저장해줌
			if( d.getId().equals(dto.getId()) ) { //해당하는 아이디 존재시
				if( d.getPwd().equals(dto.getPwd())) { //비밀번호 비교
					return 0; //모두 일치
				}
				return 1; //비밀번호 오류
			}
		}
		return -1; //아이디 오류
	}
	
}
