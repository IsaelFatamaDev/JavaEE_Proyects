package pe.edu.vallegrande.sisventas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class VentaDto {

    private int idventa;
    private int idempleado;
    private String cliente;
    private String fecha;
    private double importe;

    @Override
    public String toString() {
        return "VentaDto{" +
                "idventa=" + idventa +
                ", idempleado=" + idempleado +
                ", cliente='" + cliente + '\'' +
                ", fecha=" + fecha +
                ", importe=" + importe +
                '}';
    }

}
