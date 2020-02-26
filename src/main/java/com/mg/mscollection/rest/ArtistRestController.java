
/*
 * **********************************************************************
 * 2020 - DEVTRISKEL
 * Music Collection API
 * **********************************************************************
 */
package com.mg.mscollection.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mg.mscollection.dto.model.ArtistDTO;
import com.mg.mscollection.dto.model.Response;
import com.mg.mscollection.service.ArtistService;

@RestController
@RequestMapping("/api")
public class ArtistRestController {

  private ArtistService artistService;

  @Autowired
  public ArtistRestController(ArtistService artistService) {
    this.artistService = artistService;
  }

  /**
   * 
   * @return
   */
  @GetMapping("/artists")
  public Response<Object> getAll() {
    return Response.ok().setPayload(artistService.getAll());
  }

  /**
   * 
   * @param artistId
   * @return
   */
  @GetMapping("/artists/{artistId}")
  public Response<Object> getArtistById(@PathVariable int artistId) {
    ArtistDTO artistDto = artistService.getById(artistId);

    if (artistDto == null) {
      return Response.notFound().setErrors("No Artist found with ID: " + artistId);
    }

    return Response.ok().setPayload(artistDto);
  }

  /**
   * 
   * @param artistDto
   * @return
   */
  @PostMapping("/artists")
  public Response<Object> addArtist(@RequestBody ArtistDTO artistDto) {
    artistDto.setId(0);

    return Response.ok().setPayload(artistService.save(artistDto));
  }

  /**
   * 
   * @param artistDto
   * @return
   */
  @PutMapping("/artists")
  public Response<Object> updateArtist(@RequestBody ArtistDTO artistDto) {
    return Response.ok().setPayload(artistService.save(artistDto));
  }

  /**
   * 
   * @param artistId
   * @return
   */
  @DeleteMapping("/artists/{artistId}")
  public Response<Object> deleteArtistById(@PathVariable int artistId) {
    ArtistDTO artistDto = artistService.getById(artistId);

    if (artistDto == null) {
      return Response.notFound().setErrors("No Artist found with ID: " + artistId);
    }

    artistService.deleteById(artistId);

    return Response.ok().setPayload("Deleted Artist with ID: " + artistId);
  }

}
