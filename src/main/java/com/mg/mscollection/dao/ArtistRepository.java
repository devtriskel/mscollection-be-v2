
/*
 * **********************************************************************
 * 2020 - DEVTRISKEL
 * Music Collection API
 * **********************************************************************
 */
package com.mg.mscollection.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mg.mscollection.entity.Artist;

public interface ArtistRepository extends JpaRepository<Artist, Integer> {

}
