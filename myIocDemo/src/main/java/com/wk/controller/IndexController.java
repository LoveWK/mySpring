package com.wk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class IndexController {
	@RequestMapping("/home.do")
	@ResponseBody
	public Map<String,String> index(){
		System.out.println("controller index======");
		Map<String,String> map = new HashMap<>();
		map.put("wk","good boy");

		return map;
	}
}
