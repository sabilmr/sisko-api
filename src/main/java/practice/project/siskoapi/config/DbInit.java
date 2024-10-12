package practice.project.siskoapi.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import practice.project.siskoapi.model.entity.FakultasEntity;
import practice.project.siskoapi.model.entity.JurusanEntity;
import practice.project.siskoapi.repository.FakultasRepo;
import practice.project.siskoapi.repository.JurusanRepo;

@Component
@Slf4j
@RequiredArgsConstructor
public class DbInit implements CommandLineRunner {
    private final FakultasRepo fakultasRepo;

    @Override
    public void run(String... args) throws Exception {
        initFakultas();

    }

    private void initFakultas() {
        if (fakultasRepo.count() > 0) {
            return;
        }

        FakultasEntity fakultas = new FakultasEntity("", "P0001", "FAKULTAS TEKNIK");

        JurusanEntity it = new JurusanEntity("", "J0001","JURUSAN IT");
        JurusanEntity hukum = new JurusanEntity("", "J0002","JURUSAN HUKUM");

        fakultas.addJurusan(it);
        fakultas.addJurusan(hukum);

        try {
            fakultasRepo.save(fakultas);
            log.info("Save Fakultas Successfully");
        } catch (Exception e) {
            log.error("Save Fakultas Failed : {}", e.getMessage());
        }
        }
}
