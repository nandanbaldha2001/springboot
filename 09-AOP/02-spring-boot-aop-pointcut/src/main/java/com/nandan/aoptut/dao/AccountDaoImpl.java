package com.nandan.aoptut.dao;


import com.nandan.aoptut.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDaoImpl implements  AccountDao{

  private String name;

  private  String serviceName;


  @Override
  public List<Account> findAccounts() {
    List<Account> res=new ArrayList<>();
    Account a1=new Account("nandan","mid");
    Account a2=new Account("bhmi","pro");
    Account a3=new Account("xyz","noob");
    res.add(a1);
    res.add(a2);
    res.add(a3);
    return res;
  }

  @Override
  public void addAccount(Account account,boolean vipFlag) {
    System.out.println(getClass()+"    :IMPLEMENTING ACCOUNT DAO ");
  }

  @Override
  public boolean doWork() {
    System.out.println(getClass()+"    :IMPLEMENTING do work ");
    return false;
  }

  public String getName() {
    System.out.println(getClass()+"    :IMPLEMENTING get name");
    return name;
  }

  public void setName(String name) {
    System.out.println(getClass()+"    :IMPLEMENTING set name");
    this.name = name;
  }

  public String getServiceName() {
    System.out.println(getClass()+"    :IMPLEMENTING get service name ");
    return serviceName;
  }

  public void setServiceName(String serviceName) {
    System.out.println(getClass()+"    :IMPLEMENTING set service name ");
    this.serviceName = serviceName;
  }
}
