package com.nandan.aoptut.dao;


import com.nandan.aoptut.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDaoImpl implements  AccountDao{
  @Override
  public void addAccount(Account account,boolean vipFlag) {
    System.out.println(getClass()+"    :IMPLEMENTING ACCOUNT DAO ");
  }

  @Override
  public boolean doWork() {
    System.out.println(getClass()+"    :IMPLEMENTING do work ");
    return false;
  }
}
