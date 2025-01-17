package practice.project.siskoapi.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FakultasRes {
    private String id;
    private String code;
    private String name;
    private List<JurusanRes> jurusan = new ArrayList<>();

}
