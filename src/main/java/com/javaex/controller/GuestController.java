package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javaex.service.GuestbookService;
import com.javaex.vo.GuestVo;

@RestController
public class GuestController {

	@Autowired
	private GuestbookService guestbookService;

	@GetMapping("/api/guestbooks")
	public List<GuestVo> getList() {

		List<GuestVo> guestList = guestbookService.exeGuestList();

		System.out.println(guestList);
		return guestList;
	}

	@PostMapping("/api/guestbooks")
	public String write(@RequestBody GuestVo geustVo) {

		guestbookService.exeWrite(geustVo);

		return "redirect:/";
	}

	@GetMapping("/api/guestbooks/{no}")
	public GuestVo getGuestOne(@PathVariable(value = "no") int no) {

		GuestVo guestVo = guestbookService.exeDeleteForm(no);

		System.out.println(guestVo);
		return guestVo;
	}

	@DeleteMapping("/api/guestbooks/{no}")
	public boolean delete(@PathVariable(value = "no") int no, @RequestBody GuestVo guestVo) {
		String password = guestVo.getPassword(); // 요청에서 비밀번호 가져오기
		boolean deleted = guestbookService.exeDelete(no, password);
		return deleted;
	}

}
