package seminario.serminarioproyecto.model;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "departamento")
public class Departamento implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_dep")
    private Integer id;

    private String nombre;

    @ManyToOne
    @JoinColumn(name = "id_pais", referencedColumnName = "id_pais")
    private Pais pais;

    @ManyToOne
    @JoinColumn(name = "id_region", referencedColumnName = "id_region")
    private Region region;


}
