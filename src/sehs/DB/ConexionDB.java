/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sehs.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author SEHS - TI
 */
public class ConexionDB {
    private String driver="org.postgresql.Driver";
    private String protocolo="jdbc:postgresql";
    private String servidor="localhost:5432";
    private String usuario="postgres";
    private String contrasena="postgres";
    private String bd="sehsFINAL";
    private Connection conexion;
    private Statement sentencia;
    private ResultSet resultado;
    
    /**
     * Constructor de la clase
     * @param driver
     * @param protocolo
     * @param servidor
     * @param bd
     * @param usuario
     * @param contrasena
     */
    public ConexionDB(String driver, String protocolo, String servidor, String bd, String usuario, String contrasena) {
        setDriver(driver);
        setProtocolo(protocolo);
        setServidor(servidor);
        setBd(bd);
        setUsuario(usuario);
        setContrasena(contrasena);
    }
    
    /*Inicio declaración de set's y get's*/
    public Connection getConexion() {
        return conexion;
    }
    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }
    public final void setDriver(String driv){
        driver=driv;
    }
    public final void setProtocolo(String prot){
        protocolo=prot;
    }
    public final void setServidor(String server){
        servidor=server;
    }
    public final void setUsuario(String user){
        usuario=user;
    }
    public final void setContrasena(String pass){
        contrasena=pass;
    }
    public final void setBd(String basedatos){
        bd=basedatos;
    }
    public final String getDriver(){
        return driver;
    }
    public final String getProtocolo(){
        return protocolo;
    }
    public final String getServidor(){
        return servidor;
    }
    public final String getUsuario(){
        return usuario;
    }
    public final String getContrasena(){
        return contrasena;
    }
    public final String getBd(){
        return bd;
    }
    /*Fin declaración de set's y get's*/
    
    /**
     * Método que realiza la conexión a la BD usando los parámetros de la clase
     * @return boolean 
     */
    public boolean conectar() {
        boolean conectado = false;
        try {
           Class.forName(driver).newInstance();
           conexion = DriverManager.getConnection(protocolo+"://" + servidor + "/" + bd, usuario, contrasena);
           conectado=true;
           System.out.println("Clase conexión: conexión exitosa");
           sentencia=conexion.createStatement();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
           System.out.println("Error: "+ e.getMessage());
        }
        return conectado;
    }
    
    /**
     * Método que realiza la desconexión con la BD.
     * @return boolean
     */
    public boolean desconectar(){
        boolean desconecta=false;
        try {
           conexion.close();
           desconecta=true;
           System.out.println("Clase conexión: desconexión exitosa");
        } catch (SQLException e) {
           System.out.println("Error: " + e.getMessage());
        }
        return desconecta;
    }
    /**
     * Método que realiza una consulta a la BD, retornando un objeto Resulset donde
     * contiene los resultados de la consulta
     * @param query
     * @return Resulset
     */
    public ResultSet RealizarConsulta(String query){
        try{
            resultado = sentencia.executeQuery(query);
        }catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return resultado;
    }
    
    /**
     * Método que agrega registros a la base de datos indicando en la sentencia
     * que recibe como parámetro.
     * @param query
     */
    public void IngresarDatos(String query){
        try{
            sentencia.execute(query);
        }catch (SQLException e) {
            JOptionPane.showMessageDialog( null,e.getMessage().substring(26,76),"Error",JOptionPane.ERROR_MESSAGE);
            //System.out.println(e.getMessage().substring(26,76));
        }
    }
    
    /**
     * Método que agrega registros a la BD, pero con validación que indica si la
     * instrucción fue o no realizada con éxito
     * @param query
     * @return boolean 
     */
    public boolean agregarDatosBD(String query){
        boolean realizado;
        try{
            realizado = true;
            sentencia.execute(query);
        }catch (SQLException e) {
            realizado =  false;
            JOptionPane.showMessageDialog( null,e.getMessage().substring(26,76),"Error",JOptionPane.ERROR_MESSAGE);
            //System.out.println(e.getMessage().substring(26,76));
        }
        return realizado;
    }
    
    /**
     * Método que elimina uno o más registros de la BD usando la instrucción recibida
     * retorna verdadero falso, dependiendo si la instrucción fue o no realizada correctamente
     * @param query
     * @return boolean 
     */
    public boolean eliminarDatos(String query){
        boolean eliminado;
        try{            
            sentencia.execute(query);
            eliminado=true;
        }catch (SQLException e) {
            eliminado=false;
            System.out.println(e.getMessage().substring(26,32));
        }
        return eliminado;
    }
    
    /**
     * Método que actualiza un registro en la BD indicando con un booleano si la
     * actualización se realizó con éxito o no.
     * @param query
     * @return boolean
     */
    public boolean actualizarDatos(String query){
        boolean realizado;
        try{
            sentencia.execute(query);
            realizado = true;
        }catch (SQLException e) {
            realizado=false;
            System.out.println(e.getMessage());
        }
        return realizado;
    }


    
}
