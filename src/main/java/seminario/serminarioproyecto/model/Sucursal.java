package seminario.serminarioproyecto.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "sucursal")
public class Sucursal implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sucursal")
    private Integer id;

    private String nombre;

    private String direccion;

    @ManyToOne
    @JoinColumn(name = "id_municipio", referencedColumnName = "id_municipio")
    private Municipio municipio;

    @ManyToOne
    @JoinColumn(name = "id_comercio", referencedColumnName = "id_comercio")
    private Comercio comercio;
}
