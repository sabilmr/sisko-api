package practice.project.siskoapi.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JurusanRes {
    private String id;
    private String  code;
    private String name;
    private String fakultasId;
    private String fakultasName;

}
