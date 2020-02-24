
/*
 * **********************************************************************
 * 2020 - DEVTRISKEL
 * Music Collection API
 * **********************************************************************
 */
package com.mg.mscollection.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mg.mscollection.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Integer> {

}
