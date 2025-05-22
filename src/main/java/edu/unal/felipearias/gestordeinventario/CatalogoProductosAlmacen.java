package edu.unal.felipearias.gestordeinventario;
import java.util.TreeSet;
import java.util.Comparator;

public class CatalogoProductosAlmacen {
    private TreeSet<Producto> productosPorSku;

    public CatalogoProductosAlmacen() {
        this.productosPorSku = new TreeSet<>();
    }

    public boolean agregarProducto(Producto producto) {
        return productosPorSku.add(producto);
    }


    public boolean eliminarProductoPorSku(String sku) {
        Producto productoDummy = new Producto(sku, null, 0, 0, null);
        return productosPorSku.remove(productoDummy);
    }

    public Producto obtenerProductoPorSku(String sku) {
        Producto productoABuscar = new Producto(sku, null, 0, 0, null);
        Producto encontrado = productosPorSku.ceiling(productoABuscar);
        if (encontrado != null && encontrado.getSku().equals(sku)) {
            return encontrado;
        }
        return null;
    }

    public void listarTodosLosProductos() {
        System.out.println("\n--- Catalogo de Productos (Ordenado por SKU) ---");
        if (productosPorSku.isEmpty()) {
            System.out.println("El catalogo está vacío.");
            return;
        }
        for (Producto producto : productosPorSku) {
            System.out.println(producto); // Usa el método toString() de Producto.
        }
        System.out.println("----------------------------------------------");
    }

    public void encontrarProductosEnRangoSku(String skuInicio, String skuFin) {
        System.out.println("\n--- Productos en Rango de SKU [" + skuInicio + " a " + skuFin + "] ---");
        Producto inicio = new Producto(skuInicio, null, 0, 0, null);
        Producto fin = new Producto(skuFin, null, 0, 0, null);
        for (Producto producto : productosPorSku.subSet(inicio, true, fin, true)) {
            System.out.println(producto);
        }
        System.out.println("---------------------------------------------");
    }

    public static void main(String[] args) {
        CatalogoProductosAlmacen catalogo = new CatalogoProductosAlmacen();

        System.out.println("Agregando productos al catalogo:");
        catalogo.agregarProducto(new Producto("SKU005", "Martillo", 12.50, 100, "A1-S1"));
        catalogo.agregarProducto(new Producto("SKU001", "Set Destornilladores", 25.00, 50, "A2-S3"));
        catalogo.agregarProducto(new Producto("SKU010", "Kit Llaves Inglesas", 45.00, 30, "A1-S2"));
        catalogo.agregarProducto(new Producto("SKU003", "Cinta Metrica", 8.75, 200, "A3-S1"));
        catalogo.agregarProducto(new Producto("SKU007", "Brocas", 15.00, 75, "A2-S1"));

        // Intentar agregar un duplicado (será ignorado por TreeSet).
        System.out.println("Intentando agregar SKU001 de nuevo: " + catalogo.agregarProducto(new Producto("SKU001", "Otro Destornillador", 20.00, 40, "A2-S3")));

        catalogo.listarTodosLosProductos();

        System.out.println("\nBuscando Producto con SKU003: " + catalogo.obtenerProductoPorSku("SKU003"));
        System.out.println("Buscando Producto con SKU099 (no existe): " + catalogo.obtenerProductoPorSku("SKU099"));

        System.out.println("\nEliminando Producto con SKU005: " + catalogo.eliminarProductoPorSku("SKU005"));
        catalogo.listarTodosLosProductos();

        catalogo.encontrarProductosEnRangoSku("SKU003", "SKU007"); // Rango inclusivo.
        catalogo.encontrarProductosEnRangoSku("SKU001", "SKU004"); // Rango inclusivo.
    }
}

