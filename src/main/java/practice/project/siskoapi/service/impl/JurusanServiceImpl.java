package practice.project.siskoapi.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import practice.project.siskoapi.model.entity.JurusanEntity;
import practice.project.siskoapi.model.request.JurusanReq;
import practice.project.siskoapi.model.response.JurusanRes;
import practice.project.siskoapi.repository.JurusanRepo;
import practice.project.siskoapi.service.JurusanService;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class JurusanServiceImpl implements JurusanService {
    private final JurusanRepo jurusan;

    @Override
    public List<JurusanRes> get() {
        List<JurusanEntity> result = this.jurusan.findAll();
        if (result.isEmpty()) {
            return Collections.emptyList();
        }

        return result.stream()
                .map(this::convertEntityToRes)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<JurusanRes> getbyId(String id) {
        return Optional.empty();
    }

    @Override
    public Optional<JurusanRes> save(JurusanReq request) {
        return Optional.empty();
    }

    @Override
    public Optional<JurusanRes> update(String id, JurusanReq request) {
        return Optional.empty();
    }

    @Override
    public Optional<JurusanRes> delete(String id) {
        return Optional.empty();
    }

    private JurusanRes convertEntityToRes(JurusanEntity entity) {
        JurusanRes result = new JurusanRes();

        BeanUtils.copyProperties(entity, result);
        if (entity.getFakultas() != null) {
            result.setFakultasId(entity.getFakultas().getId());
            result.setFakultasName(entity.getFakultas().getName());
        }
        return result;
    }
}
