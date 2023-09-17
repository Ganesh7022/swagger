package com.newSwagger.repository;

// TaskRepository.java

import com.newSwagger.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
