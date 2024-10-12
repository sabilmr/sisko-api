package practice.project.siskoapi.service;

import practice.project.siskoapi.model.request.JurusanReq;
import practice.project.siskoapi.model.response.JurusanRes;

import java.util.List;
import java.util.Optional;

public interface JurusanService {
    List<JurusanRes> get();
    Optional<JurusanRes> getbyId(String id);
    Optional<JurusanRes> save(JurusanReq request);
    Optional<JurusanRes> update(String id, JurusanReq request);
    Optional<JurusanRes> delete(String id);

}
