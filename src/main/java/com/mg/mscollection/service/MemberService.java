
/*
 * **********************************************************************
 * 2020 - DEVTRISKEL
 * Music Collection API
 * **********************************************************************
 */
package com.mg.mscollection.service;

import java.util.List;

import com.mg.mscollection.entity.Member;

public interface MemberService {

  List<Member> getAll();

  Member getById(int id);

  void save(Member member);

  void deleteById(int id);

}
