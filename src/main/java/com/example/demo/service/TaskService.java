package com.example.demo.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Task;
import com.example.demo.form.TaskForm;



/**
 * タスク関連のサービスを提供するインターフェースです。
 */


public interface TaskService {// interfaceは実装を追加したり変更したりする際に、既存のコードへの影響を少なくして新しい実装に差し替えることができる
	
    /**
     * すべてのタスクを取得します。
     *
     * @return タスクのリスト
     */
	
	@Override
	@Transactional
	public String save(TaskForm taskForm) {
		
		return ;
	}

	List<Task> findAll();

}
