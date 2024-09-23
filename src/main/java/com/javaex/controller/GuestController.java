package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	
}
