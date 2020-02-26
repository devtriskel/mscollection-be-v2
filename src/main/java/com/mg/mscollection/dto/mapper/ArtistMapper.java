
/*
 * **********************************************************************
 * 2020 - DEVTRISKEL
 * Music Collection API
 * **********************************************************************
 */
package com.mg.mscollection.dto.mapper;

import java.util.ArrayList;
import java.util.List;

import com.mg.mscollection.dto.model.ArtistDTO;
import com.mg.mscollection.entity.Artist;

public class ArtistMapper {

  public static Artist toArtist(ArtistDTO artistDto) {
    Artist artist = new Artist();

    artist.setId(artistDto.getId());
    artist.setName(artistDto.getName());
    artist.setYear(artistDto.getYear());

    return artist;    
  }

  public static ArtistDTO toArtistDTO(Artist artist) {
    ArtistDTO artistDto = new ArtistDTO();

    artistDto.setId(artist.getId());
    artistDto.setName(artist.getName());
    artistDto.setYear(artist.getYear());

    return artistDto;    
  }

  public static List<ArtistDTO> toArtistDTO(List<Artist> artists) {
    List<ArtistDTO> artistsDto = new ArrayList<>();

    for (Artist artist : artists) {
      artistsDto.add(toArtistDTO(artist));
    }

    return artistsDto;
  }

}
