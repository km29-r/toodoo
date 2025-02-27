package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Task;
import com.example.demo.repository.TaskRepository;


/**
 * タスク関連のビジネスロジックを担当するサービスクラスです。
 * タスクの検索、保存、更新などの機能を提供します。
 */

@Service
public class TaskServiceImpl implements TaskService{
	
	//フィールドインジェクション
	@Autowired
	TaskRepository taskRepository;//repositoryクラスのメソッドを呼び出すため、repositoryクラスのオブジェクト

	/**
	 * タスク一覧を取得するメソッドです。
	 *
	 * @return List<Task> タスク一覧。
	 */
	
	@Override
	public List<Task> findAll(){
		return taskRepository.findAll();
	}

}
