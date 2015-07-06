package cjava.model;

import cjava.database.AccesoDB;
import cjava.entity.ProductoTO;
import cjava.service.IcrudDao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO implements IcrudDao<ProductoTO> {
// variables

  Connection cn = null;
  Statement stm = null;
  PreparedStatement ps = null;
  ResultSet rs = null;
  String sql = null;

  @Override
  public int create(ProductoTO t) throws Exception {
    int ok;
    try {
      cn = AccesoDB.getConnection();
      cn.setAutoCommit(false);// inicia la transaccion
      // genera codigo de producto
      sql = "select valor from control where parametro='Productos'";
      stm = cn.createStatement();
      rs = stm.executeQuery(sql);
      rs.next();
      int cont = rs.getInt(1);
      rs.close();
      sql = "update control set valor=valor+1 where parametro='Productos'";
      stm = cn.createStatement();
      stm.executeUpdate(sql);
      String cod = "";
      if (cont < 10) {
        cod = "A000" + cont;
      } else {
        cod = "A00" + cont;
      }
      t.setIdproducto(cod);
      // insertar
      sql = "insert into productos(idproducto,descripcion,idcategoria,preciocompra,precioventa,stock)"
              + " values(?,?,?,?,?,?)";
      ps = cn.prepareStatement(sql);
      ps.setString(1, t.getIdproducto());
      ps.setString(2, t.getDescripcion());
      ps.setInt(3, t.getIdcategoria());
      ps.setDouble(4, t.getPreciocompra());
      ps.setDouble(5, t.getPrecioventa());
      ps.setInt(6, t.getStock());
      ok = ps.executeUpdate() == 1 ? 1 : 0;
      stm.close();
      ps.close();
      cn.commit();// confirma que transaccion se realizado ok.
    } catch (Exception e) {
      try {
        cn.rollback();// deshace la transaccion
      } catch (Exception e1) {
      }
      throw e;
    }
    return ok;
  }

  @Override
  public int update(ProductoTO t) throws Exception {
    int ok;
    try {
      cn = AccesoDB.getConnection();
      sql = "update productos set descripcion=?,idcategoria=?,preciocompra=?,precioventa=?,stock=?"
              + " where idproducto=?";
      ps = cn.prepareStatement(sql);
      ps.setString(1, t.getDescripcion());
      ps.setInt(2, t.getIdcategoria());
      ps.setDouble(3, t.getPreciocompra());
      ps.setDouble(4, t.getPrecioventa());
      ps.setInt(5, t.getStock());
      ps.setString(6, t.getIdproducto());
      ok = ps.executeUpdate() == 1 ? 1 : 0;
      ps.close();
    } catch (Exception e) {
      throw e;
    }
    return ok;
  }

  @Override
  public int delete(ProductoTO t) throws Exception {
    int ok;
    try {
      cn = AccesoDB.getConnection();
      sql = "delete from productos where idproducto=?";
      ps = cn.prepareStatement(sql);
      ps.setString(1, t.getIdproducto());
      ok = ps.executeUpdate() == 1 ? 1 : 0;
      ps.close();
    } catch (Exception e) {
      throw e;
    }
    return ok;
  }

  @Override
  public List<ProductoTO> readAll() throws Exception {
    List<ProductoTO> lista = new ArrayList<>();
    try {
      cn = AccesoDB.getConnection();
      sql = "select * from productos order by idproducto";
      stm = cn.createStatement();
      rs = stm.executeQuery(sql);
      while (rs.next()) {
        ProductoTO p = new ProductoTO();
        p.setIdproducto(rs.getString(1));
        p.setDescripcion(rs.getString(2));
        p.setIdcategoria(rs.getInt(3));
        p.setPrecioventa(rs.getDouble(5));
        p.setStock(rs.getInt(6));
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
  public ProductoTO find(Object t) throws Exception {
    ProductoTO p = null;
    try {
      cn = AccesoDB.getConnection();
      sql = "select * from productos where idproducto='" + (String) t + "'";
      stm = cn.createStatement();
      rs = stm.executeQuery(sql);
      if (rs.next()) {
        p = new ProductoTO();
        p.setIdproducto(rs.getString(1));
        p.setDescripcion(rs.getString(2));
        p.setIdcategoria(rs.getInt(3));
        p.setPreciocompra(rs.getDouble(4));
        p.setPrecioventa(rs.getDouble(5));
        p.setStock(rs.getInt(6));
      }
      rs.close();
      stm.close();
    } catch (SQLException | ClassNotFoundException e) {
      throw e;
    } finally {
      // cn.close();
    }
    return p;
  }

  public List<ProductoTO> readAll(Object t, int op) throws Exception {
    List<ProductoTO> lista = new ArrayList<>();
    ProductoTO pr = null;
    try {
      cn = AccesoDB.getConnection();
      sql = "select  * from productos";
      switch (op) {
        case 1:
          sql += " where Descripcion like ?";
          ps = cn.prepareStatement(sql);
          ps.setString(1, (String) (t + "%"));
          break;
        case 2:
          sql += " where IdCategoria=?";
          ps = cn.prepareStatement(sql);
          ps.setInt(1, (int) t);
          break;
      }
      rs = ps.executeQuery();
      while (rs.next()) {
        pr = new ProductoTO();
        pr.setIdproducto(rs.getString(1));
        pr.setDescripcion(rs.getString(2));
        pr.setIdcategoria(rs.getInt(3));
        pr.setPrecioventa(rs.getDouble(5));
        pr.setStock(rs.getInt(6));
        lista.add(pr);
      }
      rs.close();
      ps.close();
    } catch (Exception e) {
      // TODO: handle exception
      throw e;
    } finally {
      // cn.close();
    }
    return lista;
  }

}
