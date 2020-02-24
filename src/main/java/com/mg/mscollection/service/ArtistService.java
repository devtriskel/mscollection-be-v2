
/*
 * **********************************************************************
 * 2020 - DEVTRISKEL
 * Music Collection API
 * **********************************************************************
 */
package com.mg.mscollection.service;

import java.util.List;

import com.mg.mscollection.entity.Artist;

public interface ArtistService {

  List<Artist> getAll();

  Artist getById(int id);

  void save(Artist artist);

  void deleteById(int id);

}
