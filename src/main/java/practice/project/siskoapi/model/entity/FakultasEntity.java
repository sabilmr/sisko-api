package practice.project.siskoapi.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "t_fakultas")
public class FakultasEntity {
    @Id
    @Column(name = "id", length = 36)
    private String id;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "fakultas", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<JurusanEntity> jurusan = new ArrayList<>();

    public FakultasEntity(String id, String code, String name) {
        this.id = UUID.randomUUID().toString();
        this.code = code;
        this.name = name;
    }

    public void addJurusan(JurusanEntity jurusan) {
        this.jurusan.add(jurusan);
        jurusan.setFakultas(this);
    }
}
