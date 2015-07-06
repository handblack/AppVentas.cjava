package cjava.controller;

import cjava.entity.CategoriaTO;
import cjava.model.CategoriaDAO;
import java.util.List;

public class CategoriaBLL {

  CategoriaDAO dao;

  public CategoriaBLL() {
    dao = new CategoriaDAO();
  }

  public List<CategoriaTO> CategoriaListar() throws Exception {
    return dao.readAll();
  }
}
