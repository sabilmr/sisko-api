package practice.project.siskoapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import practice.project.siskoapi.model.entity.JurusanEntity;

@Repository
public interface JurusanRepo extends JpaRepository<JurusanEntity, String> {
}
