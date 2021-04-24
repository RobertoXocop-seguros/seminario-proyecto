package seminario.serminarioproyecto.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultDTO implements  Serializable{

    private Integer cantidad;
    private String nombre;
}
