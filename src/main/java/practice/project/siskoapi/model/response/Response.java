package practice.project.siskoapi.model.response;

import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Response<T> {
    private int statusCode;
    private Object message;
    private T data;
}
