package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.Task;
import com.example.demo.form.TaskForm;
import com.example.demo.service.TaskService;

/**
 * Webアプリケーションのタスク関連機能を担当するControllerクラスです。 タスクの一覧表示、登録、変更などの機能が含まれています。
 *
 */

@Controller // このクラスがControllerクラスであることを、フレームワーク側に認知させる
public class TaskController {

//	@GetMapping(value = "/task/list")//URL設計で検討した"/task/list"というURLで、HTTPリクエストをGETメソッドで受け取る
//	public String showTask(Model model) {
//		
//		return "task/index";//HTMLファイルは、taskフォルダのindex.htmlを返す（.ｈｔｍｌは省略）
//		//src/main/resouces>templates配下への紐づけはフレームワーク側でやってくれるが、フォルダ構成とreturnの指定に間違いがあるとhtmlは呼び出せない
//	}

	private final TaskService taskService;// Serviceオブジェクトを格納するフィールド(taskService)を記載します

	public TaskController(TaskService taskService) {// TaskServiceを引数とするコンストラクタ(TaskController)で、引数をフィールドにセット
		// controllerクラスでServiceオブジェクトを呼び出すことが可能になった
		this.taskService = taskService;
	}

	/**
	 * タスクの一覧を表示するメソッドです。
	 * 
	 * @param model タスク一覧をViewに渡すためのSpringのModelオブジェクト
	 * @return "task/index" - タスク一覧表示用のHTMLテンプレートのパス
	 */

	@RequestMapping(value = "/task/list", method = RequestMethod.GET)
	public String showTask(Model model) {

		// タスクの一覧を取得
		List<Task> taskList = taskService.findAll();// findAllでserviceクラスの一覧取得処理を呼び出す
		model.addAttribute("taskList", taskList);// 一覧データをｍｏｄｅｌにセット

		return "task/index";// 画面に渡す
	}

	@GetMapping(value = "/task/add") // 登録画面へ遷移するメソッド
	public String showForm(Model model) {
		// タスクフォームを作成
		TaskForm taskForm = new TaskForm();

		model.addAttribute("taskForm", taskForm);
		return "task/edit";
	}

	@GetMapping(value = "/task/edit")
	public String showEditForm(@RequestParam("taskId") int taskId, Model model) {
	    //edit画面に行くとtaskIdが0になってエラーが出るので下記を追加
		if (taskId <= 0) { // 0以下のIDはエラーにする
	        throw new IllegalArgumentException("Invalid taskId: " + taskId);
	    }
		// タスクIDに基づいてタスクを取得
		TaskForm taskForm = taskService.getTask(taskId);

		model.addAttribute("taskForm", taskForm);
		return "task/edit";
	}

	@GetMapping(value = "/task/confirm") // 確認画面へ遷移するメソッド
	public String showConfirmForm(@Validated TaskForm taskForm, BindingResult bindingResult, Model model) {

		// バリデーションチェックでエラーがある場合は変更画面に戻る
		if (bindingResult.hasErrors()) {
			return "task/edit";
		}

		model.addAttribute("taskForm", taskForm);
		return "task/confirm";
	}

	@PostMapping(value = "/task/save")
	public String saveTask(@Validated TaskForm taskForm, BindingResult bindingResult,
			RedirectAttributes redirectAttributes, Model model) {

		// バリデーションチェック
		if (bindingResult.hasErrors()) {
			// バリデーションエラーがある場合は変更画面に遷移
			return "task/edit";
		}

		// 保存処理
		String completeMessage = taskService.save(taskForm);

		// redirect先に値を渡す
		redirectAttributes.addFlashAttribute("completeMessage", completeMessage);

		return "redirect:/task/complete";
	}

	@GetMapping("/task/complete")
	public String showCompletePage() {
		return "task/complete";
	}

}
