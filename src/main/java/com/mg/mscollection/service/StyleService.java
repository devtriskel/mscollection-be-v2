
/*
 * **********************************************************************
 * 2020 - DEVTRISKEL
 * Music Collection API
 * **********************************************************************
 */
package com.mg.mscollection.service;

import java.util.List;

import com.mg.mscollection.entity.Style;

public interface StyleService {

  List<Style> getAll();

  Style getById(int id);

  void save(Style artist);

  void deleteById(int id);

}
