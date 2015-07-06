package cjava.model;

import cjava.database.AccesoDB;
import cjava.entity.CategoriaTO;
import cjava.entity.ProductoTO;
import cjava.service.IcrudDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO implements IcrudDao<CategoriaTO> {

  Connection cn = null;
  Statement stm = null;
  PreparedStatement ps = null;
  ResultSet rs = null;
  String sql = null;

  @Override
  public int create(CategoriaTO t) throws Exception {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public int update(CategoriaTO t) throws Exception {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public int delete(CategoriaTO t) throws Exception {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public List<CategoriaTO> readAll() throws Exception {
    List<CategoriaTO> lista = new ArrayList<>();
    try {
      cn = AccesoDB.getConnection();
      sql = "select * from categorias order by idcategoria";
      stm = cn.createStatement();
      rs = stm.executeQuery(sql);
      while (rs.next()) {
        CategoriaTO p = new CategoriaTO();
        p.setIdcategoria(rs.getInt(1));
        p.setNombre(rs.getString(2));
        lista.add(p);
      }
      rs.close();
      stm.close();
    } catch (SQLException | ClassNotFoundException e) {
      throw e;
    } finally {
      // cn.close();
    }
    return lista;
  }

  @Override
  public CategoriaTO find(Object t) throws Exception {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

}
