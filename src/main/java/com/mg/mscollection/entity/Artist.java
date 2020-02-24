
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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "artists")
public class Artist {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;
  
  @Column(name = "name")
  private String name;
  
  @Column(name = "year")
  private Integer year;
  
  @OneToMany(
      cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH},
      fetch = FetchType.LAZY,
      mappedBy = "artist")
  @JsonBackReference
  private List<Member> members;
  
  @ManyToMany(
      cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH},
      fetch = FetchType.LAZY)
  @JoinTable(
      name = "artists_styles",
      joinColumns = @JoinColumn(name = "artist_id", referencedColumnName = "id"),
      inverseJoinColumns = @JoinColumn(name = "style_id", referencedColumnName = "id"))
  @JsonManagedReference
  private List<Style> styles;  
  
  @ManyToMany(
      cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH},
      fetch = FetchType.LAZY)
  @JoinTable(
      name = "related_artists", 
      joinColumns = @JoinColumn(name = "artist_id", referencedColumnName = "id"), 
      inverseJoinColumns = @JoinColumn(name = "related_artist_id", referencedColumnName = "id"))
  private List<Artist> relatedToArtists;
  
  @ManyToMany(
      cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH},
      fetch = FetchType.LAZY)
  @JoinTable(
      name = "related_artists",
      joinColumns = @JoinColumn(name = "related_artist_id", referencedColumnName = "id"),
      inverseJoinColumns = @JoinColumn(name = "artist_id", referencedColumnName = "id"))
  @JsonBackReference
  private List<Artist> relatedFromArtists;
  
  // Public constructors
  public Artist() {
    
  }

  public Artist(String name, Integer year) {
    this.name = name;
    this.year = year;
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

  public Integer getYear() {
    return year;
  }

  public void setYear(Integer year) {
    this.year = year;
  }

  public List<Member> getMembers() {
    return members;
  }

  public void setMembers(List<Member> members) {
    this.members = members;
  }

  public List<Style> getStyles() {
    return styles;
  }

  public void setStyles(List<Style> styles) {
    this.styles = styles;
  }

  public List<Artist> getRelatedToArtists() {
    return relatedToArtists;
  }

  public void setRelatedToArtists(List<Artist> relatedToArtists) {
    this.relatedToArtists = relatedToArtists;
  }

  public List<Artist> getRelatedFromArtists() {
    return relatedFromArtists;
  }

  public void setRelatedFromArtists(List<Artist> relatedFromArtists) {
    this.relatedFromArtists = relatedFromArtists;
  }

  @Override
  public String toString() {
    return "Artist [id=" + id + ", name=" + name + ", year=" + year + ", members=" + members + ", styles=" + styles
        + ", relatedToArtists=" + relatedToArtists + ", relatedFromArtists=" + relatedFromArtists + "]";
  }

}
