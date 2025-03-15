package com.example.demo.common;

public class Constants {

	// インスタンスの生成禁止
	private Constants() {

	}

	// staticをつけると、クラスをインスタンス化せず定数にアクセスすることが出来る
	// 変数名は大文字とアンスコで付けるのが慣習
	public static final String REGISTER_COMPLETE = "The data was successfully saved.";
	public static final String EDIT_COMPLETE = "The data was successfully updated.";
	public static final String DELETE_COMPLETE = "The data was successfully deleted.";
	public static final String ERROR_MESSAGE = "エラーが発生しました.";
	public static final String ILLEGALARGUMENTEXCEPTION_ERROR = "タスクIDは正の整数である必要があります。";

}
