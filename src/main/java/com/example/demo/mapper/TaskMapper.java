package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.Task;

@Mapper
public interface TaskMapper {
	List<Task> findAll();

	void save(Task task);

	Task getTask(int taskId);

	int update(Task task);

	int delete(int taskId);//Q.なぜint？A.削除操作に成功した行数を返すため

}
