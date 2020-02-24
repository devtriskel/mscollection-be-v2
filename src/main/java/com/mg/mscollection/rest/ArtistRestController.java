
/*
 * **********************************************************************
 * 2020 - DEVTRISKEL
 * Music Collection API
 * **********************************************************************
 */
package com.mg.mscollection.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mg.mscollection.entity.Artist;
import com.mg.mscollection.service.ArtistService;

@RestController
@RequestMapping("/api")
public class ArtistRestController {

  private ArtistService artistService;

  @Autowired
  public ArtistRestController(ArtistService artistService) {
    this.artistService = artistService;
  }

  @GetMapping("/artists")
  public List<Artist> getAll() {
    return artistService.getAll();
  }

  @GetMapping("/artists/{artistId}")
  public Artist getArtistById(@PathVariable int artistId) {
    Artist artist = artistService.getById(artistId);

    if (artist == null) {
      throw new RuntimeException("No Artist found with ID: " + artistId);
    }

    return artist;
  }

  @PostMapping("/artists")
  public Artist addArtist(@RequestBody Artist artist) {
    artist.setId(0);

    artistService.save(artist);

    return artist;
  }

  @PutMapping("/artists/{artistId}")
  public Artist updateArtist(@RequestBody Artist artist) {
    artistService.save(artist);

    return artist;
  }

  @DeleteMapping("/artists/{artistId}")
  public String deleteArtistById(@PathVariable int artistId) {
    Artist artist = artistService.getById(artistId);

    if (artist == null) {
      throw new RuntimeException("No Artist found with ID: " + artistId);
    }

    artistService.deleteById(artistId);

    return "Deleted Artist with ID: " + artistId;
  }

}
