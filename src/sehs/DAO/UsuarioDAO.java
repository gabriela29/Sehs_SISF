/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sehs.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import sehs.DB.ConexionDB;
import sehs.DTO.UsuarioTO;

/**
 *
 * @author SEHS - TI
 */
public class UsuarioDAO {


    ConexionDB conectarDB = new ConexionDB("org.postgresql.Driver", "jdbc:postgresql",
            "localhost:5432", "sehsFINAL", "postgres", "postgres");

    public ConexionDB getConectarDB() {
        return conectarDB;
    }

    public void setConectarDB(ConexionDB conectarDB) {
        this.conectarDB = conectarDB;
    }

    public UsuarioTO validateUser (String usuario, String clave){
        UsuarioTO userLog = new UsuarioTO();
        conectarDB.conectar();
        
        int usrExis = Integer.parseInt(obtenerCampo(conectarDB.RealizarConsulta(
                "select count(*) from basic.clave where usuario='"+usuario+"' and clave='"+clave+"';"),"count"));
        if(usrExis==1){
            ResultSet consulta;
            consulta = conectarDB.RealizarConsulta("select * from basic.clave where usuario='"+usuario+"';");
            try {
                while(consulta.next()){
                    userLog.setUsuario(consulta.getString("usuario"));
                    userLog.setPass(consulta.getString("clave"));
                   
                }
            } catch (SQLException ex) {
                System.out.println("Error: "+ex.getMessage());
            }
        }else{
            JOptionPane.showMessageDialog(null, "El usuario o contraseña incorrecto","Error", JOptionPane.ERROR_MESSAGE);
        }
        conectarDB.desconectar();
        return userLog;
}

    private String obtenerCampo(ResultSet rel, String campo) {
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
}