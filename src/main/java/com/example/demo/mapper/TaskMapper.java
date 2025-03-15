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

}
