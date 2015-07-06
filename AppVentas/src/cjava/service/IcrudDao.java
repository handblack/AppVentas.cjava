package cjava.service;

import java.util.List;

public interface IcrudDao<T> {

  // definir las firmas

  int create(T t) throws Exception;

  int update(T t) throws Exception;

  int delete(T t) throws Exception;

  List<T> readAll() throws Exception;

  T find(Object t) throws Exception;
}
