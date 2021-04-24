package seminario.serminarioproyecto.model;

import lombok.Data;
import seminario.serminarioproyecto.dto.ResultDTO;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "queja")
@NamedNativeQueries({
        @NamedNativeQuery(        name = "quejasPorComercio",
                query = "SELECT COUNT(*) cantidad,c.nombre " +
                        "FROM queja a " +
                        "INNER JOIN sucursal b " +
                        "ON a.id_sucursal=b.id_sucursal " +
                        "INNER JOIN comercio c " +
                        "ON b.id_comercio=c.id_comercio " +
                        "GROUP BY c.nombre " +
                        "ORDER BY cantidad ",
                resultSetMapping = "quejasPorComercio"),
        @NamedNativeQuery(
                name = "quejasPorMunicipio",
                query = "SELECT COUNT(*) cantidad,c.nombre " +
                        "FROM queja a " +
                        "INNER JOIN sucursal b " +
                        "ON a.id_sucursal=b.id_sucursal " +
                        "INNER JOIN municipio c " +
                        "ON b.id_municipio=c.id_municipio " +
                        "GROUP BY c.nombre ",
                resultSetMapping = "quejasPorMunicipio"
        ),
        @NamedNativeQuery(
                name = "quejasPorDepartamento",
                query = "SELECT COUNT(*) cantidad,d.nombre " +
                        "FROM queja a " +
                        "INNER JOIN sucursal b " +
                        "ON a.id_sucursal=b.id_sucursal " +
                        "INNER JOIN municipio c " +
                        "ON b.id_municipio=c.id_municipio " +
                        "INNER JOIN departamento d " +
                        "ON c.id_dep=d.id_dep " +
                        "GROUP BY d.nombre",
                resultSetMapping = "quejasPorDepartamento"
        ),
        @NamedNativeQuery(
                name = "quejasPorRegion",
                query = "SELECT COUNT(*) cantidad,e.nombre " +
                        "FROM queja a " +
                        "INNER JOIN sucursal b " +
                        "ON a.id_sucursal=b.id_sucursal " +
                        "INNER JOIN municipio c " +
                        "ON b.id_municipio=c.id_municipio " +
                        "INNER JOIN departamento d " +
                        "ON c.id_dep=d.id_dep " +
                        "INNER JOIN region e " +
                        "ON d.id_region=e.id_region " +
                        "GROUP BY e.nombre ",
                resultSetMapping = "quejasPorRegion"
        )
})
@SqlResultSetMappings({
        @SqlResultSetMapping(
                name = "quejasPorComercio",
                classes = @ConstructorResult(
                        targetClass = ResultDTO.class,
                        columns = {
                                @ColumnResult(name = "cantidad", type = Integer.class),
                                @ColumnResult(name = "nombre", type = String.class)
                        }
                )
        ),
        @SqlResultSetMapping(
                name = "quejasPorMunicipio",
                classes = @ConstructorResult(
                        targetClass = ResultDTO.class,
                        columns = {
                                @ColumnResult(name = "cantidad", type = Integer.class),
                                @ColumnResult(name = "nombre", type = String.class)
                        }
                )
        ),
        @SqlResultSetMapping(
                name = "quejasPorDepartamento",
                classes = @ConstructorResult(
                        targetClass = ResultDTO.class,
                        columns = {
                                @ColumnResult(name = "cantidad", type = Integer.class),
                                @ColumnResult(name = "nombre", type = String.class)
                        }
                )
        ),
        @SqlResultSetMapping(
                name = "quejasPorRegion",
                classes = @ConstructorResult(
                        targetClass = ResultDTO.class,
                        columns = {
                                @ColumnResult(name = "cantidad", type = Integer.class),
                                @ColumnResult(name = "nombre", type = String.class)
                        }
                )
        )
})

public class Queja implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_queja")
    private Integer id;

    private String descripcion;

    private LocalDateTime fecha;

    @ManyToOne
    @JoinColumn(name = "id_sucursal", referencedColumnName = "id_sucursal")
    private Sucursal sucursal;
}
