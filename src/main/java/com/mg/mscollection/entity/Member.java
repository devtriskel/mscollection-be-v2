
/*
 * **********************************************************************
 * 2020 - DEVTRISKEL
 * Music Collection API
 * **********************************************************************
 */
package com.mg.mscollection.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "members")
public class Member {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;
  
  @Column(name = "name")
  private String name;
  
  @Column(name = "role")
  private String role;
  
  @ManyToOne(
      cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH},
      fetch = FetchType.LAZY)
  @JoinColumn(name = "artist_id")
  @JsonManagedReference
  private Artist artist;
  
  // Public constructors
  public Member() {

  }

  public Member(String name, String role, Artist artist) {
    this.name = name;
    this.role = role;
    this.artist = artist;
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

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public Artist getArtist() {
    return artist;
  }

  public void setArtist(Artist artist) {
    this.artist = artist;
  }

  @Override
  public String toString() {
    return "Member [id=" + id + ", name=" + name + ", role=" + role + ", artist=" + artist + "]";
  }

  /**
   * Get related artist as object
   * @return
   */
  public Artist getRelatedArtist() {
    return this.artist;
  }

}
