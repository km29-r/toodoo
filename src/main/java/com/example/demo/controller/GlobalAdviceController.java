package com.example.demo.controller;

import org.springframework.dao.DataAccessException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice //アプリケーション全体で共通の例外処理を一箇所にまとめるための仕組みを提供
public class GlobalAdviceController {
	
	@ExceptionHandler(DataAccessException.class)
	public String handleDatabaseError(DataAccessException ex,Model model) {
		model.addAttribute("errorMessage","データベースアクセスエラーは発生しました。");
		return "task/systemError";
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public String handleIllegalArgumentWxception(IllegalArgumentException ex,Model model) {
		model.addAttribute("erroeMessage", ex.getMessage());
		return "task/systemError";
	}

}
