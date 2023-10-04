package com.nandan.aoptut.dao;

import com.nandan.aoptut.Account;

public interface AccountDao {

  void addAccount(Account account,boolean vipFlag);

  boolean doWork();
}
