package practice.project.siskoapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import practice.project.siskoapi.model.response.JurusanRes;
import practice.project.siskoapi.model.response.Response;
import practice.project.siskoapi.service.JurusanService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/jurusan")
public class JurusanController extends BaseController<JurusanRes> {
    private final JurusanService jurusanService;

    @GetMapping
    private ResponseEntity<Response> get() {
        var result = jurusanService.get();
        return this.get(result);
    }
}
