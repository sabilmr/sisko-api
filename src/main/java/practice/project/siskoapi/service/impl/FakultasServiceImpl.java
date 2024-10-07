package practice.project.siskoapi.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import practice.project.siskoapi.model.entity.FakultasEntity;
import practice.project.siskoapi.model.request.FakultasReq;
import practice.project.siskoapi.model.response.FakultasRes;
import practice.project.siskoapi.repository.FakultasRepo;
import practice.project.siskoapi.service.FakultasService;

import java.util.*;
import java.util.stream.Collectors;

@Service
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
        return Optional.empty();
    }

    @Override
    public Optional<FakultasRes> save(FakultasReq request) {
        return Optional.empty();
    }

    @Override
    public Optional<FakultasRes> update(FakultasReq request, String id) {
        return Optional.empty();
    }

    @Override
    public Optional<FakultasRes> delete(String id) {
        return Optional.empty();
    }

    private FakultasRes convertEntityToRes(FakultasEntity entity) {
        FakultasRes res = new FakultasRes();

        BeanUtils.copyProperties(entity, res);
        res.setId(UUID.randomUUID().toString());

        return res;

    }
}
