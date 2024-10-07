package practice.project.siskoapi.service;

import practice.project.siskoapi.model.request.FakultasReq;
import practice.project.siskoapi.model.response.FakultasRes;

import java.util.List;
import java.util.Optional;

public interface FakultasService {
    List<FakultasRes> get();
    Optional<FakultasRes> getById(String id);
    Optional<FakultasRes> save(FakultasReq request);
    Optional<FakultasRes> update(FakultasReq request, String id);
    Optional<FakultasRes> delete(String id);
}
