package practice.project.siskoapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import practice.project.siskoapi.model.request.FakultasReq;
import practice.project.siskoapi.model.response.FakultasRes;
import practice.project.siskoapi.model.response.Response;
import practice.project.siskoapi.service.FakultasService;

@RestController
@RequestMapping("/api/v1/fakultas")
@RequiredArgsConstructor
public class FakultasController extends BaseController<FakultasRes>{
    private final FakultasService fakultasService;

    @GetMapping
    private ResponseEntity<Response> get() {
        var result = fakultasService.get();

        return this.get(result);
    }

    @GetMapping("/{id}")
    private ResponseEntity<Response> getById(@PathVariable("id") String id) {
        var result = fakultasService.getById(id);
        return getResponse(result);
    }

    @PostMapping
    private ResponseEntity<Response> save(@RequestBody FakultasReq request) {
        var result = fakultasService.save(request);
        return getResponse(result);
    }

    @PatchMapping("/{id}")
    private ResponseEntity<Response> update(@PathVariable("id") String id, @RequestBody FakultasReq request) {
        var result = fakultasService.update(request, id);
        return getResponse(result);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Response> delete(@PathVariable("id") String id) {
        var result = fakultasService.delete(id);
        return getResponse(result);
    }
}
