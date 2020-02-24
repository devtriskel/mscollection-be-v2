
/*
 * **********************************************************************
 * 2020 - DEVTRISKEL
 * Music Collection API
 * **********************************************************************
 */
package com.mg.mscollection.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mg.mscollection.dao.ArtistRepository;
import com.mg.mscollection.entity.Artist;

@Service
public class ArtistServiceImpl implements ArtistService {

  private ArtistRepository artistRepository;

  @Autowired
  public ArtistServiceImpl(ArtistRepository artistRepository) {
    this.artistRepository = artistRepository;
  }

  @Override
  public List<Artist> getAll() {
    return artistRepository.findAll();
  }

  @Override
  public Artist getById(int id) {
    Optional<Artist> result = artistRepository.findById(id);

    Artist artist = null;

    if (result.isPresent()) {
      artist = result.get();
    } else {
      throw new RuntimeException("No Artist found with ID: " + id);
    }

    return artist;
  }

  @Override
  public void save(Artist artist) {
    artistRepository.save(artist);
  }

  @Override
  public void deleteById(int id) {
    artistRepository.deleteById(id);
  }

}
