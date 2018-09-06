/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sehs.DTO;

/**
 *
 * @author SEHS - TI
 */
public class EmpresaTO {
      private long empresaid ;
    private String nombre;
    private String ruc;
    private String direccion;
    private String url;
    //d
    public EmpresaTO(){
        
    }

    public EmpresaTO(long empresaid, String nombre, String ruc, String direccion, String url) {
        this.empresaid = empresaid;
        this.nombre = nombre;
        this.ruc = ruc;
        this.direccion = direccion;
        this.url = url;
    }

    public long getEmpresaid() {
        return empresaid;
    }

    public void setEmpresaid(long empresaid) {
        this.empresaid = empresaid;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    
}
