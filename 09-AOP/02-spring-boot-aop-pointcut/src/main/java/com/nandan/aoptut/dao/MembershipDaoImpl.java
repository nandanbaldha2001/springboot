package com.nandan.aoptut.dao;


import org.springframework.stereotype.Repository;

@Repository
public class MembershipDaoImpl implements  MembershipDAO{
  @Override
  public boolean addSilyMember() {
    System.out.println(getClass()+"    :IMPLEMENTING ACCOUNT member ");
    return  true;
  }

  @Override
  public void goToSleep() {
    System.out.println(getClass()+"    :IMPLEMENTING go to sleep ");
  }
}
