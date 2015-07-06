package cjava.controller;

import cjava.entity.ProductoTO;
import cjava.model.ProductoDAO;
import java.util.List;

public class ProductoBLL {

  //variable
  ProductoDAO dao;
  //constructor

  public ProductoBLL() {
    dao = new ProductoDAO();
  }

  // metodos de negocio
  public List<ProductoTO> ProductoListar() throws Exception {
    return dao.readAll();
  }

  public List<ProductoTO> ProductoListar(Object o, int op) throws Exception {
    return dao.readAll(o, op);
  }

  public ProductoTO ProductoBuscar(Object o) throws Exception {
    return dao.find(o);
  }

  public int ProductoAdicionar(ProductoTO o) throws Exception {
    return dao.create(o);
  }

  public int ProductoActualizar(ProductoTO o) throws Exception {
    return dao.update(o);
  }

  public int ProductoEliminar(ProductoTO o) throws Exception {
    return dao.delete(o);
  }

}
