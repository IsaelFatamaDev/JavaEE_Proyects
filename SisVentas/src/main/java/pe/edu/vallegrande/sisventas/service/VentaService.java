package pe.edu.vallegrande.sisventas.service;

import pe.edu.vallegrande.sisventas.db.AccesoDB;
import pe.edu.vallegrande.sisventas.dto.DetalleDto;
import pe.edu.vallegrande.sisventas.dto.VentaDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class VentaService {
    public VentaDto registrarVenta(VentaDto ventaDto, List<DetalleDto> items){
        // Variables
        Connection cn = null;
        String sql;
        PreparedStatement pstm;
        // Proceso
        try {
            // Inicio de la Tx
            cn = AccesoDB.getConnection();
            cn.setAutoCommit(false);
            // Registrar la venta
            sql = "insert into venta(idemp,cliente,fecha,importe) values(?,?,?,?)";
            pstm = cn.prepareStatement(sql);
            pstm.setInt(1, ventaDto.getIdempleado());
            pstm.setString(2,ventaDto.getCliente());
            // Usar la fecha y hora actual
            pstm.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
            pstm.setDouble(4,ventaDto.getImporte());
            pstm.executeUpdate();
            // Fin de Tx
            cn.commit();
        } catch (SQLException e){
            try {
                cn.rollback();
            }catch(Exception e1){}
            throw new RuntimeException(e.getMessage());
        } catch(Exception e){
            try {
                cn.rollback();
            }catch(Exception e1){}
            throw new RuntimeException("Error en el proceso, intentelo nuevamente.");
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch(Exception e){}
        }

        return ventaDto;
    }
}
