package com.example.demo.form;

import java.time.LocalDateTime;

import org.antlr.v4.runtime.misc.NotNull;



//画面で入力された値をまとめるクラス
//src/main/resouce/messages.propertiesにバリデーションチェックメッセージ
public class TaskForm {

	//タスクID
	private int taskId;
	
	//タイトルは1文字以上100文字以下
	@NotBlank
	@Size(min = 1,maix = 100)
	private String title;
	
	//説明は最大200文字
	@Size(max = 200)
	private String description;
	
	//デッドラインは必須項目
	@NotNull
	private LocalDateTime deadline;
	
	//ステータスは1から3の範囲
	@Min(value = 0)
	@Max(value = 3)
	private int stastus;
	
	//更新日時
	private LocalDateTime updateTime;

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getDeadline() {
		return deadline;
	}

	public void setDeadline(LocalDateTime deadline) {
		this.deadline = deadline;
	}

	public int getStastus() {
		return stastus;
	}

	public void setStastus(int stastus) {
		this.stastus = stastus;
	}

	public LocalDateTime getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(LocalDateTime updateTime) {
		this.updateTime = updateTime;
	}
	
	
}
