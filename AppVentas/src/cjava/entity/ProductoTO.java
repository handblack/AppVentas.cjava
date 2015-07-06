
package cjava.entity;

public class ProductoTO {
  // atributos
  private String idproducto;
  private String descripcion;
  private int idcategoria;
  private double preciocompra;
  private double precioventa;
  private int stock;
  // constructor

  public ProductoTO() {
  }

  public ProductoTO(String idproducto, String descripcion, int idcategoria, double preciocompra, double precioventa, int stock) {
    this.idproducto = idproducto;
    this.descripcion = descripcion;
    this.idcategoria = idcategoria;
    this.preciocompra = preciocompra;
    this.precioventa = precioventa;
    this.stock = stock;
  }
  // metodos get y set

  public String getIdproducto() {
    return idproducto;
  }

  public void setIdproducto(String idproducto) {
    this.idproducto = idproducto;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public int getIdcategoria() {
    return idcategoria;
  }

  public void setIdcategoria(int idcategoria) {
    this.idcategoria = idcategoria;
  }

  public double getPreciocompra() {
    return preciocompra;
  }

  public void setPreciocompra(double preciocompra) {
    this.preciocompra = preciocompra;
  }

  public double getPrecioventa() {
    return precioventa;
  }

  public void setPrecioventa(double precioventa) {
    this.precioventa = precioventa;
  }

  public int getStock() {
    return stock;
  }

  public void setStock(int stock) {
    this.stock = stock;
  }
  
}
