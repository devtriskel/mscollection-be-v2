
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

import com.mg.mscollection.dao.StyleRepository;
import com.mg.mscollection.entity.Style;

@Service
public class StyleServiceImpl implements StyleService {

  private StyleRepository styleRepository;

  @Autowired
  public StyleServiceImpl(StyleRepository styleRepository) {
    this.styleRepository = styleRepository;
  }

  @Override
  public List<Style> getAll() {
    return styleRepository.findAll();
  }

  @Override
  public Style getById(int id) {
    Optional<Style> result = styleRepository.findById(id);

    Style style = null;

    if (result.isPresent()) {
      style = result.get();
    } else {
      throw new RuntimeException("No Style found with ID: " + id);
    }

    return style;
  }

  @Override
  public void save(Style style) {
    styleRepository.save(style);
  }

  @Override
  public void deleteById(int id) {
    styleRepository.deleteById(id);
  }

}
