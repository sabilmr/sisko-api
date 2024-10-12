package practice.project.siskoapi.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JurusanReq {
    private String id;
    private String  code;
    private String name;
}
