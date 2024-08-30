package com.TaskManager.Assessment.Repository;
import com.TaskManager.Assessment.models.Project;
import com.TaskManager.Assessment.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    List<Project> findByOwner(User owner);
}
