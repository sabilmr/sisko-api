package practice.project.siskoapi.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import practice.project.siskoapi.model.entity.FakultasEntity;
import practice.project.siskoapi.model.entity.JurusanEntity;
import practice.project.siskoapi.model.request.FakultasReq;
import practice.project.siskoapi.model.response.FakultasRes;
import practice.project.siskoapi.model.response.JurusanRes;
import practice.project.siskoapi.repository.FakultasRepo;
import practice.project.siskoapi.service.FakultasService;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class FakultasServiceImpl implements FakultasService {
    private final FakultasRepo repo;

    @Override
    public List<FakultasRes> get() {
        List<FakultasEntity> entities = repo.findAll();
        if (entities.isEmpty()) {
            return Collections.emptyList();
        }
        return entities.stream()
                .map(this::convertEntityToRes)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<FakultasRes> getById(String id) {
        FakultasEntity entity = repo.findById(id).orElse(null);
        if (entity == null) {
            return Optional.empty();
        }
        return Optional.of(convertEntityToRes(entity));
    }

    @Override
    public Optional<FakultasRes> save(FakultasReq request) {
        FakultasEntity result = new FakultasEntity();

        BeanUtils.copyProperties(request, result);
        result.setId(UUID.randomUUID().toString());
        try {
            repo.save(result);
            log.info("Save fakultas success");
            return Optional.of(this.convertEntityToRes(result));
        }catch (Exception e) {
            log.error("Save fakultas failed, error : {}", e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<FakultasRes> update(FakultasReq request, String id) {
        FakultasEntity entity = this.repo.findById(id).orElse(null);
        if (entity == null) {
            return Optional.empty();
        }

        convertReqToEntity(request, entity);
        entity.setId(id);
        try {
            repo.save(entity);
            log.info("Update fakultas success");
            return Optional.of(this.convertEntityToRes(entity));
        } catch (Exception e) {
            log.error("Update fakultas failed, error : {}", e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<FakultasRes> delete(String id) {
        FakultasEntity entity = this.repo.findById(id).orElse(null);
        if (entity == null) {
            return Optional.empty();
        }
        try {
            repo.delete(entity);
            log.info("Delete fakultas success");
            return Optional.of(this.convertEntityToRes(entity));
        }catch (Exception e) {
            log.error("Delete fakultas failed, error : {}", e.getMessage());
            return Optional.empty();
        }
    }

    private FakultasRes convertEntityToRes(FakultasEntity entity) {
        FakultasRes res = new FakultasRes();

        BeanUtils.copyProperties(entity, res);
        if (!entity.getJurusan().isEmpty()) {
            List<JurusanRes> jurusan = new ArrayList<>();
            for (JurusanEntity majorsEntity : entity.getJurusan()) {
                JurusanRes result = new JurusanRes();

                BeanUtils.copyProperties(majorsEntity, result);
                result.setFakultasName(res.getName());
                jurusan.add(result);
            }

            res.setJurusan(jurusan);
        }

        return res;

    }

    private FakultasEntity convertReqToEntity(FakultasReq request) {
        FakultasEntity entity = repo.findById(request.getId()).orElse(null);
        if (entity == null) {
            return null;
        }

        BeanUtils.copyProperties(request, entity);
        return entity;
    }

    private void convertReqToEntity(FakultasReq request, FakultasEntity entity) {
        BeanUtils.copyProperties(request, entity);
    }
}
