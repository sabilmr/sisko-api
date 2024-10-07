package practice.project.siskoapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import practice.project.siskoapi.model.entity.FakultasEntity;

public interface FakultasRepo extends JpaRepository<FakultasEntity, String> {

}
