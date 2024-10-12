package practice.project.siskoapi.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "t_jurusan")
public class JurusanEntity {
    @Id
    @Column(name = "id", length = 36)
    private String id;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @Column(name = "fakultas_id", length = 36, insertable = false, updatable = false)
    private String fakultasId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fakultas_id")
    private FakultasEntity fakultas;

    public JurusanEntity(String id, String code, String name) {
        this.id = UUID.randomUUID().toString();
        this.code = code;
        this.name = name;
    }
}
