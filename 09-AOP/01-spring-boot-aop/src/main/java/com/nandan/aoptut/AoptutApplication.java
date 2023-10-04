package com.nandan.aoptut;

import com.nandan.aoptut.dao.AccountDao;
import com.nandan.aoptut.dao.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AoptutApplication {

	public static void main(String[] args) {
		SpringApplication.run(AoptutApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(AccountDao accountDao, MembershipDAO membershipDAO){
		return  runner->{
			demoBeforeForAccountDao(accountDao,membershipDAO);
		};

	}

	private void demoBeforeForAccountDao(AccountDao accountDao,MembershipDAO membershipDAO) {
		Account account=new Account();
		accountDao.addAccount(account,true);
		membershipDAO.addSilyMember();
		accountDao.doWork();
		membershipDAO.goToSleep();
	}

}
