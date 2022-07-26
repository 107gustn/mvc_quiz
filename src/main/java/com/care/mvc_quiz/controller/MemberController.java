package com.care.mvc_quiz.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.care.mvc_quiz.dto.MemberDTO;
import com.care.mvc_quiz.service.MemberService;

@Controller //연결만 시켜주는 다리 역할
public class MemberController {
	@Autowired //자동 주입 - Autowired를 통해서 객체를 넣어줌
	MemberService ms; //controller에서 Service로 이동
	
	//@GetMapping("/index") //index를 요청했을때
	@GetMapping("**") //모든 경로의 값을 받아줌
	public void index() {
		//return "index"; //index.jsp로 연결해줌 //요청경로와 JSP경로가 같으면 return값 생략 가능하다.
	}
	
	@GetMapping("register_form") //해당 경로가 있으면 경로처리를 해줌
	public String registerForm() {
		return "register_form"; // register_form.jsp로 연결
	}
	
	@PostMapping("register") //register 경로로 들어오면
	public String register(MemberDTO dto) {
	//public String register(HttpServletRequest request) {
		//MemberDTO dto = new MemberDTO();
		//dto.setId( request.getParameter("id") );
		//dto.setPwd( request.getParameter("pwd") );
		//dto.setName( request.getParameter("name") );
		
		ms.register(dto); //연산 처리를 하기 위해 dto값을 가지고 서비스로 이동 
		return "index"; //index.jsp로 연결
	}
	
	@GetMapping("list")
	public String list(Model model) { //DB에서 객체를 받아와서 넘겨줘야 하기때문에 Model 사용
		ms.list(model); //연산 처리를 하기위해 model 값을 가지고 서비스로 이동
		//model.addAttribute("aaa", ms.getList() );
		return "list";
	}
	
	@GetMapping("info")
	public String info(@RequestParam String id, HttpServletRequest request, MemberDTO dto, Model model) { //데이터를 전달하기 위해선 Model이 필요하다
		//다양한 방법으로 id값을 받을 수 있다
		System.out.println("id : " + id);
		System.out.println("request : " + request.getParameter("id"));
		System.out.println("dto : " + dto.getId());

		ms.info(model, id);//연산하기 위해 Service로 보내줌
		
		return "info";
	}
	
	@PostMapping("logchk")
	public String logchk(MemberDTO dto, RedirectAttributes rs) {
		int result = ms.logchk(dto); //로그인 성공 0
		if(result == 0) {
			return "redirect:success?id=" + dto.getId();
		}
		rs.addFlashAttribute("result", result);
		return "redirect:index";
	}
	
	@GetMapping("success")
	public String success(String id, Model model) {
		ms.info(model, id); //한명의 정보를 가지고옴
		return "success";
	}
	
}
