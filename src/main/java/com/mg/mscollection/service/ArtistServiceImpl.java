
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
import com.mg.mscollection.dto.mapper.ArtistMapper;
import com.mg.mscollection.dto.model.ArtistDTO;
import com.mg.mscollection.entity.Artist;
import com.mg.mscollection.entity.Member;

@Service
public class ArtistServiceImpl implements ArtistService {

  private ArtistRepository artistRepository;

  @Autowired
  public ArtistServiceImpl(ArtistRepository artistRepository) {
    this.artistRepository = artistRepository;
  }

  /**
   * 
   */
  @Override
  public List<ArtistDTO> getAll() {
    return ArtistMapper.toArtistDTO(
        artistRepository.findAll());
  }

  /**
   * 
   */
  @Override
  public ArtistDTO getById(int id) {
    Optional<Artist> result = artistRepository.findById(id);

    ArtistDTO artistDto = null;

    if (result.isPresent()) {
      artistDto = ArtistMapper.toArtistDTO(result.get());
    }

    return artistDto;
  }

  /**
   * 
   */
  @Override
  public ArtistDTO save(ArtistDTO artistDto) {
    return ArtistMapper.toArtistDTO(
        artistRepository.save(
            ArtistMapper.toArtist(artistDto)));
  }

  /**
   * 
   */
  @Override
  public void deleteById(int id) {
    /*
    Optional<Artist> result = artistRepository.findById(id);

    if (result.isPresent()) {
      Artist artist = result.get();
      
      for (Member member : artist.getMembers()) {
        artist.removeMember(member);
        System.out.println("Hola");
      }

      //artistRepository.save(artist);
    }*/

    artistRepository.deleteById(id);
  }

}
