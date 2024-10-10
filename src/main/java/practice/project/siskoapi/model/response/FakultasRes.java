package practice.project.siskoapi.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import practice.project.siskoapi.model.entity.FakultasEntity;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FakultasRes {
    private String id;
    private String code;
    private String name;

}
