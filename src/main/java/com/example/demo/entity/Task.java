package com.example.demo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

/**
 * タスクエンティティクラス
 */

public class Task {
	
    @Id // ✅ 主キーを指定
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ✅ 自動採番
	
	// タスクID
    /**
     * タスクID（自動インクリメントされる一意の識別子）。
     */
	private int taskId;

	// タイトル
    /**
     * タスクのタイトル。
     */
	private String title;

	// 説明
    /**
     * タスクの説明。
     */
	private String description;

	// 期限
    /**
     * タスクの締め切り日時。
     */
	private LocalDateTime deadline;

	// ステータス
    /**
     * タスクのステータス（例: 1 - 未着手, 2 - 作業中, 3 - 完了）。
     */
	private int status;

	// ユーザーID
    /**
     * ユーザーID（タスクを所有するユーザーの識別子）。
     */
	private int userId;

	// 削除フラグ
    /**
     * 削除フラグ（タスクが削除されたかどうかを示す）。
     */
	private boolean deleteFlg;

	// 更新日時
    /**
     * タスクの更新日時（更新時に現在の日時に自動設定）。
     */
	private LocalDateTime updateTime;

	// 作成日時
    /**
     * タスクの作成日時（デフォルトは現在の日時）。
     */
	private LocalDateTime createTime;

	// ここから下のメソッド、getだけだったりsetだけだったりした。戻り値指定してなかったり、引数指定してなかったりもした
	// getterとsetterについての理解が浅い
	//てかgetter・setter自動生成の機能忘れてた。右クリ、ソース、gettersetter生成で行ける。まあ理解深められて良い機会だ

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

	public void setDiscription(String description) {
		this.description = description;
	}

	public LocalDateTime getDeadline() {
		return deadline;
	}

	public void setDeadline(LocalDateTime deadline) {
		this.deadline = deadline;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public boolean getDeleteFlg() {
		return deleteFlg;
	}

	public void setDeleteFlg(boolean deleteFlg) {
		this.deleteFlg = deleteFlg;
	}

	public LocalDateTime getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(LocalDateTime updateTime) {
		this.updateTime = updateTime;
	}

	public LocalDateTime getCreateTime() {
		return createTime;
	}

	public void setCreateTime(LocalDateTime createTime) {
		this.createTime = createTime;
	}

}
