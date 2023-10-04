package com.nandan.aoptut;

import com.nandan.aoptut.dao.AccountDao;
import com.nandan.aoptut.dao.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AoptutApplication {

	public static void main(String[] args) {
		SpringApplication.run(AoptutApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(AccountDao accountDao, MembershipDAO membershipDAO){
		return  runner->{
			//demoBeforeForAccountDao(accountDao,membershipDAO);
			demoAfterForAccountDao(accountDao);
		};

	}

	private void demoAfterForAccountDao(AccountDao accountDao) {
		List<Account> list=accountDao.findAccounts();
		System.out.println("main program\n");
		System.out.println(list+"\n");
	}

	private void demoBeforeForAccountDao(AccountDao accountDao,MembershipDAO membershipDAO) {
		Account account=new Account();
		account.setName("nandan");
		account.setLevel("pro");
		accountDao.addAccount(account,true);
		membershipDAO.addSilyMember();


		accountDao.setName("nandan");
		accountDao.setServiceName("software");
		String name=accountDao.getName();
		String serviceName=accountDao.getServiceName();
		System.out.println(name);
		System.out.println(serviceName);
		accountDao.doWork();
		membershipDAO.goToSleep();
	}

}
