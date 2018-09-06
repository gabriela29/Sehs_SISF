/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sehs.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sehs.DB.ConexionDB;
import sehs.DTO.EmpresaTO;

/**
 *
 * @author SEHS - TI
 */
public class EmpleadoDAO {

    ConexionDB conectarDB = new ConexionDB("org.postgresql.Driver", "jdbc:postgresql",
            "localhost:5432", "sehsFINAL", "postgres", "postgres");

    public ConexionDB getConectarDB() {
        return conectarDB;
    }

    public void setConectarDB(ConexionDB conectarDB) {
        this.conectarDB = conectarDB;
    }

    public boolean GuardarNuevoRegistro(EmpresaTO reg) {
        conectarDB.conectar();
        boolean guardado = conectarDB.agregarDatosBD("insert into basic.empresa(empresaid, nombre, ruc, direccion, url) "
                + "values(" + reg.getEmpresaid() + ","
                + "'" + reg.getNombre() + "','" + reg.getRuc() + "'," + reg.getDireccion() + ",'" + reg.getUrl() + "');");
        conectarDB.desconectar();
        return guardado;
    }
    
    public void cargarRegistrosTablas(javax.swing.JTable pac, int idemp) throws SQLException{
        EmpresaTO lista[];
        lista = obtenerTodosRegistros(idemp);
        for (EmpresaTO reg : lista) {
            DefaultTableModel tabla=(DefaultTableModel)pac.getModel();
            String[] r=new String[5];
            r[0] = Integer.toString((int) reg.getEmpresaid());
            r[1] = reg.getNombre();
            r[2] = reg.getRuc();
            r[3] = reg.getDireccion();
            r[4] = reg.getUrl();
            tabla.addRow(r);
        }
    
}

    private EmpresaTO[] obtenerTodosRegistros(int idemp) throws SQLException {
        EmpresaTO lista[];
        conectarDB.conectar();
       int numPac = Integer.parseInt(obtenerCampo(conectarDB.RealizarConsulta("select count(*) from basic.empresa where empresaid="+idemp+";"),"count"));
      lista = new EmpresaTO[numPac];
        ResultSet consulta;
        consulta = conectarDB.RealizarConsulta("select * from basic.empresa where empresaid="+idemp+";");
        try {
            int i=0;
            while(consulta.next()){
                lista[i]=new EmpresaTO();
                lista[i].setEmpresaid(Integer.parseInt(consulta.getString("empresaid")));
                lista[i].setNombre(consulta.getString("nombre"));
                lista[i].setRuc(consulta.getString("ruc"));
                lista[i].setDireccion(consulta.getString("direccion"));
                lista[i].setUrl(consulta.getString("url"));
                i++;
            }
        } catch (SQLException ex) {
            System.out.println("Error: "+ex.getMessage());
        }
        conectarDB.desconectar();
        return lista;
    }

     public String obtenerCampo(ResultSet rel, String campo){
       String valCampo =new String();
       try{
            while(rel.next()){ 
                valCampo=rel.getString(campo);
            }
        } catch (SQLException ex) {
            System.out.println("Error: "+ex.getMessage());
        }
        return valCampo;
    }
     
     
   
     
       public void cargarRegistrosTablasMientrasEscribe(javax.swing.JTable pac, String busqueda, int iduser){
        EmpresaTO lista[];
        borrarContenidoTabla(pac);
        lista = obtenerTodosRegistro(busqueda, iduser);
        for (EmpresaTO temp : lista) {
            DefaultTableModel tabla = (DefaultTableModel)pac.getModel();
            String[] r=new String[4];
            r[0] = Integer.toString((int) temp.getEmpresaid());
            r[1] = temp.getNombre();
            r[2] = temp.getRuc();
            r[2] = temp.getDireccion();
             r[2] = temp.getUrl()        ;
            tabla.addRow(r);
        }
    }
       
        public void borrarContenidoTabla(javax.swing.JTable table){
        DefaultTableModel tab =(DefaultTableModel) table.getModel();
        while(table.getRowCount()>0){
            tab.removeRow(tab.getRowCount()-1);
        }
    }

    private EmpresaTO[] obtenerTodosRegistro(String busqueda, int empid) {
        EmpresaTO lista[];
        conectarDB.conectar();
        int numPac = Integer.parseInt(obtenerCampo(conectarDB.RealizarConsulta(
                "select count(*) from basic.empresa where nombre like '%"+busqueda+"%' and empresaid="+empid+";"),"count"));
        lista = new EmpresaTO[numPac];
        ResultSet consulta;
        consulta = conectarDB.RealizarConsulta("select * from basic.empresa where nombre like '%"+busqueda+"%' and empresaid="+empid+" ;");
        try {
            int i=0;
            while(consulta.next()){
                lista[i]=new EmpresaTO();
                lista[i].setEmpresaid(Integer.parseInt(consulta.getString("empresaid")));
                lista[i].setNombre(consulta.getString("nombre"));
                lista[i].setRuc(consulta.getString("ruc"));
                lista[i].setDireccion(consulta.getString("direccion"));
                lista[i].setUrl(consulta.getString("url"));
                i++;
            }
        } catch (SQLException ex) {
            System.out.println("Error: "+ex.getMessage());
        }
        conectarDB.desconectar();
        return lista;
    }

 public void actualizarDatosGenerales(EmpresaTO pac){
        boolean actualizado;
        conectarDB.conectar();
        actualizado=conectarDB.actualizarDatos("UPDATE basic.empresa\n" +
                            " SET nombre='"+pac.getNombre()+"',\n" +
                            " ruc='"+pac.getRuc()+"', \n" +
                            " direccion="+pac.getDireccion()+"\n" +
                            " url="+pac.getUrl()+"\n" +
                            " WHERE empresaid="+pac.getEmpresaid()+";");
        if(actualizado){
            JOptionPane.showMessageDialog(null, "El registro ha sido actualizado correctamente.","Actulizando información",JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, "Ocurrió un eror al actulizar","Error", JOptionPane.ERROR_MESSAGE);
        }
        conectarDB.desconectar();
    }
    
 public void eliminarRegistros (EmpresaTO regeliminar){
     boolean eliminado;
     conectarDB.conectar();
     eliminado = conectarDB.eliminarDatos("delete from public.listanegra where id="+regeliminar.getEmpresaid()+";");
        if(eliminado){
            JOptionPane.showMessageDialog(null, "El registro ha sido eliminado.","Eliminando información",JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, "Ocurrió un eror al eliminar.","Error", JOptionPane.ERROR_MESSAGE);
        }
        conectarDB.desconectar();
 }
 
 
 
}
