package seminario.serminarioproyecto.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "municipio")
public class Municipio implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_municipio")
    private Integer id;

    private String nombre;

    @ManyToOne
    @JoinColumn(name = "id_dep", referencedColumnName = "id_dep")
    private Departamento departamento;
}
