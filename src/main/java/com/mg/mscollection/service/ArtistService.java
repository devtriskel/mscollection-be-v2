
/*
 * **********************************************************************
 * 2020 - DEVTRISKEL
 * Music Collection API
 * **********************************************************************
 */
package com.mg.mscollection.service;

import java.util.List;

import com.mg.mscollection.dto.model.ArtistDTO;

public interface ArtistService {

  List<ArtistDTO> getAll();

  ArtistDTO getById(int id);

  ArtistDTO save(ArtistDTO artist);

  void deleteById(int id);

}
