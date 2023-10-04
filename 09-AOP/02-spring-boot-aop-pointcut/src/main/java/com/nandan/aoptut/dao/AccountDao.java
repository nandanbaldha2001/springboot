package com.nandan.aoptut.dao;

import com.nandan.aoptut.Account;
import java.util.List;

public interface AccountDao {

  List<Account> findAccounts();

  void addAccount(Account account,boolean vipFlag);

  boolean doWork();

  String getName();

  void setName(String name);

   String getServiceName() ;


   void setServiceName(String serviceName) ;

}
