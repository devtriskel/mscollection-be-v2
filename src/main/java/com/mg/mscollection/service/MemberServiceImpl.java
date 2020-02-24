
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

import com.mg.mscollection.dao.MemberRepository;
import com.mg.mscollection.entity.Member;

@Service
public class MemberServiceImpl implements MemberService {

  private MemberRepository memberRepository;

  @Autowired
  public MemberServiceImpl(MemberRepository memberRepository) {
    this.memberRepository = memberRepository;
  }

  @Override
  public List<Member> getAll() {
    return memberRepository.findAll();
  }

  @Override
  public Member getById(int id) {
    Optional<Member> result = memberRepository.findById(id);

    Member member = null;

    if (result.isPresent()) {
      member = result.get();
    } else {
      throw new RuntimeException("No Member found with ID: " + id);
    }

    return member;
  }

  @Override
  public void save(Member member) {
    memberRepository.save(member);
  }

  @Override
  public void deleteById(int id) {
    memberRepository.deleteById(id);
  }

}
