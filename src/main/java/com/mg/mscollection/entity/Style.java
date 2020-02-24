
/*
 * **********************************************************************
 * 2020 - DEVTRISKEL
 * Music Collection API
 * **********************************************************************
 */
package com.mg.mscollection.entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "styles")
public class Style {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;
  
  @Column(name = "name")
  private String name;

  @ManyToMany(
      cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH},
      fetch = FetchType.LAZY)
  @JoinTable(
      name = "artists_styles",
      joinColumns = @JoinColumn(name = "style_id", referencedColumnName = "id"),
      inverseJoinColumns = @JoinColumn(name = "artist_id", referencedColumnName = "id"))
  @JsonBackReference
  private List<Artist> artists;
  
  // Public constructors
  public Style() {

  }

  public Style(String name) {
    this.name = name;
  }

  // Getters, Setters & ToString
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Artist> getArtists() {
    return artists;
  }

  public void setArtists(List<Artist> artists) {
    this.artists = artists;
  }

  @Override
  public String toString() {
    return "Style [id=" + id + ", name=" + name + ", artists=" + artists + "]";
  }

}
