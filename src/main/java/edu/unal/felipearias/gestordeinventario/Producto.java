
package edu.unal.felipearias.gestordeinventario;
import java.util.Objects;

public class Producto implements Comparable<Producto>{
    private String sku;
    private String nombre;
    private double precio;
    private int cantidad;
    private String ubicacion;
    
    public Producto(String sku, String nombre, double precio, int cantidad, String ubicacion){
        this.sku = sku;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.ubicacion = ubicacion;
    }
    public String getSku() {
        return sku;
    }
    public String getNombre() {
        return nombre;
    }
    public double getPrecio() {
        return precio;
    }
    public int getCantidad() {
        return cantidad;
    }
    public String getUbicacion() {
        return ubicacion;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
    
    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return Objects.equals(sku, producto.sku);
    }
    
    @Override 
    public int compareTo(Producto otro){
        if (this.sku == null && otro.sku == null) return 0;
        if (this.sku == null) return -1;
        if (otro.sku == null) return 1;
        return this.sku.compareTo(otro.sku);
    }
    
    @Override 
    public String toString(){
        return "Producto: " + "sku = " + sku + ", nombre = " + nombre + ", precio = " + precio + ", cantidad = " + cantidad + ", ubicacion = " + ubicacion;
}}