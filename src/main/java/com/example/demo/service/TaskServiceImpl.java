package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.common.Constants;
import com.example.demo.entity.Task;
import com.example.demo.form.TaskForm;
import com.example.demo.repository.TaskRepository;

/**
 * タスク関連のビジネスロジックを担当するサービスクラスです。 タスクの検索、保存、更新などの機能を提供します。
 */

@Service
public class TaskServiceImpl implements TaskService {

	// フィールドインジェクション
	@Autowired
	TaskRepository taskRepository;// repositoryクラスのメソッドを呼び出すため、repositoryクラスのオブジェクト

	/**
	 * タスク一覧を取得するメソッドです。
	 *
	 * @return List<Task> タスク一覧。
	 */

	@Override
	public List<Task> findAll() {
		return taskRepository.findAll();
	}

	@Override
	@Transactional
	public String save(TaskForm taskForm) {
		// 変換処理
		Task task = convertToTask(taskForm);
		System.out.println("taskId = " + task.getTaskId()); // デバッグ用

		// 完了メッセージを宣言
		String completeMessage = null;

		if (task.getTaskId() != 0) {// task.getTaskId()が0になっているからfalseになってeditしても新規登録になってしまう
			// 変換処理の場合 真下と被ってるからいらない。そもそも何故書いてあった？
//			taskRepository.update(task);
			// 楽観ロック
			int updateCount = taskRepository.update(task);
			if (updateCount == 0) {
				throw new OptimisticLockingFailureException("楽観ロックエラー");
			}
			// 完了メッセージをセット
			completeMessage = Constants.EDIT_COMPLETE;
//			return completeMessage;ここいらない？
		} else {
			// 登録処理の場合
			taskRepository.save(task);

			// 完了メッセージをセット
			completeMessage = Constants.REGISTER_COMPLETE;
//			return completeMessage;書く場所違う？if文の外

		}
		return completeMessage;

	}

	@Override
	public Task convertToTask(TaskForm taskForm) {
		Task task = new Task();
		task.setTaskId(taskForm.getTaskId());
		task.setTitle(taskForm.getTitle());
		task.setDescription(taskForm.getDescription());
		task.setDeadline(taskForm.getDeadline());
		task.setStatus(taskForm.getStatus());
		task.setUpdatedAt(taskForm.getUpdatedAt());
		return task;
	}

	@Override
	public TaskForm getTask(int taskId) {
		// タスクを取得
		Task task = taskRepository.getTask(taskId);

		// 変換処理
		TaskForm taskForm = convertToTaskForm(task);

		return taskForm;
	}

	@Override
	public TaskForm convertToTaskForm(Task task) {

		TaskForm taskForm = new TaskForm();
		taskForm.setTaskId(task.getTaskId());
		taskForm.setTitle(task.getTitle());
		taskForm.setDescription(task.getDescription());
		taskForm.setDeadline(task.getDeadline());
		taskForm.setStatus(task.getStatus());
		taskForm.setUpdatedAt(task.getUpdatedAt());
		return taskForm;
	}
	
	//deleteメソッドを実装
	@Override
	@Transactional
	public String delete(int taskId) {
		//削除処理。Repositoｒｙクラスを介してデータベースとのやり取りを行う
		taskRepository.delete(taskId);
		
		//完了メッセージをセット
		String completeMessage = Constants.DELETE_COMPLETE;
		return completeMessage;
	}

}
